package meucci;

public class Persona {
    private String nome;
    private String congome;
    private int età;

    public Persona(String nome , String cognome , int età){
        this.nome = nome;
        this.congome = cognome;
        this.età = età;
    };

    public Persona(){
        this.nome = "";
        this.congome = "";
        this.età = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCongome() {
        return congome;
    }

    public int getEtà() {
        return età;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCongome(String congome) {
        this.congome = congome;
    }
    public void setEtà(int età) {
        this.età = età;
    }

    @Override
    public String toString() {
        return "Persona [nome=" + nome + ", congome=" + congome + ", età=" + età + "]";
    }

    
}
