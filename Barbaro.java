import java.util.ArrayList;

public class Barbaro{

    String nome;
    int landOwned;
    ArrayList<Barbaro> filhos = new ArrayList<>();
    Barbaro pai;
    int geracao;

    public Barbaro(String nome,int terrasConquistadas){        
        this.nome = nome;
        this.landOwned = terrasConquistadas;
    }

    public Barbaro(Barbaro pai, String nome, int terrasConquistadas ){
        this.nome = nome;
        this.pai = pai;        
        this.landOwned = terrasConquistadas;
    }

    public String getNome(){
        return nome;
    }

    public Barbaro getPai(){
        return pai;
    }

    public ArrayList<Barbaro> getFilhos(){
        return filhos;
    }

    public void setGeracao(int i){
        geracao = i;
    }

    public int getGeracao(){
        return geracao;
    }

    public boolean addFilho(Barbaro b){
        return getFilhos().add(b);
    }
    

    public void herdar(Barbaro herdeiro, int nivel){
        // terras do pai / nr filhos
        int fracao = (getPai().getTerras()) / (getPai().getFilhos().size());
        landOwned += fracao;
    }

    public int getTerras(){
        return landOwned;
    }

    public String toString(){
        if(getPai() == null){
            return nome+" é o ancião da tribo e tem propriedade de "+landOwned+"\n\n \n";
        } else{
            return nome+", filho de "+getPai().getNome()+", propriedade de "+landOwned+" tem "+getFilhos().size()+" filhos. Herdeiro de "+getGeracao()+" geração \n";
        }
    }

}   