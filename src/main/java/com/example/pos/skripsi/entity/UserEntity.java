package com.example.pos.skripsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	
	@Id
	@Column(name = "id_user")
	private String id_user;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "no_telp")
	private String no_telp;
	
	@Column(name = "user_kategori")
	private int user_kategori;
	
	@Column(name = "alamat_toko")
	private String alamat_toko;
	
	@Column(name = "nama_toko")
	private String nama_toko;
	
	@Column(name = "desc_toko")
	private String desc_toko;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "file_size")
	private String file_size;
	
	@Column(name = "created_at")
	private String created_at;
	
	@Column(name = "updated_at")
	private String updated_at;
	
	@Column(name = "fullname")
	private String fullname;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

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

	public int getUser_kategori() {
		return user_kategori;
	}

	public void setUser_kategori(int user_kategori) {
		this.user_kategori = user_kategori;
	}

	public String getAlamat_toko() {
		return alamat_toko;
	}

	public void setAlamat_toko(String alamat_toko) {
		this.alamat_toko = alamat_toko;
	}

}
