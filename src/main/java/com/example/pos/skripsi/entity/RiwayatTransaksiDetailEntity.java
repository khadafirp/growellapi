package com.example.pos.skripsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "riwayat_transaksi_detail")
public class RiwayatTransaksiDetailEntity {

	@Id
	@Column(name = "id_riwayat_transaksi_detail")
	private String id_riwayat_transaksi_detail;
	
	@Column(name = "nama_produk")
	private String nama_produk;
	
	@Column(name = "desc_produk")
	private String desc_produk;
	
	@Column(name = "harga_produk")
	private String harga_produk;
	
	@Column(name = "id_produk")
	private String id_produk;
	
	@Column(name = "id_riwayat_transaksi")
	private String id_riwayat_transaksi;
	
	@Column(name = "id_user")
	private String id_user;
	
	@Column(name = "created_at")
	private String created_at;
	
	@Column(name = "edited_at")
	private String edited_at;
	
	@Column(name = "status_transaksi")
	private int status_transaksi;
	
	@Column(name = "id_toko")
	private String id_toko;
	
	@Column(name = "jumlah_belanja")
	private String jumlah_belanja;

	public String getJumlah_belanja() {
		return jumlah_belanja;
	}

	public void setJumlah_belanja(String jumlah_belanja) {
		this.jumlah_belanja = jumlah_belanja;
	}

	public String getId_riwayat_transaksi_detail() {
		return id_riwayat_transaksi_detail;
	}

	public void setId_riwayat_transaksi_detail(String id_riwayat_transaksi_detail) {
		this.id_riwayat_transaksi_detail = id_riwayat_transaksi_detail;
	}

	public String getNama_produk() {
		return nama_produk;
	}

	public void setNama_produk(String nama_produk) {
		this.nama_produk = nama_produk;
	}

	public String getDesc_produk() {
		return desc_produk;
	}

	public void setDesc_produk(String desc_produk) {
		this.desc_produk = desc_produk;
	}

	public String getHarga_produk() {
		return harga_produk;
	}

	public void setHarga_produk(String harga_produk) {
		this.harga_produk = harga_produk;
	}

	public String getId_produk() {
		return id_produk;
	}

	public void setId_produk(String id_produk) {
		this.id_produk = id_produk;
	}

	public String getId_riwayat_transaksi() {
		return id_riwayat_transaksi;
	}

	public void setId_riwayat_transaksi(String id_riwayat_transaksi) {
		this.id_riwayat_transaksi = id_riwayat_transaksi;
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

	public String getEdited_at() {
		return edited_at;
	}

	public void setEdited_at(String edited_at) {
		this.edited_at = edited_at;
	}

	public int getStatus_transaksi() {
		return status_transaksi;
	}

	public void setStatus_transaksi(int status_transaksi) {
		this.status_transaksi = status_transaksi;
	}

	public String getId_toko() {
		return id_toko;
	}

	public void setId_toko(String id_toko) {
		this.id_toko = id_toko;
	}
}
