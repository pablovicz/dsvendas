package br.com.pablovicz.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pablovicz.dsvendas.dto.SaleSucessDTO;
import br.com.pablovicz.dsvendas.dto.SaleSumDTO;
import br.com.pablovicz.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new br.com.pablovicz.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	public List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new br.com.pablovicz.dsvendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	public List<SaleSucessDTO> successGroupedBySeller();


}
