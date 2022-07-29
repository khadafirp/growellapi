package com.example.pos.skripsi.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.example.pos.skripsi.controller.GetUserEntity;
import com.example.pos.skripsi.controller.ProdukController;
import com.example.pos.skripsi.dto.FindProdukDTO;
import com.example.pos.skripsi.dto.GetListProdukDTO;
import com.example.pos.skripsi.dto.ProdukDTO;
import com.example.pos.skripsi.dto.ResponseUserDTO;
import com.example.pos.skripsi.entity.ProdukEntity;
import com.example.pos.skripsi.entity.UserEntity;
import com.example.pos.skripsi.repository.ProdukRepository;
import com.example.pos.skripsi.security.FileUploadUtil;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Service
public class ProdukService {
	
	@Autowired
	ProdukRepository produkRepository;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	UserService userService = new UserService();
	
	@Transactional
	public Map<String, Object> getListProdukToko(String id_user){
		
		List<ProdukEntity> listProduk = produkRepository.getListProdukToko(id_user);
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		
			if(listProduk.isEmpty()) {
				response.put("statusCode", 404);
				response.put("message", "data is not found");
				response.put("data", null);
			}else {
				response.put("statusCode", 200);
				response.put("message", "success");
				response.put("data", listProduk);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return response;
		
	}
	
	@Transactional
	public String getFile(@RequestParam String filename) throws Exception {
		Resource file = fileService.load(filename);
		return file.getFilename();
	}
	
	@Transactional
	public Map<String, Object> addProduk(
		String id_produk,
		String nama_produk,
		int stok,
		String id_kategori,
		String kode_barcode,
		String id_user,
		String harga_produk,
		MultipartFile path,
		String size,
		String detail_produk
	) throws Exception{
		//Map<String, Object> dataUser = userService.findUser(username, password);
		Map<String, Object> response = new HashMap<>();
		
		String fileName = StringUtils.cleanPath(path.getOriginalFilename());
		
		String fileSize = String.valueOf(size);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		String url = MvcUriComponentsBuilder.fromMethodName(ProdukController.class, "getFile",
                fileName.toString()).build().toString();
		
		ProdukEntity produkEntity = new ProdukEntity();
		produkEntity.setId_produk(id_produk);
		produkEntity.setNama_produk(nama_produk);
		produkEntity.setStok(stok);
		produkEntity.setId_kategori(id_kategori);
		produkEntity.setKode_barcode(kode_barcode);
		produkEntity.setId_user(id_user);
		produkEntity.setPath(url + "/" + fileName);
		produkEntity.setSize(size);
		produkEntity.setCreated_at(now.toString());
		produkEntity.setUpdated_at("");
		produkEntity.setHarga_produk(harga_produk);
		produkEntity.setDetail_produk(detail_produk);
		
		ProdukEntity savedData = produkRepository.save(produkEntity);
		
		String uploadDir = "user-photos/" + savedData.getId_user();
		 
        FileUploadUtil.saveFile(url, fileName, path);
		
		response.put("statusCode", 200);
		response.put("message", "success");
		response.put("data", savedData);
		
		return response;	
	}
//	
//	@Autowired
//	public Map<String, Object> findProduk(@RequestBody FindProdukDTO findProdukDTO){
//		ProdukEntity produkEntity = produkRepository.findProduk(findProdukDTO);
//		
//		Map<String, Object> map = new HashMap<>();
//		
//		if(produkEntity == null) {
//			map.put("statusCode", 404);
//			map.put("message", "data is not found");
//			map.put("data", null);
//		}else {
//			map.put("statusCode", 200);
//			map.put("message", "success");
//			map.put("data", produkEntity);
//		}
//		
//		return map;
//	}
//	
	@Transactional
	public Map<String, Object> editProduk(
		String id_produk,
		String nama_produk,
		int stok,
		String id_kategori,
		String kode_barcode,
		String id_user,
		String harga_produk,
		MultipartFile path,
		String size,
		String detail_produk
	) throws IOException{
		String fileName = "";
		
		String fileSize = "";
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		String uploadDir = "user-photos/" + id_user;
		
		String url = MvcUriComponentsBuilder.fromMethodName(ProdukController.class, "getFile",
                fileName.toString()).build().toString();
		 
		if(!path.isEmpty()) {
			fileName = StringUtils.cleanPath(path.getOriginalFilename());
			fileSize  = String.valueOf(size);
			FileUploadUtil.saveFile(url, fileName, path);
		}		
		produkRepository.editProduk(
				id_produk,
				nama_produk,
				stok,
				id_kategori,
				kode_barcode,
				id_user,
				path.isEmpty() ? "" : (url + "/" + fileName),
				size,
				harga_produk,
				detail_produk,
				now.toString(),
				now.toString()
			);
		
		Map<String, Object> response = new HashMap<>();
		
		response.put("statusCode", 200);
		response.put("message", "success");
		
		return response;
	}
	
}
