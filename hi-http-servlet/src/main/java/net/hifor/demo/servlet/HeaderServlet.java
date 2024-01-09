package net.hifor.demo.servlet;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author IKin
 */
@WebServlet(name = "UrlParameterServlet", value = "/header")
public class HeaderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userAgent = request.getHeader("User-Agent");

        //设置返回内容编码
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //输出内容
        response.getWriter().write(
                "User-Agent header value: " + StringEscapeUtils.escapeHtml4(userAgent)
        );
    }
}