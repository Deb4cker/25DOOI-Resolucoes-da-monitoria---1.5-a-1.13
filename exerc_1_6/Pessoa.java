public class Pessoa {
    private final int anoNascimento;
    private String nome;
    private double peso;
    private double altura;
    private Pessoa conjuge;

    public Pessoa(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        boolean ehNomeValido = !nome.isBlank();
        if(ehNomeValido) this.nome = nome;

        return ehNomeValido;
    }

    public double getPeso() {
        return peso;
    }

    public boolean setPeso(double peso) {
        boolean ehPesoValido = peso > 0.0;
        if(ehPesoValido)this.peso = peso;

        return ehPesoValido;
    }

    public double getAltura() {
        return altura;
    }

    public boolean setAltura(double altura) {
        boolean ehAlturaValida = altura > 0.0;
        if(ehAlturaValida) this.altura = altura;

        return ehAlturaValida;
    }

    public boolean casar(Pessoa conjuge){
        if (!ehCasado()){
            this.conjuge = conjuge;
            conjuge.casar(this);

            return true;
        }
        return false;
    }

    public boolean ehCasado(){
        return conjuge != null;
    }

    public String getNomeConjuge(){
        if (ehCasado()) return conjuge.getNome();
        return "Não é casado.";
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "anoNascimento=" + anoNascimento +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}