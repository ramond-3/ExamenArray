package utils;

public class Validacion {
	public static boolean esPosicionValida(char[][] sala, int filaAsiento, int columnaAsiento) {
		boolean esValida = true;
		
		if (filaAsiento>Sala.NUM_FILAS || columnaAsiento>Sala.NUM_COLUMNAS) {
			esValida = false;
			}
		
		return esValida;
	}
}
