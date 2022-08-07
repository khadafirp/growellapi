package com.example.pos.skripsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pos.skripsi.entity.RiwayatTransaksiDetailEntity;

@Repository
public interface RiwayatTransaksiDetailRepository extends JpaRepository<RiwayatTransaksiDetailEntity, String> {

	@Query("SELECT p FROM RiwayatTransaksiDetailEntity p WHERE p.id_riwayat_transaksi=:id_riwayat_transaksi")
	public List<RiwayatTransaksiDetailEntity> getListDetailRiwayatTransaksi(@RequestParam(name = "id_riwayat_transaksi") String id_riwayat_transaksi);
}
