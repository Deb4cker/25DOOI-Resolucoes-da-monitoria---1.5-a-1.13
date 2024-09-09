import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * Não tem muito o que avançar aqui. É uma classe muito simples. 😗
 */

public class PessoaTestAvancado
{
    @Test
    @DisplayName("Deve criar Pessoa.")
    public void deveCriarPessoa(){
        criarEChecarPessoa(2004);
    }

    @Test
    @DisplayName("Deve Cumprir o Enunciado do exercício.")
    public void deveCumprirEnunciadoDoExercicio(){
    	final String nome1 = "Maria";
    	final double peso1 = 60.5;
    	final double altura1 = 1.65;
    	final int anoNascimento1 = 1990;

    	final String nome2 = "José";
    	final double peso2 = 80.0;
    	final double altura2 = 1.85;
    	final int anoNascimento2 = 1985;

    	final Pessoa maria = criarEChecarPessoa(anoNascimento1);
    	final Pessoa jose = criarEChecarPessoa(anoNascimento2);

        maria.setNome(nome1);
        maria.setPeso(peso1);
        maria.setAltura(altura1);

        jose.setNome(nome2);
        jose.setPeso(peso2);
        jose.setAltura(altura2);

        assertEquals(nome1, maria.getNome(), "O nome da pessoa 1 deve ser o mesmo informado no enunciado.");
        assertEquals(peso1, maria.getPeso(), "O peso da pessoa 1 deve ser o mesmo informado no enunciado.");
        assertEquals(altura1, maria.getAltura(), "A altura da pessoa 1 deve ser a mesma informada no enunciado.");

        assertEquals(nome2, jose.getNome(), "O nome da pessoa 2 deve ser o mesmo informado no enunciado.");
        assertEquals(peso2, jose.getPeso(), "O peso da pessoa 2 deve ser o mesmo informado no enunciado.");
        assertEquals(altura2, jose.getAltura(), "A altura da pessoa 2 deve ser a mesma informada no enunciado.");
    }

    @Test
    @DisplayName("Dados da pessoa devem ser os mesmos informados no input.")
    public void dadosDaPessoaDevemSerOsMesmosInformados(){

    	final String nome = "Maria";
    	final double peso = 56.8;
    	final double altura = 1.65;

    	final Pessoa maria = criarEChecarPessoa(2002);

        maria.setNome(nome);
        maria.setPeso(peso);
        maria.setAltura(altura);

        assertEquals(nome, maria.getNome(), "O nome da pessoa deve ser o mesmo informado.");
        assertEquals(peso, maria.getPeso(), "O peso da pessoa deve ser o mesmo informado.");
        assertEquals(altura, maria.getAltura(), "A altura da pessoa deve ser a mesmo informada.");
    }

    @Test
    @DisplayName("Não deve alterar quando dados forem inválidos.")
    public void naoDeveAlterarDadosQuandoForInvalido(){
        final String nome = "Maria";
        final double peso = 56.8;
        final double altura = 1.65;

        final Pessoa maria = criarEChecarPessoa(2002);

        maria.setNome(nome);
        maria.setPeso(peso);
        maria.setAltura(altura);

        final String nomeInvalido = " ";
        final double pesoInvalido = -1;
        final double alturaInvalida = 0;

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
    @DisplayName("Formatação do método toString() deve estar como no enunciado.")
    public void toStringDeveRetornarNaFormatacaoCorreta(){
        final String nome = "Maria";
        final double peso = 60.5;
        final double altura = 1.65;
        final int anoNascimento = 1990;

        final Pessoa maria = criarEChecarPessoa(anoNascimento);

        maria.setNome(nome);
        maria.setPeso(peso);
        maria.setAltura(altura);

        final String formatoCorreto = "Pessoa{" +
                "anoNascimento=" + anoNascimento +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';

        assertEquals(formatoCorreto, maria.toString());
    }

    private Pessoa criarEChecarPessoa(int anoNascimento){
        final Pessoa pessoa = new Pessoa(anoNascimento);
        assertNotNull(pessoa, "A pessoa não pode ser nula.");
        return pessoa;
    }
}
