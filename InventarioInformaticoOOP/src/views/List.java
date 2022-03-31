package views;

import java.util.ArrayList;

import models.Impresora;
import models.Inventario;
import models.Portatil;
import models.Proyector;
import models.Sobremesa;
import utils.ConsoleHelper;

public class List {
	public static void listAllLapTops(Inventario inventario) {
		for (Portatil p : inventario.getPortatiles()) {
			System.out.printf("%-10s %-10s %-10s %n", p.getMarca(), p.getModelo(), p.getUbicacion());
		}
	}

	public static void listByLocation(Inventario inventario) {
		String location = ConsoleHelper.readString("Introduce la ubicación del equipo: ");
		ArrayList<Object> list = new ArrayList<Object>();

		for (Sobremesa s : inventario.getSobremesas()) {
			list.add(s);
		}

		for (Portatil p : inventario.getPortatiles()) {
			list.add(p);
		}

		for (Proyector p : inventario.getProyectores()) {
			list.add(p);
		}

		for (Impresora i : inventario.getImpresoras()) {
			list.add(i);
		}

		System.out.println(location);
		for (Object o : list) {
			if (o instanceof Impresora) {
				Impresora i = (Impresora) o;
				if (i.getUbicacion().equals(location)) {
					System.out.println(i.getCodigo() + " " + i.getModelo());
				}
			} else if (o instanceof Proyector) {
				Proyector p = (Proyector) o;
				if (p.getUbicacion().equals(location)) {
					System.out.println(p.getCodigo() + " " + p.getModelo());
				}
			} else if (o instanceof Portatil) {
				Portatil p = (Portatil) o;
				if (p.getUbicacion().equals(location)) {
					System.out.println(p.getCodigo() + " " + p.getModelo());
				}
			} else if (o instanceof Sobremesa) {
				Sobremesa s = (Sobremesa) o;
				if (s.getUbicacion().equals(location)) {
					System.out.println(s.getCodigo() + " " + s.getModelo());
				}
			}
		}

	}

	public static void listGroupByLocation(Inventario inventario) {

		ArrayList<Object> list = new ArrayList<Object>();
		ArrayList<String> locations = new ArrayList<String>();

		for (Sobremesa s : inventario.getSobremesas()) {
			list.add(s);
			if (!locations.contains(s.getUbicacion())) {
				locations.add(s.getUbicacion());
			}
		}

		for (Portatil p : inventario.getPortatiles()) {
			list.add(p);
			if (!locations.contains(p.getUbicacion())) {
				locations.add(p.getUbicacion());
			}
		}

		for (Proyector p : inventario.getProyectores()) {
			list.add(p);
			if (!locations.contains(p.getUbicacion())) {
				locations.add(p.getUbicacion());
			}
		}

		for (Impresora i : inventario.getImpresoras()) {
			list.add(i);
			if (!locations.contains(i.getUbicacion())) {
				locations.add(i.getUbicacion());
			}
		}

		for (String l : locations) {
			System.out.printf("%n%s %n%n", l);
			for (Object o : list) {
				if (o instanceof Impresora) {
					Impresora i = (Impresora) o;
					if (i.getUbicacion().equals(l)) {
						System.out.println(i.getCodigo() + " " + i.getModelo());
					}
				} else if (o instanceof Proyector) {
					Proyector p = (Proyector) o;
					if (p.getUbicacion().equals(l)) {
						System.out.println(p.getCodigo() + " " + p.getModelo());
					}
				} else if (o instanceof Portatil) {
					Portatil p = (Portatil) o;
					if (p.getUbicacion().equals(l)) {
						System.out.println(p.getCodigo() + " " + p.getModelo());
					}
				} else if (o instanceof Sobremesa) {
					Sobremesa s = (Sobremesa) o;
					if (s.getUbicacion().equals(l)) {
						System.out.println(s.getCodigo() + " " + s.getModelo());
					}
				}
			}
			System.out.println();
		}

	}
	
	public static void listGroupByType(Inventario inventario) {
		for (Sobremesa s : inventario.getSobremesas()) {
			System.out.println(s.getCodigo() + " " + s.getModelo());
		}

		for (Portatil p : inventario.getPortatiles()) {
			System.out.println(p.getCodigo() + " " + p.getModelo());
		}

		for (Proyector p : inventario.getProyectores()) {
			System.out.println(p.getCodigo() + " " + p.getModelo());
		}

		for (Impresora i : inventario.getImpresoras()) {
			System.out.println(i.getCodigo() + " " + i.getModelo());
		}
	}
	
	public static void listGroupByState(Inventario inventario) {

		ArrayList<Object> list = new ArrayList<Object>();
		ArrayList<String> state = new ArrayList<String>();

		for (Sobremesa s : inventario.getSobremesas()) {
			list.add(s);
			if (!state.contains(s.getEstado())) {
				state.add(s.getEstado());
			}
		}

		for (Portatil p : inventario.getPortatiles()) {
			list.add(p);
			if (!state.contains(p.getEstado())) {
				state.add(p.getEstado());
			}
		}

		for (Proyector p : inventario.getProyectores()) {
			list.add(p);
			if (!state.contains(p.getEstado())) {
				state.add(p.getEstado());
			}
		}

		for (Impresora i : inventario.getImpresoras()) {
			list.add(i);
			if (!state.contains(i.getEstado())) {
				state.add(i.getEstado());
			}
		}

		for (String l : state) {
			System.out.printf("%n%s %n%n", l);
			for (Object o : list) {
				if (o instanceof Impresora) {
					Impresora i = (Impresora) o;
					if (i.getEstado().equals(l)) {
						System.out.println(i.getCodigo() + " " + i.getModelo());
					}
				} else if (o instanceof Proyector) {
					Proyector p = (Proyector) o;
					if (p.getEstado().equals(l)) {
						System.out.println(p.getCodigo() + " " + p.getModelo());
					}
				} else if (o instanceof Portatil) {
					Portatil p = (Portatil) o;
					if (p.getEstado().equals(l)) {
						System.out.println(p.getCodigo() + " " + p.getModelo());
					}
				} else if (o instanceof Sobremesa) {
					Sobremesa s = (Sobremesa) o;
					if (s.getEstado().equals(l)) {
						System.out.println(s.getCodigo() + " " + s.getModelo());
					}
				}
			}
			System.out.println();
		}

	}
}
