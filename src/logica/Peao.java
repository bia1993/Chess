package logica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import erros.MovimentoInvalidoException;
import fachada.Fachada;

public class Peao extends Peca {

	public static ArrayList<Integer> movimentosPossiveis (String idPeca, int casaCorrente, String[][] casasTabuleiro, int[][] idCasas) {
		ArrayList<Integer> movimentos = new ArrayList<Integer>();
		boolean podeComer = false;
		int idxEsq = 0, jdxEsq = 0, idxDir = 0, jdxDir = 0, idDiagEsq = 0, idDiagDir = 0;
		String conteudoDiagEsq, conteudoDiagDir;

		try {
			podeComer = Fachada.peaoPodeComer(idPeca, casaCorrente, casasTabuleiro, idCasas);
		} 
		catch (MovimentoInvalidoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		if (idPeca == "p")
			numJogador = 1;
		else
			numJogador = -1;

		movimentos.add(casaCorrente + (10 * numJogador));
		if ((casaCorrente >= 60 && casaCorrente <= 67)||(casaCorrente >= 10 && casaCorrente <= 17))
			movimentos.add(casaCorrente + (20 * numJogador));
		
//		if (podeComer) {
//			if (idPeca == "p") {
//				idDiagEsq = casaCorrente + (11 * numJogador);
//				idDiagDir = casaCorrente + (9 * numJogador);
//	
//				idxEsq = idDiagEsq / 10;
//				jdxEsq = idDiagEsq - (idDiagEsq * 10);
//				idxDir = idDiagDir / 10;
//				jdxDir = idDiagDir - (idDiagDir * 10);
//			
//				conteudoDiagEsq = casasTabuleiro[idxEsq][jdxEsq];
//				conteudoDiagDir = casasTabuleiro[idxDir][jdxDir];
//	
//				if (((conteudoDiagEsq != ".") && (Fachada.ehPrimeiroJogador(conteudoDiagEsq) == false)))
//					movimentos.add(idDiagEsq);
//				else if  (((conteudoDiagDir != ".") && (Fachada.ehPrimeiroJogador(conteudoDiagDir) == false)))
//					movimentos.add(idDiagDir);
//			}
//		
//			if (idPeca == "P") {
//				idDiagEsq = casaCorrente + (11 * numJogador);
//				idDiagDir = casaCorrente + (9 * numJogador);
//			
//				idxEsq = idDiagEsq / 10;
//				jdxEsq = idDiagEsq - (idDiagEsq * 10);
//				idxDir = idDiagDir / 10;
//				jdxDir = idDiagDir - (idDiagDir * 10);
//	
//				conteudoDiagEsq = casasTabuleiro[idxEsq][jdxEsq];
//				conteudoDiagDir = casasTabuleiro[idxDir][jdxDir];
//	
//				if (((conteudoDiagEsq != ".") && (Fachada.ehPrimeiroJogador(conteudoDiagEsq) == false)))
//					movimentos.add(idDiagEsq);
//				else if  (((conteudoDiagDir != ".") && (Fachada.ehPrimeiroJogador(conteudoDiagDir) == false)))
//					movimentos.add(idDiagDir);
//			}
//		}
		
		return movimentos;
	}

}