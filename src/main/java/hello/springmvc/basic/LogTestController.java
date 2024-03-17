package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //  private final Logger log = LoggerFactory.getLogger(getClass());
@RestController // RequestMapping의 String을 반환
public class LogTestController {
//  private final Logger log = LoggerFactory.getLogger(getClass());

  @RequestMapping("/log-test")
  public String logTest() {
    String name = "Spring";

    log.trace("trace log = {}", name);
    log.debug("debug log = {}", name);
    // 2024-03-17 22:48:19.303  INFO 4063 --- [nio-8080-exec-1] hello.springmvc.basic.LogTestController  : info log = Spring
    log.info("info log = {}", name);
    log.warn("warn log = {}", name);
    log.error("error log = {}", name);

    return "ok";
  }
}
