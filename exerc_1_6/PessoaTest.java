import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PessoaTest
{
    @Test
    public void deveCriarPessoa(){
        criarEChecarPessoa(2004);
    }

    @Test
    public void deveCumprirEnunciadoDoExercicio(){
        String nome1 = "Maria";
        double peso1 = 60.5;
        double altura1 = 1.65;
        int anoNascimento1 = 1990;

        String nome2 = "José";
        double peso2 = 80.0;
        double altura2 = 1.85;
        int anoNascimento2 = 1985;

        Pessoa maria = criarEChecarPessoa(anoNascimento1);
        Pessoa jose = criarEChecarPessoa(anoNascimento2);

        maria.setNome(nome1);
        maria.setPeso(peso1);
        maria.setAltura(altura1);

        jose.setNome(nome2);
        jose.setPeso(peso2);
        jose.setAltura(altura2);

        boolean casou = maria.casar(jose);
        boolean casouComAlguemCasado = jose.casar(maria);

        assertTrue(casou, "O casamento entre duas pessoas não casadas pode acontecer.");
        assertFalse(casouComAlguemCasado, "O casamento não deve ocorrer para uma pessoa casada.");

        assertTrue(maria.ehCasado(), "Maria deve estar casada.");
        assertTrue(jose.ehCasado(), "José deve estar casado.");

        assertEquals(jose.getNome(), maria.getNomeConjuge(), "O nome do conjuge de Maria deve ser José");
        assertEquals(maria.getNome(), jose.getNomeConjuge(), "O nome do conjuge de José deve ser Maria");
    }

    @Test
    public void dadosDaPessoaDevemSerOsMesmosInformados(){

        String nome = "Maria";
        double peso = 56.8;
        double altura = 1.65;

        Pessoa maria = criarEChecarPessoa(2002);

        maria.setNome(nome);
        maria.setPeso(peso);
        maria.setAltura(altura);

        assertEquals(nome, maria.getNome(), "O nome da pessoa deve ser o mesmo informado.");
        assertEquals(peso, maria.getPeso(), "O peso da pessoa deve ser o mesmo informado.");
        assertEquals(altura, maria.getAltura(), "A altura da pessoa deve ser a mesmo informada.");
    }

    @Test
    public void naoDeveAlterarDadosQuandoForInvalido(){
        String nome = "Maria";
        double peso = 56.8;
        double altura = 1.65;

        Pessoa maria = criarEChecarPessoa(2002);

        maria.setNome(nome);
        maria.setPeso(peso);
        maria.setAltura(altura);

        String nomeInvalido = " ";
        double pesoInvalido = -1;
        double alturaInvalida = 0;

        maria.setNome(nomeInvalido);
        maria.setPeso(pesoInvalido);
        maria.setAltura(alturaInvalida);

        assertEquals(nome, maria.getNome(), "O nome da pessoa deve ser mantido.");
        assertEquals(peso, maria.getPeso(), "O peso da pessoa deve ser mantido.");
        assertEquals(altura, maria.getAltura(), "A altura da pessoa deve ser mantido.");

        assertNotEquals(nomeInvalido, maria.getNome(), "O nome da pessoa não pode ser invalido.");
        assertNotEquals(pesoInvalido, maria.getPeso(), "O peso da pessoa não pode ser invalido.");
        assertNotEquals(alturaInvalida, maria.getAltura(), "A altura da pessoa não pode ser invalida.");
    }

    @Test
    public void toStringDeveRetornarNaFormatacaoCorreta(){
        String nome = "Maria";
        double peso = 60.5;
        double altura = 1.65;
        int anoNascimento = 1990;

        Pessoa maria = criarEChecarPessoa(anoNascimento);

        maria.setNome(nome);
        maria.setPeso(peso);
        maria.setAltura(altura);

        String formatoCorreto = "Pessoa{" +
                "anoNascimento=" + anoNascimento +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';

        assertEquals(formatoCorreto, maria.toString());
    }

    private Pessoa criarEChecarPessoa(int anoNascimento){
        Pessoa pessoa = new Pessoa(anoNascimento);
        assertNotNull(pessoa, "A pessoa não pode ser nula.");
        return pessoa;
    }
}
