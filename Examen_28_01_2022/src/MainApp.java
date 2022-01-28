import java.time.LocalDate;
import java.util.ArrayList;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<RegistreCotxe> cotxes = new ArrayList<RegistreCotxe>();

		entrarCotxe("12345E", "Audi", "Blau", "Gasolina", LocalDate.now(), cotxes);
		entrarCotxe("12345R", "BMW", "Red", "Gasil", LocalDate.of(1978, 1, 1), cotxes);
		entrarCotxe("12345B", "Bols", "Yellow", "Electric", LocalDate.of(1979, 1, 1), cotxes);
		entrarCotxe("12345J", "Porche", "Yellow", "Electric", LocalDate.of(1970, 1, 1), cotxes);
		
		
		eliminarCotxes("Yellow", cotxes);
		for(int i = 0; i < cotxes.size(); i++) {
			System.out.println(cotxes.get(i).model);
		}
	}

	static void entrarCotxe(String matricula, String model, String color, String motor, LocalDate dataCompra, ArrayList<RegistreCotxe> cotxes) {
		RegistreCotxe data = new RegistreCotxe();
		data.matricula = matricula;
		data.model = model;
		data.color = color;
		data.motor = motor;
		data.dataCompra = dataCompra;
		cotxes.add(data);
	}

	static RegistreCotxe getOldestCar(ArrayList<RegistreCotxe> cotxes) {
		int oldestCarID = 0;
		for (int i = 0; i < cotxes.size(); i++) {
			if (i < cotxes.size() - 1) {
				if (cotxes.get(i).dataCompra.compareTo(cotxes.get(i + 1).dataCompra) < 0) {
					oldestCarID = i;
				}
			} else {
				if (cotxes.get(i).dataCompra.compareTo(cotxes.get(oldestCarID).dataCompra) < 0) {
					oldestCarID = i;
				}
			}

		}
		return cotxes.get(oldestCarID);
	}

	static ArrayList<RegistreCotxe> llistaCotxesMotor(String motor, ArrayList<RegistreCotxe> cotxes) {
		ArrayList<RegistreCotxe> sameEngine = new ArrayList<RegistreCotxe>();
		for (int i = 0; i < cotxes.size(); i++) {
			if (cotxes.get(i).motor.equalsIgnoreCase(motor)) {
				sameEngine.add(cotxes.get(i));
			}
		}
		return sameEngine;
	}

	static void eliminarCotxes(String color, ArrayList<RegistreCotxe> cotxes) {
		for (int i = 0; i < cotxes.size(); i++) {
			if(cotxes.get(i).color.equalsIgnoreCase(color)) {
				cotxes.remove(i);
				i--;
			}
		}
		
	}
	
	static String dataITV(String matricula, ArrayList<RegistreCotxe> cotxes) {
		String ITVDate = "";
		int i = 0;
		while(!cotxes.get(i).matricula.equalsIgnoreCase(matricula) && i < cotxes.size()) {
			i++;
		}
		if(cotxes.get(i).matricula.equalsIgnoreCase(matricula)) {
			int yearBuy = cotxes.get(i).dataCompra.getYear();
			if((LocalDate.now().getYear() - yearBuy) < 4) {
				//2000 -> 2004 -> 2006 -> 2008 -> 2010
				ITVDate = LocalDate.now().plusYears(4).toString();
			}
			if((LocalDate.now().getYear() - yearBuy) >= 4 && (LocalDate.now().getYear() - yearBuy) < 10) {
				ITVDate = LocalDate.now().plusYears(2).toString();
			}
			if((LocalDate.now().getYear() - yearBuy) >= 10) {
				ITVDate = LocalDate.now().plusYears(1).toString();
			}
		}
		return ITVDate;
	}
	
	static RegistreCotxe[] canviArrayListATaula(ArrayList<RegistreCotxe> cotxes) {
		RegistreCotxe[] arrayCotxes = new RegistreCotxe[cotxes.size()];
		for(int i = 0; i < arrayCotxes.length; i++) {
			arrayCotxes[i] = cotxes.get(i);
		}		
		return arrayCotxes;
	}

}
