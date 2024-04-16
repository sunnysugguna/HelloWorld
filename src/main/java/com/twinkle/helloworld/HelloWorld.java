package com.twinkle.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class HelloWorld {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World";
    }

}
