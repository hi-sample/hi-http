package net.hifor.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author IKin <br/>
 * @description HTTP头部  <br/>
 * @date 2019/11/17 <br/>
 */
@RestController
@RequestMapping("/header")
public class HeaderController {

    @GetMapping("/")
    public String handleHeader(@RequestParam("params") List<String> params) {
        for (int i = 0; i < params.size(); i++) {
            System.out.println(params.get(i));
        }
        return "Received numbers: " + params;
    }
}
