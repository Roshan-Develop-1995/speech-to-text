package com.speech.text.application.api.outbound.gcspeech;

import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;
import com.speech.text.domain.speechtotext.SpeechToTextExternalSource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoogleSpeechClient implements SpeechToTextExternalSource {

    @Override
    public Mono<String> getSpeechToTextFromClient(byte[] audioData) throws IOException {
        SpeechClient speechClient = SpeechClient.create();

        RecognitionConfig recognitionConfig =
                RecognitionConfig.newBuilder()
                        .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                        .setSampleRateHertz(16000) // set the sample rate to 16000 Hz
                        .setLanguageCode("en-US")
                        .build();

        RecognitionAudio recognitionAudio =
                RecognitionAudio.newBuilder()
                        .setContent(ByteString.copyFrom(audioData))
                        .build();

        RecognizeResponse response = speechClient.recognize(recognitionConfig, recognitionAudio);

        List<SpeechRecognitionResult> results = response.getResultsList();
        String text = results.stream()
                .map(result -> result.getAlternatives(0).getTranscript())
                .collect(Collectors.joining());

        speechClient.close();

        return Mono.just(text);
    }
}
