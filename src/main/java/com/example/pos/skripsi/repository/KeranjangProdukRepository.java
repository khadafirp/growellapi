package com.example.pos.skripsi.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pos.skripsi.entity.KeranjangProdukEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface KeranjangProdukRepository extends JpaRepository<KeranjangProdukEntity, String>{
	
	@Query("SELECT p FROM KeranjangProdukEntity p WHERE p.id_keranjang_toko=:id_keranjang_toko")
	public List<KeranjangProdukEntity> getListProdukKeranjang(
		@RequestParam(name = "id_keranjang_toko") String id_keranjang_toko
	);
}
