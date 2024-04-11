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

    public void setNome(String nome) {
        boolean ehNomeInvalido = nome.isBlank();
        this.nome = ehNomeInvalido? this.nome : nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        boolean ehPesoInvalido = peso <= 0.0;
        this.peso = ehPesoInvalido? this.peso : peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        boolean ehAlturaInvalida = altura <= 0.0;
        this.altura = ehAlturaInvalida? this.altura : altura;
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
