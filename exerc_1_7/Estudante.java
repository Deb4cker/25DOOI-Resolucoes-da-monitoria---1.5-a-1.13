public class Estudante 
{
    private final int numeroMatricula;
    private int creditos;
    private String nome;

    public Estudante(String nome, int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        final boolean ehNomeValido = !nome.isBlank();
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
        creditos += Math.max(creditosGanhos, 0);
        return creditosGanhos > 0;
    }

    public String getLogin(){
    	/*
    	 * O mais correto nessa ocasião seria ter uma propriadade "private final String login;"
    	 * e a lógica a baixo dentro do construtor atribuindo o valor a ela.
    	 * Deste modo a lógica seria executada uma vez e o getLogin() retornaria um valor estático da memória.
    	 * Além de economizar memória, ajudaria no desempenho e na manutenção do código.
    	 */
    	
        final String nomeSubstring = nome.substring(0, 3);
        final String matriculaString = String.valueOf(numeroMatricula);
        final String matriculaSubstring = matriculaString.substring(matriculaString.length() - 3);

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