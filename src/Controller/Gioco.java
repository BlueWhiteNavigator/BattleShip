package Controller;

import java.util.Random;

import Model.*;
import View.*;

public class Gioco {
	
	public Giocatore giocatoreA;
	public Giocatore giocatoreB;
	public Shell shell;
	public int posizioneAttacco;
	
	public boolean effettuaAttacco(Giocatore giocatore, Giocatore avversario) {
		//Riepilogo delle vite dei giocatori...
		shell.scriviSuSchermo("Numero vite di " + giocatore.getNome() + ": " + giocatore.getCampo().calcolaNumeroNaviRimanenti());
		shell.scriviSuSchermo("Numero vite di " + avversario.getNome() + ": " + avversario.getCampo().calcolaNumeroNaviRimanenti());		
		//Calcola la posizione da attaccare....
		posizioneAttacco = (new Random()).nextInt(avversario.getCampo().getNumeroCelle()-1);
		//Effettua attacco!
		if(avversario.getCampo().getCella(posizioneAttacco).cellaSottoAttacco() == true) {
			shell.scriviSuSchermo("-> " + giocatore.getNome() + " attacca " + avversario.getNome() + " in posizione " + posizioneAttacco + " ... COLPITO");
		}
		else {
			shell.scriviSuSchermo("-> " + giocatore.getNome() + " attacca " + avversario.getNome() + " in posizione " + posizioneAttacco + "... MARE");
		}
		//Qualche giocatore ha già perso?
		if(giocatore.getCampo().calcolaNumeroNaviRimanenti() == 0) {
			shell.scriviSuSchermo(avversario.getNome() + " ha vinto!");
			return true;
		}
		if(avversario.getCampo().calcolaNumeroNaviRimanenti() == 0) {
			shell.scriviSuSchermo(giocatore.getNome() + " ha vinto!");
			return true;
		}
		//Il gioco prosegue...
		return false;
	}
	
	public void descrizionePosizioneNave(Giocatore giocatore) {
		String messaggio = "Posizione delle navi di " + giocatore.getNome() + ":";
		for(int i=0; i<giocatore.getCampo().getNumeroCelle(); i++) {
			if(giocatore.getCampo().getCella(i).isPresenzaNave() == true) {
				messaggio = messaggio + " " + i;
			}
		}
		shell.scriviSuSchermo(messaggio);
	}
	
	
	public Gioco() {
		shell = new Shell();
		giocatoreA = new Giocatore("Davide");
		giocatoreB = new Giocatore("Pietro");
		//Descrizione della situazione
		this.descrizionePosizioneNave(giocatoreA);
		this.descrizionePosizioneNave(giocatoreB);
		//Avvio del gioco...
		boolean fineDelGioco = false;
		int turnoDiGioco = 1;
		do {
			shell.scriviSuSchermo("*** *** *** *** *** *** *** *** *** *** *** ***");
			shell.scriviSuSchermo("TURNO: " + turnoDiGioco);
			fineDelGioco = effettuaAttacco(giocatoreA, giocatoreB);
			if(fineDelGioco == false)
				fineDelGioco = effettuaAttacco(giocatoreB, giocatoreA);
			try {
				Thread.sleep(1000);
			}
			catch(Throwable e) {}
			turnoDiGioco = turnoDiGioco + 1;
		} while(fineDelGioco == false);
	}

}
