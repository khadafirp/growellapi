package com.example.pos.skripsi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pos.skripsi.service.TransaksiService;

@Controller
@RequestMapping("/keranjang-produk")
public class KeranjangProdukController {

	@Autowired
	TransaksiService transaksiService;
	
	@GetMapping("/list-produk")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getListProdukKeranjang(
		String id_keranjang_toko
	){
		ResponseEntity<Map<String, Object>> response = transaksiService.getListProdukKeranjang(id_keranjang_toko);
		return response;
	}
}
