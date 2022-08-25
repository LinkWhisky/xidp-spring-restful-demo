package com.example.xidpspringrestfuldemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private  static final String helloTemplate = "Hello, %s!";
    private final AtomicLong automaticId = new AtomicLong();
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "helloname",defaultValue = "World") String name) {
        return new Greeting(automaticId.incrementAndGet(), String.format(helloTemplate,name));
    }
}
