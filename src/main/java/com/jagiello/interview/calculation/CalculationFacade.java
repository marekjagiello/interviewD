package com.jagiello.interview.calculation;

import javax.annotation.PostConstruct;

import com.jagiello.interview.boundry.awesome.AwesomeRepository;
import com.jagiello.interview.boundry.dumb.DumbRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculationFacade {

    private final CalculationService calculationService;

    private final DumbRepository dumbRepository;

    private final AwesomeRepository awesomeRepository;

    @PostConstruct
    public void init() {
        testMe();
    }

    public void testMe() {
        Integer awesomeNumber = awesomeRepository.getAwesomeNumber();
        Integer dumbNumber = dumbRepository.getDumbNumber();

        log.info(String.format("%d + %d = %d",
                awesomeNumber,
                dumbNumber,
                calculationService.addMagicNumbers(awesomeNumber, dumbNumber)
        ));
    }
}
