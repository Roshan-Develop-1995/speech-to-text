package com.speech.text.domain.speechtotext;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface SpeechToTextService {
    Mono<String> speechToText(byte[] audioData);
}
