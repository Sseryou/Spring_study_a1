package controllers.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file/upload")
public class UploadController {

    @Value("${file.upload.path}")
    private String fileUploadPath;


    @GetMapping
    public String upload(){

        return "file/upload";
    }


    @PostMapping
    public String uploadPs(MultipartFile[] files){

        /*배열로 들어간 파일을 모두 꺼낼때까지 반복*/
        for(MultipartFile file : files){

        File uploadPath = new File(fileUploadPath + file.getOriginalFilename());
        try {
            file.transferTo(uploadPath);

            System.out.printf("originalFilename=%s, name=%s, contentType=%s, size=%d%n",
                    file.getOriginalFilename(), file.getName(), file.getContentType(), file.getSize());

        } catch (IOException e) {
            e.printStackTrace();
        }


        }
        return "file/upload";
    }

}
