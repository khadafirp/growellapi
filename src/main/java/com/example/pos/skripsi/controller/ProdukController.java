package com.example.pos.skripsi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.example.pos.skripsi.dto.FindProdukDTO;
import com.example.pos.skripsi.dto.GetListProdukDTO;
import com.example.pos.skripsi.dto.ProdukDTO;
import com.example.pos.skripsi.security.ErrorHandling;
import com.example.pos.skripsi.service.FileService;
import com.example.pos.skripsi.service.ProdukService;

@Controller
@RequestMapping("/produk")
public class ProdukController {

	@Autowired
	ProdukService produkService;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	ErrorHandling errorHandling = new ErrorHandling();
	
//	int errorSet(HttpServletResponse response) {
//		return response.setStatus(404);
//	}
	
	public Map<String, Object> errorNotfound(){
		Map<String, Object> map = new HashMap<>();
		
		map.put("statusCode", 404);
		map.put("message", "data is not found");
		map.put("data", null);
		
		return map;
	}
	
	@PostMapping("/listProduk")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getListProdukToko(@RequestParam(name = "id_user") String id_user) throws Exception{
		
		Map<String, Object> response = produkService.getListProdukToko(id_user);
		Map<String, Object> responseError = new HashMap<>();
		
		if(response.get("statusCode").equals(200)) {
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<Map<String,Object>>(errorNotfound(), HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/addProduk")
	@ResponseBody
	public Map<String, Object> addProduk(
		@RequestParam(name = "id_produk") String id_produk,
		@RequestParam(name = "nama_produk") String nama_produk,
		@RequestParam(name = "stok") int stok,
		@RequestParam(name = "id_kategori") String id_kategori,
		@RequestParam(name = "kode_barcode") String kode_barcode,
		@RequestParam(name = "id_user") String id_user,
		@RequestParam(name = "path") MultipartFile path,
		@RequestParam(name = "size") String size,
		@RequestParam(name = "harga_produk") String harga_produk,
		@RequestParam(name = "detail_produk") String detail_produk
	) throws Exception{
		Map<String, Object> response = produkService.addProduk(id_produk, nama_produk, stok, id_kategori, kode_barcode, id_user, harga_produk, path, size, detail_produk);
		return response;
	}
//	
//	@PostMapping("/findProduk")
//	@ResponseBody
//	public Map<String, Object> findProduk(FindProdukDTO findProdukDTO){
//		Map<String, Object> response = produkService.findProduk(findProdukDTO);
//		return response;
//	}
//	
	@PostMapping("/editProduk")
	@ResponseBody
	public Map<String, Object> editProduk(
		@RequestParam(name = "id_produk") String id_produk,
		@RequestParam(name = "nama_produk") String nama_produk,
		@RequestParam(name = "stok") int stok,
		@RequestParam(name = "id_kategori") String id_kategori,
		@RequestParam(name = "kode_barcode") String kode_barcode,
		@RequestParam(name = "id_user") String id_user,
		@RequestParam(name = "path") MultipartFile path,
		@RequestParam(name = "size") String size,
		@RequestParam(name = "harga_produk") String harga_produk,
		@RequestParam(name = "detail_produk") String detail_produk
	) throws IOException{
		Map<String, Object> response = produkService.editProduk(id_produk, nama_produk, stok, id_kategori, kode_barcode, id_user, harga_produk, path, size, detail_produk);
		return response;
		
	}
	
	@GetMapping("/Download")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fileService.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;filename=\"" + file.getFilename() + "\"").body(file);

    }
	
	@GetMapping("/Download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Resource file = fileService.load(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;filename=\"" + file.getFilename() + "\"").body(file);

    }
	
}
