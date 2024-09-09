public class Pessoa {
    
    private final int anoNascimento;
    private String nome;
    private double peso;
    private double altura;

    public Pessoa(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Pessoa(int anoNascimento, String nome) {
        this.anoNascimento = anoNascimento;
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

    public double getPeso() {
        return peso;
    }

    public boolean setPeso(double peso) {
        final boolean ehPesoValido = peso > 0.0;
        if (ehPesoValido) this.peso = peso;
        return ehPesoValido;
    }

    public double getAltura() {
        return altura;
    }

    public boolean setAltura(double altura) {
        final boolean ehAlturaValida = altura > 0.0;
        if(ehAlturaValida) this.altura = altura;
        return ehAlturaValida;
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
