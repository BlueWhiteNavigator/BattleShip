package View;

import java.io.*;

public class Shell {
	
	public InputStreamReader flusso;
	public BufferedReader tastiera;
	
	public void scriviSuSchermo(String stringa) {
		System.out.println(stringa);
	}
	
	public int leggiNumeroIntero() {
		try {
			String stringa = tastiera.readLine();
			return Integer.parseInt(stringa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}		
	}
	
	public Shell() {
		flusso = new InputStreamReader(System.in);
		tastiera = new BufferedReader(flusso);
	}

	
}
