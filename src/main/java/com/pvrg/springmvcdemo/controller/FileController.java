package com.pvrg.springmvcdemo.controller;


import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * Handles requests for the application home page.
 */
@Controller
public class FileController {
	
	@RequestMapping(value = "/myForm" )
	public String myForm() {
		return "myForm";
	}
	
	@RequestMapping(value="/handleForm")
	public String handleForm(@RequestParam("file") MultipartFile file){
		
		try(FileOutputStream fileOutputStream = new FileOutputStream("D:\\Users\\HARBAL\\Desktop\\DeleteME.txt")){
			if(!file.isEmpty()){
				byte[] bytes=file.getBytes();
				fileOutputStream.write(bytes);
				System.out.println("Success Uploading File");
			} else {
				System.out.println("No File Found");
			}
		} catch(Exception e){
			System.out.println("Error Uploading File");
			e.printStackTrace();
		}
		return "operationCompleted";
	}
	
}
