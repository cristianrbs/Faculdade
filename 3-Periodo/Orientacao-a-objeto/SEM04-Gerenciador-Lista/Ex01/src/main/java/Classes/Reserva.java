package Classes;

import java.util.Scanner;
import java.util.Objects;


public class Reserva {
    private String nomeReserva;
    private int numPessoas;
    private String dataHora;

    public Reserva(String nomeReserva, int numPessoas, String dataHora) {
        this.nomeReserva = nomeReserva;
        this.numPessoas = numPessoas;
        this.dataHora = dataHora;
    }
    
    public Reserva(){
        this.nomeReserva = "";
        this.numPessoas = 0;
        this.dataHora = "";
    }
    
    public void fill() {
        Scanner ler = new Scanner(System.in);

        System.out.print("Nome da reserva: ");
        this.nomeReserva = ler.nextLine();

        System.out.print("Número de pessoas: ");
        this.numPessoas = ler.nextInt(); 

        System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
        this.dataHora = ler.nextLine();
    }

    @Override
    public String toString() {
        return "Reserva{" + "nomePessoa=" + nomeReserva + ", numPessoa=" + numPessoas + ", dataHora=" + dataHora + '}';
    }
    
    

    public String getNomeReserva() {
        return nomeReserva;
    }

    public void setNomeReserva(String nomeReserva) {
        this.nomeReserva = nomeReserva;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
    public void copiar(Reserva outro){
        this.nomeReserva = outro.getNomeReserva();
        this.numPessoas = outro.getNumPessoas();
        this.dataHora = outro.getDataHora();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nomeReserva);
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
        final Reserva other = (Reserva) obj;
        if (this.numPessoas != other.numPessoas) {
            return false;
        }
        if (!Objects.equals(this.nomeReserva, other.nomeReserva)) {
            return false;
        }
        return Objects.equals(this.dataHora, other.dataHora);
    }  

}
