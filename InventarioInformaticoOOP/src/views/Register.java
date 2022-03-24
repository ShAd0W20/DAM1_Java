package views;

import models.Impresora;
import models.Inventario;
import models.Portatil;
import models.Proyector;
import models.Sobremesa;
import utils.ConsoleHelper;

public class Register {
	
	public static void RegisterNewLapTop(Inventario inventario) {
		String codigo = ConsoleHelper.readString("Introduce el codigo del portatil: ");
		String marca = ConsoleHelper.readString("Introduce la marca: ");
		String modelo = ConsoleHelper.readString("Introduce el modelo: ");
		String ubicacion = ConsoleHelper.readString("Introduce la ubicacion donde se encuentra: ");
		String estado = ConsoleHelper.readString("Introduce el estado en el que se encuentra: ");
		int ram = ConsoleHelper.readInteger("Introduce la ram que dispone: ");
		String procesador = ConsoleHelper.readString("Introduce el procesador que lleva: ");
		String discoDuro = ConsoleHelper.readString("Introduce el discor duro que lleva: ");
		int pulgadas = ConsoleHelper.readInteger("Introduce las pulgadas de la pantalla: ");
		String conexionExterna = ConsoleHelper.readString("Introduce las conexiones externas: ");
		
		Portatil p = new Portatil(codigo, marca, modelo, ubicacion, estado, ram, procesador, discoDuro, pulgadas, conexionExterna);
		inventario.addPortatil(p);
	}
	
	public static void RegisterNewComputer(Inventario inventario) {
		String codigo = ConsoleHelper.readString("Introduce el codigo del ordenador: ");
		String marca = ConsoleHelper.readString("Introduce la marca: ");
		String modelo = ConsoleHelper.readString("Introduce el modelo: ");
		String ubicacion = ConsoleHelper.readString("Introduce la ubicacion donde se encuentra: ");
		String estado = ConsoleHelper.readString("Introduce el estado en el que se encuentra: ");
		int ram = ConsoleHelper.readInteger("Introduce la ram que dispone: ");
		String procesador = ConsoleHelper.readString("Introduce el procesador que lleva: ");
		String discoDuro = ConsoleHelper.readString("Introduce el discor duro que lleva: ");
		String pantalla = ConsoleHelper.readString("Introduce la pantalla que tiene: ");
		String perifericos = ConsoleHelper.readString("Introduce los perifericos que dispone: ");
		
		Sobremesa p = new Sobremesa(codigo, marca, modelo, ubicacion, estado, ram, procesador, discoDuro, pantalla, perifericos);
		inventario.addSobremesa(p);
	}
	
	public static void RegisterNewPrinter(Inventario inventario) {
		String codigo = ConsoleHelper.readString("Introduce el codigo de la impresora: ");
		String marca = ConsoleHelper.readString("Introduce la marca: ");
		String modelo = ConsoleHelper.readString("Introduce el modelo: ");
		String ubicacion = ConsoleHelper.readString("Introduce la ubicacion donde se encuentra: ");
		String estado = ConsoleHelper.readString("Introduce el estado en el que se encuentra: ");
		String tipo = ConsoleHelper.readString("Introduce el tipo de impresora: ");
		String conexionActual = ConsoleHelper.readString("Introduce como esta conectada: ");
		
		Impresora i = new Impresora(codigo, marca, modelo, ubicacion, estado, tipo, conexionActual);
		inventario.addImpresora(i);
	}
	
	public static void RegisterNewProjector(Inventario inventario) {
		String codigo = ConsoleHelper.readString("Introduce el codigo del proyector: ");
		String marca = ConsoleHelper.readString("Introduce la marca: ");
		String modelo = ConsoleHelper.readString("Introduce el modelo: ");
		String ubicacion = ConsoleHelper.readString("Introduce la ubicacion donde se encuentra: ");
		String estado = ConsoleHelper.readString("Introduce el estado en el que se encuentra: ");
		String conector = ConsoleHelper.readString("Introduce como esta conectado: ");
		int lumnes = ConsoleHelper.readInteger("Introduce los lumens del proyector: ");
		String resolucion = ConsoleHelper.readString("Introduce la resolucion del proyector: ");
		
		Proyector p = new Proyector(codigo, marca, modelo, ubicacion, estado, conector, lumnes, resolucion);
		inventario.addPoryector(p);
	}
	
}
