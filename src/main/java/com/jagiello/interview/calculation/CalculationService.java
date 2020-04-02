package com.jagiello.interview.calculation;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CalculationService {

    static final int DEFAULT_VALUE = 0;

    public Integer addMagicNumbers(final Integer awesomeNumber, final Integer dumbNumber) {
        long value = add(awesomeNumber, dumbNumber);
        if (value > Integer.MAX_VALUE) {
            return DEFAULT_VALUE;
        }

        return (int) value;
    }

    private long add(Integer awesomeNumber, Integer dumbNumber) {
        return (long) Optional.ofNullable(awesomeNumber).orElse(0)
                +
                Optional.ofNullable(dumbNumber).orElse(0);
    }
}
