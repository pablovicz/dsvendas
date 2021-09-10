package br.com.pablovicz.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pablovicz.dsvendas.dto.SellerDTO;
import br.com.pablovicz.dsvendas.services.SellerService;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {
	
	@Autowired
	private SellerService service;
	
	@GetMapping
	private ResponseEntity<List<SellerDTO>> findAll(){
		List<SellerDTO> list = service.findaAll();
		return ResponseEntity.ok(list);
	}

}
