package models;

import java.util.ArrayList;

public class Inventario {
	private String codigoCentro;
	private String nombreCentro;
	private ArrayList<Sobremesa> sobremesas;
	private ArrayList<Portatil> portatiles;
	private ArrayList<Proyector> proyectores;
	private ArrayList<Impresora> impresoras;
	
	public Inventario(String codigo, String instituto) {
		this.codigoCentro = codigo;
		this.nombreCentro = instituto;
		sobremesas = new ArrayList<>();
		portatiles = new ArrayList<>();
		proyectores = new ArrayList<>();
		impresoras = new ArrayList<>();
	}

	public String getCodigo() {
		return codigoCentro;
	}

	public void setCodigo(String codigo) {
		this.codigoCentro = codigo;
	}

	public String getInstituto() {
		return nombreCentro;
	}

	public void setInstituto(String instituto) {
		this.nombreCentro = instituto;
	}
	
	public void addSobremesa(Sobremesa s) {
		this.sobremesas.add(s);
	}
	
	public ArrayList<Sobremesa> getSobremesas() {
		return sobremesas;
	}
	
	public void addPortatil(Portatil p) {		 
		this.portatiles.add(p);
	}

	public ArrayList<Portatil> getPortatiles() {
		return portatiles;
	}
	
	public void addPoryector(Proyector p) {		 
		this.proyectores.add(p);
	}

	public ArrayList<Proyector> getProyectores() {
		return proyectores;
	}
	
	public void addImpresora(Impresora i) {		 
		this.impresoras.add(i);
	}

	public ArrayList<Impresora> getImpresoras() {
		return impresoras;
	}
	
	public void deleteLapTop(int positionInArray) {
		this.portatiles.remove(positionInArray);
	}
	
	public void deleteComputer(int positionInArray) {
		this.sobremesas.remove(positionInArray);
	}
	
	public void deletePrinter(int positionInArray) {
		this.impresoras.remove(positionInArray);
	}
	
	public void deletePorjector(int positionInArray) {
		this.proyectores.remove(positionInArray);
	}
	
}
