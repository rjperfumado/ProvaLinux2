package pilha;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class CargaFilme {

	    Filme filme = null;	  
	    Stack<Filme> pilha = new Stack<Filme>();
	    Filme[] filmes2 = new Filme[1100000];
	    
	    Stack<Filme> filmes = new Stack<Filme>();
	    
	    public Stack<Filme> lerArquivo() throws IOException{  
	    	
	    	File file = new File("/root/Programacao/workspace/TrabalhoProva/filmes.txt");  // aqui deve ser mudado para o diretório do seu computador.
	    	FileReader fileReader = new FileReader(file);  
	        BufferedReader reader = new BufferedReader(fileReader);  
	        
	        String data = null;  
	        int indice = 0;
	        while((data = reader.readLine()) != null){  
	        	
	        	filme = new Filme();
	        	filmes.push(desmembrarString(data, filme,indice));
	        	indice++;
	        }  
	        
	        fileReader.close();  
	        reader.close(); 
	        return filmes;
	    }  
	    
	private Filme desmembrarString(String dados, Filme filme, int codigoInterno) {
		
		StringTokenizer st = new StringTokenizer(dados, ";");
		
		while (st.hasMoreTokens()) {
			filme = new Filme();
			filme.setCodigo(st.nextToken());
			filme.setTitulo(st.nextToken());
			filme.setMidia(st.nextToken());
			filme.setValor(Double.parseDouble(st.nextToken()));
			filme.setGenero(st.nextToken());
			filme.setDataPedido(st.nextToken());
			filme.setNumeroInterno(codigoInterno);
		}
		return filme;
	}
}

































