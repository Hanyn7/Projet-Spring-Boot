package com.hanin.parfums.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hanin.parfums.entities.Famille;
import com.hanin.parfums.entities.Parfum;

@RepositoryRestResource(path = "rest")
public interface ParfumRepository extends JpaRepository<Parfum, Long> {
	List<Parfum> findByNomParfum(String nom);
    List<Parfum> findByNomParfumContains(String nom); 
    @Query("select p from Parfum p where p.nomParfum like %?1 and p.prixParfum > ?2")
    List<Parfum> findByNomPrix  (@Param("nom") String nom,@Param("prix") Double prix);
    @Query("select p from Parfum p where p.famille = ?1")
    List<Parfum> findByFamille (Famille famille);
    List<Parfum> findByFamilleIdFam(Long id);
    List<Parfum> findByOrderByNomParfumAsc();
    @Query("select p from Parfum p order by p.nomParfum ASC, p.prixParfum DESC")
    List<Parfum> trierParfumsNomsPrix ();


}