package Classes;

import java.util.Objects;

public class Musica {

    private String titulo;
    private double duracao;

    //construtor com parametro
    public Musica(String titulo, double duracao){
        this.titulo = titulo;
        this.duracao = duracao;
    }

    //construtor sem parametro
    public Musica(){
        this.titulo = "";
        this.duracao = 0.0;
    }

    //metodo copiar
    public void copiar(Musica outro){
        this.titulo = outro.getTitulo();
        this.duracao = outro.getDuracao();
    }

    //metodo imprimir
    public void imprimir(){
        System.out.println(this);
    }
    
    @Override
    public String toString() {
        return "Musicatitulo = " + titulo 
                + ", duracao = " + duracao;
    }

    //getters e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }
    
    //equals e hashcode

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.titulo);
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
        final Musica other = (Musica) obj;
        if (Double.doubleToLongBits(this.duracao) != Double.doubleToLongBits(other.duracao)) {
            return false;
        }
        return Objects.equals(this.titulo, other.titulo);
    }
}