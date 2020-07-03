package logica;

import java.util.ArrayList;

public class Rei extends Peca {
	
	public static ArrayList<Integer> movimentosPossiveis (String idPeca, int casaCorrente, String[][] casasTabuleiro, int[][] idCasas) {
		ArrayList<Integer> movimentos = new ArrayList<Integer>();	
		
		movimentos.add(casaCorrente + 10);
		movimentos.add(casaCorrente - 10);
		movimentos.add(casaCorrente + 1);
		movimentos.add(casaCorrente - 1);
		movimentos.add(casaCorrente + 9);
		movimentos.add(casaCorrente - 9);
		movimentos.add(casaCorrente + 11);
		movimentos.add(casaCorrente - 11); 
		
		return movimentos;
	}


}
