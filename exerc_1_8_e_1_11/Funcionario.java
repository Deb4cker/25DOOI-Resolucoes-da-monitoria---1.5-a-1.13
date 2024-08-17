public class Funcionario {
    private String nome;
    private double salarioHora;
    private double horasTrabalhadas;
    private int quantidadeDependentes;

    public Funcionario(String nome, double salarioHora, double horasTrabalhadas, int quantidadeDependentes) {
        this.nome = nome;
        this.salarioHora = salarioHora;
        this.horasTrabalhadas = horasTrabalhadas;
        this.quantidadeDependentes = quantidadeDependentes;
    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        boolean nomeValido = !nome.isBlank();
        if (nomeValido) this.nome = nome;

        return nomeValido;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public boolean setHorasTrabalhadas(double horasTrabalhadas) {
        boolean horasInformadasValidas = horasTrabalhadas > 0;
        if(horasInformadasValidas) this.horasTrabalhadas = horasTrabalhadas;

        return horasInformadasValidas;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public boolean setSalarioHora(double salarioHora) {
        boolean salarioInformadoValido = salarioHora > 0;
        if(salarioInformadoValido) this.salarioHora = salarioHora;

        return salarioInformadoValido;
    }

    public int getQuantidadeDependentes() {
        return quantidadeDependentes;
    }

    public boolean setQuantidadeDependentes(int quantidadeDependentes) {
        boolean quantidadeDependentesValida = quantidadeDependentes > 0;
        if(quantidadeDependentesValida) this.quantidadeDependentes = quantidadeDependentes;

        return quantidadeDependentesValida;
    }

    public double getSalarioBruto(){
        return horasTrabalhadas * salarioHora + (50 * quantidadeDependentes);
    }

    public double descontoINSS(){
        double salarioBruto = getSalarioBruto();
        if (salarioBruto > 1000) return salarioBruto * 0.09;
        return salarioBruto * 0.085;
    }

    public double descontoImpostoDeRenda(){
        double salarioBruto = getSalarioBruto();

        if(salarioBruto > 500) {
            if (salarioBruto > 1000) return salarioBruto * 0.07;
            return salarioBruto * 0.05;
        }

        return 0;
    }

    public double getSalarioLiquido(){
        return getSalarioBruto() - descontoImpostoDeRenda() - descontoINSS();
    }

    @Override
    public String toString() {
        return "Nome: " + nome    +
                ", Dependentes: " + quantidadeDependentes    +
                ", Sal. Hora: "   + salarioHora              +
                ", Horas Trab.: " + horasTrabalhadas         +
                ", Sal. Bruto.: " + getSalarioBruto()        +
                ", INSS.: "       + descontoINSS()           +
                ", IR.: "         + descontoImpostoDeRenda() +
                ", Sal. Líquido: "+ getSalarioLiquido();
    }
}