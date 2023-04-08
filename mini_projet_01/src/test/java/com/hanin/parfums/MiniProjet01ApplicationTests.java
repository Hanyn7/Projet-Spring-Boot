package com.hanin.parfums;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.hanin.parfums.repos.ParfumRepository;
import com.hanin.parfums.service.ParfumService;
import com.hanin.parfums.entities.Parfum;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class MiniProjet01ApplicationTests {

	@Autowired
	private ParfumRepository parfumRepository;
	@Autowired
	private ParfumService parfumService;
	@Test
	public void testCreateProduit() {
	Parfum prod = new Parfum("HERMÈS",500.0,new Date());
	parfumRepository.save(prod);
	}
	
	@Test
	public void testFindProduit()
	{
	Parfum p = parfumRepository.findById(1L).get();
	System.out.println(p);
	}
	@Test
	public void testUpdateProduit()
	{
		Parfum p = parfumRepository.findById(1L).get();
	p.setPrixParfum(1000.0);
	parfumRepository.save(p);
	}
	@Test
	public void testDeleteProduit()
	{
		parfumRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousProduits()
	{
	List<Parfum> prods = parfumRepository.findAll();
	for (Parfum p : prods)
	{
	System.out.println(p);
	}
	}

	@Test
	public void testFindByNomParfumContains()
	{
	Page<Parfum> prods = parfumService.getAllParfumsParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	
	}}



