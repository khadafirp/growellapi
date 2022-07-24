package com.example.pos.skripsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.pos.skripsi.dto.FindProdukDTO;
import com.example.pos.skripsi.dto.GetListProdukDTO;
import com.example.pos.skripsi.dto.ProdukDTO;
import com.example.pos.skripsi.entity.ProdukEntity;

@Repository
public interface ProdukRepository extends JpaRepository<ProdukEntity, String> {

	@Query("SELECT p FROM ProdukEntity p WHERE p.id_user=:id_user")
	public List<ProdukEntity> getListProdukToko(@RequestParam(name = "id_user") String id_user);
	
//	@Query("SELECT * FROM ProdukEntity p WHERE p.id_produk=:id_produk")
//	public ProdukEntity findProduk(@RequestBody FindProdukDTO findProdukDTO);
//	
	@Modifying
	@Query("UPDATE ProdukEntity p SET p.nama_produk=:nama_produk, p.stok=:stok, id_kategori=:id_kategori, p.kode_barcode=:kode_barcode, id_user=:id_user, p.path=:path, p.size=:size, p.harga_produk=:harga_produk, p.detail_produk=:detail_produk, p.created_at=:created_at, p.updated_at=:updated_at WHERE p.id_produk=:id_produk")
	void editProduk(
		@RequestParam(name = "id_produk") String id_produk,
		@RequestParam(name = "nama_produk") String nama_produk,
		@RequestParam(name = "stok") int stok,
		@RequestParam(name = "id_kategori") String id_kategori,
		@RequestParam(name = "kode_barcode") String kode_barcode,
		@RequestParam(name = "id_user") String id_user,
		@RequestParam(name = "path") String path,
		@RequestParam(name = "size") String size,
		@RequestParam(name = "harga_produk") String harga_produk,
		@RequestParam(name = "detail_produk") String detail_produk,
		@RequestParam(name = "created_at") String created_at,
		@RequestParam(name = "updated_at") String updated_at
	);
}
