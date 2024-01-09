package net.hifor.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import net.hifor.demo.entity.User;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author IKin
 */
@WebServlet(name = "BodyJsonServlet", value = "/body/user")
public class BodyJsonServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        User user = JSONObject.parseObject(sb.toString(),User.class);
        user.setName(StringEscapeUtils.escapeHtml4(user.getName()));

        //设置返回内容编码
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //输出内容
        response.getWriter().write(
                "User created: " + user.getName()
                + ", Age: " + user.getAge()
        );
    }
}