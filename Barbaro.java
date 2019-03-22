import java.util.ArrayList;

public class Barbaro{
    String nome;
    int heirloom;
    int landOwned;
    ArrayList<Barbaro> filhos = new ArrayList<>();
    Barbaro pai;

    public Barbaro(String nome){
        this.nome = nome;
    }

    public Barbaro(String nome, int heirloom){
        this.nome = nome;
        this.heirloom = heirloom;
    }

    public void herdar(int landSize){
        heirloom =+ landSize;
    }

    public Barbaro buscar(String nome){
        if(this.nome.equals(nome)){
            return this;
        }
        for (Barbaro filho : filhos) {
            Barbaro aux = filho.buscar(nome);
            if (aux != null){
                return aux;
            }
        }
        return new Barbaro("ué");            
        
    }
}   