package clase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetaliiCard {
	private String numeBeneficiar;
	private String numarCard;
	private Date dataExpirare;
	private int codCard;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	
	public DetaliiCard() {
		super();
	}
	
	public DetaliiCard(String numeBeneficiar, String numarCard, Date dataExpirare, int codCard) {
		super();
		this.numeBeneficiar = numeBeneficiar;
		this.numarCard = numarCard;
		this.dataExpirare = dataExpirare;
		this.codCard = codCard;
	}
	public String getNumeBeneficiar() {
		return numeBeneficiar;
	}
	public void setNumeBeneficiar(String numeBeneficiar) {
		this.numeBeneficiar = numeBeneficiar;
	}
	public String getNumarCard() {
		return numarCard;
	}
	public void setNumarCard(String numarCard) {
		this.numarCard = numarCard;
	}
	public Date getDataExpirare() {
		return dataExpirare;
	}
	public void setDataExpirare(Date dataExpirare) {
		this.dataExpirare = dataExpirare;
	}
	public int getCodCard() {
		return codCard;
	}
	public void setCodCard(int codCard) {
		this.codCard = codCard;
	}
	@Override
	public String toString() {
		return "DetaliiCard [numeBeneficiar=" + numeBeneficiar + ", numarCard=" + numarCard + ", dataExpirare="
				+ dateFormat.format(dataExpirare) + ", codCard=" + codCard + "]";
	}
	
	
	

}
