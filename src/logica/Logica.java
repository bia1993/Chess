package logica;

public class Logica {
	
	/* Posi��o inicial das pe�as no tabuleiro. Letras min�sculas representam as pe�as de cor escura, a as mai�sculas, as claras. 
	 * Os pontos indicam casas vazias. O rei e a rainha s�o representados por "e" e "a" respectivamente, pois possuem as mesmas 
	 * iniciais. Todas as outras pe�as s�o representadas por suas iniciais. 
	 * */
	
	public static String casasTabuleiro [][] = {
		{"t", "c", "b", "a", "e", "b", "c", "t"},
		{"p", "p", "p", "p", "p", "p", "p", "p"},
		{".", ".", ".", ".", ".", ".", ".", "."},
		{".", ".", ".", ".", ".", ".", ".", "."},
		{".", ".", ".", ".", ".", ".", ".", "."},
		{".", ".", ".", ".", ".", ".", ".", "."},
		{"P", "P", "P", "P", "P", "P", "P", "P"},
		{"T", "C", "B", "A", "E", "B", "C", "T"}
	};
	public static int idCasas [][] = {
		{ 0,  1,  2,  3,  4,  5,  6,  7},
		{10, 11, 12, 13, 14, 15, 16, 17},
		{20, 21, 22, 23, 24, 25, 26, 27},
		{30, 31, 32, 33, 34, 35, 36, 37},
		{40, 41, 42, 43, 44, 45, 46, 47},
		{50, 51, 52, 53, 54, 55, 56, 57},
		{60, 61, 62, 63, 64, 65, 66, 67},
		{70, 71, 72, 73, 74, 75, 76, 77}
	};
	

}
	

