package Model;

/**
 * Classe che gestisce ogni cella del campo da gioco
 * @author Davide
 */
public class Cella {
	
	//Proprietà della classe
	private final int MARE = 0;
	private final int NAVE = 1;
	private int statoCella;
	private boolean isColpita;
	
	//Metodi SET
	/**
	 * Metodo che imposta lo stato "colpita" alla cella
	 * @param isColpita True se la cella è stata colpita
	 */
	public void setIsColpita(boolean isColpita) {
		this.isColpita = isColpita;
	}
	
	//Metodi GET
	/**
	 * Metodo che indica se la cella è stata colpita
	 * @return Indicazione se la cella è stata colpita
	 */
	public boolean getIsColpita() {
		return isColpita;
	}
	
	/**
	 * Metodo che ritorna lo stato della cella
	 * @return Stato della cella
	 */
	public int getStatoCella() {
		return this.statoCella;
	}
	
	//Metodi di logica
	/**
	 * Metodo che imposta la "nave" nella cella
	 */
	public void impostaNave() {
		this.statoCella = this.NAVE;
	}
	
	/**
	 * Metodo che imposta la "mare" nella cella
	 */
	public void impostaMare() {
		this.statoCella = this.MARE;
	}
	
	/**
	 * Metodo che imposta la "mare" o "nave" nella cella
	 * @param presenzaNave True se bisogna posizionare la nave
	 */
	public void impostazioneMareNave(boolean presenzaNave) {
		if(presenzaNave == true)
			this.impostaNave();
		else
			this.impostaMare();
	}
	
	/**
	 * Metodo che indica se, nella cella, vi è la nave
	 * @return True se la nave è presente nella cella
	 */
	public boolean isPresenzaNave() {
		if(this.statoCella == this.NAVE)
			return true;
		else 
			return false;
	}
	
	//Nel caso la cella venisse attaccata...
	/**
	 * Metodo che imposta "mare" se la cella aveva "nave" ed è stata colpita
	 * @return True se la cella aveva "nave" ed è stata colpita
	 */
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
	/**
	 * Costruttore di Cella
	 * @param presenzaNave True se la cella deve contenere "nave"
	 */
	public Cella(boolean presenzaNave) {
		this.setIsColpita(false);
		this.impostazioneMareNave(presenzaNave);
	}

}
