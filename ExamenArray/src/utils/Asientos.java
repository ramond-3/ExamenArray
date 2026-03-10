package utils;

public class Asientos {
	
	public static boolean reservarAsiento(char[][] sala, int filaAsiento, int columnaAsiento) {
		boolean esReservable = true;
		if (!Validacion.esPosicionValida(sala, filaAsiento, columnaAsiento) || sala[filaAsiento][columnaAsiento] != 'L') {
			esReservable = false;
		} else {
			sala[filaAsiento][columnaAsiento] = 'R';
		}
		
		return esReservable;
	}
	
	public static int[] reservarGrupoEnFila(char[][] sala, int filaDeseada, int numeroPersonas) {
		int[] asientosReservados = new int[2];
		int contAsientosConsecutivos = 0;
		for (int asientos = 0; asientos < Sala.NUM_COLUMNAS; asientos++) {
			if (sala[filaDeseada][asientos] == 'L') {
				contAsientosConsecutivos++;
			} else {
				contAsientosConsecutivos = 0;
			}
			if (contAsientosConsecutivos == 1) {
				asientosReservados[0] = sala[filaDeseada][asientos];
			}
			if (contAsientosConsecutivos == 6) {
				asientosReservados[1] = sala[filaDeseada][asientos];
				break;
			}
		}
		
		if (contAsientosConsecutivos >= numeroPersonas) {
			for (int numColumnaAsiento = asientosReservados[0]; numColumnaAsiento < asientosReservados[1]; numColumnaAsiento++) {
				reservarAsiento(sala, filaDeseada, numColumnaAsiento);	
			}	
			
		}else {
			asientosReservados = null;
		}
		
		return asientosReservados;
	}
	
	public static void confirmarReservas(char[][] sala) {
		for (int fila = 0; fila < Sala.NUM_FILAS; fila++) {
			for (int columna = 0; columna < Sala.NUM_COLUMNAS ; columna++) {
				if (sala[fila][columna] == 'R') {
					sala[fila][columna] = 'O';
				}
			}
		}
	}
	
	public static void cancelarReservas(char[][] sala) {
		for (int fila = 0; fila < Sala.NUM_FILAS; fila++) {
			for (int columna = 0; columna < Sala.NUM_COLUMNAS ; columna++) {
				if (sala[fila][columna] == 'R') {
					sala[fila][columna] = 'L';
				}
			}
		}
	}

}
