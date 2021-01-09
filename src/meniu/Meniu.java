package meniu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import clase.Client;
import clase.Comanda;
import clase.DetaliiCard;
import clase.Produs;
import clase.TipModalitatePlata;
import clase.TipProdus;
import exceptii.ExceptieGenerata;



class Rezultat {
	public int val;

	public Rezultat() {
	}

	public Rezultat(int val) {
		super();
		this.val = val;
	}

}


public class Meniu {
	static Double valoare = 0.0;
	static Double nrAlimentar = 0.0;
	static Double nrCosmetic = 0.0;
	static Double nrImbracaminte = 0.0;
	static Double nrElectronic = 0.0;
	
	
	public static Client autentificareClient() throws ExceptieGenerata {
		Scanner s = new Scanner(System.in).useDelimiter("\n");
		
		Client client = new Client();
		System.out.println("Nume: ");
		client.setNume(s.next());
		System.out.println("Prenume: ");
		client.setPrenume(s.next());
		System.out.println("Email: ");
		client.setEmail(s.next());
		System.out.println("Parola: ");
		client.setParola(s.next());
		System.out.println("Telefon: ");
		client.setTelefon(s.next());
		System.out.println("Adresa: ");
        
		client.setAdresa(s.next());
		
		return client;
	}
	
	public static Produs adaugareProdus() throws ExceptieGenerata {
		Scanner s = new Scanner(System.in).useDelimiter("\n");
		
		Produs produs = new Produs();
		System.out.println("Denumire: ");
		produs.setDenumire(s.next());
		System.out.println("Pret: ");
		produs.setPret(s.nextDouble());
		System.out.println("Tip (ELECTRONIC / COSMETIC / ALIMENTAR / IMBRACAMINTE)");
		String tip = s.next();
		if (tip.toUpperCase().equals("ELECTRONIC")) {
			produs.setTip(TipProdus.ELECTRONIC);
		} 
		else if (tip.toUpperCase().equals("COSMETIC")) {
			produs.setTip(TipProdus.COSMETIC);
		} 
		else if (tip.toUpperCase().equals("ALIMENTAR")) {
			produs.setTip(TipProdus.ALIMENTAR);
		}
		else if (tip.toUpperCase().equals("IMBRACAMINTE")) {
			produs.setTip(TipProdus.IMBRACAMINTE);
		}else {
			System.out.println("Tipul produsului poate fi doar ELECTRONIC, COSMETIC sau ALIMENTAR\n");
		}
		System.out.println("Producator: ");
		produs.setProducator(s.next());
		System.out.println("Cantitate: ");
		produs.setCantitate(s.nextInt());
		
		return produs;
	}

	public static Client gasireClientDupaEmail(String email, String parola, ArrayList<Client> listaClienti) {
	    for(Client client : listaClienti) {
	        if(client.getEmail().equals(email) && client.getParola().equals(parola)) {
	            return client;
	        }
	    }
	    return null;
	}
	
