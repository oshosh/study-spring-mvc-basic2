package hello.springmvc.basic.request;

import java.util.Locale;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestHeaderController {

  @RequestMapping("/headers")
  public String headers(HttpServletRequest request,
      HttpServletResponse response,
      HttpMethod httpMethod, Locale locale,
      @RequestHeader MultiValueMap<String, String> headerMap,
      @RequestHeader("host") String host,
      @CookieValue(value = "myCookie", required = false) String cookie) {
    log.info("request={}", request);
    log.info("response={}", response);
    log.info("httpMethod={}", httpMethod);
    log.info("locale={}", locale);
    log.info("headerMap={}", headerMap);
    log.info("header host={}", host);
    log.info("myCookie={}", cookie);
    return "ok";

    //    HttpServletRequest : 서블릿(Servlet) 기반의 요청 객체
    //    HttpServletResponse : 서블릿(Servlet) 기반의 응답 객체
    //    HttpMethod : HTTP 메서드 정보(GET, POST, PUT, … 등)
    //    Locale : 언어 정보(우선 순위가 가장 높은 Locale 출력하게 됨)
    //    @RequestHeader MultiValueMap<String, String> : 모든 HTTP 헤더를 MultiValueMap 형식으로 조회
    //    @RequestHeader() : 특정 HTTP 헤더를 조회, “host”를 입력하면 localhost:8080이 반환됨 속성 : required(필수 값 여부), defaultValue(기본 값)
    //    @CookieValue(value = "myCookie", required = false) : 특정 쿠키를 조회한다. 속성 : required(필수 값 여부), defaultValue(기본 값)
  }
}
