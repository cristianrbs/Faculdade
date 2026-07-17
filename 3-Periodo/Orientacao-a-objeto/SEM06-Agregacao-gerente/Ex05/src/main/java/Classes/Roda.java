package Classes;

import java.util.Objects;

public class Roda{

    private double raio;
    private String material;
    private String cor;

    //construtor com parametro
    public Roda(double raio, String material, String cor){
        this.raio = raio;
        this.material = material;
        this.cor = cor;
    }

    //construtor sem parametro
    public Roda(){
        this.raio = 0.0;
        this.material = "";
        this.cor = "";
    }

    //metodo copiar
    public void copiar(Roda outro){
        this.raio = outro.getRaio();
        this.material = outro.getMaterial();
        this.cor = outro.getCor();
    }

    public void imprimir(){
        System.out.println(this);
    }
    
    @Override
    public String toString() {
        return "Roda{raio=" + raio +
               ", material=" + material +
               ", cor=" + cor + "}";
    }

    //getters e setters
    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    
    //equals e hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.raio) ^ (Double.doubleToLongBits(this.raio) >>> 32));
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
        final Roda other = (Roda) obj;
        if (Double.doubleToLongBits(this.raio) != Double.doubleToLongBits(other.raio)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        return Objects.equals(this.cor, other.cor);
    } 
}