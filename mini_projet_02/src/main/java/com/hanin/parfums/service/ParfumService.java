package com.hanin.parfums.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hanin.parfums.entities.Famille;
import com.hanin.parfums.entities.Parfum;

public interface ParfumService {
	Parfum saveParfum(Parfum p);
	Parfum updateParfum(Parfum p);
	void deleteParfum(Parfum p);
	 void deleteParfumById(Long id);
	 Parfum getParfum(Long id);
	List<Parfum> getAllParfums();
	Page<Parfum> getAllParfumsParPage(int page, int size);
	List<Parfum> findByNomParfum(String nom);
	List<Parfum> findByNomParfumContains(String nom);
	List<Parfum> findByNomPrix (String nom, Double prix);
	List<Parfum> findByFamille(Famille famille);
	List<Parfum> findByFamilleIdFam(Long id);
	List<Parfum> findByOrderByNomParfumAsc();
	List<Parfum> trierParfumsNomsPrix();
}
