package com.example.pos.skripsi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.pos.skripsi.dto.UserDTO;
import com.example.pos.skripsi.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/showAllUser")
	@ResponseBody
	public Map<String, Object> showAllUser(){
		
		Map<String, Object> response = userService.showAll();
		
		return response;
	}
	
	@GetMapping("/login")
	@ResponseBody
	public Map<String, Object> findUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) throws Exception{
		Map<String, Object> response = userService.findUser(username, password);
		return response;
	}
	
	@PostMapping("/register")
	@ResponseBody
	public Map<String, Object> addUser(
		@RequestParam(name = "id_user") String id_user, 
		@RequestParam(name = "username") String username,
		@RequestParam(name = "password") String password,
		@RequestParam(name = "email") String email,
		@RequestParam(name = "no_telp") String no_telp,
		@RequestParam(name = "user_kategori") int user_kategori,
		@RequestParam(name = "alamat_toko") String alamat_toko,
		@RequestParam(name = "nama_toko") String nama_toko,
		@RequestParam(name = "desc_toko") String desc_toko,
		@RequestParam(name = "path") MultipartFile path,
		@RequestParam(name = "fullname") String fullname
	) throws Exception{
		Map<String, Object> response = userService.addUser(id_user, username, password, email, no_telp, user_kategori, alamat_toko, nama_toko, desc_toko, path, fullname);
		return response;
	}
}
