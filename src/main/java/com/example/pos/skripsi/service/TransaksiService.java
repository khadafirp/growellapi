package com.example.pos.skripsi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.pos.skripsi.entity.KeranjangProdukEntity;
import com.example.pos.skripsi.entity.KeranjangTokoEntity;
import com.example.pos.skripsi.repository.KeranjangProdukRepository;
import com.example.pos.skripsi.repository.KeranjangTokoRepository;
import com.example.pos.skripsi.repository.UserRepository;

@Service
public class TransaksiService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	KeranjangTokoRepository keranjangTokoRepository;
	
	@Autowired
	KeranjangProdukRepository keranjangProdukRepository;
	
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
			response.put("message", "sorry, could not duplicate data");
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
	
	@Transactional
	public ResponseEntity<Map<String, Object>> getListProdukKeranjang(
		String id_user
	){
		List<KeranjangProdukEntity> data = keranjangProdukRepository.getListProdukKeranjang(id_user);
		Map<String, Object> response = new HashMap<>();
		
		if(data == null) {
			response.put("statusCode", HttpStatus.NOT_FOUND);
			response.put("message", "success");
			
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		} else {
			response.put("statusCode", HttpStatus.OK);
			response.put("message", "success");
			response.put("data", data);
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
	}
	
	@Transactional
	public ResponseEntity<Map<String, Object>> addKeranjangProduk(
		String id_keranjang_produk,
		String id_produk,
		String nama_produk,
		String kode_barcode,
		String id_user,
		String harga_produk,
		String detail_produk,
		String created_at,
		String path,
		String id_keranjang_toko,
		String total_amount,
		int jumlah_belanjaan,
		String edited_at
	){
		KeranjangProdukEntity getProduk = keranjangProdukRepository.getProduk(id_produk);
		KeranjangProdukEntity entity = new KeranjangProdukEntity();
		Map<String, Object> response = new HashMap<>();
		
		if(getProduk == null) {
			entity.setId_keranjang_produk(id_keranjang_produk);
			entity.setId_produk(id_produk);
			entity.setNama_produk(nama_produk);
			entity.setKode_barcode(kode_barcode);
			entity.setId_user(id_user);
			entity.setHarga_produk(harga_produk);
			entity.setCreated_at(created_at);
			entity.setPath(path);
			entity.setId_keranjang_toko(id_keranjang_toko);
			entity.setTotal_amount(total_amount);
			entity.setJumlah_belanjaan(jumlah_belanjaan);
			entity.setEdited_at(edited_at);
			
			response.put("statusCode", HttpStatus.OK);
			response.put("message", "success");
			response.put("data", keranjangProdukRepository.save(entity));
		} else {
			int jumBelanja = getProduk.getJumlah_belanjaan() + jumlah_belanjaan;
			String jumlahBayar = String.valueOf(Integer.parseInt(getProduk.getHarga_produk()) + Integer.parseInt(harga_produk));
			keranjangProdukRepository.editKeranjangProduk(id_keranjang_produk, id_produk, nama_produk, kode_barcode, id_user, harga_produk, detail_produk, created_at, path, id_keranjang_toko, jumlahBayar, jumBelanja, edited_at);
			response.put("statusCode", HttpStatus.OK);
			response.put("message", "success");
			response.put("data", null);
		}
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<Map<String, Object>> deleteKeranjangProduk(
		String id_produk
	){
		KeranjangProdukEntity getData = keranjangProdukRepository.getProduk(id_produk);
		Map<String, Object> response = new HashMap<>();
		if(getData == null) {
			response.put("statusCode", HttpStatus.NOT_FOUND);
			response.put("message", "success");
			response.put("data", null);
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		} else {
			keranjangProdukRepository.deleteById(id_produk);
			response.put("statusCode", HttpStatus.OK);
			response.put("message", "data is successfully deleted");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
	}

}
