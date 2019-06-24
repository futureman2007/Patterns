package unternehmen.impl;

import unternehmen.abstrakt.Angestellter;
import unternehmen.exception.UnsupportedOpperationException;

public class UnternehmenTest {

	public static void main(String[] args) {
		Angestellter zeno = new Abteilungsleiter("Zeno", "Sama", "Zen",Integer.MAX_VALUE,"King of all");
		Angestellter daishinkan = new Abteilungsleiter("Daishin", "Kan", "Zen", Integer.MAX_VALUE, "Grand-Priest");
		
		Angestellter kami11 = new Abteilungsleiter("Belmod", "Sama", "Universe 11", Short.MAX_VALUE, "Hakai-Shin");
		Angestellter kami9 = new Abteilungsleiter("Sidra" , "Sama", "Universe 9", Short.MAX_VALUE , "Hakai-Shin");
		Angestellter kami7 = new Abteilungsleiter("Beerus", "Sama", "Universe 7", Short.MAX_VALUE, "Hakai-Shin");
		Angestellter kami6 = new Abteilungsleiter("Champa", "Sama", "Universe 6", Short.MAX_VALUE, "Hakai-Shin");

		Angestellter ningen11_1 = new Abteilungsleiter("Jiren", "Jiren", "Pride-Troopers", Short.MAX_VALUE, "Leader");
		Angestellter ningen11_2 = new Mitarbeiter("Toppo", "Toppo", "Pride-Troopers ",9001 );	
		Angestellter ningen11_3 = new Mitarbeiter("Dispo", "Dispo", "Pride-Troopers ",9001 );	
		
		
		Angestellter ningen9_1 = new Mitarbeiter("Basil" , "Basil", "Universe 9", 9001);
		Angestellter ningen9_2 = new Mitarbeiter("Lavenda" , "Lavenda", "Universe 9", 9001);
		Angestellter ningen9_3 = new Mitarbeiter("Bergamo" , "Bergamo", "Universe 9", 9001);
		
		Angestellter ningen7_1 = new Mitarbeiter("Son-Goku" , "Kakarot", "Universe 7", 9001);
		Angestellter ningen7_2 = new Mitarbeiter("Vegeta" , "Vegeta", "Universe 7", 9001);
		Angestellter ningen7_3 = new Mitarbeiter("Frieza" , "Frieza", "Universe 7", 9001);
		
		try {
			zeno.addUnterstellten(daishinkan);
			daishinkan.addUnterstellten(kami6);
			daishinkan.addUnterstellten(kami7);
			daishinkan.addUnterstellten(kami9);
			daishinkan.addUnterstellten(kami11);
			
			kami7.addUnterstellten(ningen7_1);
			kami7.addUnterstellten(ningen7_2);
			kami7.addUnterstellten(ningen7_3);
			
			kami9.addUnterstellten(ningen9_1);
			kami9.addUnterstellten(ningen9_2);
			kami9.addUnterstellten(ningen9_3);
			
			kami11.addUnterstellten(ningen11_1);
			ningen11_1.addUnterstellten(ningen11_2);
			ningen11_1.addUnterstellten(ningen11_3);
			
			
		} catch (UnsupportedOpperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(zeno.toString());
		
		
	}
	
}
