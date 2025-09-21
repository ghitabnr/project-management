package org.mql.spring.dao;

import java.util.List;

import org.mql.spring.jdbc.Database;
import org.mql.spring.models.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("moduleDaoJdbc")
public class ModuleDaoJdbc implements ModuleDao{
	@Autowired
	private Database db;

	@Override
	public List<Module> selectAll() {
		String[][] data = db.select("formation");
		return ORM.getModules(data);
	}

	@Override
	public boolean insert(Module m) {
		// TODO Auto-generated method stub
		return db.insert("modules", m);
	}

}
