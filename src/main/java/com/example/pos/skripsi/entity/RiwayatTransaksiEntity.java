package com.example.pos.skripsi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "riwayat_transaksi")
public class RiwayatTransaksiEntity {

	@Id
	@Column(name = "id_riwayat_transaksi")
	private String id_riwayat_transaksi;
	
	@Column(name = "total_amount")
	private String total_amount;
	
	@Column(name = "status_transaksi")
	private int status_transaksi;
	
	public String getId_riwayat_transaksi() {
		return id_riwayat_transaksi;
	}

	public void setId_riwayat_transaksi(String id_riwayat_transaksi) {
		this.id_riwayat_transaksi = id_riwayat_transaksi;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public int getStatus_transaksi() {
		return status_transaksi;
	}

	public void setStatus_transaksi(int status_transaksi) {
		this.status_transaksi = status_transaksi;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getId_toko() {
		return id_toko;
	}

	public void setId_toko(String id_toko) {
		this.id_toko = id_toko;
	}

	@Column(name = "id_user")
	private String id_user;
	
	@Column(name = "id_toko")
	private String id_toko;
	
	@Column(name = "created_at")
	private String created_at;

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
}
