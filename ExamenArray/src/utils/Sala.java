package utils;


public class Sala {
	
	public final static int NUM_FILAS = 6;
	public final static int NUM_COLUMNAS = 10;
	
	public static void inicializarSala(char[][] salaAInicializar) {
		for (int fila = 0; fila < NUM_FILAS; fila++) {
			for (int columna = 0; columna < NUM_COLUMNAS; columna++) {
				salaAInicializar[fila][columna] = 'L';
			}
		}
	}
	
	public static void pintarSala(char[][] salaAPintar) {
		for (int encabezado = 0; encabezado <= NUM_COLUMNAS; encabezado++) {
			if (encabezado == 0) {
				System.out.print("  ");
			}else {
				System.out.print(encabezado + " ");
				
			}
		}
		System.out.println();
		for (int fila = 0; fila < NUM_FILAS; fila++) {
			for (int columna = 0; columna < NUM_COLUMNAS; columna++) {
				if (columna == 0) {
					System.out.print((fila + 1) + " ");
				}
				System.out.print(salaAPintar[fila][columna] + " ");
			}
			System.out.println();
		}
	}
	
	public static int contarEstado(char[][] sala, char estadoAContar) {
		int numEncontrados = 0;
		for (int fila = 0; fila < NUM_FILAS; fila++) {
			for (int columna = 0; columna < NUM_COLUMNAS ; columna++) {
				if (sala[fila][columna] == estadoAContar) {
					numEncontrados++;
				}
			}
		}
		return numEncontrados;
	}
	
	public static void mostrarEstadisticas(char[][] sala) {
		int numAsientosTotal = contarEstado(sala, 'L') + contarEstado(sala, 'R') + contarEstado(sala, 'O');
		
		System.out.println("Estadisticas:");
		System.out.println("Asientos libres: " + contarEstado(sala, 'L'));
		System.out.println("Asientos reservados: " + contarEstado(sala, 'R'));
		System.out.println("Asientos ocupados: " + contarEstado(sala, 'O'));
		System.out.println("Porcentaje de asientos ocupados: " + (contarEstado(sala, 'O')*100/numAsientosTotal) + "%");
		
		
	}
}
