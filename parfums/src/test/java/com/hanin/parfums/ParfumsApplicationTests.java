package com.hanin.parfums;

import com.hanin.parfums.entities.*;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hanin.parfums.repos.ParfumRepository;

@SpringBootTest
class ParfumsApplicationTests {

	@Autowired
	private ParfumRepository parfumRepository;
	@Test
	public void testCreateParfum() {
		Parfum prod = new Parfum("parfum",2200.500,new Date());
		parfumRepository.save(prod);
	}
	@Test
	public void testFindParfum()
	{
	Parfum p = parfumRepository.findById(1L).get();
	System.out.println(p);
	}

	@Test
	public void testUpdateParfum()
	{
	Parfum p = parfumRepository.findById(1L).get();
	p.setPrixParfum(1000.0);
	parfumRepository.save(p);
	}

	@Test
	public void testDeleteParfum()
	{
	parfumRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousParfums()
	{
	List<Parfum> parfs = parfumRepository.findAll();
	for (Parfum p : parfs)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByNomParfum()
	{
	List<Parfum> prods = parfumRepository.findByNomParfum("dior");
	for (Parfum p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByNomParfumContains ()
	{
	List<Parfum> prods=parfumRepository.findByNomParfumContains("dior");
	for (Parfum p : prods)
	{
	System.out.println(p);
	} }
	
	@Test
	public void testfindByNomPrix()
	{
	List<Parfum> prods = parfumRepository.findByNomPrix("dior", 250.0);
	for (Parfum p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testfindByFamille()
	{
		Famille cat = new Famille();
	cat.setIdFam(1L);
	List<Parfum> prods = parfumRepository.findByFamille(cat);
	for (Parfum p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void findByFamilleIdCat()
	{
	List<Parfum> prods = parfumRepository.findByFamilleIdFam(1L);
	for (Parfum p : prods)
	{
	System.out.println(p);
	}
	 }
	@Test
	public void testfindByOrderByNomParfumAsc()
	{
	List<Parfum> prods = parfumRepository.findByOrderByNomParfumAsc();
	for (Parfum p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testTrierParfumsNomsPrix()
	{
	List<Parfum> prods = parfumRepository.trierParfumsNomsPrix();
	for (Parfum p : prods)
	{
	System.out.println(p);
	}
	}
	
	
	
	
}
