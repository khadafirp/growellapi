package com.example.pos.skripsi.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.pos.skripsi.entity.KeranjangProdukEntity;
import com.example.pos.skripsi.entity.KeranjangTokoEntity;
import com.example.pos.skripsi.entity.RiwayatTransaksiDetailEntity;
import com.example.pos.skripsi.entity.RiwayatTransaksiEntity;
import com.example.pos.skripsi.entity.UserEntity;
import com.example.pos.skripsi.repository.KeranjangProdukRepository;
import com.example.pos.skripsi.repository.KeranjangTokoRepository;
import com.example.pos.skripsi.repository.RiwayatTransaksiDetailRepository;
import com.example.pos.skripsi.repository.RiwayatTransaksiRepository;
import com.example.pos.skripsi.repository.UserRepository;

@Service
public class TransaksiService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	KeranjangTokoRepository keranjangTokoRepository;
	
	@Autowired
	KeranjangProdukRepository keranjangProdukRepository;
	
	@Autowired
	RiwayatTransaksiRepository riwayatTransaksiRepository;
	
	@Autowired
	RiwayatTransaksiDetailRepository riwayatTransaksiDetailRepository;
	
	@Transactional
	public Map<String, Object> getAllKeranjangToko(){
		List<KeranjangTokoEntity> getData = keranjangTokoRepository.findAll();
		List<UserEntity> detailToko = new ArrayList<>();
		List<KeranjangTokoEntity> keranjangToko = new ArrayList<>();
		Map<String, Object> tambahanData = new HashMap<>();
		
		if(getData != null) {
			for(int i = 0; i < getData.size(); i++) {
				UserEntity dataUser = userRepository.findUserById(getData.get(i).getId_keranjang_toko());
				KeranjangTokoEntity dataKeranjangToko = keranjangTokoRepository.getKeranjangToko(getData.get(i).getId_keranjang_toko());
				detailToko.add(dataUser);
				keranjangToko.add(dataKeranjangToko);
			}
		}
		
		tambahanData.put("keranjang_toko", keranjangToko);
		tambahanData.put("pemilik_toko", detailToko);
		
		Map<String, Object> response = new HashMap<>();
		response.put("statusCode", 200);
		response.put("message", "success");
		response.put("data", tambahanData);
		
		return response;
	}
	
	@Transactional
	public ResponseEntity<Map<String, Object>> addKeranjangToko(
		String id_keranjang_toko,
		String id_user
	){
		KeranjangTokoEntity getData = keranjangTokoRepository.getKeranjangToko(id_keranjang_toko);
		Map<String, Object> response = new HashMap<>();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		if(getData == null) {
			KeranjangTokoEntity keranjangTokoEntity = new KeranjangTokoEntity();
			keranjangTokoEntity.setId_keranjang_toko(id_keranjang_toko);
			keranjangTokoEntity.setId_user(id_user);
			keranjangTokoEntity.setCreated_at(dateFormat.format(date));
			
			response.put("statusCode", HttpStatus.OK);
			response.put("message", "success");
			response.put("data", keranjangTokoRepository.save(keranjangTokoEntity));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
		
		response.put("statusCode", HttpStatus.OK);
		response.put("message", "success");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
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
			keranjangTokoRepository.deleteById(getData.getId_keranjang_toko());
			response.put("statusCode", HttpStatus.OK);
			response.put("message", "data is successfully deleted");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
	}
	
	@Transactional
	public ResponseEntity<Map<String, Object>> getListProdukKeranjang(
		String id_user,
		String id_keranjang_toko
	){
		List<KeranjangProdukEntity> data = new ArrayList<>();
		if(id_user.equals(id_keranjang_toko)) {
			data = keranjangProdukRepository.getListProdukKeranjangPenjual(id_user, id_keranjang_toko);
		} else {
			data = keranjangProdukRepository.getListProdukKeranjangPembeli(id_keranjang_toko);
		}
		
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
			if(!getProduk.getId_user().equals(id_user)) {
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
			KeranjangProdukEntity data = keranjangProdukRepository.getProduk(id_produk);
			if(data != null) {
				keranjangProdukRepository.deleteById(data.getId_keranjang_produk());
			}
			response.put("statusCode", HttpStatus.OK);
			response.put("message", "data is successfully deleted");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
	}
	
	@Transactional
	public ResponseEntity<Map<String, Object>> addToRiwayatTransaksi(
		String id_riwayat_transaksi,
		String total_amount,
		int status_transaksi,
		String id_user,
		String id_toko
	){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		RiwayatTransaksiEntity riwayatTransaksiEntity = new RiwayatTransaksiEntity();
		riwayatTransaksiEntity.setId_riwayat_transaksi(id_riwayat_transaksi);
		riwayatTransaksiEntity.setTotal_amount(total_amount);
		riwayatTransaksiEntity.setStatus_transaksi(status_transaksi);
		riwayatTransaksiEntity.setId_toko(id_toko);
		riwayatTransaksiEntity.setId_user(id_user);
		riwayatTransaksiEntity.setCreated_at(dateFormat.format(date));
		
		Map<String, Object> response = new HashMap<>();
		response.put("statusCode", 200);
		response.put("message", "success");
		response.put("data", riwayatTransaksiRepository.save(riwayatTransaksiEntity));
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<Map<String, Object>> addToRiwayatTransaksiDetail(
		String id_riwayat_transaksi_detail,
		String nama_produk,
		String desc_produk,
		String harga_produk,
		String id_produk,
		String id_riwayat_transaksi,
		String id_user,
		int status_transaksi,
		String id_toko,
		String created_at,
		String edited_at
	){
		RiwayatTransaksiDetailEntity riwayatTransaksiDetailEntity = new RiwayatTransaksiDetailEntity();
		riwayatTransaksiDetailEntity.setId_riwayat_transaksi_detail(id_riwayat_transaksi_detail);
		riwayatTransaksiDetailEntity.setNama_produk(nama_produk);
		riwayatTransaksiDetailEntity.setDesc_produk(desc_produk);
		riwayatTransaksiDetailEntity.setHarga_produk(harga_produk);
		riwayatTransaksiDetailEntity.setId_produk(id_produk);
		riwayatTransaksiDetailEntity.setId_riwayat_transaksi(id_riwayat_transaksi);
		riwayatTransaksiDetailEntity.setId_user(id_user);
		riwayatTransaksiDetailEntity.setStatus_transaksi(status_transaksi);
		riwayatTransaksiDetailEntity.setId_toko(id_toko);
		riwayatTransaksiDetailEntity.setCreated_at(created_at);
		riwayatTransaksiDetailEntity.setEdited_at(edited_at);
		
		Map<String, Object> response = new HashMap<>();
		response.put("statusCode", 200);
		response.put("message", "success");
		response.put("data", riwayatTransaksiDetailRepository.save(riwayatTransaksiDetailEntity));
		
		deleteKeranjangToko(id_toko);
		deleteKeranjangProduk(id_produk);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<Map<String, Object>> getListRiwayatTransaksi(String id_toko){
		List<RiwayatTransaksiEntity> listRiwayatTransaksiToko = riwayatTransaksiRepository.getListRiwayatTransaksi(id_toko);
		List<UserEntity> listDataUser = new ArrayList<>();
		
		if(listRiwayatTransaksiToko != null) {
			for(int i = 0; i < listRiwayatTransaksiToko.size(); i++) {
				UserEntity data = userRepository.findUserById(listRiwayatTransaksiToko.get(i).getId_toko());
				if(data.getUser_kategori() == 1) {
					listDataUser.add(data);
				}
			}
		}
		
		Map<String, Object> response = new HashMap<>();
		response.put("statusCode", 200);
		response.put("message", "success");
		response.put("data", listDataUser);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	@Transactional
	public ResponseEntity<Map<String, Object>> getDetailTransaksi(String id_riwayat_transaksi){
		List<RiwayatTransaksiDetailEntity> getData = riwayatTransaksiDetailRepository.getListDetailRiwayatTransaksi(id_riwayat_transaksi);
		
		Map<String, Object> response = new HashMap<>();
		response.put("statusCode", 200);
		response.put("message", "success");
		response.put("data", getData);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}

}
