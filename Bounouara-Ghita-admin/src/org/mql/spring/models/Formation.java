package org.mql.spring.models;


public class Formation {
	private String id;
	private Module module;
	private String date;
	private int duree;
	private Formateur formateur;
	
	public Formation() {
		
	}

	public Formation(String id, Module module, String date, int duree, Formateur formateur) {
		super();
		this.id = id;
		this.module = module;
		this.date = date;
		this.duree = duree;
		this.formateur = formateur;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duration) {
		this.duree = duration;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@Override
	public String toString() {
		return "Formation [id=" + id + ", module=" + module + ", date=" + date + ", duree=" + duree
				+ ", formateur=" + formateur + "]";
	}

	
	
	
}
