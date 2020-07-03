package logica;

import java.util.ArrayList;

public class Cavalo extends Peca {
	
	public static ArrayList<Integer> movimentosPossiveis (String idPeca, int casaCorrente, String[][] casasTabuleiro, int[][] idCasas) {
		ArrayList<Integer> movimentos = new ArrayList<Integer>();	
		if (idPeca == "C")
			numJogador = 1;
		else
			numJogador = -1;
		
		movimentos.add(casaCorrente + (19 * numJogador));
		movimentos.add(casaCorrente - (19 * numJogador));
		movimentos.add(casaCorrente + (21 * numJogador));
		movimentos.add(casaCorrente - (21 * numJogador));
		movimentos.add(casaCorrente + (12 * numJogador));
		movimentos.add(casaCorrente - (12 * numJogador));
		movimentos.add(casaCorrente + (8 * numJogador));
		movimentos.add(casaCorrente - (8 * numJogador)); 
		
		return movimentos;
	}


}
