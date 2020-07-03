package fachada;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logica.Bispo;
import logica.Cavalo;
import logica.Logica;
import logica.Peao;
import logica.Rainha;
import logica.Rei;
import logica.Torre;
import erros.MovimentoInvalidoException;
import gui.Casa;
import gui.Tabuleiro;

public class Fachada {
	
	public static String[][] pegaCasas () {
		return Logica.casasTabuleiro;
	} 

	public static int[][] pegaIdCasas () {
		return Logica.idCasas;
	}
	
	public static ArrayList<Integer> pegaMovimentosPossiveisPeao (String idPeca, int idCasaCorrente, String[][] casasTabuleiro, int[][] idCasas) {
		return Peao.movimentosPossiveis(idPeca, idCasaCorrente, casasTabuleiro, idCasas);
	}
	
	public static ArrayList<Integer> pegaMovimentosPossiveisBispo (String idPeca, int idCasaCorrente, String[][] casasTabuleiro, int[][] idCasas) {
		return Bispo.movimentosPossiveis(idPeca, idCasaCorrente, casasTabuleiro, idCasas);
	}
	
	public static ArrayList<Integer> pegaMovimentosPossiveisCavalo (String idPeca, int idCasaCorrente, String[][] casasTabuleiro, int[][] idCasas) {
		return Cavalo.movimentosPossiveis(idPeca, idCasaCorrente, casasTabuleiro, idCasas);
	}
	
	public static ArrayList<Integer> pegaMovimentosPossiveisTorre (String idPeca, int idCasaCorrente, String[][] casasTabuleiro, int[][] idCasas) {
		return Torre.movimentosPossiveis(idPeca, idCasaCorrente, casasTabuleiro, idCasas);
	}
	
	public static ArrayList<Integer> pegaMovimentosPossiveisRei (String idPeca, int idCasaCorrente, String[][] casasTabuleiro, int[][] idCasas) {
		return Rei.movimentosPossiveis(idPeca, idCasaCorrente, casasTabuleiro, idCasas);
	}
	
	public static ArrayList<Integer> pegaMovimentosPossiveisRainha (String idPeca, int idCasaCorrente, String[][] casasTabuleiro, int[][] idCasas) {
		return Rainha.movimentosPossiveis(idPeca, idCasaCorrente, casasTabuleiro, idCasas);
	}
	
	public static boolean verificaColuna (int casaCorrente, int casaDestino, String[][] casasTabuleiro) {
		int i, idxCorrente = 0, jdxCorrente = 0, idxDestino = 0, jdxDestino = 0;
		int caminho;
		boolean caminhoLivre = false;
		idxCorrente = casaCorrente / 10;
		jdxCorrente = casaCorrente - (idxCorrente * 10);
		idxDestino = casaDestino / 10;
		jdxDestino = casaDestino - (idxDestino * 10);
		if (jdxCorrente == jdxDestino) {
			caminho = Math.abs(idxCorrente - idxDestino);
			for (i = 0; i < caminho; i++) {
				if (casasTabuleiro[i][jdxDestino] == ".")
					break;
				else 
					caminhoLivre = true;	
			}
		}
		return caminhoLivre; 
	}
	
	public static boolean verificaLinha (int casaCorrente, int casaDestino, String[][] casasTabuleiro) {
		int i, idxCorrente = 0, jdxCorrente = 0, idxDestino = 0, jdxDestino = 0;
		int caminho;
		boolean caminhoLivre = false;
		idxCorrente = casaCorrente / 10;
		jdxCorrente = casaCorrente - (idxCorrente * 10);
		idxDestino = casaDestino / 10;
		jdxDestino = casaDestino - (idxDestino * 10);
		if (idxCorrente == idxDestino) {
			caminho = Math.abs(jdxCorrente - jdxDestino);
			for (i = 0; i < caminho; i++) {
				if (casasTabuleiro[idxDestino][i] == ".")
					break;
				else 
					caminhoLivre = true;
			}	
		}
		return caminhoLivre; 	
	}
	
//	public static boolean verificaDiagonal (int casaCorrente, int casaDestino, String[][] casasTabuleiro) {
//		int i, idxCorrente = 0, jdxCorrente = 0, idxDestino = 0, jdxDestino = 0;
//		
//	}
	//verificaColuna ( X!!!!!!!!!! <o1> == <d1> )
	//verificaLinha  ( Y!!!!!!!!!! <o2> == <d2> )
	//verificaDiagonal ( NADA!!!! <o1> != <d1> <o2> != <d2>  )
	
