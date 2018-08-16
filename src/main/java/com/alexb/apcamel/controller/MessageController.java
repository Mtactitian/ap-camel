package com.alexb.apcamel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MessageController {

    @PostMapping(value = "/submit")
    public void messageConsumer(@RequestBody String value) {
        log.info("Message received: " + value);
    }
}
