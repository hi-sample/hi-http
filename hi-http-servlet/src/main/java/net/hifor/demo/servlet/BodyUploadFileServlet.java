package net.hifor.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author IKin
 */
@WebServlet(name = "BodyUploadFileServlet", value = "/body/uploadFile")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class BodyUploadFileServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part filePart = request.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        System.out.println(fileName);

        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        if (fileName == null || fileName.isEmpty()) {
            out.println("Please select a file to upload");
            return;
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
            String uniqueFileName = UUID.randomUUID() + "_" + fileName;

            // 将上传的文件保存到 upload 文件夹下
            Path filePath = Paths.get(uploadPath.toString(), uniqueFileName);
            try (InputStream fileContent = filePart.getInputStream()) {
                Files.copy(fileContent, filePath);
            }
            out.println("File uploaded successfully to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            out.println("Failed to upload file: " + e.getMessage());
        }
    }
}