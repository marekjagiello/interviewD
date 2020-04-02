package com.jagiello.interview.boundry.awesome;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

import static java.util.function.Predicate.not;

@UtilityClass
class IntegerMapper {

    public static final String SEPARATOR = "\n";

    List<Integer> map(String integerString) {
        return Optional.ofNullable(integerString)
                .map(s -> s.split(SEPARATOR))
                .map(IntegerMapper::mapToIntegers)
                .orElseGet(Collections::emptyList);
    }

    private List<Integer> mapToIntegers(@NonNull String[] strings) {
        return Stream.of(strings)
                .filter(not(StringUtils::isEmpty))
                .map(Integer::valueOf)
                .collect(Collectors.toList())
                ;
    }


}
