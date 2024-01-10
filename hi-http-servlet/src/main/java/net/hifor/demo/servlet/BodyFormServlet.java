package net.hifor.demo.servlet;

import net.hifor.demo.entity.User;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author IKin
 */
@WebServlet(name = "BodyFormServlet", value = {"/body/formParam","/body/formModel"})
public class BodyFormServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        User user = new User();
        user.setName(StringEscapeUtils.escapeHtml4(name));
        user.setAge(age);
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