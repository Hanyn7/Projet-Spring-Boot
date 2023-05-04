package com.hanin.parfums.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanin.parfums.dto.ParfumDTO;
import com.hanin.parfums.entities.Famille;
import com.hanin.parfums.entities.Parfum;
import com.hanin.parfums.repos.ParfumRepository;

@Service
public class ParfumServiceImpl implements ParfumService {
	@Autowired
	ParfumRepository parfumRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public void deleteParfum(Parfum p) {
	parfumRepository.delete(p);
	}

	@Override
	public void deleteParfumById(Long id) {
	parfumRepository.deleteById(id);
	}

	@Override
	public ParfumDTO getParfum(Long id) {
	return convertEntityToDto( parfumRepository.findById(id).get());
	}
	
	@Override
	public List<ParfumDTO> getAllParfums() {
	return parfumRepository.findAll().stream()
			.map(this::convertEntityToDto)
			.collect(Collectors.toList());
	}

	@Override
	public ParfumDTO saveParfum(ParfumDTO p) {
		return convertEntityToDto( parfumRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public ParfumDTO updateParfum(ParfumDTO p) {
		 return convertEntityToDto(parfumRepository.save(convertDtoToEntity(p)));

	}

	@Override
	public List<Parfum> findByNomParfum(String nom) {
		return parfumRepository.findByNomParfum(nom);
	}

	@Override
	public List<Parfum> findByNomParfumContains(String nom) {
		return parfumRepository.findByNomParfumContains(nom);
	}

	@Override
	public List<Parfum> findByNomPrix(String nom, Double prix) {
		return parfumRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Parfum> findByFamille(Famille famille) {
		return parfumRepository.findByFamille(famille);
	}

	@Override
	public List<Parfum> findByFamilleIdFam(Long id) {
		return parfumRepository.findByFamilleIdFam(id);
	}

	@Override
	public List<Parfum> findByOrderByNomParfumAsc() {
		return parfumRepository.findByOrderByNomParfumAsc();
	}

	@Override
	public List<Parfum> trierParfumsNomsPrix() {
		return parfumRepository.trierParfumsNomsPrix();
	}

	@Override
	public ParfumDTO convertEntityToDto(Parfum parfum) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ParfumDTO parfumDTO = modelMapper.map(parfum, ParfumDTO.class);
		 return parfumDTO; 
		
		
		/*ParfumDTO parfumDTO = new ParfumDTO();
		parfumDTO.setIdParfum(parfum.getIdParfum());
		parfumDTO.setNomParfum(parfum.getNomParfum());
		parfumDTO.setPrixParfum(parfum.getPrixParfum());
		parfumDTO.setDateCreation(parfum.getDateCreation());
		parfumDTO.setFamille(parfum.getFamille()); 
		return parfumDTO;*/
		/*return ParfumDTO.builder()
		.idParfum(parfum.getIdParfum())
		.nomParfum(parfum.getNomParfum())
		.prixParfum(parfum.getPrixParfum())
		.dateCreation(parfum.getDateCreation())
		//.nomFam(parfum.getFamille().getNomFam())
		.famille(parfum.getFamille())
		.build();*/
		}

	@Override
	public Parfum convertDtoToEntity(ParfumDTO parfumDto) {
		
		Parfum parfum = new Parfum();
		parfum = modelMapper.map(parfumDto,Parfum.class);
		return parfum;

		/*Parfum parfum = new Parfum();
		parfum.setIdParfum(parfumDto.getIdParfum());
		parfum.setNomParfum(parfumDto.getNomParfum());
		parfum.setPrixParfum(parfumDto.getPrixParfum());
		parfum.setDateCreation(parfumDto.getDateCreation());
		parfum.setFamille(parfumDto.getFamille());
		 return parfum;*/
	}
	}

	

