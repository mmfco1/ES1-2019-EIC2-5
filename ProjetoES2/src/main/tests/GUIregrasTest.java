package main.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.Test;

import main.GUIregras;
import main.Regras;

class GUIregrasTest {

	@Test
	void test() {

		Regras r = new Regras("test", 0, 0, 0, 0);
		
		GUIregras g = new GUIregras(r);
		
		ActionEvent e = new ActionEvent(this, 0, "Ok");
		g.actionPerformed(e);
		

		
		
		
	}

}
