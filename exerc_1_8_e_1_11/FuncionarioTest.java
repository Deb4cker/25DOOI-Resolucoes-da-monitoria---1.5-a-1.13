import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FuncionarioTest {

    @Test
    public void testeFuncionario1() {
        Funcionario fun1 = new Funcionario("Bob", 160, 6.15, 2);

        // Verificar e imprimir o estado inicial
        System.out.println("Salário Bruto: " + fun1.getSalarioBruto());
        System.out.println("Desconto INSS: " + fun1.descontoINSS());
        System.out.println("Desconto IR: " + fun1.descontoImpostoDeRenda());
        System.out.println("Salário Líquido: " + fun1.getSalarioLiquido());

        // Alterar o salário por hora para R$ 8,00 e verificar novamente
        assertEquals(fun1.setSalarioHora(8.00), true);
        System.out.println("Salário Líquido após aumento: " + fun1.getSalarioLiquido());

        // Imprimir representação textual
        System.out.println(fun1.toString());

        // Asserts para verificação de consistência
        assertEquals(1380.0, fun1.getSalarioBruto(), 0.01);
        assertEquals(124.19, fun1.descontoINSS(), 0.01);
        assertEquals(96.60, fun1.descontoImpostoDeRenda(), 0.01);
        assertEquals(1159.2, fun1.getSalarioLiquido(), 0.01);
    }

    @Test
    public void testeFuncionario2() {
        Funcionario fun2 = new Funcionario("Bia", 200, 12.50, 0);

        // Imprimir representação textual
        System.out.println(fun2.toString());

        // Tentar alterar quantidade de dependentes para -2
        assertEquals(fun2.setQuantidadeDependentes(-2), false);

        // Alterar nome para Bianca
        assertEquals(fun2.setNome("Bianca"), true);
        System.out.println(fun2.toString());

        // Alterar quantidade de dependentes para 1 e verificar
        assertEquals(fun2.setQuantidadeDependentes(1), true);
        assertEquals(fun2.setSalarioHora(15.00), true);
        assertEquals(fun2.setHorasTrabalhadas(750), true);
        System.out.println(fun2.toString());

        // Asserts para verificação de consistência
        assertEquals("Bianca", fun2.getNome());
        assertEquals(1, fun2.getQuantidadeDependentes());
        assertEquals(15.00, fun2.getSalarioHora(), 0.01);
        assertEquals(750, fun2.getHorasTrabalhadas(), 0.01);
    }
}
