package com.example.pos.skripsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pos.skripsi.entity.RiwayatTransaksiEntity;

@Repository
public interface RiwayatTransaksiRepository extends JpaRepository<RiwayatTransaksiEntity, Integer>{

	@Query("SELECT p FROM RiwayatTransaksiEntity p WHERE p.id_toko=:id_toko")
	public List<RiwayatTransaksiEntity> getListRiwayatTransaksi(@RequestParam(name = "id_toko") String id_toko);
}
