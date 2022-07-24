package com.example.pos.skripsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "keranjang_toko")
public class KeranjangTokoEntity {
	
	@Id
	@Column(name = "id_keranjang_toko")
	private String id_keranjang_toko;
	
	@Column(name = "id_user")
	private String id_user;
	
	@Column(name = "created_at")
	private String created_at;

	public String getId_keranjang_toko() {
		return id_keranjang_toko;
	}

	public void setId_keranjang_toko(String id_keranjang_toko) {
		this.id_keranjang_toko = id_keranjang_toko;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
}
