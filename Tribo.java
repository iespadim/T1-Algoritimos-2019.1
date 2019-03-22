import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
 
public class Tribo {
 int a = 2;
    public static void main(String[] args) { 
      System.out.printf("\nConteúdo do arquivo texto:\n");
      try {
        String nome = "casoMC4a.txt";
        FileReader arq = new FileReader(nome);
        BufferedReader lerArq = new BufferedReader(arq);   
        String linha = lerArq.readLine();         
        int posseDoPaiDeTodos = new Integer(linha);
        
        System.out.println(linha);
        linha = lerArq.readLine(); //pula para a segunda linha
        String nomeDoPaideTodos = linha.split(" ")[0];
        System.out.println("criando um barbaro com nome e posse de "+nomeDoPaideTodos +" e "+posseDoPaiDeTodos);

        ArvoreGenealogicaDePosse arvore = new ArvoreGenealogicaDePosse(new Barbaro(nomeDoPaideTodos, posseDoPaiDeTodos));

        while (linha != null) {
          System.out.print(linha);

          System.out.print("  splitting: ");
          for (String var : linha.split(" ")) {
            System.out.print(var.toString()+ " e ");
          }        
          System.out.println("");
          
          linha = lerArq.readLine(); //pula para a proxima linha;
        }
   
        arq.close();
      } catch (IOException e) {
          String format = "Erro na abertura do arquivo: %s.\n";
		System.err.printf(format,
            e.getMessage());
      }
   
      System.out.println();
    }
  }