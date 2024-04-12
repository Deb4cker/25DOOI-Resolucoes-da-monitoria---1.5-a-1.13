import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FuncionarioTestAvancado {

    @Test
    public void deveCriarFuncionario(){
        String nome = "Bob";
        double horasTrabalhadas = 160;
        double salarioHora = 6.15;
        int quantidadeDependentes = 2;
        criarEChecarFuncionario(nome, horasTrabalhadas, salarioHora, quantidadeDependentes);
    }

    @Test
    public void deveDarDescontoInss(){
        String nome = "Bia";
        double horasTrabalhadas = 200;
        double salarioHora = 12.50;
        int quantidadeDependentes = 0;
        Funcionario bia = criarEChecarFuncionario(nome, horasTrabalhadas, salarioHora, quantidadeDependentes);
        
        double salarioBruto = horasTrabalhadas * salarioHora;
        double descontoINSS = calcularDescontoINSS(salarioBruto);
        double descontoIR = calcularDescontoImpostoDeRenda(salarioBruto);
        double salarioLiquido = salarioBruto - descontoINSS - descontoIR;
        
        assertEquals(salarioLiquido, bia.getSalarioLiquido(), "Salário líquido deve incluir desconto do INSS.");
    }

    @Test
    public void dadosDoFuncionarioDevemSerOsMesmosInformados(){
        String nome = "Bob";
        double horasTrabalhadas = 160;
        double salarioHora = 6.15;
        int quantidadeDependentes = 2;
        Funcionario bob = criarEChecarFuncionario(nome, horasTrabalhadas, salarioHora, quantidadeDependentes);

        assertEquals(nome, bob.getNome());
        assertEquals(horasTrabalhadas, bob.getHorasTrabalhadas());
        assertEquals(salarioHora, bob.getSalarioHora());
        assertEquals(quantidadeDependentes, bob.getQuantidadeDependentes());
    }

    @Test
    public void naoDeveAlterarDadosQuandoForInvalido(){
        String nome = "Bob";
        double horasTrabalhadas = 160;
        double salarioHora = 6.15;
        int quantidadeDependentes = 2;
        Funcionario bob = criarEChecarFuncionario(nome, horasTrabalhadas, salarioHora, quantidadeDependentes);

        assertFalse(bob.setNome(" "));
        assertFalse(bob.setSalarioHora(-1));
        assertFalse(bob.setHorasTrabalhadas(-160));
        assertFalse(bob.setQuantidadeDependentes(-1));

        assertEquals(nome, bob.getNome());
        assertEquals(horasTrabalhadas, bob.getHorasTrabalhadas());
        assertEquals(salarioHora, bob.getSalarioHora());
        assertEquals(quantidadeDependentes, bob.getQuantidadeDependentes());
    }

    private Funcionario criarEChecarFuncionario(String nome, double horasTrabalhadas, double salarioHora, int quantidadeDependentes ){
        Funcionario funcionario = new Funcionario(nome, horasTrabalhadas, salarioHora, quantidadeDependentes);
        assertNotNull(funcionario, "Funcionário não deve ser nulo!");
        return funcionario;
    }

    private double calcularDescontoINSS(double salarioBruto) {
        if (salarioBruto > 1000) return salarioBruto * 0.09;
        return salarioBruto * 0.085;
    }
    
    private double calcularDescontoImpostoDeRenda(double salarioBruto){
        if(salarioBruto > 500) {
            if (salarioBruto > 1000) return salarioBruto * 0.07;
            return salarioBruto * 0.05;
        }

        return 0;
    }
}
