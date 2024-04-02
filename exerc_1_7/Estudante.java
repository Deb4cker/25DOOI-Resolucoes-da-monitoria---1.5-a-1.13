public class Estudante {

    private String nome;
    private final int numeroMatricula;
    private int creditos;

    public Estudante(String nome, int numeroMatricula) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.isBlank()) this.nome = nome;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public int getCreditos() {
        return creditos;
    }

    public boolean adicionarCreditos(int creditosGanhos) {
        this.creditos += Math.max(creditosGanhos, 0);
        return creditosGanhos > 0;
    }

    public String getLogin(){
        String nomeSubstring = nome.substring(0, 3);
        String matriculaString = String.valueOf(numeroMatricula);
        String matriculaSubstring = matriculaString.substring(matriculaString.length() - 3);

        return nomeSubstring + matriculaSubstring;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome +
                ", Matricula: " + numeroMatricula +
                ", Créditos: " + creditos +
                '.';
    }
}