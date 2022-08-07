package com.example.pos.skripsi.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pos.skripsi.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	@Query("SELECT s FROM UserEntity s WHERE s.username=:username AND s.password=:password")
	public UserEntity findUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password);
	
	@Query("SELECT s FROM UserEntity s WHERE s.id_user=:id_keranjang_toko")
	public UserEntity findUserById(@RequestParam(name = "id_user") String id_keranjang_toko);
	
	@Query("SELECT s FROM UserEntity s WHERE s.id_user=:id_user")
	public UserEntity findUserByIdUser(@RequestParam(name = "id_user") String id_user);

}
