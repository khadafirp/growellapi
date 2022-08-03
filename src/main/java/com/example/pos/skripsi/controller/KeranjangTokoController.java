package com.example.pos.skripsi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pos.skripsi.service.TransaksiService;

@Controller
@RequestMapping("/keranjang-toko")
public class KeranjangTokoController {

	@Autowired
	TransaksiService transaksiService;
	
	@GetMapping("/list-keranjang-toko")
	@ResponseBody
	public  Map<String, Object> getAllKeranjangToko(){
		Map<String, Object> response = transaksiService.getAllKeranjangToko();
		return response;
	}
	
	@PostMapping("/tambah-keranjang-toko")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> addKeranjangToko(
		@RequestParam(name = "id_keranjang_toko") String id_keranjang_toko,
		@RequestParam(name = "id_user") String id_user
	){
		ResponseEntity<Map<String, Object>> response = transaksiService.addKeranjangToko(id_keranjang_toko, id_user);
		return response;
	}
	
	@DeleteMapping("/hapus-keranjang-toko")
	public ResponseEntity<Map<String, Object>> hapusKeranjangToko(@RequestParam(name = "id_keranjang_toko") String id_keranjang_toko){
		ResponseEntity<Map<String, Object>> response = transaksiService.deleteKeranjangToko(id_keranjang_toko);
		return response;
	}
}
