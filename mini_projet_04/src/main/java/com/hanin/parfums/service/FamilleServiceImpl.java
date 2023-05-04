package com.hanin.parfums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanin.parfums.entities.Famille;
import com.hanin.parfums.repos.FamilleRepository;
@Service

public class FamilleServiceImpl implements FamilleService{
	@Autowired
	FamilleRepository famRepository;

	@Override
	public Famille saveFamille(Famille f) {
		return famRepository.save(f);
	}

	@Override
	public Famille updateFamille(Famille f) {
		return famRepository.save(f);
	}

	@Override
	public void deleteFamille(Famille f) {
		famRepository.delete(f);
		
	}

	@Override
	public void deleteParFamilleById(Long id) {
		famRepository.deleteById(id);
	}

	@Override
	public Famille getFamille(Long id) {
		return famRepository.findById(id).get();
	}

	@Override
	public List<Famille> getAllFamille() {
		return famRepository.findAll();
	}

}
