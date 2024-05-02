public class Atleta {
    private String nome;
    private String sexo;
    private String pais;
    private double tempo;

    public Atleta(String nome, String sexo, String pais, double tempo) {
        this.nome = nome;
        this.sexo = sexo;
        this.pais = pais;
        this.tempo = tempo;
    }

    public Atleta(String nome, String pais, double tempo) {
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public String getPais() {
        return pais;
    }

    public double getTempo() {
        return tempo;
    }

    public String toString(){ return nome;}
}
