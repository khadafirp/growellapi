package com.example.pos.skripsi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.pos.skripsi.entity.KeranjangTokoEntity;
import com.example.pos.skripsi.repository.KeranjangTokoRepository;
import com.example.pos.skripsi.repository.UserRepository;

@Service
public class TransaksiService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	KeranjangTokoRepository keranjangTokoRepository;
	
	@Transactional
	public Map<String, Object> getAllKeranjangToko(){
		List<KeranjangTokoEntity> getData = keranjangTokoRepository.findAll();
		
		Map<String, Object> response = new HashMap<>();
		response.put("statusCode", 200);
		response.put("message", "success");
		response.put("data", getData);
		
		return response;
	}
	
	@Transactional
	public ResponseEntity<Map<String, Object>> addKeranjangToko(
		String id_keranjang_toko,
		String id_user,
		String created_at
	){
		KeranjangTokoEntity getData = keranjangTokoRepository.getKeranjangToko(id_user);
		Map<String, Object> response = new HashMap<>();
		if(getData == null) {
			KeranjangTokoEntity keranjangTokoEntity = new KeranjangTokoEntity();
			keranjangTokoEntity.setId_keranjang_toko(id_keranjang_toko);
			keranjangTokoEntity.setId_user(id_user);
			keranjangTokoEntity.setCreated_at(created_at);
			
			response.put("statusCode", HttpStatus.OK);
			response.put("message", "success");
			response.put("data", keranjangTokoRepository.save(keranjangTokoEntity));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		} else {
			response.put("statusCode", HttpStatus.FOUND);
			response.put("message", "success");
			response.put("data", getData);
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.FOUND);
		}
	}
	
	@Transactional
	public ResponseEntity<Map<String, Object>> deleteKeranjangToko(
		String id_keranjang_toko
	){
		KeranjangTokoEntity getData = keranjangTokoRepository.getKeranjangToko(id_keranjang_toko);
		Map<String, Object> response = new HashMap<>();
		if(getData == null) {
			response.put("statusCode", HttpStatus.NOT_FOUND);
			response.put("message", "success");
			response.put("data", null);
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		} else {
			keranjangTokoRepository.deleteById(id_keranjang_toko);
			response.put("statusCode", HttpStatus.OK);
			response.put("message", "data is successfully deleted");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
	}

}
