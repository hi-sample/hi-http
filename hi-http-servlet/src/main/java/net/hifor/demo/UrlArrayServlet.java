package net.hifor.demo;

import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author IKin
 * 数组参数
 * /url/array?params=盘古开天&params=女娲造人
 * /url/array?params=盘古开天,女娲造人
 */
@WebServlet(name = "UrlArrayServlet", value = "/url/array")
public class UrlArrayServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取URL查询参数
        String[] paramsValue = request.getParameterValues("params");
        if (paramsValue.length == 1) {
            String[] params = paramsValue[0].split(",");
            if (params.length > 1) {
                paramsValue = params;
            }
        }
        //设置返回内容编码
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < paramsValue.length; i++) {
            System.out.println(paramsValue[i]);
            stringBuilder.append("Parameter " + i + " value is: " + StringEscapeUtils.escapeHtml4(paramsValue[i]));
            stringBuilder.append("</br>");
        }
        //输出内容
        response.getWriter().write(stringBuilder.toString());
    }
}