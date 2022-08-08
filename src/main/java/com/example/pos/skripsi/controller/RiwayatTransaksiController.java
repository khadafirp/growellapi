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
@RequestMapping("/riwayat-transaksi")
public class RiwayatTransaksiController {

	@Autowired
	TransaksiService transaksiService;
	
	@PostMapping("/add-riwayat-transaksi")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> addRiwayatTransaksi(
		@RequestParam(name = "id_riwayat_transaksi") String id_riwayat_transaksi,
		@RequestParam(name = "total_amount") String total_amount,
		@RequestParam(name = "status_transaksi")int status_transaksi,
		@RequestParam(name = "id_user") String id_user,
		@RequestParam(name = "id_toko") String id_toko
	){
		ResponseEntity<Map<String, Object>> response = transaksiService.addToRiwayatTransaksi(id_riwayat_transaksi, total_amount, status_transaksi, id_user, id_toko);
		return response;
	}
	
	@PostMapping("/add-riwayat-transaksi-detail")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> addRiwayatTransaksiDetail(
		@RequestParam(name = "id_riwayat_transaksi_detail") String id_riwayat_transaksi_detail,
		@RequestParam(name = "nama_produk") String nama_produk,
		@RequestParam(name = "desc_produk") String desc_produk,
		@RequestParam(name = "harga_produk") String harga_produk,
		@RequestParam(name = "id_produk") String id_produk,
		@RequestParam(name = "id_riwayat_transaksi") String id_riwayat_transaksi,
		@RequestParam(name = "id_user") String id_user,
		@RequestParam(name = "status_transaksi") int status_transaksi,
		@RequestParam(name = "id_toko") String id_toko,
		@RequestParam(name = "created_at") String created_at,
		@RequestParam(name = "updated_at") String updated_at,
		@RequestParam(name = "jumlah_belanja") String jumlah_belanja
	){
		ResponseEntity<Map<String, Object>> response = transaksiService.addToRiwayatTransaksiDetail(id_riwayat_transaksi_detail, nama_produk, desc_produk, harga_produk, id_produk, id_riwayat_transaksi, id_user, status_transaksi, id_toko, created_at, updated_at, jumlah_belanja);
		return response;
	}
	
	@GetMapping("/list-riwayat-transaksi")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listRiwayatTransaksi(
		@RequestParam(name = "id_user") String id_user
	){
		ResponseEntity<Map<String, Object>> response = transaksiService.getListRiwayatTransaksi(id_user);
		return response;
	}
	
	@PostMapping("/detail-riwayat-transaksi")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getDetailRiwayatTransaksi(
		@RequestParam(name = "id_riwayat_transaksi") String id_riwayat_transaksi
	){
		ResponseEntity<Map<String, Object>> response = transaksiService.getDetailTransaksi(id_riwayat_transaksi);
		return response;
	}
}
