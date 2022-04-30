package mainapp;

import models.Coche;
import models.Moto;
import models.Vehiculo;

public class MainApp {

	public static void main(String[] args) {
		Vehiculo[] vehiculos = new Vehiculo[7];

		Coche coche1 = new Coche("0001X", "Coche", "Todoterreno");
		Coche coche2 = new Coche("0002X", "Coche", "Deportivo");
		Coche coche3 = new Coche("0003X", "Coche", "Familiar");

		Moto moto1 = new Moto("ABC123", "Moto", "Carretera");
		Moto moto2 = new Moto("ABB456", "Moto", "Montaña");

		Vehiculo camion = new Vehiculo("CAM123", "Camion");
		Vehiculo quad = new Vehiculo("QUD986", "Quad");

		vehiculos[0] = coche1;
		vehiculos[1] = coche2;
		vehiculos[2] = coche3;
		vehiculos[3] = moto1;
		vehiculos[4] = moto2;
		vehiculos[5] = camion;
		vehiculos[6] = quad;

		for (Vehiculo v : vehiculos) {
			System.out.println(v.info());
		}

	}

}
