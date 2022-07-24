package com.example.pos.skripsi.dto;

import org.springframework.web.multipart.MultipartFile;

public class UserDTO {
	
	String id_user, username, password, email, no_telp, alamat_toko, nama_toko, desc_toko, path, file_size;
	int user_kategori;
	MultipartFile multipartFile;
	
	public UserDTO(String id_user, String username, String password, String email, String no_telp, String alamat_toko, String nama_toko, String desc_toko, int user_kategori, MultipartFile multipartFile, String path, String file_size) {
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.email = email;
		this.no_telp = no_telp;
		this.alamat_toko = alamat_toko;
		this.user_kategori = user_kategori;
		this.nama_toko = nama_toko;
		this.desc_toko = desc_toko;
		this.multipartFile = multipartFile;
		this.path = path;
		this.file_size = file_size;
	}

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

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
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
