package meucci;

public class Persona {
    private String nome;
    private String congome;
    private int eta;

    public Persona(String nome , String cognome , int eta){
        this.nome = nome;
        this.congome = cognome;
        this.eta = eta;
    };

    public Persona(){

    }

    public String getNome() {
        return nome;
    }

    public String getCongome() {
        return congome;
    }

    public int getEta() {
        return eta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCongome(String congome) {
        this.congome = congome;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Persona [nome=" + nome + ", congome=" + congome + ", età=" + eta + "]";
    }

    
}