	public static boolean podeMover (String idPeca, int casaDestino, String[][] casasTabuleiro, int[][] idCasas, ArrayList<Integer> movimentosPossiveis) throws MovimentoInvalidoException  {
		int k, idx = 0, jdx = 0;
		boolean destinoValido = false;
		for (k = 0; k < movimentosPossiveis.size(); k++) {
			if (casaDestino == movimentosPossiveis.get(k)) {
				destinoValido = true;
				break;
			}
		}
		
		if (destinoValido == false) {
			System.out.println("Esse destino não é válido.");
			throw new MovimentoInvalidoException();
		}
		
		if (destinoValido) {
			idx = casaDestino / 10;
			jdx = casaDestino - (idx * 10);
		}
		// a fazer
		if (casasTabuleiro[idx][jdx] == ".") {
			//if(idPeca == "T" || idPeca == "t") {
				//if(verificaColuna(jdx, casaDestino, casasTabuleiro) || verificaLinha(jdx, casaDestino, casasTabuleiro))
				return true;
			//}
		}	
		else
			System.out.println("Esta casa está ocupada.");
		
		return false;
	}
	
	public static String[][] atualizaTabuleiro (String idPeca, int casaCorrente, int casaDestino, String[][] casasTabuleiro, int[][] idCasas) {
		int i, idxCorrente = 0, jdxCorrente = 0, idxDestino = 0, jdxDestino = 0;
		int corrente = 0, destino = 0;
		Casa[] arrayCasas = Tabuleiro.arrayCasas;
		
		idxCorrente = casaCorrente / 10;
		jdxCorrente = casaCorrente - (idxCorrente * 10);
		idxDestino = casaDestino / 10;
		jdxDestino = casaDestino - (idxDestino * 10);

		for (i = 0; i < 64; i++) {
			if (arrayCasas[i].idCasa == casaCorrente)
				corrente = i;
			if (arrayCasas[i].idCasa == casaDestino)
				destino = i;
		}
		casasTabuleiro[idxCorrente][jdxCorrente] = ".";
		casasTabuleiro[idxDestino][jdxDestino] = idPeca;
		arrayCasas[corrente].conteudoCasa = ".";
		arrayCasas[destino].conteudoCasa = idPeca;
		
		return casasTabuleiro;
	}

	public static boolean ehPrimeiroJogador (String idPeca) {
		
		if ((idPeca == "P") || (idPeca == "B") || (idPeca == "C") || (idPeca == "T") || (idPeca == "E") || (idPeca == "A"))
			return true;
		else
			return false;
	}

