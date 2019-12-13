package main;

public class Regras {
	/**@author Francisco Veiga
	 * 
	 */

	private String nome;
	private int Loc;
	private int Aftd;
	private int Cyclos;
	private double Laa;

	/**
	 * Construtor
	 * @param nome
	 * @param loc
	 * @param aftd
	 * @param cyclos
	 * @param laa
	 */
	public Regras(String nome, int loc, int aftd, int cyclos, double laa) {
		super();
		this.nome = nome;
		Loc = loc;
		Aftd = aftd;
		Cyclos = cyclos;
		Laa = laa;
	}

	/**
	 * getter do nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * getter do Loc
	 * @return Loc
	 */
	
	public int getLoc() {
		return Loc;
	}
	/**
	 * getter do aftd
	 * @return Aftd
	 */
	public int getAftd() {
		return Aftd;
	}
	/**
	 * getter do cyclos
	 * @return Cyclos
	 */
	public int getCyclos() {
		return Cyclos;
	}
	/**
	 * getter do laa
	 * @return Laa
	 */
	public double getLaa() {
		return Laa;
	}
	/**
	 * Impressao da informaçao
	 */
	@Override
	public String toString() {
		String loc = new String(), laa = new String(), cyc = new String(), atfd = new String();

		if (Loc >= 0) {
			loc = new String(" LOC > " + Loc);
		} else {
			loc = new String(" LOC < " + Loc*(-1));
		}

		if (Laa >= 0) {
			laa = new String(" LAA > "+Laa);
		} else {
			laa = new String(" LAA < "+Laa*(-1));
		}

		if (Cyclos >= 0) {
			cyc = new String(" CYCLOS > "+ Cyclos);
		} else {
			cyc = new String(" CYCLOS < "+Cyclos*(-1));
		}

		if (Aftd >= 0) {
			atfd = new String(" AFTD > "+ Aftd);

		} else {
			atfd = new String(" AFTD < "+Aftd*(-1));
		}

		return nome + loc + cyc + atfd + laa;

	}

}
