/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import eccezioni.FileException;
import java.io.*;

/**
 * Rappresenta un file di testo.
 * Consente di scrivere una stringa sul file di testo o di leggere una stringa dal file di testo
 * quando viene istanziato il file di testo può essere aperto:
 * -in scrittura
 * -in scrittura in appenad
 * -in lettura
 * Consente di chiudere il file 
 * @author Studente
 */
public class TextFile
{
    private char mode; //R=reader/lettura - W=writer/scrittura
    private BufferedReader reader;
    private BufferedWriter writer;
    
    /**
     * Costruttore (senza append)
     * 
     * @param nomeFile pathname del file fisico da leggere / scrivere
     * @param mode modalità di apertura del file, può assumere i seguenti valori:
     * W-->per aprire il file in scrittura
     * R o qualsiasi altra lettera-->per aprire il file in lettura
     * @throws FileNotFoundException  quando il file da leggere non viene trovato il file.
     * se il file è aperto in scrittura, non viene trovato esso viene creato.
     * @throws IOException viene sollevata se non è possibile accedre al file.
     */
    public TextFile(String nomeFile, char mode) throws FileNotFoundException, IOException
    {
	this.mode='R'; //modalità di default
	if(mode=='W' || mode=='w')
	    this.mode='W';
	if(this.mode=='R')
	    reader=new BufferedReader(new FileReader(nomeFile));
	else
	    writer=new BufferedWriter(new FileWriter(nomeFile));
    }
    
    /**
     * Costruttore (con append)
     * @param nomeFile pathname del file fisico da leggere / scrivere
     * @param mode modalità di apertura del file, può assumere i seguenti valori:
     * W-->per aprire il file in scrittura
     * R o qualsiasi altra lettera-->per aprire il file in lettura
     * 
     * @param append se vale true il file aperto in scrittura viene aperto in append altrimenti no
     * 
     * @throws FileNotFoundException  quando il file da leggere non viene trovato il file.
     * se il file è aperto in scrittura, non viene trovato esso viene creato.
     * @throws IOException viene sollevata se non è possibile accedre al file.
     */
    public TextFile(String nomeFile, char mode, boolean append) throws FileNotFoundException, IOException
    {
	this.mode='R'; //modalità di default
	if(mode=='W' || mode=='w')
	    this.mode='W';
	if(this.mode=='R')
	    reader=new BufferedReader(new FileReader(nomeFile));
	else
	    writer=new BufferedWriter(new FileWriter(nomeFile,append));
    }
    
    /**
     * Scrive una stringa su file
     * @param line la stringa da scrivere sul file
     * @throws FileNotFoundException  quando il file è aperto in lettura
     * @throws IOException viene sollevata se non è possibile accedre al file.
     */
    public void toFile(String line) throws FileException, IOException
    {
	if(mode=='R')
	    throw new FileException("Errore: file aperto in lettura");
	writer.write(line);
	writer.newLine();
    }
    
    /**
     * Legge dal file e restituisce la stringa letta 
     * la prima volta che viene invocato questo metodo viene letta la pria riga del file, in seguito ogni volta che viene invocato questo metood la stringa 
     * letta è la successiva
     * Quando viene raggiunta la fine del file il metodod solleva l'eccezzione fileException
     * @return la stringa letta 
     * @throws FileException viene sollevata se il file e aperto in scrittura ed anche se legge una Stringa contenente il nulla
     * @throws IOException viene sollevata se non è possibile accedere al file
     */
    public String fromFile() throws FileException, IOException
    {
	if(mode=='W')
	    throw new FileException("Errore: file aperto in scrittura");
	String s=reader.readLine();
	if(s==null)
	    throw new FileException("fine del file");
	return s;
    }
    
    /**
     * 
     * Chiude il file
     * @throws IOException viene sollevata se non è possibile accedere al file
     */
    public void closeFile() throws IOException
    {
	if(mode=='R')
	    reader.close();
	else
	    writer.close();
    }
}