package main.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Main;

class MainTest {

	@Test
	void test() {
		Main m = new Main();
		Main.main(null);
	}

}
