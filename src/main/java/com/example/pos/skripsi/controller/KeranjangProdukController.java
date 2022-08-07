package com.example.pos.skripsi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		@RequestParam(name = "id_user") String id_user,
		@RequestParam(name = "id_keranjang_toko") String id_keranjang_toko
	){
		ResponseEntity<Map<String, Object>> response = transaksiService.getListProdukKeranjang(id_user, id_keranjang_toko);
		return response;
	}
	
	@PostMapping("/add-keranjang-produk")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> addKeranjangProduk(
		@RequestParam(name = "id_keranjang_produk") String id_keranjang_produk,
		@RequestParam(name = "id_produk") String id_produk,
		@RequestParam(name = "nama_produk") String nama_produk,
		@RequestParam(name = "kode_barcode") String kode_barcode,
		@RequestParam(name = "id_user") String id_user,
		@RequestParam(name = "harga_produk") String harga_produk,
		@RequestParam(name = "detail_produk") String detail_produk,
		@RequestParam(name = "created_at") String created_at,
		@RequestParam(name = "path") String path,
		@RequestParam(name = "id_keranjang_toko") String id_keranjang_toko,
		@RequestParam(name = "total_amount") String total_amount,
		@RequestParam(name = "jumlah_belanjaan") int jumlah_belanjaan,
		@RequestParam(name = "edited_at") String edited_at
	){
		ResponseEntity<Map<String,Object>> response = transaksiService.addKeranjangProduk(id_keranjang_produk, id_produk, nama_produk, kode_barcode, id_user, harga_produk, detail_produk, created_at, path, id_keranjang_toko, total_amount, jumlah_belanjaan, edited_at);
		return response;
	}
	
}
