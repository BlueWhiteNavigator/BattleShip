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
	/**
	 * Metodo che ritorna il numero delle navi
	 * @return Numero delle navi
	 */
	public int getNumeroNavi() {
		return numeroNavi;
	}
	
	/**
	 * Metodo che ritorna la cella del campo dell'utente
	 * @param posizione Posizione della cella
	 * @return Cella del campo da gioco
	 */
	public Cella getCella(int posizione) {
		return cella[posizione];
	}
	
	/**
	 * Metodo che ritorna il numero delle celle del campo
	 * @return Numero di celle del campo da gioco
	 */
	public int getNumeroCelle() {
		return numeroCelle;
	}
	
	//Metodi di logica
	/**
	 * Metodo che imposta, per tutte le celle, il mare (solitamente in fase di inizializzazione iniziale del gioco)
	 */
	public void impostaTuttoMare() {
		for(int i=0; i<numeroCelle; i++) {
			cella[i] = new Cella(false);
		}
	}
	
	/**
	 * Metodo che imposta, in modo casuale, le navi sul campo da gioco
	 */
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
	
	/**
	 * Metodo che calcola il numero di navi ancora presenti sul campo da gioco
	 * @return Numero di navi rimanenti del campo da gioco
	 */
	public int calcolaNumeroNaviRimanenti() {
		naviRimanenti = 0;
		for(int i=0; i<numeroCelle; i++) {
			if(cella[i].isPresenzaNave() == true) {
				naviRimanenti = naviRimanenti + 1;
			}
		}
		return naviRimanenti;
	}
	
	/**
	 * Metodo che crea il campo da gioco
	 */
	public void costruzioneCampo() {
		cella = new Cella[numeroCelle];
		//Prima metto tutto mare...
		this.impostaTuttoMare();
		//Mettiamo un numero di navi pari a numeroNavi
		this.posizionamentoNavi();
	}
	
	//Costruttore
	/**
	 * Costruttore di Campo
	 */
	public Campo() {
		this.costruzioneCampo();
		this.calcolaNumeroNaviRimanenti();
	}
}
