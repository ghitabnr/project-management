package org.mql.spring.repositories;


import java.util.List;

import org.mql.spring.models.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepository extends JpaRepository<Formateur, Integer>{
	public List<Formateur> findByName(String name); 
}
