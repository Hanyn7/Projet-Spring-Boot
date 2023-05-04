package com.hanin.parfums.service;

import java.util.List;

import com.hanin.parfums.dto.ParfumDTO;
import com.hanin.parfums.entities.Famille;
import com.hanin.parfums.entities.Parfum;

public interface ParfumService {
	ParfumDTO saveParfum(ParfumDTO p);
	ParfumDTO updateParfum(ParfumDTO p);

	
	ParfumDTO getParfum(Long id);
	List<ParfumDTO> getAllParfums();


	void deleteParfum(Parfum p);
	void deleteParfumById(Long id);
	List<Parfum> findByNomParfum(String nom);
	List<Parfum> findByNomParfumContains(String nom);
	List<Parfum> findByNomPrix (String nom, Double prix);
	List<Parfum> findByFamille (Famille famille);
	List<Parfum> findByFamilleIdFam(Long id);
	List<Parfum> findByOrderByNomParfumAsc();
	List<Parfum> trierParfumsNomsPrix();
	ParfumDTO convertEntityToDto (Parfum parfum);
	Parfum convertDtoToEntity(ParfumDTO parfumDto);


}
