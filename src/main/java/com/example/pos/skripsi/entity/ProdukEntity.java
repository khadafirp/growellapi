package com.example.pos.skripsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produk")
public class ProdukEntity {
	
	@Id
	@Column(name = "id_produk")
	private String id_produk;
	
	@Column(name = "nama_produk")
	private String nama_produk;
	
	@Column(name = "stok")
	private int stok;
	
	@Column(name = "id_kategori")
	private String id_kategori;
	
	@Column(name = "kode_barcode")
	private String kode_barcode;
	
	@Column(name = "id_user")
	private String id_user;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "size")
	private String size;
	
	@Column(name = "created_at")
	private String created_at;
	
	@Column(name = "updated_at")
	private String updated_at;
	
	@Column(name = "harga_produk")
	private String harga_produk;
	
	@Column(name = "detail_produk")
	private String detail_produk;

	public String getDetail_produk() {
		return detail_produk;
	}

	public void setDetail_produk(String detail_produk) {
		this.detail_produk = detail_produk;
	}

	public String getHarga_produk() {
		return harga_produk;
	}

	public void setHarga_produk(String harga_produk) {
		this.harga_produk = harga_produk;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
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

}
