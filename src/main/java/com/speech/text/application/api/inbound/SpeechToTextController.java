package com.speech.text.application.api.inbound;

import com.speech.text.application.usecases.interfaces.SpeechToTextUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.speech.text.application.constants.Endpoints.SPEECH_TO_TEXT_URL;

@RestController
@Validated
@RequiredArgsConstructor
public class SpeechToTextController {

    private final SpeechToTextUseCase speechToTextUseCase;

    @PostMapping(value = SPEECH_TO_TEXT_URL)
    public Mono<String> convertSpeechToText(@RequestBody byte[] audioData){
        return speechToTextUseCase.getSpeechToTextFromService(audioData);
    }
}
