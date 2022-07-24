package com.example.pos.skripsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "keranjang_produk")
public class KeranjangProdukEntity {
	
	@Id
	@Column(name = "id_keranjang_produk")
	private String id_keranjang_produk;
	
	@Column(name = "id_produk")
	private String id_produk;
	
	@Column(name = "nama_produk")
	private String nama_produk;
	
	@Column(name = "kode_barcode")
	private String kode_barcode;
	
	@Column(name = "id_user")
	private String id_user;
	
	@Column(name = "harga_produk")
	private String harga_produk;
	
	@Column(name = "detail_produk")
	private String detail_produk;
	
	@Column(name = "created_at")
	private String created_at;

	public String getId_keranjang_produk() {
		return id_keranjang_produk;
	}

	public void setId_keranjang_produk(String id_keranjang_produk) {
		this.id_keranjang_produk = id_keranjang_produk;
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

	public String getHarga_produk() {
		return harga_produk;
	}

	public void setHarga_produk(String harga_produk) {
		this.harga_produk = harga_produk;
	}

	public String getDetail_produk() {
		return detail_produk;
	}

	public void setDetail_produk(String detail_produk) {
		this.detail_produk = detail_produk;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

}
