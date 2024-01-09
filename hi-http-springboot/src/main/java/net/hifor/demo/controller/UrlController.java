package net.hifor.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * @author IKin <br/>
 * @description URL参数  <br/>
 * @date 2019/11/17 <br/>
 */
@RestController
@RequestMapping("/url")
public class UrlController {

    /**
     * 查询参数
     * /url/parameter?param1=盘古开天&param2=女娲造人
     * curl -X GET 'http://localhost:9090/url/parameter?param1=盘古开天&param2=女娲造人'
     * @param param1
     * @param param2
     * @return
     */
    @GetMapping("/parameter")
    public String handleParameter(@RequestParam(name = "param1", required = false) String param1,
                                  @RequestParam(name = "param2", required = false) String param2) {
        param1 = HtmlUtils.htmlEscape(param1);
        param2 = HtmlUtils.htmlEscape(param2);
        return "Parameter 1 value is: " + param1
                + "<br/>Parameter 2 value is: " + param2
                ;
    }

    /**
     * 路径参数
     * /url/path/盘古开天/女娲造人
     * curl -X GET 'http://localhost:9090/url/path/盘古开天/女娲造人'
     * @param param1
     * @param param2
     * @return
     */
    @GetMapping("/path/{param1}/{param2}")
    public String handlePath(@PathVariable(name = "param1", required = false) String param1,
                             @PathVariable(name = "param2", required = false) String param2) {
        param1 = HtmlUtils.htmlEscape(param1);
        param2 = HtmlUtils.htmlEscape(param2);
        return "Parameter 1 value is: " + param1
                + "<br/>Parameter 2 value is: " + param2
                ;
    }

    /**
     * 数组参数
     * /url/array?params=盘古开天&params=女娲造人
     * /url/array?params=盘古开天,女娲造人
     * curl -X GET 'http://localhost:9090/url/array?params=盘古开天&params=女娲造人'
     * curl -X GET 'http://localhost:9090/url/array?params=盘古开天,女娲造人'
     * @param params
     * @return
     */
    @GetMapping("/array")
    public String handleArray(@RequestParam("params") List<String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < params.size(); i++) {
            System.out.println(params.get(i));
            stringBuilder.append("Parameter " + i + " value is: " + HtmlUtils.htmlEscape(params.get(i)));
            stringBuilder.append("</br>");
        }
        return stringBuilder.toString();
    }
}
