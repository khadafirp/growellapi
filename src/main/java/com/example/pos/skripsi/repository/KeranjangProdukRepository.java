package com.example.pos.skripsi.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pos.skripsi.entity.KeranjangProdukEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface KeranjangProdukRepository extends JpaRepository<KeranjangProdukEntity, String>{
	
	@Query("SELECT p FROM KeranjangProdukEntity p WHERE p.id_keranjang_toko=:id_keranjang_toko")
	public List<KeranjangProdukEntity> getListProdukKeranjang(
		@RequestParam(name = "id_keranjang_toko") String id_keranjang_toko
	);
	
	@Query("SELECT p FROM KeranjangProdukEntity p WHERE p.id_produk=:id_produk")
	public KeranjangProdukEntity getProduk(
		@RequestParam(name = "id_produk") String id_produk
	);
	
	
	@Modifying
	@Query("UPDATE KeranjangProdukEntity p SET p.id_keranjang_produk=:id_keranjang_produk, p.id_produk=:id_produk, p.nama_produk=:nama_produk, p.kode_barcode=:kode_barcode, p.id_user=:id_user, p.harga_produk=:harga_produk, p.detail_produk=:detail_produk, p.created_at=:created_at, p.path=:path, p.id_keranjang_toko=:id_keranjang_toko, p.total_amount=:total_amount, p.jumlah_belanjaan=:jumlah_belanjaan, p.edited_at=:edited_at WHERE p.id_produk=:id_produk")
	void editKeranjangProduk(
		@RequestParam(name = "id_keranjang_produk") String id_keranjang_produk,
		@RequestParam(name = "id_produk") String id_produk,
		@RequestParam(name = "nama_produk") String nama_produk,
		@RequestParam(name = "kode_barcode") String kode_barcode,
		@RequestParam(name = "id_user") String id_user,
		@RequestParam(name = "harga_produk") String harga_produk,
		@RequestParam(name = "detail_produk") String detail_produk,
		@RequestParam(name = "created_at") String created_at,
		@RequestParam(name = "path") String path,
		@RequestParam(name = "id_keranjang_toko") String id_keranjang_toko,
		@RequestParam(name = "total_amount") String total_amount,
		@RequestParam(name = "jumlah_belanjaan") int jumlah_belanjaan,
		@RequestParam(name = "edited_at") String edited_at
	);
}
