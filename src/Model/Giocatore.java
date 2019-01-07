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
	
	public void setCampo() {
		campo = new Campo();
	}
	
	//Metodi GET
	/**
	 * Metodo che ritorna il nome del giocatore
	 * @return
	 */
	public String getNome() {
		return this.nome;
	}
	
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
