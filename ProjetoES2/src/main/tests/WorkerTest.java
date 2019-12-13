package main.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;

import main.Gui;
import main.Regras;
import main.Worker;

class WorkerTest {

	@Test
	void test() {
		Gui gui = new Gui();
		Worker w = new Worker(gui);

		Regras regra = new Regras("test", 0, 0, 0, 0);
		Regras regra1 = new Regras("test", 1, 0, 0, 0);

		w.testar(1, 2);
		w.testar(2, -1);
		w.testar(2, 0);

		String test = new String("0");

		String sheet[][] = { { test, test, test, test, test, test, test, test, test, test, test, test },
				{ test, test, test, test, test, test, test, test, test, test, test, test }

		};
		
		w.adicionaRegra(regra1, sheet);

		w.adicionaRegra(regra, sheet);
		
//		File f = new File("‪C:\\Users\\Kiko\\Desktop\\Long-Method.xlsx");
//		
//		try {
//			w.createCols(f);
//		} catch (InvalidFormatException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		

	}

}
