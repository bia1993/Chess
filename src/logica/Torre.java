package logica;

import java.util.ArrayList;

public class Torre extends Peca {
	
	public static ArrayList<Integer> movimentosPossiveis (String idPeca, int casaCorrente, String[][] casasTabuleiro, int[][] idCasas) {
		ArrayList<Integer> movimentos = new ArrayList<Integer>();	
		int idCasa = casaCorrente;
		
		while (idCasa >= idCasas[0][0] && idCasa <= idCasas[7][7]) {
			idCasa = idCasa + 1;
			movimentos.add(idCasa);
		}
		idCasa = casaCorrente;
		while (idCasa >= idCasas[0][0] && idCasa <= idCasas[7][7]) {
			idCasa = idCasa - 1;
			movimentos.add(idCasa);
		}
		idCasa = casaCorrente;
		while (idCasa >= idCasas[0][0] && idCasa <= idCasas[7][7]) {
			idCasa = idCasa + 10;
			movimentos.add(idCasa);
		}
		idCasa = casaCorrente;
		while (idCasa >= idCasas[0][0] && idCasa <= idCasas[7][7]) {
			idCasa = idCasa - 10;
			movimentos.add(idCasa);
		}
		
		return movimentos;
	}


}
