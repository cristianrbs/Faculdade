
package Classes;

import java.util.ArrayList;
import java.util.List;

public class Aeroporto {
    private String nome;
    private String localizacao;
    private List<Voo> voos;
    
    public Aeroporto(){
        this.nome = "";
        this.localizacao = "";
        this.voos = new ArrayList<>();
    }
    
    public Aeroporto(String nome, String localizacao){
        this.nome = nome;
        this.localizacao = localizacao;
        this.voos = new ArrayList<>();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= voos.size(); i++){
            sb.append(voos.get(i));
        }
        
        return sb.toString();
    }
    
    //metodo voos com prejuizo
    public void VoosComPrejuizo(){
        
        for(int i = 0; i <= voos.size(); i++){
            if(voos.get(i).getPassageiros().size() < 5){
                System.out.println("O Voo " + voos.get(i).getNumVoo() + "terá prejuízo");
            }
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public void setVoos(List<Voo> Voos) {
        this.voos = Voos;
    }
}
