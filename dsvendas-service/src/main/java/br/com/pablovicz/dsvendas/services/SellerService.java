package br.com.pablovicz.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pablovicz.dsvendas.dto.SellerDTO;
import br.com.pablovicz.dsvendas.entities.Seller;
import br.com.pablovicz.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;

	public List<SellerDTO> findaAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(s -> new SellerDTO(s)).collect(Collectors.toList());
	}
}
