package controllers.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		for(MultipartFile file : files){
			File uploadPath = new File(fileUploadPath + file.getOriginalFilename());
			try {
				file.transferTo(uploadPath);

				System.out.printf("originalFileName=%s\n", file.getOriginalFilename());
				System.out.printf("name=%s\n", file.getName());
				System.out.printf("contentType=%s\n", file.getContentType());
				System.out.printf("size=%d\n", file.getSize());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "file/upload";
	}
}
