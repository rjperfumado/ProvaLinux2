package pilha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class CargaLivro {
	
	public static Stack<Livro> lerArquivo() throws IOException{  
		
		Stack<Livro> pilha = new Stack<Livro>();
		Stack<String> pilhaString = new Stack<String>();
		
    	File file = new File("/root/Programacao/workspace/TrabalhoProva/livros.txt");  // aqui deve ser mudado para o diretório do seu computador.
    	FileReader fileReader = new FileReader(file);  
        BufferedReader reader = new BufferedReader(fileReader);  
        
        
        String data = null;  
        long inicio = System.currentTimeMillis();
        
        while((data = reader.readLine()) != null){  
        	
        	   pilha.push(desmembrarString(data));
        }  
        
        long fim = System.currentTimeMillis();
        
        System.out.println((fim - inicio)/1000 + " Segundos");
        fileReader.close();  
        reader.close(); 
        return pilha;
    }  
	
	
	private static Livro desmembrarString(String dados) {
		Livro livro  = null;
		StringTokenizer st = new StringTokenizer(dados, ";");
		while (st.hasMoreTokens()) {
			/* System.out.println(" Linha Bruta " + dados); */
			livro  = new Livro();				
			livro.setNome(st.nextToken());
			livro.setAutor(st.nextToken());
			livro.setEditora(st.nextToken());
			livro.setISBN(st.nextToken());
			
			
//			aluno.setColocacao(Integer.parseInt(st.nextToken()));
//			aluno.setMatricula(st.nextToken());
//			aluno.setNome(st.nextToken());
//			aluno.setCurso(st.nextToken());
		}
		return livro;
	}
}
