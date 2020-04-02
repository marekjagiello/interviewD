package com.jagiello.interview.boundry.awesome;

import java.util.ArrayList;
import java.util.List;

import feign.FeignException;
import feign.RetryableException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class AwesomeRepository {

    public static final int MIN = 1;

    public static final int MAX = 10;

    private final AwesomeApi api;

    public Integer getAwesomeNumber() {
        List<Integer> response = getIntegers(1);
        if(CollectionUtils.isEmpty(response)) {
            return 0;
        }

        return response.get(0);
    }

    public List<Integer> getAwesomeNumber(AwsomeNumberCommand command) {
        return getIntegers(command.requestedNumberCount);
    }


    private List<Integer> getIntegers(@NonNull Integer requestedNumbersCount) {
        try {
            return IntegerMapper.map(api.getInteger(requestedNumbersCount, MIN, MAX));
        } catch (RetryableException e) {
            log.error("Timeout ... not so awesome :(");
        } catch (FeignException e) {
            if (HttpStatus.valueOf(e.status()).is4xxClientError()) {
                log.error("Gdzie jest ta ulica gdzie jest ten dom...", e);
            }

            if (HttpStatus.valueOf(e.status()).is5xxServerError()) {
                log.error("Looo matko bosko co to sie stanelo mowie... tak pier.. a nie bede mowil", e);
            }
        }

        return new ArrayList<>();
    }


}
