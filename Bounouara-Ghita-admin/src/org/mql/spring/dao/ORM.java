package org.mql.spring.dao;

import java.util.List;
import java.util.Vector;

import org.mql.spring.models.Formation;
import org.mql.spring.models.Formateur;
import org.mql.spring.models.Module;

public class ORM {
	    
	    public ORM() {
	    }
	    
	    public static Formateur getFormateur(String... row) {
	        return new Formateur(
	            getInt(row[0]),  
	            row[1],         
	            getInt(row[2]), 
	            row[3]         
	        );
	    }
	    
	    public static List<Formateur> getFormateurs(String data[][]){
	        List<Formateur> formateurs = new Vector<Formateur>();
	        for (int i=1; i<data.length;i++) {
	            formateurs.add(getFormateur(data[i]));
	        }
	        return formateurs;
	    }
	    
	    public static Module getModule(String... row) {
	        return new Module(
	            getInt(row[0]),  
	            row[1]         
	        );
	    }
	    
	    
		public static int getInt(String value) { 
			try {
				return Integer.parseInt(value);
			} catch (Exception e) {
				return -1;
			}
		}
	    public static List<Module> getModules(String data[][]){
	        List<Module> modules = new Vector<Module>();
	        for (int i=1; i<data.length;i++) {
	            modules.add(getModule(data[i]));
	        }
	        return modules;
	    }
	    
	    public static Formation getFormation(String... row) {
	        Module module = new Module(getInt(row[1]), null);
	        
	        Formateur formateur = new Formateur(getInt(row[4]), null, -1, null);
	        
	        return new Formation(
	            row[0],        
	            module,      
	            row[2],       
	            getInt(row[3]),
	            formateur 
	        );
	    }
	    
	    public static List<Formation> getFormations(String data[][]){
	        List<Formation> formations = new Vector<Formation>();
	        for (int i=1; i<data.length;i++) {
	            formations.add(getFormation(data[i]));
	        }
	        return formations;
	    }
	}
	

