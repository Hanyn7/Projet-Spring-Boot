package com.hanin.parfums.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Famille {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFam;
	private String nomFam;
	private String descriptionFam;
	@JsonIgnore
	@OneToMany(mappedBy = "famille")
	private List<Parfum> parfums;
	

}
