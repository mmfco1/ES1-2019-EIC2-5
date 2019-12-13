package main.tests;

import org.junit.jupiter.api.Test;

import main.Regras;

class RegrasTest {

	@Test
	void test() {
		Regras regra = new Regras("Hi", 0, 0, 0, 0);
		Regras regra2 = new Regras("Hello", -1, -1, -1, -1);
		regra.getAftd();
		regra.getCyclos();
		regra.getLaa();
		regra.getLoc();
		regra.getNome();
		regra.toString();
		regra2.toString();
	}

}