	public static ArrayList<Client> initializareDateClienti() throws IOException, ParseException, ExceptieGenerata {
		ArrayList<Client> listaClienti = new ArrayList<Client>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		

		File f = new File("dateClienti.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		int count = br.read();
		String line = br.readLine();
		
		for (int i = 0; i < count; i++) {
			if ((line = br.readLine()) != null) {

				String v[] = line.split(",");
				Client client = new Client();
				int idx = 0;
				
				client.setNume(v[0]);
				client.setPrenume(v[1]);
				client.setEmail(v[2]);
				client.setParola(v[3]);
				client.setTelefon(v[4]);
				client.setAdresa(v[5]);
				
				ArrayList<Produs> listaFavorite = new ArrayList<Produs>();
				
				int sizeProduse = Integer.parseInt(br.readLine());
				
				for (int j = 0; j < sizeProduse; j++) {
					if ((line = br.readLine()) != null) {
						String a[] = line.split(",");
						
						Produs produs = new Produs();
						
						produs.setId(Integer.parseInt(a[0]));
						produs.setDenumire(a[1]);
						produs.setPret(Double.parseDouble(a[2]));
						String tip = a[3];
						if (tip.equals("ELECTRONIC")) {
							produs.setTip(TipProdus.ELECTRONIC);
						} else if (tip.equals("ALIMENTAR")) {
							produs.setTip(TipProdus.ALIMENTAR);
						}
						else if (tip.equals("IMBRACAMINTE")) {
							produs.setTip(TipProdus.IMBRACAMINTE);
						}else if (tip.equals("COSMETIC")) {
							produs.setTip(TipProdus.COSMETIC);
						}
						produs.setProducator(a[4]);
						produs.setCantitate(Integer.parseInt(a[5]));
						
						listaFavorite.add(produs);
					}
				}
				client.setListaFavorite(listaFavorite);
				
				ArrayList<Produs> listaProduseCosCumparaturi = new ArrayList<Produs>();
				
				int sizeProduseCosCumparaturi = Integer.parseInt(br.readLine());
				
				for (int j = 0; j < sizeProduseCosCumparaturi; j++) {
					if ((line = br.readLine()) != null) {
						String b[] = line.split(",");
						
						Produs produs = new Produs();
						
						produs.setId(Integer.parseInt(b[0]));
						produs.setDenumire(b[1]);
						produs.setPret(Double.parseDouble(b[2]));
						String tip = b[3];
						if (tip.equals("ELECTRONIC")) {
							produs.setTip(TipProdus.ELECTRONIC);
						} else if (tip.equals("ALIMENTAR")) {
							produs.setTip(TipProdus.ALIMENTAR);
						} 
						else if (tip.equals("IMBRACAMINTE")) {
							produs.setTip(TipProdus.IMBRACAMINTE);
						}else if (tip.equals("COSMETIC")) {
							produs.setTip(TipProdus.COSMETIC);
						}
						produs.setProducator(b[4]);
						produs.setCantitate(Integer.parseInt(b[5]));
						
						listaProduseCosCumparaturi.add(produs);
					}
				}
				client.setListaProduseCosCumparaturi(listaProduseCosCumparaturi);
				
				
				int nrComenzi = Integer.parseInt(br.readLine());
				HashMap<Integer, Comanda> listaComenzi = new HashMap<Integer, Comanda>();
				
				for (int k = 0; k < nrComenzi; k++) {
					if ((line = br.readLine()) != null) {
						idx++;
						String b[] = line.split(",");
						int key = idx;

						Comanda comanda = new Comanda();
						comanda.setNumarComanda(Integer.parseInt(b[0]));
						comanda.setDataLivrare(sdf.parse(b[1]));
						String plataEfectuata = b[2];
						if (plataEfectuata.toUpperCase().equals("FALSE")) {
							comanda.setPlataEfectuata(Boolean.FALSE);
						}
						else if (plataEfectuata.toUpperCase().equals("TRUE")) {
							comanda.setPlataEfectuata(Boolean.TRUE);
						}
						String modalitatePlata = b[3];
						if (modalitatePlata.toUpperCase().equals("RAMBURS")) {
							comanda.setTipModalitatePlata(TipModalitatePlata.RAMBURS);
						} 
						else if (modalitatePlata.toUpperCase().equals("CARD")) {
							comanda.setTipModalitatePlata(TipModalitatePlata.CARD);
						} 
						
						ArrayList<Produs> listaProduse = new ArrayList<Produs>();
						int sizeProduseComanda = Integer.parseInt(br.readLine());
						for(int p=0; p<sizeProduseComanda; p++) {
							if ((line = br.readLine()) != null) {
								
								String c[] = line.split(",");
								
								Produs produs = new Produs();
								produs.setId(Integer.parseInt(c[0]));
								produs.setDenumire(c[1]);
								produs.setPret(Double.parseDouble(c[2]));
								String tip = c[3];
								if (tip.equals("ELECTRONIC")) {
									produs.setTip(TipProdus.ELECTRONIC);
								} else if (tip.equals("ALIMENTAR")) {
									produs.setTip(TipProdus.ALIMENTAR);
								} 
								else if (tip.equals("IMBRACAMINTE")) {
									produs.setTip(TipProdus.IMBRACAMINTE);
								}else if (tip.equals("COSMETIC")) {
									produs.setTip(TipProdus.COSMETIC);
								}
								produs.setProducator(c[4]);
								produs.setCantitate(Integer.parseInt(c[5]));
								
								listaProduse.add(produs);
							
							}
						}
						comanda.setListaProduse(listaProduse);
					
						listaComenzi.put(key, comanda);
					}
					client.setListaComenzi(listaComenzi);
				}
				
				listaClienti.add(client);
				
			}
		}
		br.close();
		fr.close();

		return listaClienti;
	}
	
	
	public static void scriereDate(ArrayList<Client> listaClienti) {
		System.out.println(listaClienti);
		File f = new File("dateClienti.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			BufferedWriter bf = new BufferedWriter(fw);

			bf.write(listaClienti.size() + "\n");
			for (Client c : listaClienti) {
				bf.write(c.toStringScriereFisier());
				bf.write("\n");
				
				bf.write(c.getListaFavorite().size() + "\n");
				
				for(Produs p: c.getListaFavorite()) {
					bf.write(p.toStringScriereFisier()+ "\n");
				}
				
				bf.write(c.getListaProduseCosCumparaturi().size() + "\n");
				
				for(Produs p: c.getListaProduseCosCumparaturi()) {
					bf.write(p.toStringScriereFisier()+ "\n");
				}
				HashMap listaComenzi = c.getListaComenzi();
				bf.write(c.getListaComenzi().size() + "\n");
				c.getListaComenzi().forEach((key, value) -> {
					try {
						bf.write(value.toStringScriereFisier()+ "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					try {
						bf.write(value.getListaProduse().size() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					for(Produs p: value.getListaProduse()) {
						try {
							bf.write(p.toStringScriereFisier()+ "\n");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
			}

			bf.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static Rezultat meniu(Client client, Comanda comanda, DetaliiCard detaliiCard, ArrayList<Client> listaClienti) throws ParseException, ExceptieGenerata {
		
		System.out.println("-------------------------------------");
		System.out.println("MENIU");
		System.out.println("Alegeti una din optiunile de mai jos:");
		
		System.out.println("1 - Despre");
		System.out.println("2 - Introducere date personale");
		System.out.println("3 - Editeaza datele personale");
		
		System.out.println("4 - Afiseaza lista de favorite");
		System.out.println("5 - Adauga produs la favorite");
		System.out.println("6 - Sterge produs de la favorite");
		System.out.println("7 - Sterge lista de favorite");
		System.out.println("8 - Adauga produs in cosul de cumparaturi");
		System.out.println("9 - Afiseaza cosul de cumparaturi");
		System.out.println("10 - Stergeti produs din cosul de cumparaturi");
		System.out.println("11 - Stergeti toate produsele din cosul de cumparaturi");
		System.out.println("12 - Selectati modalitatea de plata");
		System.out.println("13 - Trimite comanda formata din produsele din cos si efectuati plata");
		System.out.println("14 - Afisati toate comenzile efectuate");
		System.out.println("15 - Afisati denumirea tuturor produselor din comenzile efectuate pana acum de dvs.");
		
		System.out.println("16 - Statistici - Valoarea totala a comenzilor efectuate de dvs.");
		System.out.println("17 - Statistici - Valoarea totala a produselor comandate de utilizatorii aplicatiei (pe categorii)");
		System.out.println("18 - Salvare");
		System.out.println("19 - Iesire");
		System.out.println("-------------------------------------");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Scanner s = new Scanner(System.in);
		int value = s.nextInt();
		int index = 0;
		Vector vectTipuriProduse = new Vector();
		
		for(int i=0; i< TipProdus.values().length; i++) {
			vectTipuriProduse.add(TipProdus.values()[i]);
		}
		
		

		switch (value) {
		case 1: {
			System.out.println("1 - Despre");
			System.out.println("Bun venit in aplicatia About You Mag! Navigare placuta!");
			
			System.out.println("Tipurile de produse pe care le puteti gasi in aplicatie sunt: ");
			System.out.println(vectTipuriProduse);
			
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		
		case 2: {
			System.out.println("2 - Introducere date personale");
			client = autentificareClient();
			System.out.println("Ati fost adaugat cu succes!");
			System.out.println(client.toString());
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		
		
		case 3: {
			System.out.println("3 - Editeaza datele personale");
			//nume
			System.out.println("Numele actual este: ");
			System.out.println(client.getNume());
			System.out.println("Doriti sa il modificati? (DA / NU)");
			String rasp = s.next();
			if (rasp.toUpperCase().equals("DA")) {
				System.out.println("Introduceti noul nume de familie.");
				client.setNume(s.next());
			} 
			else if (rasp.toUpperCase().equals("NU")) {
				System.out.println("Numele nu a fost modificat.");
			} 
			
			//prenume
			System.out.println("Prenumele actual este: ");
			System.out.println(client.getPrenume());
			System.out.println("Doriti sa il modificati? (DA / NU)");
			rasp = s.next();
			if (rasp.toUpperCase().equals("DA")) {
				System.out.println("Introduceti noul prenume.");
				client.setPrenume(s.next());
			} 
			else if (rasp.toUpperCase().equals("NU")) {
				System.out.println("Prenumele nu a fost modificat.");
			} 
			
			//email
			System.out.println("Email-ul actual este: ");
			System.out.println(client.getEmail());
			System.out.println("Doriti sa il modificati? (DA / NU)");
			rasp = s.next();
			if (rasp.toUpperCase().equals("DA")) {
				System.out.println("Introduceti noul email.");
				client.setEmail(s.next());
			} 
			else if (rasp.toUpperCase().equals("NU")) {
				System.out.println("Email-ul nu a fost modificat.");
			} 
			
			//telefon
			System.out.println("Telefonul actual este: ");
			System.out.println(client.getTelefon());
			System.out.println("Doriti sa il modificati? (DA / NU)");
			rasp = s.next();
			if (rasp.toUpperCase().equals("DA")) {
				System.out.println("Introduceti noul numar de telefon.");
				client.setTelefon(s.next());
			} 
			else if (rasp.toUpperCase().equals("NU")) {
				System.out.println("Numarul de telefon nu a fost modificat.");
			} 
			
			//adresa
			System.out.println("Adresa actuala este: ");
			System.out.println(client.getAdresa());
			System.out.println("Doriti sa o modificati? (DA / NU)");
			rasp = s.next();
			if (rasp.toUpperCase().equals("DA")) {
				System.out.println("Introduceti noua adresa.");
				client.setAdresa(s.next());
			} 
			else if (rasp.toUpperCase().equals("NU")) {
				System.out.println("Adresa nu a fost modificata.");
			} 
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		
		case 4: {
			System.out.println("4 - Afiseaza lista de favorite");
			if(client.getNume() == null || client.getAdresa() == null || client.getEmail() == null || client.getPrenume() == null) {
				System.out.println("Trebuie sa introduceti mai intai datele personale. Selectati din meniu optiunea 2.");
			}
			else {
				if(client.getListaFavorite().size() == 0) {
					System.out.println("Lista dvs de favorite este goala.");
				}
				else {
					System.out.println(client.getListaFavorite()); 
				}
			}
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		
		case 5: {
			System.out.println("5 - Adauga produs la favorite");
			if(client.getNume() == null || client.getAdresa() == null || client.getEmail() == null || client.getPrenume() == null) {
				System.out.println("Trebuie sa introduceti mai intai datele personale. Selectati din meniu optiunea 2.");
			}
			else {
				Produs p = adaugareProdus();
				client.adaugaProdusLaFavorite(p);
				System.out.println("Produsul a fost adaugat la favorite! \n");
				System.out.println("Acum, lista de favorite contine urmatoarele produse:");
				System.out.println(client.getListaFavorite());
				System.out.println(client.toString());
			}
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		
		case 6: {
			System.out.println("6 - Sterge produs de la favorite");
			if(client.getNume() == null || client.getAdresa() == null || client.getEmail() == null || client.getPrenume() == null) {
				System.out.println("Trebuie sa introduceti mai intai datele personale. Selectati din meniu optiunea 2.");
			}
			else {
				if(client.getListaFavorite().size() == 0) {
					System.out.println("Lista dvs de favorite este goala.");
				}
				else {
					System.out.println("Lista de favorite contine urmatoarele produse:");
					System.out.println(client.getListaFavorite());
					System.out.println("Introduceti id-ul al produsului pe care doriti sa il stergeti: ");
					Scanner scan = new Scanner(System.in);
					int id = scan.nextInt();
					
					client.stergeProdusDinFavorite(id);
					
					System.out.println("Produsul a fost sters.");
					System.out.println("Acum, lista de favorite contine urmatoarele produse:");
					System.out.println(client.getListaFavorite());
				}
			}
			
			
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		
		case 7: {
			System.out.println("7 - Sterge lista de favorite");
			if(client.getNume() == null || client.getAdresa() == null || client.getEmail() == null || client.getPrenume() == null) {
				System.out.println("Trebuie sa introduceti mai intai datele personale. Selectati din meniu optiunea 2.");
			}
			else {
				if(client.getListaFavorite().size() == 0) {
					System.out.println("Lista dvs de favorite este goala.");
				}
				else {
					System.out.println("Lista de favorite contine urmatoarele produse:");
					System.out.println(client.getListaFavorite());
					System.out.println("Confirmati stergerea listei? (DA / NU)");
					String rasp = s.next();
					if (rasp.toUpperCase().equals("DA")) {
						client.getListaFavorite().clear();
						System.out.println("Lista dvs. de favorite a fost stearsa.");
					} 
					else if (rasp.toUpperCase().equals("NU")) {
						System.out.println("Lista dvs. de favorite NU a fost stearsa.");
					} 
					else {
						System.out.println("Lista dvs. de favorite nu a fost stearsa.");
					}
				}
				
			}
			
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		case 8: {
			System.out.println("8 - Adauga produs in cosul de cumparaturi");
			if(client.getNume() == null || client.getAdresa() == null || client.getEmail() == null || client.getPrenume() == null) {
				System.out.println("Trebuie sa introduceti mai intai datele personale. Selectati din meniu optiunea 2.");
			}
			else {
				Produs p = adaugareProdus();
				client.adaugaProdusInCos(p);
				System.out.println("Produsul a fost adaugat in cosul de cumparaturi.");
				System.out.println("Lista produse din cosul de cumparaturi este: ");
				System.out.println(client.getListaProduseCosCumparaturi());
			}
			
			
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		case 9: {
			System.out.println("9 - Afiseaza cosul de cumparaturi");
			if(client.getNume() == null || client.getAdresa() == null || client.getEmail() == null || client.getPrenume() == null) {
				System.out.println("Trebuie sa introduceti mai intai datele personale. Selectati din meniu optiunea 2.");
			}
			else {
				if(client.getListaProduseCosCumparaturi().size() == 0) {
					System.out.println("Cosul dvs de cumparaturi este gol.");
				}
				else {
					System.out.println("Lista produse din cosul de cumparaturi: ");
					System.out.println(client.getListaProduseCosCumparaturi());
				}
			}
		
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		
		case 10:{
			System.out.println("10 - Stergeti produs din cosul de cumparaturi");
			if(client.getNume() == null || client.getAdresa() == null || client.getEmail() == null || client.getPrenume() == null) {
				System.out.println("Trebuie sa introduceti mai intai datele personale. Selectati din meniu optiunea 2.");
			}
			else {
				if(client.getListaProduseCosCumparaturi().size() == 0) {
					System.out.println("Cosul dvs de cumparaturi este gol.");
				}
				else {
					System.out.println("Cosul de cumparaturi contine urmatoarele produse:");
					System.out.println(client.getListaProduseCosCumparaturi());
					System.out.println("Introduceti id-ul al produsului pe care doriti sa il stergeti: ");
					Scanner scan = new Scanner(System.in);
					int id = scan.nextInt();
					
					client.stergeProdusDinCos(id);
					
					System.out.println("Produsul a fost sters din cos.");
					System.out.println("Acum, cosul de cumparaturi contine urmatoarele produse:");
					System.out.println(client.getListaProduseCosCumparaturi());
				}
			}
			
			
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		
		case 11: {
			System.out.println("11 - Stergeti toate produsele din cosul de cumparaturi");
			if(client.getNume() == null || client.getAdresa() == null || client.getEmail() == null || client.getPrenume() == null) {
				System.out.println("Trebuie sa introduceti mai intai datele personale. Selectati din meniu optiunea 2.");
			}
			else {
				if(client.getListaProduseCosCumparaturi().size() == 0) {
					System.out.println("Cosul dvs de cumparaturi este gol.");
				}
				else {
					System.out.println("Cosul de cumparaturi contine urmatoarele produse:");
					System.out.println(client.getListaProduseCosCumparaturi());
					System.out.println("Confirmati stergerea cosului de cumparaturi? (DA / NU)");
					String rasp = s.next();
					if (rasp.toUpperCase().equals("DA")) {
						client.getListaProduseCosCumparaturi().clear();
						System.out.println("Produsele din cosul de cumparaturi au fost sterse.");
					} 
					else if (rasp.toUpperCase().equals("NU")) {
						System.out.println("Produsele din cosul de cumparaturi NU au fost sterse.");
					} 
					else {
						System.out.println("Produsele din cosul de cumparaturi NU au fost sterse.");
					}
				}
			}
		
			
			
			
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		case 12:{
			System.out.println("12 - Selectati modalitatea de plata");
			
			System.out.println("Alegeti modalitatea de plata (RAMBURS / CARD)");
			String rasp = s.next();
			Boolean corect = false;
			if (rasp.toUpperCase().equals("RAMBURS")) {
				corect = true;
				comanda.setTipModalitatePlata(TipModalitatePlata.RAMBURS);
				System.out.println("Ati ales modalitatea de plata ramburs.");
			} 
			else if (rasp.toUpperCase().equals("CARD")) {
				corect = true;
				comanda.setTipModalitatePlata(TipModalitatePlata.CARD);
				System.out.println("Ati ales modalitatea de plata cu cardul. Va rugam introduceti detaliile cardului.");
				System.out.println("Nume beneficiar: ");
				detaliiCard.setNumeBeneficiar(s.next());
				System.out.println("Numar card: ");
				detaliiCard.setNumarCard(s.next());
				System.out.println("Data expirare card: ");
				detaliiCard.setDataExpirare(simpleDateFormat.parse(s.next()));
				System.out.println("Codul de 3 cifre de pe spatele cardului: ");
				detaliiCard.setCodCard(s.nextInt());
				
				System.out.println("Detaliile cardului au fost introduse cu succes!");
				System.out.println(detaliiCard.toString());
				
			} 
			else {
				System.out.println("Puteti aleget doar dintre variantele RAMBURS si CARD");
				corect = false;
			}
			
			
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
			
		}
		case 13: {
			System.out.println("13 - Trimite comanda formata din produsele din cos si efectuati plata");
			if(client.getNume() == null || client.getAdresa() == null || client.getEmail() == null || client.getPrenume() == null) {
				System.out.println("Trebuie sa introduceti mai intai datele personale. Selectati din meniu optiunea 2.");
			}
			else {
				if(comanda.getTipModalitatePlata() == null) {
					System.out.println("Trebuie sa selectati mai intai modalitatea de plata pentru care optati. Selectati din meniu optiunea 13.");
				}
				else {
					comanda.setPlataEfectuata(true);
					System.out.println("Produsele din cosul de cumparaturi sunt: ");
					System.out.println(client.getListaProduseCosCumparaturi());
					System.out.println("Confirmati trimiterea comenzii (DA / NU)?");
					String rasp = s.next();
					if (rasp.toUpperCase().equals("DA")) {
						comanda.setListaProduse(client.getListaProduseCosCumparaturi());
						client.adaugaComandaLaListaComenzi(comanda, index);
						client.getListaProduseCosCumparaturi().clear();
						
						System.out.println("Comanda a fost trimisa.");
					} 
					else if (rasp.toUpperCase().equals("NU")) {
						System.out.println("Comanda NU a fost trimisa.");
					} 
					else {
						System.out.println("Comanda NU a fost trimisa.");
					}	
				}
			}

			
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		
		case 14: {
			System.out.println("14 - Afisati toate comenzile efectuate");
			if(client.getNume() == null || client.getAdresa() == null || client.getEmail() == null || client.getPrenume() == null) {
				System.out.println("Trebuie sa introduceti mai intai datele personale. Selectati din meniu optiunea 2.");
			}
			else {
				if(client.getListaComenzi().size() == 0) {
					System.out.println("Nu aveti comenzi efectuate pana in acest moment.");
				}
				else {
					System.out.println(client.getListaComenzi());
				}
			}
		
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		
		case 15: {
			System.out.println("15 - Afisati denumirea tuturor produselor din comenzile efectuate pana acum de dvs.");
			if(client.getNume() == null || client.getAdresa() == null || client.getEmail() == null || client.getPrenume() == null) {
				System.out.println("Trebuie sa introduceti mai intai datele personale. Selectati din meniu optiunea 2.");
			}
			else {
				if(client.getListaComenzi().size() == 0) {
					System.out.println("Nu aveti comenzi efectuate pana in acest moment.");
				}
				else {
					Vector vect = new Vector(); 
					client.getListaComenzi().forEach((k, v) -> {
						for(Produs p: v.getListaProduse()) {
							vect.add(p.getDenumire());
						}
					});
					System.out.println("Denumirile produselor comandate de dvs pana acum sunt: ");
					System.out.println(vect);
				}
			}
		}
		
		case 16:{
			System.out.println("16 - Statistici - Valoarea totala a comenzilor efectuate de dvs.");
			valoare = 0.0;
			
			client.getListaComenzi().forEach((k, v) -> {
				for(Produs p: v.getListaProduse()) {
					valoare +=  p.getPret()*p.getCantitate();
				}
			});
			
			System.out.println("Valoarea totala a comenzilor efectuate este:");
			System.out.println(valoare);
			
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		
		case 17: {
			System.out.println("17 - Statistici - Valoarea totala a produselor comandate de utilizatorii aplicatiei (pe categorii)");
			Hashtable<TipProdus, Double> hash = new Hashtable<TipProdus, Double>();
			hash.put(TipProdus.ALIMENTAR, 0.0);
			hash.put(TipProdus.COSMETIC, 0.0);
			hash.put(TipProdus.IMBRACAMINTE, 0.0);
			hash.put(TipProdus.ELECTRONIC, 0.0);
			nrAlimentar = 0.0;
			nrCosmetic = 0.0;
			nrImbracaminte = 0.0;
			nrElectronic = 0.0;

			for(Client c: listaClienti) {
				c.getListaComenzi().forEach((k, v) -> {
					for(Produs p: v.getListaProduse()) {
						if(p.getTip() == TipProdus.ALIMENTAR) {
							nrAlimentar += p.getPret();
							hash.put(TipProdus.ALIMENTAR, nrAlimentar);
						}
						else if(p.getTip() == TipProdus.COSMETIC) {
							nrCosmetic += p.getPret();
							hash.put(TipProdus.COSMETIC, nrCosmetic);
						}
						else if(p.getTip() == TipProdus.IMBRACAMINTE) {
							nrImbracaminte += p.getPret();
							hash.put(TipProdus.IMBRACAMINTE, nrImbracaminte);
						}
						else if(p.getTip() == TipProdus.ELECTRONIC) {
							nrElectronic += p.getPret();
							hash.put(TipProdus.ELECTRONIC, nrElectronic);
						}
					}
				});
			}
			
			System.out.println(hash);
			
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		
		case 18:{
			System.out.println("18 - Salvare");
			if(client.getEmail() != null) {
					listaClienti.add(client);
			}
			scriereDate(listaClienti);
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		case 19 :{
			System.out.println("19 - Iesire");
			return new Rezultat(2);
		}
		default:{
			System.out.println("Alegeti o valoare intre 1 - 16\n");
			meniu(client, comanda, detaliiCard, listaClienti);
			break;
		}
		}
		
		return new Rezultat(2);
	}
		
		
	
	public static void main(String[] args) throws ParseException, IOException, ExceptieGenerata {
		Rezultat rezultat = new Rezultat(0);
		Client client = new Client();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date(System.currentTimeMillis());
		ArrayList listaProduse = new ArrayList<>();
		Comanda comanda = new Comanda(1, simpleDateFormat.parse("07.11.2019"), false, listaProduse);
		DetaliiCard detaliiCard = new DetaliiCard();
		
		
		ArrayList<Client> listaClienti = new ArrayList<Client>();
		listaClienti = initializareDateClienti();
		
		
		
		while (rezultat.val < 1) {
			try {

				rezultat = meniu(client, comanda, detaliiCard, listaClienti);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

		

	
	
	
//	2
//	Popescu,Mihaela,popescumihaela@gmail.com,123abc,0745362718,Calea Crangasi,
//	2
//	9,ruj,50.0,COSMETIC,Fenty,2
//	12,rochie,320.0,IMBRACAMINTE,Zara,1
//	2
//	5,fard,78.0,COSMETIC, Sephora,1
//	15,tort,150.0,ALIMENTAR,TIP&TOP,1
//	1
//	39,02.11.2018,true,RAMBURS
//	2
//	53,camasa,410.0,IMBRACAMINTE,TommyJeans,1
//	13,casti,230.0,ELECTRONIC,Apple,1
//	Iordache,Andrei,andreiiordache@gmai.com,zxcvbnm,0725341425,Calea Ceahlau,
//	2
//	2,tableta,3200.0,ELECTRONIC,Apple,1
//	19,hanorac,200.0,IMBRACAMINTE,Adidas,1
//	1
//	14,tricou,190.0,IMBRACAMINTE,Puma,1
//	1
//	33,20.03.2019,true,CARD
//	1
//	1,telefon,5000.0,ELECTRONIC,Samsung,1


	
	

	

}
