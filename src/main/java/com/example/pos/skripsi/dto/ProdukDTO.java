package com.example.pos.skripsi.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProdukDTO {
	
	String username, password, id_produk, nama_produk, id_kategori, kode_barcode, id_user, size;
	int stok;
	Character path;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId_produk() {
		return id_produk;
	}
	public void setId_produk(String id_produk) {
		this.id_produk = id_produk;
	}
	public String getNama_produk() {
		return nama_produk;
	}
	public void setNama_produk(String nama_produk) {
		this.nama_produk = nama_produk;
	}
	public String getId_kategori() {
		return id_kategori;
	}
	public void setId_kategori(String id_kategori) {
		this.id_kategori = id_kategori;
	}
	public String getKode_barcode() {
		return kode_barcode;
	}
	public void setKode_barcode(String kode_barcode) {
		this.kode_barcode = kode_barcode;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getStok() {
		return stok;
	}
	public void setStok(int stok) {
		this.stok = stok;
	}
	public Character getPath() {
		return path;
	}
	public void setPath(Character path) {
		this.path = path;
	}
}
