package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MappingController {

  @RequestMapping(value = {"hello-basic", "/hello-go"}, method = RequestMethod.GET)
  public String helloBasic() {
    log.info("helloBasic");
    return "ok";
  }

  @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
  public String mappingGetV1() {
    log.info("mappingGetV1");
    return "ok";
  }

  @GetMapping("/mapping-get-v2")
  public String mappingGetV2() {
    log.info("mappingGetV2");
    return "ok";
  }

  @GetMapping("/mapping/{userId}")
  public String mappingPath(@PathVariable("userId") String data) {
    log.info("mappingPath userId={}", data);
    return "ok";
  }

  // GetMapping과 파라메터의 값이 같으면 그냥 사용도 가능
  @GetMapping("/mapping2/{userId2}")
  public String mappingPath2(@PathVariable String userId2) {
    log.info("mappingPath2 userId={}", userId2);
    return "ok";
  }

  // PathVariable 다중 사용
  @GetMapping("/mapping/user/{userId}/orders/{orderId}")
  public String mappingPath(@PathVariable String userId, @PathVariable String orderId) {
    log.info("mappingPath userId={}, orderId={}", userId, orderId);
    return "ok";
  }

  //http://localhost:8080/mapping-param?mode=debug (O)
  //http://localhost:8080/mapping-param (X)
  @GetMapping(value = "/mapping-param", params = "mode=debug")
  public String mappingParam() {
    log.info("mappingParam");
    return "ok";
  }

  // 헤더에 조건
  @GetMapping(value = "/mapping-header", headers = "mode=debug")
  public String mappingHeader() {
    log.info("mappingParam");
    return "ok";
  }

  // content type 조건
  @PostMapping(value = "/mapping-consume", consumes = "application/json")
  public String mappingConsume() {
    log.info("mappingConsume");
    return "ok";
  }

  // accept header 조건
  @PostMapping(value = "/mapping-produce", produces = "text/html")
  public String mappingProduces() {
    log.info("mappingProduces");
    return "ok";
  }
}
