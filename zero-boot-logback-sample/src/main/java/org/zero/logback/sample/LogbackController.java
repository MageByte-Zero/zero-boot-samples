package org.zero.logback.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zeroframework.boot.message.ResultDTO;

@Slf4j
@RestController
public class LogbackController {

    @RequestMapping("/logback")
    public ResultDTO<Void> greeting() {
        log.debug("debug log");
        log.info("info log");
        log.warn("warn log");
        log.error("error log");
        return ResultDTO.success();
    }
}
