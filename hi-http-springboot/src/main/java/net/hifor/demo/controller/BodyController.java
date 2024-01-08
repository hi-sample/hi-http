package net.hifor.demo.controller;

import net.hifor.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author IKin <br/>
 * @description 请求体  <br/>
 * @date 2019/11/17 <br/>
 */
@RestController
@RequestMapping("/body")
public class BodyController {

    /**
     * 表单参数
     * @param name
     * @param age
     * @return
     */
    @PostMapping("/formParam")
    public String handleFormParam(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return "User created: " + name + ", Age: " + age;
    }

    /**
     * 表单对象
     * @param user
     * @return
     */
    @PostMapping("/formModel")
    public String handleFormModel(@ModelAttribute("user") User user) {
        return "User created: " + user.getName() + ", Age: " + user.getAge();
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping("/user")
    public String handleUser(@RequestBody User user) {
        return "User created: " + user.getName() + ", Age: " + user.getAge();
    }
}
