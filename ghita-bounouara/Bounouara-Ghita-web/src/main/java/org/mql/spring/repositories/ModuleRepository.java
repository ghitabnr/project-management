package org.mql.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.mql.spring.models.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer>{

	
	@Query("SELECT m FROM Module a WHERE m.titre LIKE :keyword%") 
	public List<Module> findByKeyword(String keyword); 
	
	
    @Query("SELECT f.module FROM Formation f WHERE f.formateur.id = :formateurId")
    List<Module> findModulesByFormateurId(@Param("formateurId") int formateurId);
	
}
