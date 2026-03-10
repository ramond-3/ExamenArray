package main;

import java.util.Iterator;
import java.util.Scanner;

import utils.*;

public class ReservaTeatro {



	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		//Definimos la matriz de los asientos
		char[][] sala = new char[Sala.NUM_FILAS][Sala.NUM_COLUMNAS];
		Sala.inicializarSala(sala);
		
		int opcionMenu;
		
		do {
			System.out.println("TEATRO");
			System.out.println("1. Mostrar sala");
			System.out.println("2. Reservar asiento suelto");
			System.out.println("3. Reservar grupo en una fila");
			System.out.println("4. Confirmar reservas (R -> O)");
			System.out.println("5. Cancelar reservas (R -> L)");
			System.out.println("6. Estadísticas");
			System.out.println("7. Salir");
			System.out.print("Introduce la opcion que desees (1-7): ");
			opcionMenu = entrada.nextInt();
			
			int numFila;
			int numColumna;
			int numPersonas;
			
			switch (opcionMenu) {
			case 1:
				Sala.pintarSala(sala);
				break;
				
			case 2:
				System.out.println("Introduzca los siguientes datos: ");
				System.out.print("Numero de fila: ");
				numFila = entrada.nextInt()-1;
				System.out.print("Numero de columna: ");
				numColumna= entrada.nextInt()-1;
				
				if(Asientos.reservarAsiento(sala, numFila, numColumna)) {
					System.out.println("Reserva tramitada.");
				}else {
					System.out.println("Reserva imposible.");
				}
				break;
				
			case 3: 
				System.out.println("Introduzca los siguientes datos: ");
				System.out.print("Numero de fila: ");
				numFila = entrada.nextInt()-1;
				System.out.print("Numero de personas: ");
				numPersonas = entrada.nextInt();
				
				int[] numButacas = Asientos.reservarGrupoEnFila(sala, numFila, numPersonas);
				if( numButacas == null) {
					System.out.println("Reserva imposible.");
				} else {
					System.out.println("Reserva tramitada.");
					System.out.println("Rango de butacas reservadas: " + numButacas[0] + "-" + numButacas[1]);
				}
				break;
			
			case 4:
				Asientos.confirmarReservas(sala);
				System.out.println("Reservas confirmadas");
				break;
			
			case 5:
				Asientos.cancelarReservas(sala);
				System.out.println("Reservas canceladas");
				break;
			
			case 6:
				Sala.mostrarEstadisticas(sala);
				break;
				
			case 7:
				System.out.println("Saliendo del programa...");
				break;
			
			}
		} while (opcionMenu != 7);
		
		
		
	}
}
