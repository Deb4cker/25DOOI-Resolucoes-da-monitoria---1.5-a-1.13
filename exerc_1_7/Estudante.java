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

    public boolean setNome(String nome) {
        boolean ehNomeValido = !nome.isBlank();
        if (ehNomeValido) this.nome = nome;

        return ehNomeValido;
    }

    public int getMatricula() {
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
                ", Matrícula: " + numeroMatricula +
                ", Login: " + getLogin() +
                ", Créditos: " + creditos;
    }
}