package org.mql.spring.dao;

import java.util.List;
import org.mql.spring.models.Module;

public interface ModuleDao {
	
	
	public List<Module> selectAll();
	public boolean insert(Module m);

}
