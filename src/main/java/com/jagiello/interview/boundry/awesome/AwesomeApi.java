package com.jagiello.interview.boundry.awesome;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "randomApi", url = "https://www.random.org/")
interface AwesomeApi {

    @GetMapping(value = "/integers/?num={num}&min={min}&max={max}&col=1&base=10&format=plain&rnd=new")
    String getInteger(
            @PathVariable("num") int num,
            @PathVariable("min") int min,
            @PathVariable("max") int max
    );

}
