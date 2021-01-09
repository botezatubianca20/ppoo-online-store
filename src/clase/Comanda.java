package clase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Comanda {
	private int numarComanda;
	private Date dataLivrare;
	private Boolean plataEfectuata;
	private TipModalitatePlata tipModalitatePlata;
	ArrayList<Produs> listaProduse = new ArrayList<>();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	
	
	public Comanda() {
		super();
	}

	public Comanda(int numarComanda, Date dataLivrare, Boolean plataEfectuata, ArrayList<Produs> listaProduse) {
		super();
		this.numarComanda = numarComanda;
		this.dataLivrare = dataLivrare;
		this.plataEfectuata = plataEfectuata;
		this.listaProduse = listaProduse;
	}

	public Comanda(int numarComanda, Date dataLivrare, Boolean plataEfectuata, TipModalitatePlata tipModalitatePlata, ArrayList<Produs> listaProduse) {
		super();
		this.numarComanda = numarComanda;
		this.dataLivrare = dataLivrare;
		this.plataEfectuata = plataEfectuata;
		this.tipModalitatePlata = tipModalitatePlata;
		this.listaProduse = listaProduse;
	}

	

	public int getNumarComanda() {
		return numarComanda;
	}

	public void setNumarComanda(int numarComanda) {
		this.numarComanda = numarComanda;
	}

	public Date getDataLivrare() {
		return dataLivrare;
	}

	public void setDataLivrare(Date dataLivrare) {
		this.dataLivrare = dataLivrare;
	}

	public ArrayList<Produs> getListaProduse() {
		return listaProduse;
	}

	public void setListaProduse(ArrayList<Produs> listaProduse) {
		this.listaProduse = (ArrayList<Produs>) listaProduse.clone();
	}

	public Boolean getPlataEfectuata() {
		return plataEfectuata;
	}

	public void setPlataEfectuata(Boolean plataEfectuata) {
		this.plataEfectuata = plataEfectuata;
	}

	public TipModalitatePlata getTipModalitatePlata() {
		return tipModalitatePlata;
	}

	public void setTipModalitatePlata(TipModalitatePlata tipModalitatePlata) {
		this.tipModalitatePlata = tipModalitatePlata;
	}

	@Override
	public String toString() {
		return "Comanda [numarComanda=" + numarComanda + ", dataLivrare=" + dateFormat.format(dataLivrare) + ", plataEfectuata="
				+ plataEfectuata + ", tipModalitatePlata=" + tipModalitatePlata + ", listaProduse=" + listaProduse
				+ "]";
	}
	
	public String toStringScriereFisier() {
//		StringBuffer lista = new StringBuffer();
//		lista.append("\n" + listaProduse.size() + "\n");
//		int i = 0;
//		for (Produs p : listaProduse) {
//			lista.append(p.toStringScriereFisier());
//
//			if (i < listaProduse.size() - 1) {
//				lista.append("\n");
//			}
//			i++;
//		}
		return numarComanda + "," + dateFormat.format(dataLivrare) + "," + plataEfectuata + "," + tipModalitatePlata;
				
	}



	
	

}
