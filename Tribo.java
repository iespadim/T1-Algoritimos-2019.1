import java.awt.Color;
import java.io.*;
import org.enoir.graphvizapi;
 
public class Tribo {
 
    public static void main(String[] args) {      
      try {
        //configura e/s
        String nomeDoArquivo = "casoMC4a.txt";          
        FileReader arq = new FileReader(nomeDoArquivo);
        BufferedReader reader = new BufferedReader(arq);   
        String linha = reader.readLine(); 
        String[] build = linha.split(" ");


        // inicializa a o tamanho da propriedade do ancião da aldeia
        int conquista = new Integer(build[0]);  

        // le a segunda linha a fim de descobrir qual o nome do ancião da aldeia
        linha = reader.readLine();
        //quebra a segunda linha em 3 - [pai] [nome do barbaro] [conquista em vida]
        build = linha.split(" ");

        // apriveita que ja está na segunda linha e pega dados para criar o primeiro filho também
        String pai = build[0]; 
        String nome = build[1];
        Barbaro barbaro = new Barbaro(pai, conquista);        

        // inicia a arvore com o ancião criado
        ArvoreGenealogicaDePosse arvore = new ArvoreGenealogicaDePosse(barbaro);
        p(barbaro.toString());
            
        // int nlinha = 1;
        // le da segunda linha em diante
        while (linha != null) {
          // nlinha++;
          // p("lendo a linha "+nlinha);
          //quebra a linha em 3 - [pai] [nome do barbaro] [conquista em vida]
          build = linha.split(" ");
          pai = build[0];
          nome = build[1];
          conquista = new Integer(build[2]);
          
          // p(nome+ " será filho de "+ pai  + " (se ele for encontrado), e adquiriu "+conquista+" terras ao longo de sua vida");
          //busca o barbaro pai
          Barbaro aux = arvore.buscarBarbaro(pai);

          //cria um novo barbaro e adiciona-o como filho do pai
          Barbaro aux2 = new Barbaro(aux, nome, conquista);
          if(!aux.addFilho(aux2)){
            //se por alguma razao nao conseguiu, informa
            p(aux2.getNome()+ " não é filho de "+aux.getNome());
          }

          //pula para a proxima linha;
          linha = reader.readLine(); 
        }

        
        //fim de arquivo;
        arq.close();
        p("Fim que leitura de arquivo.");
        
        // aqui a arvore está pronta

        // percorre a arvore da raiz, distribuindo igualmente a propriedade da geração anterior.
        arvore.distribuiBens();
        
        // percorre a arvore buscando folhas. As folhas estão referenciadas em Arraylist<Barbaro> folhas internamente em ArvoreGenealogicaDePosse
        p(arvore.maisRico());
               
      } catch (IOException e) {
          String format = "Erro na abertura do arquivo: %s.\n";
          System.err.printf(format,
                  e.getMessage());
      }   
      System.out.println();
      System.exit(0);
    }

    // print preguiçoso
    public static void p(String s){
      System.out.println(s);
    }
  }