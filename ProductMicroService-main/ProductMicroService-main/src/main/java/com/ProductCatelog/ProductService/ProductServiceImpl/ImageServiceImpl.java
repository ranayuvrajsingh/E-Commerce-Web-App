package com.ProductCatelog.ProductService.ProductServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ProductCatelog.ProductService.ImageService;

@Service
public class ImageServiceImpl implements ImageService  {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		
		//File Name
		
		
		String name=file.getOriginalFilename();
		
		
		//Full Path
		
		String filePath=path+File.separator+name;
		
		//random Name Generator File
		String randomId=UUID.randomUUID().toString();
		
		String fileName1=randomId.concat(name.substring(name.lastIndexOf(".")));
		
		
		
		//Create Folder   if not created
		File f=new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}

		
		
		//file.copy
		
		Files.copy(file.getInputStream(),Paths.get(filePath));
		
		return name;
	}


}
