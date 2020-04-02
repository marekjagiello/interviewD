package com.jagiello.interview.boundry.dumb;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
class DumbRepositoryImpl implements DumbRepository {

    @Override
    public Integer getDumbNumber() {
        return new Random().nextInt(10);
    }
}
