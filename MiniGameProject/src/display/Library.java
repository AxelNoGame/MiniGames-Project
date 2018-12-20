package display;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public abstract class Library {

	static File library = new File("Fichiers/francais.dic");
	int nbLines = 369086;
	
	static Random random = new Random();
	static String word ="";
	
	/*
	 * Envoie un mot al�atoire du fichier francais.dic
	 */
	public static String GiveWord() {
		try {
			FileInputStream fis= new FileInputStream(library);
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			int line= 1 + random.nextInt(369086 - 1);
			int i=0;
			while (i<(line-1)){
			i++;
			br.readLine();
			}
			word = br.readLine();
			br.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return word;
		
	}
	
	/*
	 * Appelle la fonction GiveWord jusqu'� trouver un mot du bon nombre de lettres
	 */
	public static String GiveWordofXLetters(int x) {
		while(word.length()!=x) {
			GiveWord();
		}
		return word;
	}
	
	
}
	
	
	