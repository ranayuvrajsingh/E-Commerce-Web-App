package com.ProductCatelog.ProductController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ProductCatelog.Models.FileResponse;
import com.ProductCatelog.ProductService.ImageService;

@RestController
@RequestMapping("/file")
public class ImageController {

	@Autowired
	private ImageService imageService;

	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(
			@RequestParam("image") MultipartFile image
			)   {
		
		String fileName=null;
		try {
			
		      fileName=this.imageService.uploadImage(path, image);
		
		}catch (IOException e) {
			e.printStackTrace();
			
			return new ResponseEntity<>(new FileResponse(null,"Image is not uploaded Due to error on server"),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<>(new FileResponse(fileName,"Image is Successfully uploaded"),HttpStatus.OK);
		
	}
	
}
