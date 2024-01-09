package net.hifor.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * @author IKin <br/>
 * @description HTTP头部  <br/>
 * @date 2019/11/17 <br/>
 */
@RestController
@RequestMapping("/header")
public class HeaderController {

    /**
     *
     * curl -X GET -H "User-Agent: MyCustomUserAgent" http://localhost:9090/header
     * @param userAgent
     * @return
     */
    @GetMapping("/")
    public String getHeader(@RequestHeader("User-Agent") String userAgent) {
        return "User-Agent header value: " + HtmlUtils.htmlEscape(userAgent);
    }
}
