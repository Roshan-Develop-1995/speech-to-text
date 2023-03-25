package com.speech.text.application.usecases;

import com.speech.text.application.usecases.interfaces.SpeechToTextUseCase;
import com.speech.text.domain.speechtotext.SpeechToTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GoogleSpeechToTextUseCase implements SpeechToTextUseCase {
    private final SpeechToTextService speechToTextService;
    @Override
    public Mono<String> getSpeechToTextFromService(byte[] audioData) {
        return speechToTextService.speechToText(audioData);
    }
}
