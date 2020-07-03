package gui;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import erros.MovimentoInvalidoException;
import fachada.Fachada;

@SuppressWarnings("serial")
public class Jogo extends JFrame implements MouseListener {
	static int qtdClicks = 0;
	private static Jogo instancia = null;
	ArrayList<Integer> movimentosPossiveis = null;
	String[][] casasTabuleiro = Fachada.pegaCasas();
	int[][] idCasas = Fachada.pegaIdCasas();
	Casa[] arrayCasas = Tabuleiro.pegaArrayCasas();
	private Casa casa = null;
	private Casa casaDestino = null;
	private String idPeca = null;
	boolean ehPrimeiroJogador = true;
	public static boolean roquePequeno = false;
	public static boolean roqueGrande = false;

	public static Jogo pegaInstancia() {
		if (instancia == null)
			instancia = new Jogo();
		return instancia;
	}

	public static Casa pegaCasaPosicaoClick(int posX, int posY, Casa[] arrayCasas) {
		Casa casa = null;
		int i = 0;
		for (; i < 64; i++) {
			if ((posX >= arrayCasas[i].posX) && (posX <= arrayCasas[i].posX + 64)) {
				if ((posY >= arrayCasas[i].posY) && (posY <= arrayCasas[i].posY + 64)) {
					casa = arrayCasas[i];
					break;
				}
			}
		}
		return casa;
	}

	public Jogo() {
		Menu menu = Menu.pegaInstancia();
		Color corFundo = new Color(186, 231, 247);
		this.setTitle("Xadrez!");
		this.setBounds(0, 0, 538, 583);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		Tabuleiro t = Tabuleiro.pegaInstancia();
		t.criaCasasTabuleiro();
		t.setBackground(corFundo);
		this.setJMenuBar(menu.barraDeMenu);
		this.add(t);
	}

	public void mouseClicked(MouseEvent me) {
		
		Point p1 = MouseInfo.getPointerInfo().getLocation();
		if (this.arrayCasas != null) {

			if (qtdClicks == 0) {
				casa = pegaCasaPosicaoClick(p1.x, p1.y, this.arrayCasas);
				
				if (casa == null)
					return;
				
				System.out.println("Origem:");
				System.out.println(casa.idCasa);
				idPeca = casa.conteudoCasa;
				
				if (idPeca == ".")
					System.out.println("A casa está vazia.");
				
				if (idPeca == "P" && ehPrimeiroJogador || idPeca == "p" && !ehPrimeiroJogador) {
					movimentosPossiveis = Fachada.pegaMovimentosPossiveisPeao(idPeca, casa.idCasa, casasTabuleiro, idCasas);
					qtdClicks = 1;
				}
				else if (idPeca == "B" && ehPrimeiroJogador || idPeca == "b" && !ehPrimeiroJogador) {
					movimentosPossiveis = Fachada.pegaMovimentosPossiveisBispo(idPeca, casa.idCasa, casasTabuleiro, idCasas);
					qtdClicks = 1;
				}
				else if (idPeca == "C" && ehPrimeiroJogador || idPeca == "c" && !ehPrimeiroJogador) {
					movimentosPossiveis = Fachada.pegaMovimentosPossiveisCavalo(idPeca, casa.idCasa, casasTabuleiro, idCasas);
					qtdClicks = 1;
				}
				else if (idPeca == "T" && ehPrimeiroJogador || idPeca == "t" && !ehPrimeiroJogador) {
					movimentosPossiveis = Fachada.pegaMovimentosPossiveisTorre(idPeca, casa.idCasa, casasTabuleiro, idCasas);
					qtdClicks = 1;
				}
				else if (idPeca == "E" && ehPrimeiroJogador || idPeca == "e" && !ehPrimeiroJogador) {
					movimentosPossiveis = Fachada.pegaMovimentosPossiveisRei(idPeca, casa.idCasa, casasTabuleiro, idCasas);
					qtdClicks = 1;
				}
				else if (idPeca == "A" && ehPrimeiroJogador || idPeca == "a" && !ehPrimeiroJogador) {
					movimentosPossiveis = Fachada.pegaMovimentosPossiveisRainha(idPeca, casa.idCasa, casasTabuleiro, idCasas);
					qtdClicks = 1;
				}
				else
					qtdClicks = 0;
			} 
			
			else if (qtdClicks == 1) {
				Point p2 = MouseInfo.getPointerInfo().getLocation();
				boolean movimentoValido = false;
				boolean podeMover = false;
				boolean podeComer = false;
				boolean peaoPodeComer = false;
				boolean podePromoverPeao = false;
				casaDestino = pegaCasaPosicaoClick(p2.x, p2.y, this.arrayCasas);
				System.out.println("Destino:");
				System.out.println(casaDestino.idCasa);
				
				try {
					podeMover = Fachada.podeMover(casa.conteudoCasa, casaDestino.idCasa, casasTabuleiro, idCasas, movimentosPossiveis);
					podeComer = Fachada.podeComer(idPeca, casaDestino.idCasa, casasTabuleiro, idCasas, movimentosPossiveis);
					peaoPodeComer = Fachada.peaoPodeComer(idPeca, casa.idCasa, casasTabuleiro, idCasas);
					podePromoverPeao = Fachada.podePromoverPeao(idPeca, casaDestino.idCasa, casasTabuleiro, idCasas, movimentosPossiveis);
					if (podeComer || podeMover || peaoPodeComer)
						movimentoValido = true;
				} 
				catch (MovimentoInvalidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				if (movimentoValido) 
					casasTabuleiro = Fachada.atualizaTabuleiro(idPeca, casa.idCasa, casaDestino.idCasa, casasTabuleiro, idCasas);
				if (podePromoverPeao)
					casasTabuleiro = Fachada.atualizaPromocaoPeao(idPeca, casa.idCasa, casaDestino.idCasa, casasTabuleiro, idCasas, movimentosPossiveis);
				
				if (roquePequeno)
					casasTabuleiro = Fachada.fazRoquePequeno(ehPrimeiroJogador, casasTabuleiro, idCasas);
				if (roqueGrande)
					casasTabuleiro = Fachada.fazRoqueGrande(ehPrimeiroJogador, casasTabuleiro, idCasas);
				
				qtdClicks = 2;
			}	
				
			else if (qtdClicks == 2) {
				qtdClicks = 0;
				ehPrimeiroJogador = !ehPrimeiroJogador;
				
				if (ehPrimeiroJogador)
					this.setTitle("Xadrez! - Vez do Jogador 1");
				else
					this.setTitle("Xadrez! - Vez do Jogador 2");
			}

		}

		repaint();
	}

	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

}
