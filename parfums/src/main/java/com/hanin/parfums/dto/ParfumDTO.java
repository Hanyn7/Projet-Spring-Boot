package com.hanin.parfums.dto;

import java.util.Date;

import com.hanin.parfums.entities.Famille;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParfumDTO {
	private Long idParfum;
	private String nomParfum;
	private Double prixParfum;
	private Date dateCreation;
	private Famille famille;
	private String nomFam;

}
