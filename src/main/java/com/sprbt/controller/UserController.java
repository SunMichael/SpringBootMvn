package com.sprbt.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sprbt.DAO.UserMapper;
import com.sprbt.entity.User;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@Value("${com.sun.uploadPath}")
	private String uploadPath;
	
	
	@RequestMapping("/adduser")
	public void addUser(@RequestParam("name") String name, @RequestParam("password")String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		 Date date = new Date();
		 
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String string = df.format(date);
		 user.setRegTime(string);
		 
		 System.out.println(" save user ");
		 userMapper.addUser(user);
		 
	}
	
	@RequestMapping("/alluser")
	public List<User> getAllUser() {
		System.out.println(" get all user ");
		return userMapper.getAll();
		
	}
	
	@RequestMapping("/finduser")
	public User findUser(@RequestParam("id") long id) {
		return userMapper.findById(id);
	}
	
	@RequestMapping("/deleteuser/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		userMapper.deleteById(id);
	}
	
	@RequestMapping(value = "/updateuser" ,method = RequestMethod.POST ,consumes = "application/json")
	public User updateUser(@RequestBody User user) {   
	     userMapper.updateUser(user);
	     return userMapper.findById(user.getId());
	}
	//使用RequestBody接受参数，请求一定要是application/json类型，请求参数为{"id":3 ,"name":"update","password":"7777777"} 不然会报错
	
	
	
	
	@RequestMapping(value = "/fileupload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void fileUpload(@RequestParam("file") MultipartFile file , @RequestParam("id") long id) {
		
		if(!file.isEmpty()) {
			if(file.getContentType().contains("image")) {
				
				
				try {
				String temp = "image" + File.separator + "upload" + File.separator;
				System.out.println(" temp path: " + temp);
				
				String fileName = file.getOriginalFilename();
				String suffixName = fileName.substring(fileName.lastIndexOf("."));
				System.out.println(" fileName: " + fileName + "\n" + "suffix: " + suffixName);
				
				
				String newFileName = String.valueOf(System.currentTimeMillis())  + suffixName;
				System.out.println(" newFileName: " + newFileName);	
				
				String dataDic = temp.concat(String.valueOf(id)).concat(File.separator);
                 String filePath = (uploadPath + File.separator).concat(dataDic);
                 System.out.println(" file path:" + filePath);	
                 
                 File dest = new File(filePath , newFileName);
                 if(!dest.getParentFile().exists()) {
                	    dest.getParentFile().mkdirs();
                 }
//                 file.transferTo(dest);
                 
                 BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
                 out.write(file.getBytes());
                 out.flush();
                 out.close();
                 
				} catch (IOException e) {
				  System.out.println(" image upload fail: " + e.getMessage());	
				}
				
			}else {
				System.out.println(" this is not image type");
			}
		}
		
		
		
	}
	
	
	
	
	
	
	
}
