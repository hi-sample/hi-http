package net.hifor.demo;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author IKin
 * 路径参数
 * /url/path/盘古开天/女娲造人
 */
@WebServlet(name = "UrlPathServlet", value = "/url/path/*")
public class UrlPathServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        // 从路径中解析参数值
        Pattern pattern = Pattern.compile("/([^/]+)/([^/]+)");
        Matcher matcher = pattern.matcher(pathInfo);

        String param1Value = null, param2Value = null;
        if (matcher.find()) {
            param1Value = matcher.group(1);
            param2Value = matcher.group(2);

            System.out.println("param1: " + param1Value);
            System.out.println("param2: " + param2Value);
        }

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