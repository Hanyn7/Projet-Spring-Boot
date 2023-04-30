package com.hanin.parfums.service;

import java.util.List;

import com.hanin.parfums.entities.Famille;
import com.hanin.parfums.entities.Parfum;

public interface FamilleService {
	Famille saveFamille(Famille f);
	Famille updateFamille(Famille f);
	void deleteFamille(Famille f);
	 void deleteParFamilleById(Long id);
	 Famille getFamille(Long id);
	List<Famille> getAllFamille();

}
