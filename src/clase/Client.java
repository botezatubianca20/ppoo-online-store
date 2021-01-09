package clase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.regex.Pattern;

import exceptii.ExceptieGenerata;

public class Client {
	private String nume;
	private String prenume;
	private String email;
	private String parola;
	private String telefon;
	private String adresa;
	HashMap<Integer, Comanda> listaComenzi = new HashMap<>();
	ArrayList<Produs>listaFavorite = new ArrayList<>();
	ArrayList<Produs> listaProduseCosCumparaturi = new ArrayList<>();
	
	public Client() {
		super();
	}


	public Client(String nume, String prenume, String email, String parola, String telefon, String adresa) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.parola = parola;
		this.telefon = telefon;
		this.adresa = adresa;
	}

	public Client(String nume, String prenume, String email, String parola, String telefon, String adresa,
			HashMap<Integer, Comanda> listaComenzi, ArrayList<Produs> listaFavorite,
			ArrayList<Produs> listaProduseCosCumparaturi) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.parola = parola;
		this.telefon = telefon;
		this.adresa = adresa;
		this.listaComenzi = listaComenzi;
		this.listaFavorite = listaFavorite;
		this.listaProduseCosCumparaturi = listaProduseCosCumparaturi;
	}

	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getParola() {
		return parola;
	}

	public void setParola(String parola) throws ExceptieGenerata {
		if(parola.length() < 5) {
			throw new ExceptieGenerata("Parola trebuie sa aiba mai mult de 5 caractere.");
		}
		this.parola = parola;
	}

	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) throws ExceptieGenerata {
		if (Pattern.matches("[a-zA-Z]+", telefon) == true) {
			throw new ExceptieGenerata("Numarul de telefon trebuie sa contina doar cifre.");
		}
		if (telefon.length() != 10) {
			throw new ExceptieGenerata("Numarul de telefon trebuie sa aiba 10 cifre.");
		}
		this.telefon = telefon;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public HashMap<Integer, Comanda> getListaComenzi() {
		return listaComenzi;
	}

	public void setListaComenzi(HashMap<Integer, Comanda> listaComenzi) {
		this.listaComenzi = listaComenzi;
	}

	public ArrayList<Produs> getListaFavorite() {
		return listaFavorite;
	}

	public void setListaFavorite(ArrayList<Produs> listaFavorite) {
		this.listaFavorite = listaFavorite;
	}

	
	public ArrayList<Produs> getListaProduseCosCumparaturi() {
		return listaProduseCosCumparaturi;
	}

	public void setListaProduseCosCumparaturi(ArrayList<Produs> listaProduseCosCumparaturi) {
		this.listaProduseCosCumparaturi = listaProduseCosCumparaturi;
	}


	@Override
	public String toString() {
		return "Client [nume=" + nume + ", prenume=" + prenume + ", email=" + email + ", telefon=" + telefon
				+ ", adresa=" + adresa + ", listaComenzi=" + listaComenzi + ", listaFavorite=" + listaFavorite
				+ ", listaProduseCosCumparaturi=" + listaProduseCosCumparaturi + "]";
	}
	
	public String toStringScriereFisier() {
		return nume + "," + prenume + "," + email + "," +  parola + "," +telefon + "," + adresa + ",";
				
	}
	

	public HashMap adaugaComandaLaListaComenzi(Comanda c, int index) {
		HashMap lista = this.listaComenzi;
		lista.put(1+index,  c);	
		return lista;
	}
	
	public ArrayList adaugaProdusLaFavorite(Produs p) {
		Random rand = new Random(); 
		ArrayList list = this.listaFavorite;
		p.setId(rand.nextInt(1000));
		list.add(p);
		return list;
	}
	
	public ArrayList adaugaProdusInCos(Produs p) {
		Random rand = new Random(); 
		ArrayList list = this.listaProduseCosCumparaturi;
		p.setId(rand.nextInt(1000));
		list.add(p);
		return list;
	}
	
	public void stergeProdusDinFavorite(int id) {
		 this.listaFavorite.removeIf(obj -> obj.getId() == id);
	}
	
	public void stergeProdusDinCos(int id) {  
		 this.listaProduseCosCumparaturi.removeIf(obj -> obj.getId() == id);
	}
	
	
	

	
	
	

}
