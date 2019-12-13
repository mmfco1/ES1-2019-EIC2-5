package main.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.Gui;
import main.Regras;

class GuiTest {

	@Test
	void test() {
		ActionEvent e = new ActionEvent(this, 0, "Choose");
		ActionEvent e1 = new ActionEvent(this, 0, "Tresholds");
		ActionEvent e2 = new ActionEvent(this, 0, "Correr");
		ActionEvent e3 = new ActionEvent(this, 0, "Criar");
		ActionEvent e4 = new ActionEvent(this, 0, "Delete");
		ActionEvent e5 = new ActionEvent(this, 0, "Visualizar");
		ActionEvent e6 = new ActionEvent(this, 0, "Editar");
		ActionEvent e7 = new ActionEvent(this, 0, "Comparar");
		
		
		ArrayList<Regras> test = new ArrayList<Regras>();
		
		Gui g = new Gui();
		
		g.actionPerformed(e1);
		g.actionPerformed(e2);
		g.actionPerformed(e3);
		g.actionPerformed(e4);
		g.actionPerformed(e5);
		g.actionPerformed(e6);
		g.actionPerformed(e7);
		g.batata(0);
		g.setRegraslist(test);
		
		
		
		
		
	}

}