	public static boolean podeComer (String idPeca, int casaDestino, String[][] casasTabuleiro, int[][] idCasas, ArrayList<Integer> movimentosPossiveis) throws MovimentoInvalidoException {
		int k, idx = 0, jdx = 0;
		boolean destinoValido = false;
		for (k = 0; k < movimentosPossiveis.size(); k++) {
			if (casaDestino == movimentosPossiveis.get(k)) {
				destinoValido = true;
				break;
			}
		}
		if (destinoValido == false) {
			System.out.println("Esse destino não é válido.");
			throw new MovimentoInvalidoException();
		}
		
		if (destinoValido) {
			idx = casaDestino / 10;
			jdx = casaDestino - (idx * 10);
		}
		
		/* Se a peça a ser movida não for do primeiro jogador, mas a peçaa destino for, então ela poder ser comida. Caso contrário, se a peça
		 * a ser movida for do primeiro mas a outra não, ela também pode ser comida. Aém disso, a peça não pode ser um peão, já que eles comem
		 * de outro jeito. */
		if ((idPeca != "P") && (idPeca != "p")) {
			if ((ehPrimeiroJogador(idPeca) == false && ehPrimeiroJogador(casasTabuleiro[idx][jdx]) == true) || 
					(ehPrimeiroJogador(idPeca) == true && ehPrimeiroJogador(casasTabuleiro[idx][jdx]) == false))
				return true;
		}
		return false;
	}
	// nao funciona ainda
	public static boolean podePromoverPeao (String idPeca, int casaDestino, String[][] casasTabuleiro, int[][] idCasas, ArrayList<Integer> movimentosPossiveis) throws MovimentoInvalidoException {
		boolean podePromover = false;
		boolean podeMover = false;
		podeMover = podeMover(idPeca, casaDestino, casasTabuleiro, idCasas, movimentosPossiveis);
		if (podeMover) {
			if ((idPeca == "P") && (casaDestino >= 0 && casaDestino <= 7))
				podePromover = true;
			if ((idPeca == "p") && (casaDestino >= 70 && casaDestino <= 77))
				podePromover = true;
		}
		return podePromover;
	}
	// nao funciona ainda
	public static String [][] atualizaPromocaoPeao (String idPeca, int casaCorrente, int casaDestino, String[][] casasTabuleiro, int[][] idCasas, ArrayList<Integer> movimentosPossiveis) {
		boolean podePromover = false;
		Casa[] arrayCasas = Tabuleiro.arrayCasas;
		int i, j, idxCorrente = 0, jdxCorrente = 0, idxDestino = 0, jdxDestino = 0;
		int corrente = 0, destino = 0;
		try {
			podePromover = podePromoverPeao(idPeca, casaDestino, casasTabuleiro, idCasas, movimentosPossiveis);
		} 
		catch (MovimentoInvalidoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		if (podePromover) {
			idxCorrente = casaCorrente / 10;
			jdxCorrente = casaCorrente - (idxCorrente * 10);
			idxDestino = casaDestino/ 10;
			jdxDestino = casaDestino - (idxDestino * 10);		
		
			for (i = 0; i < 64; i++) {
				if (arrayCasas[i].idCasa == casaCorrente)
					corrente = i;
				if (arrayCasas[i].idCasa == casaDestino)
					destino = i;
			}
			
			casasTabuleiro[idxCorrente][jdxCorrente] = ".";
			arrayCasas[corrente].conteudoCasa = ".";
			
			if (idPeca == "P") {
				casasTabuleiro[idxDestino][jdxDestino] = "A";
				arrayCasas[destino].conteudoCasa = "A";
			}
			else {
				casasTabuleiro[idxDestino][jdxDestino] = "a";	
				arrayCasas[corrente].conteudoCasa = "a";
			}
		}
		
		return casasTabuleiro;
	}
	// novo
//	public static int pegaPosicaoRei () {
//		
//	}
	// novo
	public static boolean verificaCheque () {
		return false;
	}
	// em progresso...
	public static boolean peaoPodeComer (String idPeca, int casaCorrente, String[][] casasTabuleiro, int[][] idCasas) throws MovimentoInvalidoException {
		boolean podeComer = false;
		String conteudoDiagEsq, conteudoDiagDir;
		int idDiagEsq, idDiagDir;
		int i, j, idxEsq = 0, jdxEsq = 0, idxDir = 0, jdxDir = 0;
		
		if (idPeca == "P") {
			idDiagEsq = casaCorrente - 11;
			idDiagDir = casaCorrente - 9;
			for (i = 0; i < 8; i++) {
				for (j = 0; j < 8; j++) {
					if (idDiagEsq == idCasas[i][j]) {
						idxEsq = i;
						jdxEsq = j;
					}
					if (idDiagDir == idCasas[i][j]) {
						idxDir = i;
						jdxDir = j;
					}
						
				}
			}
			conteudoDiagEsq = casasTabuleiro[idxEsq][jdxEsq];
			conteudoDiagDir = casasTabuleiro[idxDir][jdxDir];
			if (ehPrimeiroJogador(conteudoDiagEsq) == false || ehPrimeiroJogador(conteudoDiagDir) == false)
				podeComer = true;
		}
		
		if (idPeca == "p") {
			idDiagEsq = casaCorrente + 11;
			idDiagDir = casaCorrente + 9;
			for (i = 0; i < 8; i++) {
				for (j = 0; j < 8; j++) {
					if (idDiagEsq == idCasas[i][j]) {
						idxEsq = i;
						jdxEsq = j;
					}
					if (idDiagDir == idCasas[i][j]) {
						idxDir = i;
						jdxDir = j;
					}
						
				}
			}
			conteudoDiagEsq = casasTabuleiro[idxEsq][jdxEsq];
			conteudoDiagDir = casasTabuleiro[idxDir][jdxDir];
			if (ehPrimeiroJogador(conteudoDiagEsq) == true || ehPrimeiroJogador(conteudoDiagDir) == true)
				podeComer = true;
		}
		return podeComer;
	}

	public static String[][] fazRoquePequeno (boolean ehPrimeiroJogador, String[][] casasTabuleiro, int[][] idCasas) {
		Casa[] arrayCasas = Tabuleiro.arrayCasas;
		boolean podeRoque = false;
		if (ehPrimeiroJogador) {
			if (casasTabuleiro[7][4] == "E" && casasTabuleiro [7][7] == "T") {
				if (casasTabuleiro[7][5] == "." && casasTabuleiro[7][6] == ".") 
					podeRoque = true;
				
				if (podeRoque) {
					casasTabuleiro[7][4] = ".";
					casasTabuleiro[7][5] = "T";
					casasTabuleiro[7][6] = "E";
					casasTabuleiro[7][7] = ".";
					arrayCasas[60].conteudoCasa = ".";
					arrayCasas[61].conteudoCasa = "T";
					arrayCasas[62].conteudoCasa = "E";
					arrayCasas[63].conteudoCasa = ".";
					}
			}	
		}
		else {
			if (casasTabuleiro[0][4] == "e" && casasTabuleiro [0][7] == "t") {
				if (casasTabuleiro[0][5] == "." && casasTabuleiro[0][6] == ".") 
					podeRoque = true;
				
				if (podeRoque) {
					casasTabuleiro[0][4] = ".";
					casasTabuleiro[0][5] = "t";
					casasTabuleiro[0][6] = "e";
					casasTabuleiro[0][7] = ".";
					arrayCasas[4].conteudoCasa = ".";
					arrayCasas[5].conteudoCasa = "t";
					arrayCasas[6].conteudoCasa = "e";
					arrayCasas[7].conteudoCasa = ".";
				}
			}	
		}
		if (!podeRoque)
			JOptionPane.showMessageDialog(null, "Não foi possível realizar o roque.");
		
		return casasTabuleiro;
	}
	
	public static String[][] fazRoqueGrande (boolean ehPrimeiroJogador, String[][] casasTabuleiro, int[][] idCasas) {
		Casa[] arrayCasas = Tabuleiro.arrayCasas;
		boolean podeRoque = false;
		if (ehPrimeiroJogador) {
			if (casasTabuleiro[7][4] == "E" && casasTabuleiro [7][0] == "T") {
				if (casasTabuleiro[7][1] == "." && casasTabuleiro[7][2] == "." && casasTabuleiro[7][3] == ".") 
					podeRoque = true;
				
				if (podeRoque) {
					casasTabuleiro[7][0] = ".";
					casasTabuleiro[7][2] = "E";
					casasTabuleiro[7][3] = "T";
					casasTabuleiro[7][4] = ".";
					arrayCasas[56].conteudoCasa = ".";
					arrayCasas[58].conteudoCasa = "E";
					arrayCasas[59].conteudoCasa = "T";
					arrayCasas[60].conteudoCasa = ".";
					}
			}	
		}
		else {
			if (casasTabuleiro[0][4] == "e" && casasTabuleiro [0][7] == "t") {
				if (casasTabuleiro[0][1] == "." && casasTabuleiro[0][2] == "." && casasTabuleiro[0][3] == ".") 
					podeRoque = true;
				if (podeRoque) {
					casasTabuleiro[0][0] = ".";
					casasTabuleiro[0][2] = "e";
					casasTabuleiro[0][3] = "t";
					casasTabuleiro[0][4] = ".";
					arrayCasas[0].conteudoCasa = ".";
					arrayCasas[2].conteudoCasa = "e";
					arrayCasas[3].conteudoCasa = "t";
					arrayCasas[4].conteudoCasa = ".";
				}
			}	
		}
		if (!podeRoque)
			JOptionPane.showMessageDialog(null, "Não foi possível realizar o roque.");
		
		return casasTabuleiro;
	}
}
