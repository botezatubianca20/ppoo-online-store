package clase;

import exceptii.ExceptieGenerata;

public class Produs {
	private int id;
	private String denumire;
	private Double pret;
	private TipProdus tip;
	private String producator;
	private int cantitate;
	
	public Produs() {
		super();
	}

	public Produs(int id, String denumire, Double pret, TipProdus tip, String producator, int cantitate) {
		super();
		this.id = id;
		this.denumire = denumire;
		this.pret = pret;
		this.tip = tip;
		this.producator = producator;
		this.cantitate = cantitate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public Double getPret() {
		return pret;
	}

	public void setPret(Double pret) throws ExceptieGenerata {
		if(pret <= 0) {
			throw new ExceptieGenerata("Pretul nu poate fi negativ.");
		}
		this.pret = pret;
	}

	public TipProdus getTip() {
		return tip;
	}

	public void setTip(TipProdus tip) {
		this.tip = tip;
	}

	public String getProducator() {
		return producator;
	}

	public void setProducator(String producator) {
		this.producator = producator;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) throws ExceptieGenerata {
		if(cantitate <= 0) {
			throw new ExceptieGenerata("Cantitatea nu poate fi negativa.");
		}
		this.cantitate = cantitate;
	}

	@Override
	public String toString() {
		return "Produs [id=" + id + ", denumire=" + denumire + ", pret=" + pret + ", tip=" + tip + ", producator="
				+ producator + ", cantitate=" + cantitate + "]";
	}
	
	
	public String toStringScriereFisier() {
		return id + "," + denumire + "," + pret + "," + tip + "," + producator + "," + cantitate;
	}
	
	

}
