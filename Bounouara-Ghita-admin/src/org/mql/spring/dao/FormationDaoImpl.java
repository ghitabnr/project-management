package org.mql.spring.dao;

import java.util.List;

import org.mql.spring.models.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("formationDaoImpl")
public class FormationDaoImpl implements FormationDao{
	@Autowired
	private List<Formation> formations;

	@Override
	public List<Formation> selectAll() {
		return formations;
	}

	@Override
	public boolean insert(Formation fn) {
		return formations.add(fn);
	}

}
