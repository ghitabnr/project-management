package org.mql.spring.dao;

import java.util.List;

import org.mql.spring.models.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("formateurDaoImpl")
public class FormateurDaoImpl implements FormateurDao{
	@Autowired
	private List<Formateur> formateurs;

	@Override
	public List<Formateur> selectAll() {
		// TODO Auto-generated method stub
		return formateurs;
	}

	@Override
	public boolean insert(Formateur fr) {
		// TODO Auto-generated method stub
		return formateurs.add(fr);
	}

}
