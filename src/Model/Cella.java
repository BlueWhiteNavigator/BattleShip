package Model;

/**
 * Classe che gestisce ogni cella del campo da gioco
 * @author Davide *
 */
public class Cella {
	
	//Proprietà della classe
	private final int MARE = 0;
	private final int NAVE = 1;
	private int statoCella;
	private boolean isColpita;
	
	//Metodi SET
	public void setIsColpita(boolean isColpita) {
		this.isColpita = isColpita;
	}
	
	//Metodi GET
	public boolean getIsColpita() {
		return isColpita;
	}
	
	public int getStatoCella() {
		return this.statoCella;
	}
	
	//Metodi di logica
	public void impostaNave() {
		this.statoCella = this.NAVE;
	}
	
	public void impostaMare() {
		this.statoCella = this.MARE;
	}
	
	public void impostazioneMareNave(boolean presenzaNave) {
		if(presenzaNave == true)
			this.impostaNave();
		else
			this.impostaMare();
	}
	
	public boolean isPresenzaNave() {
		if(this.statoCella == this.NAVE)
			return true;
		else 
			return false;
	}
	
	//Nel caso la cella venisse attaccata...
	public boolean cellaSottoAttacco() {
		//La cella è stata già colpita? Se sì, ritorna sempre MARE
		if(this.getIsColpita() == true) {
			return false;
		}
		else {
			this.setIsColpita(true);
			if(this.statoCella == this.NAVE) {
				this.impostaMare();
				return true;
			}
			else
				return false;
		}
	}
	
	//Costruttore
	public Cella(boolean presenzaNave) {
		this.setIsColpita(false);
		this.impostazioneMareNave(presenzaNave);
	}

}
