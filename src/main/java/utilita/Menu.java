/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe che rappresenta un menu
 * elencoVoci è un' array di stringhe dove ogni stringa rappresenta una voce del menu, ad ogni voce del menu è assocciato un valore intero.
 * Alla prima voce è associato il valore 0, alla seconda il valore 1.
 * Ad esempio:
 * 0-->Esci         valore associato=0;
 * 1-->aggiungi     valore associato=1;
 * 2-->rimuovi      valore associato=2;
 * ...
 * 
 * la classe 
 * -consente di visualizzare le voci del menu; 
 * -far scelgliere all'utente una voce e di restituire il valore associato ad essa;
 * 
 * @author Studente
 */
public class Menu
{
    private String[] elencoVoci;
    private int numeroVoci;
    /**
     * Costruttore
     * @param elencoVoci
     */
    public Menu(String[] elencoVoci)
    {
	numeroVoci=elencoVoci.length;
	this.elencoVoci=new String[numeroVoci];
	for(int i=0;i<numeroVoci;i++)
	    this.elencoVoci[i]=elencoVoci[i];
    }
    /**
     * visualizza le voci del menu
     */
    public void visualizzaMenu()
    {
	System.out.println("MENU:");
	for(int i=0;i<numeroVoci;i++)
	    System.out.println(elencoVoci[i]);
    }
    /**
     * Permette all'utente di scegliere una voce del menu
     * i valori interi associati alle voci del menu vanno da 0 a numeroVoci-1.
     * Se l'utente inserisce un espressione non idonea verrà richiesto nuovamente di inserire un valore
     * @return il valore intero associato alla voce scelta
     */
    public int sceltaMenu()
    {
	int sceltaUtente=0;
	boolean inputUtenteOK=true;
	
	do{
	    ConsoleInput tastiera=new ConsoleInput();
	    inputUtenteOK=true;
	    visualizzaMenu();
	    System.out.print("Scelta --> ");
            try
            {
                sceltaUtente=tastiera.readInt();
                //verifico se il numero inserito è compreso nelle voci del menu
		if(sceltaUtente<0 || sceltaUtente>numeroVoci-1)
                {
                    inputUtenteOK=false;
                    System.out.println("voce non prevista");
                }
                    
		    
            }
            catch (IOException ex) 
            {
                System.out.println("impossibile leggere la tastiera!");
            } 
            catch (NumberFormatException ex) 
            {
                System.out.println("il dato inserito non è un intero");
                inputUtenteOK=false;
            }
            
	}while(!inputUtenteOK);
	return sceltaUtente;
    }
}