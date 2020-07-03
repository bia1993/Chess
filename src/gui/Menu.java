package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fachada.Fachada;

@SuppressWarnings("serial")
public class Menu extends AbstractAction  {
	
	JMenuBar barraDeMenu =  new JMenuBar();
	JMenu menu = new JMenu("Menu");
	JMenuItem novoJogo = new JMenuItem("Novo Jogo");
	JMenuItem salvarJogo = new JMenuItem("Salvar Jogo");
	JMenuItem carregarJogo = new JMenuItem("Carregar Jogo");
	JMenuItem roquePequeno = new JMenuItem("Roque Pequeno");
	JMenuItem roqueGrande = new JMenuItem("Roque Grande");

	private static Menu instancia = null;
	
	public static Menu pegaInstancia () {
        if (instancia == null) 
            instancia = new Menu ();
        return instancia;
    }
	
	private Menu () {
		this.novoJogo.addActionListener(this);
		this.salvarJogo.addActionListener(this);
		this.carregarJogo.addActionListener(this);
		this.roquePequeno.addActionListener(this);
		this.roqueGrande.addActionListener(this);
		this.menu.add(this.novoJogo);
		this.menu.add(this.salvarJogo);
		this.menu.add(this.carregarJogo);
		this.menu.add(this.roquePequeno);
		this.menu.add(this.roqueGrande);
		this.barraDeMenu.add(this.menu);
		
	}
	
	public void actionPerformed(ActionEvent a) {
		if (a.getActionCommand() == "Novo Jogo") {
			System.out.println("Novo jogo");
			
		}
		else if (a.getActionCommand() == "Salvar Jogo") {
			
		}
		else if (a.getActionCommand() == "Carregar Jogo") {
			
		}
		else if (a.getActionCommand() == "Roque Pequeno") {
			Jogo.roquePequeno = true;
		}
		else if (a.getActionCommand() == "Roque Grande") {
			Jogo.roqueGrande = true;
		}
		
	}
	
	

}
