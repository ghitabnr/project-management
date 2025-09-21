package org.mql.spring;

import java.util.List;

import org.mql.spring.business.FormationServices;
import org.mql.spring.models.Formateur;
import org.mql.spring.models.Module;
import org.mql.spring.models.Formation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EntryPoint {
	ApplicationContext context;
	
	public EntryPoint() {
		loadContext();
		exp01();
	}
	
	public void loadContext() {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	public void exp01() {
		FormationServices service = context.getBean(FormationServices.class);
		service.saveAllFormateurs();
		service.saveAllFormations();
		service.saveAllModules();
		
		List<Formateur> formateurs = service.getAllFormateurs();
		System.out.println("Formateurs");
		for (Formateur formateur : formateurs) {
			System.out.println(formateur);
		}
		System.out.println("Modules");
		List<Module> modules = service.getAllModules();
		for (Module module : modules) {
			System.out.println(module);
		}
		System.out.println("Formations");
		List<Formation> formations = service.getAllFormations();
		for (Formation formation : formations) {
			System.out.println(formation);
		}
		
	}
	
	
	public static void main(String[] args) {
		new EntryPoint();
	}
	
	
}
