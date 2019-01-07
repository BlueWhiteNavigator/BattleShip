package Model;

/**
 * Classe che definisce il giocatore
 * @author Davide
 */
public class Giocatore {
	
	//Proprietà della classe
	private final String NOME_DEFAULT = "";	
	private String nome;
	private Campo campo;
	
	//Metodi SET
	/**
	 * Metodo che imposta il nome del giocatore
	 * @param nome Nome del giocatore
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Metodo che crea il campo da gioco
	 */
	public void setCampo() {
		campo = new Campo();
	}
	
	//Metodi GET
	/**
	 * Metodo che ritorna il nome del giocatore
	 * @return Nome del giocatore
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Metodo che ritorna il campo del giocatore
	 * @return Campo del giocatore
	 */
	public Campo getCampo() {
		return this.campo;
	}
	
	//Metodi di logica	
	
	//Costruttori
	/**
	 * Costruttore della classe Giocatore
	 * @param nome Nome del giocatore
	 */	
	public Giocatore(String nome) {
		this.setNome(nome);
		this.setCampo();
	}
	
	/**
	 * Costruttore della classe Giocatore
	 */
	public Giocatore() {
		this.setNome(this.NOME_DEFAULT);
		this.setCampo();
	}

}
