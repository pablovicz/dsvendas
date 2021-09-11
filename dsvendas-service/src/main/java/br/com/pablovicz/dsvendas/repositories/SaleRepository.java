package br.com.pablovicz.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pablovicz.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
