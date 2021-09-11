package br.com.pablovicz.dsvendas.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pablovicz.dsvendas.dto.SaleDTO;
import br.com.pablovicz.dsvendas.dto.SaleSucessDTO;
import br.com.pablovicz.dsvendas.dto.SaleSumDTO;
import br.com.pablovicz.dsvendas.entities.Sale;
import br.com.pablovicz.dsvendas.repositories.SaleRepository;
import br.com.pablovicz.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(s -> new SaleDTO(s));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSucessDTO> sucessGroupedBySeller(){
		return repository.successGroupedBySeller();
	}

}
