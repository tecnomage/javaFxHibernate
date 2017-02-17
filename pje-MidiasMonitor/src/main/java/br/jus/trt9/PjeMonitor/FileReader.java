package br.jus.trt9.PjeMonitor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

	private static List<String> textoArq; 
	
	//TODO depois alterar para receber um parametro File
	public FileReader() {
		
	}

	public List<String> getTextoArq() {
		return textoArq;
	}

	public void setTextoArq(List<String> textoArq) {
		this.textoArq = textoArq;
	}

	public static List<String> readFile() {

		
		try {
			textoArq = new ArrayList<String>();
			InputStream is = new FileInputStream("arquivo.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			try {
				String linha = br.readLine();
				while(linha != null) {
					textoArq.add(linha);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return textoArq;
	}

}
