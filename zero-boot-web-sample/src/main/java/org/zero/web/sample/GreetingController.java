package org.zero.web.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zeroframework.boot.exception.BaseException;
import org.zeroframework.boot.message.ResultDTO;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public ResultDTO<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        return ResultDTO.success(greeting);
    }

    @GetMapping("/base-exception")
    public ResultDTO<Greeting> baseException() {
        throw new BaseException("出错啦");
    }

    @GetMapping("/exception-test")
    public ResultDTO<Greeting> exception() throws Exception {
        throw new Exception("出错啦");
    }

    @GetMapping("/exception-null")
    public ResultDTO<Long> nullException() throws Exception {
        Greeting greeting = null;
        return ResultDTO.success(greeting.getId());
    }

}