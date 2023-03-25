package com.speech.text.domain.speechtotext;

import com.speech.text.domain.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.speech.text.application.constants.AppConstants.ERROR_OCCURRED;
import static com.speech.text.application.constants.AppConstants.RESPONSE_RECEIVED_SUCCESSFULLY;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoogleSpeechToTextService implements  SpeechToTextService{
    private final SpeechToTextExternalSource speechToTextExternalSource;

    @Override
    public Mono<String> speechToText(byte[] audioData) {
        try{
            return speechToTextExternalSource.getSpeechToTextFromClient(audioData)
                    .doOnError(error -> log.error(ERROR_OCCURRED + error))
                    .onErrorResume(error -> Mono.error(new ServiceException(ERROR_OCCURRED + error.getLocalizedMessage())))
                    .doOnSuccess(response -> log.info(RESPONSE_RECEIVED_SUCCESSFULLY + response));
        }catch(Exception e){
            log.error(ERROR_OCCURRED + e.getLocalizedMessage());
            return Mono.error(new ServiceException(ERROR_OCCURRED + e.getLocalizedMessage()));
        }

    }
}
