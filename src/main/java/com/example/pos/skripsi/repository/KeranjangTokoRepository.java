package com.example.pos.skripsi.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.pos.skripsi.entity.KeranjangTokoEntity;


@Repository
public interface KeranjangTokoRepository extends JpaRepository<KeranjangTokoEntity, String>{
	@Query("SELECT p FROM KeranjangTokoEntity p WHERE p.id_user=:id_user")
	public KeranjangTokoEntity getKeranjangToko(@RequestParam(name = "id_user") String id_user);
}
