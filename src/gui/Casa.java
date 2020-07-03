package gui;

import java.awt.Color;

public class Casa {

	public int idCasa;
	public String conteudoCasa = ".";
	public int posX;
	public int posY;
	public int coordX;
	public int coordY;
	public boolean estaVazio = true;
	public Color corCasa;

	public Casa (int idCasa, String conteudoCasa, int posX, int posY, int coordX, int coordY, boolean estaVazio, Color corCasa) {
		this.idCasa = idCasa;
		this.conteudoCasa = conteudoCasa;
		this.posX = posX;
		this.posY = posY;
		this.coordX = coordX;
		this.coordY = coordY;
		this.estaVazio = estaVazio;
		this.corCasa = corCasa;
	}
}
