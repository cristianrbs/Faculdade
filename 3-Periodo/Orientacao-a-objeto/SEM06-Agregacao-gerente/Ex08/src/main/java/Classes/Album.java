package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Album {

    private String nome;
    private int anoLancamento;
    private List<Musica> musicas;

    //construtor com parametro
    public Album(String nome, int anoLancamento){
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.musicas = new ArrayList<>();
    }

    //construtor sem parametros
    public Album(){
        this.nome = "";
        this.anoLancamento = 0;
        this.musicas = new ArrayList<>();
    }

    //metodo copiar
    public void copiar(Album outro){
        this.nome = outro.getNome();
        this.anoLancamento = outro.getAnoLancamento();
        this.musicas = new ArrayList<>();
        
        for (Musica m : outro.getMusicas()){
            Musica nova = new Musica();
            nova.copiar(m);
           this.musicas.add(nova);
        }
    }

    //adicionar música
    public void adicionarMusica(Musica musicaNova){
        this.musicas.add(musicaNova);
    }

    //metodo imprimir
    public void imprimir(){
        System.out.println(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Album{nome = ").append(nome).append("\n");
        sb.append(", anoLancamento = ").append(anoLancamento).append("\n");
        sb.append(", musicas = ").append("\n");
        for (int i = 0; i < musicas.size(); i++){
            sb.append(musicas.get(i).toString());
        }
        return sb.toString();
    }

    //setters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
    
    //equals e hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Album other = (Album) obj;
        if (this.anoLancamento != other.anoLancamento) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.musicas, other.musicas);
    }
}