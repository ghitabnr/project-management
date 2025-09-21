package org.mql.spring.dao;

import java.util.List;

import org.mql.spring.models.Formation;

public interface FormationDao {
	
	public List<Formation> selectAll();
	public boolean insert(Formation fn);

}
