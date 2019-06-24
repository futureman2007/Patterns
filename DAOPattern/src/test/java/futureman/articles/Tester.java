package futureman.articles;

import java.io.File;
import futureman.ort.*;
import java.io.IOException;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import futureman.articles.clothes.Jacke;
import futureman.articles.clothes.Jeans;
import futureman.articles.clothes.Kleidungstueck;
import futureman.articles.dataAccessObjectImpl.JasonDAOProvider;
import futureman.articles.dataAccessObjectImpl.JsonDAOOrtProvider;
import futureman.articles.shoes.Schuhe;
import futureman.business.Lagersteuerung;
import futureman.ort.Ort;

public class Tester {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		Ort[] orte = { new Ort(0,0,0),
				new Ort(1,0,0),
				new Ort(0,1,0),
				new Ort(0,0,1),
				new Ort(0,1,1),
				new Ort(1,1,1),
				new Ort(2,5,7),
				new Ort(3,1,7),
				new Ort(-2,2,-5)
		};
		Artikel[] arts = new Artikel[] {
				new Schuhe(46, "LEDER", Farbe.SCHWARZ, "D" ),
				new Schuhe(46, "LEDER", Farbe.BRAUN, "D"),
				new Kleidungstueck(36, "Abendkleid" , Farbe.HIMMELBLAU),
				new Kleidungstueck(36, "Rock" , Farbe.ROT),
				new Kleidungstueck(38, "FUtureman´s suit", Farbe.FUTUREMAN2007),
				new Jeans(Short.MAX_VALUE, "Thor´s Jeans", Farbe.BLAU, Integer.MAX_VALUE),
				new Jacke(42, "Winterjacke", Farbe.SILBER, 15)
		};
		for(int i = 0; (i < arts.length) && (i < orte.length); i++) {
			orte[i].set_artikel(arts[i]);
		}
		
		File file = Paths.get(System.getProperty("user.home") , "/Desktop/DAOFiles", "Test.txt").toFile();
		File ofile = Paths.get(System.getProperty("user.home") , "/Desktop/DAOFiles", "TestOrte.txt").toFile();
		if(file.exists()) {
			file.delete();
		}
		if(ofile.exists()) {
			ofile.delete();
		}
		
		System.out.println("=====Saving Orte=====");
		JsonDAOOrtProvider jodao = new JsonDAOOrtProvider(System.getProperty("user.home") + "/Desktop/DAOFiles", "TestOrte.txt");
		System.out.println("=======Writing to file:\n" + System.getProperty("user.home") + "/Desktop/DAOFiles/TestOrte.txt" + "\n in JSON format...=======");
		for(int i = 0; i < orte.length; i++) {
			jodao.saveNewOrt(orte[i]);
		}
		
		JasonDAOProvider dao = new JasonDAOProvider(System.getProperty("user.home") + "/Desktop/DAOFiles", "Test.txt");
		System.out.println("=======Writing to file:\n" + System.getProperty("user.home") + "/Desktop/DAOFiles/Test.txt" + "\n in JSON format...=======");
		for(int i = 0; i < arts.length; i++) {
			dao.saveArticle(arts[i]);	
		}
		System.out.println("=======Done.=======");
		System.out.println("\n=======Reading now from\n " + System.getProperty("user.home") + "/Desktop/DAOFiles/Test.txt=======");
		
		for(int i = 0; i < 20; i++) {
			System.out.println("Trying to find artikel with id=" + i + " in this file.");
			Artikel a = dao.loadArticle(i);
			if(a == null) {
				System.out.println("   \nCould not find artikel with artikelID = " + i + "\n"); 
			}else {
				System.out.println("   \nLoaded from file: " + dao._destpath + "/" + dao._filename + "\n"+ a.toString() + "\n");
			}
		}
		System.out.println("\n=======Deleting article with id = 4 in file...=======");
		dao.deleteArticle(4);
		System.out.println("File contains now: ");
		for(int i = 0; i < 8; i++) {
			System.out.println("Trying to find artikel with id=" + i + " in this file.");
			Artikel a = dao.loadArticle(i);
			if(a == null) {
				System.out.println("   \nCould not find artikel with artikelID = " + i + "\n"); 
			}else {
				System.out.println("   \nLoaded from file: " + dao._destpath + "/" + dao._filename + "\n"+ a.toString() + "\n");
			}
		}
		
		System.out.println("\n\n the next free Ort is " + new Lagersteuerung().ermittleEinenFreienOrt(jodao).toString() );
		
	}
}
