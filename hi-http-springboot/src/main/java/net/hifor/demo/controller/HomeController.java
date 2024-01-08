package net.hifor.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author IKin <br/>
 * @description 根路径  <br/>
 * @date 2019/11/17 <br/>
 */
@RestController
public class HomeController {

    /**
     * 引导页
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "Hello Spring boot!";
    }

}
