package com.example.my_greetings_app;

import org.springframework.web.bind.annotation.*;

@RestController

public class GreetingController {

    @GetMapping( "/greet")
    public String greeting(@RequestParam(defaultValue="world") String name) {
        return "Hello "+ name+" welcome to my app";
    }
    @GetMapping("/greet/{name}")
    public String greetPathVariable(
            @PathVariable String name) {

        return "Hello, " + name +
                "! (this time via a path variable, not a query param)";
    }

}
