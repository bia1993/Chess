package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import fachada.Fachada;

@SuppressWarnings("serial")
public class Tabuleiro extends JPanel {
	
    String[][] casasTabuleiro = Fachada.pegaCasas();
    int linha, coluna, desloc;
    static int qtdClicks;
    private static Tabuleiro instancia = null;
    public static Casa[] arrayCasas = new Casa[64];
    
    public static Tabuleiro pegaInstancia () {
        if (instancia == null) 
            instancia = new Tabuleiro ();
        return instancia;
    }
    
    protected void paintComponent (Graphics g2) { 
        Graphics2D g = (Graphics2D) g2;
        super.paintComponent(g);
        desloc = 64;
        Image torreR = null;
	    Image cavaloR = null;
	    Image bispoR = null;
	    Image peaoR = null;
	    Image reiR = null;
	    Image rainhaR = null;
	    Image torreA = null;
	    Image cavaloA = null;
	    Image bispoA = null;
	    Image peaoA = null;
	    Image reiA = null;
	    Image rainhaA = null;
	        
		try {
			torreR = ImageIO.read(new File("PurpleR.png"));
		    cavaloR = ImageIO.read(new File("PurpleN.png"));
		    bispoR = ImageIO.read(new File("PurpleB.png"));
		    peaoR = ImageIO.read(new File("PurpleP.png"));
		    reiR = ImageIO.read(new File("PurpleK.png"));
		    rainhaR = ImageIO.read(new File("PurpleQ.png"));
		    torreA = ImageIO.read(new File("CyanR.png"));
		    cavaloA = ImageIO.read(new File("CyanN.png"));
		    bispoA = ImageIO.read(new File("CyanB.png"));
		    peaoA = ImageIO.read(new File("CyanP.png"));
		    reiA = ImageIO.read(new File("CyanK.png"));
		    rainhaA = ImageIO.read(new File("CyanQ.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		Color cor;
		
        for (linha = 0; linha < 8; linha++) { 
        	for (coluna = 0; coluna < 8; coluna++){ 
        		if (linha % 2 == 0) {
	        		if (coluna % 2 == 0) {
	        			cor = Color.white;
	        			g.setColor(cor);
	        	        g.fillRect(10 + (desloc * coluna), 10 + (desloc * linha), 64, 64);
	        		}
	        		else {
	        			cor = Color.black;
	        			g.setColor(cor);
	        	        g.fillRect(10 + (desloc * coluna), 10 + (desloc * linha), 64, 64);
	        		}
        		}
        		else {
        			if (coluna % 2 == 0) {
        				cor = Color.black;
	        			g.setColor(cor);
	        	        g.fillRect(10 + (desloc * coluna), 10 + (desloc * linha), 64, 64);
	        		}
	        		else {
	        			cor = Color.white;
	        			g.setColor(cor);
	        	        g.fillRect(10 + (desloc * coluna), 10 + (desloc * linha), 64, 64);
	        		}
        			
        		}

        		String conteudoCasa = casasTabuleiro[linha][coluna];
            	switch (conteudoCasa) {
            		case "p":
            			g.drawImage(peaoR, 10 + (64 * coluna), 10 + (64 * linha), 64, 64, null);
            			break;
            		case "a":
            			g.drawImage(rainhaR, 10 + (64 * coluna), 10 + (64 * linha), 64, 64, null);
            			break;
            		case "e":
            			g.drawImage(reiR, 10 + (64 * coluna), 10 + (64 * linha), 64, 64, null);
            			break;
            		case "b":
            			g.drawImage(bispoR, 10 + (64 * coluna), 10 + (64 * linha), 64, 64, null);
            			break;
            		case "c":
            			g.drawImage(cavaloR, 10 + (64 * coluna), 10 + (64 * linha), 64, 64, null);
            			break;
            		case "t":
            			g.drawImage(torreR, 10 + (64 * coluna), 10 + (64 * linha), 64, 64, null);
            			break;
            		case "P":
            			g.drawImage(peaoA, 10 + (64 * coluna), 10 + (64 * linha), 64, 64, null);
            			break;
            		case "A":
            			g.drawImage(rainhaA, 10 + (64 * coluna), 10 + (64 * linha), 64, 64, null);
            			break;
            		case "E":
            			g.drawImage(reiA, 10 + (64 * coluna), 10 + (64 * linha), 64, 64, null);
            			break;
            		case "B":
            			g.drawImage(bispoA, 10 + (64 * coluna), 10 + (64 * linha), 64, 64, null);
            			break;
            		case "C":
            			g.drawImage(cavaloA, 10 + (64 * coluna), 10 + (64 * linha), 64, 64, null);
            			break;
            		case "T":
            			g.drawImage(torreA, 10 + (64 * coluna), 10 + (64 * linha), 64, 64, null);
            			break;	
            		case ".":
            			break;
            	}
      
        	}   	
        		
        }

      
   } /* Fim do método paint. */
    
   protected Casa[] criaCasasTabuleiro () {
	   
       	desloc = 64;
		Color cor = null;
		int k = 0;
		
       for (linha = 0; linha < 8; linha++) { 
       	for (coluna = 0; coluna < 8; coluna++){ 
       		if (linha % 2 == 0) {
	        		if (coluna % 2 == 0) 
	        			cor = Color.white;
	        		else 
	        			cor = Color.black;
       		}
       		else {
       				if (coluna % 2 == 0) 
       					cor = Color.black;
	        		else 
	        			cor = Color.white;
       		}

       		String conteudoCasa = casasTabuleiro[linha][coluna];
           	
           	/* Se o conteúdo da casa for ".", a casa está vazia. */
           	if (conteudoCasa == ".") {
           		arrayCasas[k] = new Casa(((linha * 10) + coluna), conteudoCasa, (13 + (desloc * coluna)), 
           			(58 + (desloc * linha)), coluna, linha, true, cor);
           	}	
           	else {
           	arrayCasas[k] = new Casa(((linha * 10) + coluna), conteudoCasa, (13 + (desloc * coluna)), 
           			(58 + (desloc * linha)), coluna, linha, false, cor);
           	}
           	k++;
     
       	}   	
       }
    	
    	return Tabuleiro.arrayCasas;
    }       

	public static Casa[] pegaArrayCasas() {
		
		return Tabuleiro.arrayCasas;
	}

}
