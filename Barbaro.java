import java.util.ArrayList;

public class Barbaro{
    String nome;
    int terrasHerdadas;
    int landOwned;
    ArrayList<Barbaro> filhos = new ArrayList<>();
    Barbaro pai;

    public Barbaro(String nome){
        this.nome = nome;
    }

    public Barbaro(String nome, int terrasHerdadas, int terrasConquistadas ){
        this.nome = nome;
        this.terrasHerdadas = terrasHerdadas;
        this.landOwned = terrasConquistadas;
    }

    public void herdar(int landSize){
        landOwned = +landSize;
    }

    public int getTerras(){
        return terrasHerdadas+landOwned;
    }

}   