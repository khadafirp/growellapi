package com.example.pos.skripsi.dto;

import org.springframework.web.multipart.MultipartFile;

public class ResponseUserDTO {
	
	String id_user, username, password, email, no_telp, alamat_toko, nama_toko, desc_toko, path, file_size, created_at, updated_at, fullname;
	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	int user_kategori;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFile_size() {
		return file_size;
	}

	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNo_telp() {
		return no_telp;
	}

	public void setNo_telp(String no_telp) {
		this.no_telp = no_telp;
	}

	public String getAlamat_toko() {
		return alamat_toko;
	}

	public void setAlamat_toko(String alamat_toko) {
		this.alamat_toko = alamat_toko;
	}

	public int getUser_kategori() {
		return user_kategori;
	}

	public void setUser_kategori(int user_kategori) {
		this.user_kategori = user_kategori;
	}

	public String getNama_toko() {
		return nama_toko;
	}

	public void setNama_toko(String nama_toko) {
		this.nama_toko = nama_toko;
	}

	public String getDesc_toko() {
		return desc_toko;
	}

	public void setDesc_toko(String desc_toko) {
		this.desc_toko = desc_toko;
	};

}
