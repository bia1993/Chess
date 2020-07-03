package logica;

import java.util.ArrayList;

public class Bispo extends Peca {
	
	public static ArrayList<Integer> movimentosPossiveis (String idPeca, int casaCorrente, String[][] casasTabuleiro, int[][] idCasas) {
		ArrayList<Integer> movimentos = new ArrayList<Integer>();	
		int idCasa = casaCorrente;
		
		while (idCasa >= idCasas[0][0] && idCasa <= idCasas[7][7]) {
			idCasa = idCasa + 9;
			movimentos.add(idCasa);
		}
		idCasa = casaCorrente;
		while (idCasa >= idCasas[0][0] && idCasa <= idCasas[7][7]) {
			idCasa = idCasa - 9;
			movimentos.add(idCasa);
		}
		idCasa = casaCorrente;
		while (idCasa >= idCasas[0][0] && idCasa <= idCasas[7][7]) {
			idCasa = idCasa + 11;
			movimentos.add(idCasa);
		}
		idCasa = casaCorrente;
		while (idCasa >= idCasas[0][0] && idCasa <= idCasas[7][7]) {
			idCasa = idCasa - 11;
			movimentos.add(idCasa);
		}
		
		return movimentos;
	}

}
