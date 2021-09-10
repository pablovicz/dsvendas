package br.com.pablovicz.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pablovicz.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository	<Seller, Long>{

}
