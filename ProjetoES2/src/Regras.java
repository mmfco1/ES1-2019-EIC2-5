
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
	
	

}
