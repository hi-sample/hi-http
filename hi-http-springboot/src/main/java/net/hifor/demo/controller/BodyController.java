package net.hifor.demo.controller;

import net.hifor.demo.entity.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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
     * curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "name=John&age=25" http://localhost:9090/body/formParam
     * @param name
     * @param age
     * @return
     */
    @PostMapping("/formParam")
    public String handleFormParam(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return "User created: " + HtmlUtils.htmlEscape(name) + ", Age: " + age;
    }

    /**
     * 表单对象
     * curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "name=John&age=25" http://localhost:9090/body/formModel
     * @param user
     * @return
     */
    @PostMapping("/formModel")
    public String handleFormModel(@ModelAttribute("user") User user) {
        return "User created: " + HtmlUtils.htmlEscape(user.getName()) + ", Age: " + user.getAge();
    }

    /**
     * json对象
     * curl -X POST -H "Content-Type: application/json" -d '{"name":"John","age":25}' http://localhost:9090/body/user
     * @param user
     * @return
     */
    @PostMapping("/user")
    public String handleUser(@RequestBody User user) {
        return "User created: " + HtmlUtils.htmlEscape(user.getName()) + ", Age: " + user.getAge();
    }

    /**
     * 上传文件
     * curl -X POST -H "Content-Type: multipart/form-data" -F "file=@/path/to/your/file" http://localhost:9090/body/uploadFile
     * @param file
     * @return
     */
    @PostMapping("/uploadFile")
    public String handleFileUpload(@RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload";
        }

        try {
            // 运行命令所在根目录
            String currentDir = System.getProperty("user.dir");
            System.out.println(currentDir);

            // 创建 upload 文件夹路径
            Path uploadPath = Paths.get(currentDir, "upload");

            // 如果 upload 文件夹不存在，则创建它
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // 使用 UUID 生成唯一的文件名
            String uniqueFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            // 将上传的文件保存到 upload 文件夹下
            Path filePath = Paths.get(uploadPath.toString(), uniqueFileName);
            Files.copy(file.getInputStream(), filePath);

            return "File uploaded successfully to: " + filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file: " + e.getMessage();
        }
    }
}
