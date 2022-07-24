package com.example.pos.skripsi.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.pos.skripsi.dto.ResponseUserDTO;
import com.example.pos.skripsi.dto.UserDTO;
import com.example.pos.skripsi.entity.UserEntity;
import com.example.pos.skripsi.repository.UserRepository;
import com.example.pos.skripsi.security.FileUploadUtil;
import com.example.pos.skripsi.security.PasswordUtils;

@Service
public class UserService {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public Map<String, Object> showAll(){
		
		List<UserEntity> data = userRepository.findAll();
		
		Map<String, Object> response = new HashMap<>();
		response.put("statusCode", 200);
		response.put("message", "success");
		response.put("data", data);
		
		return response;
	}
	
	@Transactional
	public Map<String, Object> findUser(String username, String password) throws Exception{
		
		PasswordUtils passwordUtils = new PasswordUtils();
		UserEntity data = userRepository.findUser(username, passwordUtils.encrypt(password));
		
		ResponseUserDTO responseData = new ResponseUserDTO();
		responseData.setId_user(data.getId_user());
		responseData.setUsername(data.getUsername());
		responseData.setPassword(passwordUtils.decrypt(data.getPassword()));
		responseData.setEmail(data.getEmail());
		responseData.setNo_telp(data.getNo_telp());
		responseData.setUser_kategori(data.getUser_kategori());
		responseData.setAlamat_toko(data.getAlamat_toko());
		responseData.setNama_toko(data.getNama_toko());
		responseData.setCreated_at(data.getCreated_at());
		responseData.setUpdated_at(data.getUpdated_at());
		responseData.setFullname(data.getFullname());
		
		Map<String, Object> response = new HashMap<>();
		response.put("statusCode", 200);
		response.put("message", "success");
		response.put("data", responseData);
		
		return response;
		
	}
	
	@Transactional
	public Map<String, Object> addUser(
		String id_user, 
		String username,
		String password,
		String email,
		String no_telp,
		int user_kategori,
		String alamat_toko,
		String nama_toko,
		String desc_toko,
		MultipartFile path,
		String fullname
	) throws Exception{
		
		String fileName = StringUtils.cleanPath(path.getOriginalFilename());
		
		PasswordUtils passwordUtils = new PasswordUtils();
		
		String fileSize = String.valueOf(path.getSize());
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
        
		UserEntity setData = new UserEntity();
		setData.setId_user(id_user);
		setData.setUsername(username);
		setData.setPassword(passwordUtils.encrypt(password));
		setData.setEmail(email);
		setData.setNo_telp(no_telp);
		setData.setUser_kategori(user_kategori);
		setData.setAlamat_toko(alamat_toko);
		setData.setNama_toko(nama_toko);
		setData.setDesc_toko(desc_toko);
		setData.setPath("http://localhost:6969/growells/src/main/resource/static/user-photos/" + id_user + "/" + fileName);
		setData.setFile_size(fileSize);
		setData.setCreated_at(dtf.format(now));
		setData.setFullname(fullname);
		
		UserEntity savedData = userRepository.save(setData);
		
		String uploadDir = "src/main/resources/static/user-photos/" + savedData.getId_user();
		 
        FileUploadUtil.saveFile(uploadDir, fileName, path);
        
		Map<String, Object> response = new HashMap<>();
		response.put("statusCode", 200);
		response.put("message", "success");
		response.put("data", savedData);
		
		return response;
	}

}
