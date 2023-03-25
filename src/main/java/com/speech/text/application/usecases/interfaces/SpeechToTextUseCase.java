package com.speech.text.application.usecases.interfaces;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface SpeechToTextUseCase {
    Mono<String> getSpeechToTextFromService(byte[] audioData);
}
