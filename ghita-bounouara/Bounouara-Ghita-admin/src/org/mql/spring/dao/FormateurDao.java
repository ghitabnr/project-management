package org.mql.spring.dao;

import java.util.List;

import org.mql.spring.models.Formateur;

public interface FormateurDao {
	
		public List<Formateur> selectAll();
		public boolean insert(Formateur fr);
	

}
