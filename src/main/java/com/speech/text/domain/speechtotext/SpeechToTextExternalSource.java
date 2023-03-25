package com.speech.text.domain.speechtotext;

import com.speech.text.application.ExternalSource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public interface SpeechToTextExternalSource extends ExternalSource {
    Mono<String> getSpeechToTextFromClient(byte[] audioData) throws IOException;
}
