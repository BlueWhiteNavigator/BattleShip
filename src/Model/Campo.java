package Model;

import java.util.*;

/**
 * Classe che definisce il campo da gioco (di ogni giocatore)
 * @author Davide
 */
public class Campo {
	
	//Proprietà della classe
	public final int RIGHE = 10;
	public final int COLONNE = 10;	
	public final int numeroCelle = RIGHE * COLONNE;
	public final int numeroNavi = 10;
	public Cella cella[];
	public int naviRimanenti;
	
	//Metodi SET
		
	//Metodi GET
	public int getNumeroNavi() {
		return numeroNavi;
	}
	
	public Cella getCella(int posizione) {
		return cella[posizione];
	}
	
	public int getNumeroCelle() {
		return numeroCelle;
	}
	
	//Metodi di logica
	public void impostaTuttoMare() {
		for(int i=0; i<numeroCelle; i++) {
			cella[i] = new Cella(false);
		}
	}
	
	public void posizionamentoNavi() {
		int posizioneCasuale;
		for(int i=0; i<numeroNavi; i++) {
			//Determino una posizione casuale...
			posizioneCasuale = (new Random()).nextInt(numeroCelle-1);
			//Se c'è il mare in posizioneCasuale, allora posizione la nave in quella posizione
			if(cella[posizioneCasuale].isPresenzaNave() == false) {
				//Posiziona la nave...
				cella[posizioneCasuale].impostaNave(); 
			}
			else {
				//C'è già una nave in quella posizione... devo rifare il ciclo nuovamente, diminuisco i di un'unità
				i = i - 1; 
			}
		}		
	}
	
	public int calcolaNumeroNaviRimanenti() {
		naviRimanenti = 0;
		for(int i=0; i<numeroCelle; i++) {
			if(cella[i].isPresenzaNave() == true) {
				naviRimanenti = naviRimanenti + 1;
			}
		}
		return naviRimanenti;
	}
	
	public void costruzioneCampo() {
		cella = new Cella[numeroCelle];
		//Prima metto tutto mare...
		this.impostaTuttoMare();
		//Mettiamo un numero di navi pari a numeroNavi
		this.posizionamentoNavi();
	}
	
	//Costruttore
	public Campo() {
		this.costruzioneCampo();
		this.calcolaNumeroNaviRimanenti();
	}
}
