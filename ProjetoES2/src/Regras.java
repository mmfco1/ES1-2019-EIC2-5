
public class Regras {

	private String nome;
	private int Loc;
	private int Aftd;
	private int Cyclos;
	private int Laa;

	public Regras(String nome, int loc, int aftd, int cyclos, int laa) {
		super();
		this.nome = nome;
		Loc = loc;
		Aftd = aftd;
		Cyclos = cyclos;
		Laa = laa;
	}

	public String getNome() {
		return nome;
	}

	public int getLoc() {
		return Loc;
	}

	public int getAftd() {
		return Aftd;
	}

	public int getCyclos() {
		return Cyclos;
	}

	public int getLaa() {
		return Laa;
	}

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
