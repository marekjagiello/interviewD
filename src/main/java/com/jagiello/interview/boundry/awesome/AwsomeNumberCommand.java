package com.jagiello.interview.boundry.awesome;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AwsomeNumberCommand {

    @NonNull
    public final Integer requestedNumberCount;
}
