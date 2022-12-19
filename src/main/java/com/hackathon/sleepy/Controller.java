package com.hackathon.sleepy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    final long DEFAULT_SLEEP_TIME = 500;

    @GetMapping("/sleep")
    public String sleep(@RequestParam(required = false) Long sleepTime) throws InterruptedException {
        sleepTime = sleepTime == null ? DEFAULT_SLEEP_TIME : sleepTime;

        System.out.printf("New request: %d%n", Thread.currentThread().getId());

        Thread.sleep(sleepTime);

        System.out.printf("End request: %d\n\n", Thread.currentThread().getId());
        return String.format("Sleep for %d ms - done with thread.id %d", sleepTime, Thread.currentThread().getId());
    }

}
