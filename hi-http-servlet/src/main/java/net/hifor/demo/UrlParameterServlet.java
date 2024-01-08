package net.hifor.demo;

import org.apache.commons.text.StringEscapeUtils;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * @author IKin
 * 查询参数
 * /url/parameter?param1=盘古开天&param2=女娲造人
 */
@WebServlet(name = "UrlParameterServlet", value = "/url/parameter")
public class UrlParameterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取URL查询参数
        String param1Value = request.getParameter("param1");
        String param2Value = request.getParameter("param2");
        //设置返回内容编码
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //输出内容
        response.getWriter().write(
                "Parameter 1 value is: " + StringEscapeUtils.escapeHtml4(param1Value)
                + "<br/>Parameter 2 value is: " + StringEscapeUtils.escapeHtml4(param2Value)
        );
    }
}