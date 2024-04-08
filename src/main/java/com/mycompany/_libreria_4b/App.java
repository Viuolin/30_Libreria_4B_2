/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._libreria_4b;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.EccezioneRipianoNonValido;
import eccezioni.FileException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.ConsoleInput;
import utilita.Menu;
import utilita.TextFile;

/**
 *
 * @author gian
 */
public class App 
{

    public static void main(String[] args) 
    {
        int numeroVociMenu=9;
        String[] vociMenu=new String[numeroVociMenu];
        int voceMenuScelta;
        Menu menu;
        Scaffale s1=new Scaffale();
        ConsoleInput tastiera=new ConsoleInput();
        String titolo,autore;
        int numeroPagine,ripiano, posizione;
        
        Libro lib;
        Libro[] elencoLibriOrdinatiAlfabeticamente;
        String [] elencoTitoliAutore;
        String nomeFileCSV="volumi.csv";
        
        
        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tVisualizza tutti i volumi dello scaffale";
        vociMenu[2]="2 -->\tAggiungi volume (ripiano,posizione)";
        vociMenu[3]="3 -->\tCerca volume (ripiano, posizione)";
        vociMenu[4]="4 -->\tElimina volume (ripiano,posizione)";
        vociMenu[5]="5 -->\tMostra titoli di uno specifico autore";
        vociMenu[6]="6 -->\tMostra elenco dei volumi presenti ordinato alfabeticamente per titolo";
        vociMenu[7]="7 -->\tesporta volumi in formato CSV";
        vociMenu[8]="8 -->\tImporta volumi da file CSV";
        menu=new Menu(vociMenu);
        
        
        
        
        
        do
        {
            System.out.println("MENU:");
            voceMenuScelta=menu.sceltaMenu();
            switch (voceMenuScelta) 
            {
                case 0:
                    System.out.println("Arrivederci");
                    break;
                case 1:
                    System.out.println(s1.toString());
                    break;
                case 2:
                {
                    
                    System.out.println("Titolo --> ");
                    try
                    {
                         titolo=tastiera.readString();
                         System.out.println("Autore --> ");
                         autore=tastiera.readString();
                         
                         do
                         {
                            try
                            {
                            System.out.println("Numero pagine --> ");
                            numeroPagine=tastiera.readInt();
                            break;
                            }
                            catch (NumberFormatException e)
                             {
                            System.out.println("il dato inserito è errato");                       
                             }
                         }while(true);
                         
                         do
                         {
                            try
                            {
                            System.out.println("Ripiano (0..4) --> ");
                            ripiano=tastiera.readInt();
                            break;
                            }
                            catch(NumberFormatException e)
                            {
                             System.out.println("il dato inserito è errato");  
                            }
                         }while (true);                          
                            
                         do
                         {
                             try
                             {
                             System.out.println("Posizione (0..14) --> ");
                             posizione=tastiera.readInt();
                             break;
                             }
                             catch(NumberFormatException e)
                             {
                               System.out.println("il dato inserito è errato"); 
                             }
                         }while (true);                           
                         lib=new Libro(titolo,autore,numeroPagine);
                         s1.setLibro(lib, ripiano, posizione);
                         System.out.println("Volume inserito correttamente.");
                    } 
                    catch (IOException ex) 
                    {
                         System.out.println("impossibile leggere da tastiera");
                    }
                    catch (NumberFormatException ex) 
                    {
                       System.out.println("il dato inserito è errato");
                    }
                    catch (EccezioneRipianoNonValido ex) 
                    {
                        System.out.println("Ripiano non valido!");
                    }
                    catch (EccezionePosizioneNonValida ex)
                    {
                        System.out.println("Posizione non valida!");
  
                    } 
                    catch (EccezionePosizioneOccupata ex) 
                    {
                        System.out.println("Posizione occupata!");
                       
                    }
                    
                }
                    
                    break;


                case 3:
                    try{
                         do
                         {
                            try
                            {
                            System.out.println("Ripiano (0..4) --> ");
                            ripiano=tastiera.readInt();
                            break;
                            }
                            catch(NumberFormatException e)
                            {
                               System.out.println("il dato inserito è errato");  
                            }
                         }while (true);   
                   
                         do
                         {
                             try
                             {
                             System.out.println("Posizione (0..14) --> ");
                             posizione=tastiera.readInt();
                             break;
                             }
                             catch(NumberFormatException e)
                             {
                               System.out.println("il dato inserito è errato"); 
                             }
                         }while (true);  
                         lib=s1.getLibro(ripiano, posizione);
                         System.out.println("Libro cercato:\n"+lib.toString());
                    }
                    catch(IOException e)
                    {
                         System.out.println("impossibile leggere da tastiera");
                    }                    
                    catch (EccezioneRipianoNonValido ex) 
                    {
                        System.out.println("Ripiano non valido!");
                    }
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida!");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                        System.out.println("Volume non presente in quel ripiano/posizione");
                    }
                    break;


                    
                case 4:
                   try{
                         do
                         {
                            try
                            {
                            System.out.println("Ripiano (0..4) --> ");
                            ripiano=tastiera.readInt();
                            break;
                            }
                            catch(NumberFormatException e)
                            {
                               System.out.println("il dato inserito è errato");  
                            }
                         }while (true);   
                   
                         do
                         {
                             try
                             {
                             System.out.println("Posizione (0..14) --> ");
                             posizione=tastiera.readInt();
                             break;
                             }
                             catch(NumberFormatException e)
                             {
                               System.out.println("il dato inserito è errato"); 
                             }
                         }while (true);  
                        s1.rimuoviLibro(ripiano, posizione);
                        System.out.println("Il libro è stato rimosso correttamente");
                    }
                   catch(IOException e)
                   {
                       System.out.println("impossibile leggere da tastiera");
                   }
                    catch (EccezioneRipianoNonValido ex) 
                    {
                        System.out.println("Ripiano non valido!");
                    }
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida!");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                        System.out.println("La posizione è già vuota. Nessun libro è stto rimosso");
                    }
                    break;

                case 5:
                    System.out.println("Autore --> ");
                {
                    try 
                    {
                        autore=tastiera.readString();
                        elencoTitoliAutore=s1.elencoTitoliAutore(autore);
                        if (elencoTitoliAutore!=null)
                    {
                        for(int i=0;i<elencoTitoliAutore.length;i++)
                        {
                            System.out.println(elencoTitoliAutore[i]);
                        }
                    }
                    else
                        System.out.println("Nessun volume presente per l'autore scelto.");
                    break;
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("impossibile leggere da tastiera");                    }
                    }
                    
                    

                
                case 6:
                    elencoLibriOrdinatiAlfabeticamente=s1.elencoLibriOrdinatoPerTitolo();
                    for(int i=0;i<elencoLibriOrdinatiAlfabeticamente.length;i++)
                    {
                        System.out.println(elencoLibriOrdinatiAlfabeticamente[i].toString());
                    }
                    break;
             
                case 7:
                {
                    try 
                    {
                        TextFile f1=new TextFile(nomeFileCSV,'W'); //apro il file in scrittura
                        String datiVolume;
                        for(int i=0; i<s1.getNumRipiani();i++)
                        {
                            for(int j=0;j<s1.getNumMaxLibri(i);j++)
                            {
                                try {
                                    lib=s1.getLibro(i, j);
                                    datiVolume=i+";"+j+";"+lib.getTitolo()+";"+lib.getAutore()+";"+lib.getNumeroPagine();
                                    f1.toFile(datiVolume);
                                    
                             
                                } 
                                catch (EccezioneRipianoNonValido | EccezionePosizioneNonValida ex) 
                                {
                                    //non succederà mai
                                } 
 
                                catch (EccezionePosizioneVuota ex)
                                {
                                    //non far nulla
                                } 
                                catch (FileException ex)
                                {
                                    System.out.println(ex.toString());
                                }
                            }
                        }
                        f1.closeFile(); 
                        System.out.println("Esportazione avvenuta correttamente ");
                    } 
                    catch (IOException ex)
                    {
                        System.out.println("Impossibile accedere al file");
                    }
                }
                    
                    break;

            }
        }while(voceMenuScelta!=0);
        
        
            
        
    }
}
