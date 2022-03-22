package views;

import java.util.HashMap;

import models.Impresora;
import models.Inventario;
import models.Portatil;
import models.Proyector;
import models.Sobremesa;
import utils.ConsoleHelper;

public class Delete {
	public static void deleteLapTop(Inventario inventario) {
		String codigoPortatil = ConsoleHelper.readString("Introduce el codigo del portatil: ");
		
		HashMap<String, Portatil> mapper = new HashMap<String, Portatil>();
		
		for(Portatil p : inventario.getPortatiles()) {
			mapper.put(p.getCodigo(), p);
		}
		
		inventario.deleteLapTop(inventario.getPortatiles().indexOf(mapper.get(codigoPortatil)));
	}
	
	public static void deleteComputer(Inventario inventario) {
		String codigoSobremesa = ConsoleHelper.readString("Introduce el codigo del sobremesa: ");
		
		HashMap<String, Sobremesa> mapper = new HashMap<String, Sobremesa>();
		
		for(Sobremesa s : inventario.getSobremesas()) {
			mapper.put(s.getCodigo(), s);
		}
		
		inventario.deleteComputer(inventario.getSobremesas().indexOf(mapper.get(codigoSobremesa)));
	}
	
	public static void deletePrinter(Inventario inventario) {
		String codigoImpresora = ConsoleHelper.readString("Introduce el codigo de la impresora: ");
		
		HashMap<String, Impresora> mapper = new HashMap<String, Impresora>();
		
		for(Impresora i : inventario.getImpresoras()) {
			mapper.put(i.getCodigo(), i);
		}
		
		inventario.deletePrinter(inventario.getImpresoras().indexOf(mapper.get(codigoImpresora)));
	}
	
	public static void deleteProjector(Inventario inventario) {
		String codigoProyector = ConsoleHelper.readString("Introduce el codigo del proyector: ");
		
		HashMap<String, Proyector> mapper = new HashMap<String, Proyector>();
		
		for(Proyector p : inventario.getProyectores()) {
			mapper.put(p.getCodigo(), p);
		}
		
		inventario.deletePorjector(inventario.getProyectores().indexOf(mapper.get(codigoProyector)));
	}
}
