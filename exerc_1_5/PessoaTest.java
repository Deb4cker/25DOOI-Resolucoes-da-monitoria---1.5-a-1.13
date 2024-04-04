import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PessoaTest
{
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

        Pessoa maria = new Pessoa(anoNascimento1);
        Pessoa jose = new Pessoa(anoNascimento2);

        maria.setNome(nome1);
        maria.setPeso(peso1);
        maria.setAltura(altura1);

        jose.setNome(nome2);
        jose.setPeso(peso2);
        jose.setAltura(altura2);

        assertEquals(nome1, maria.getNome());
        assertEquals(peso1, maria.getPeso());
        assertEquals(altura1, maria.getAltura());

        assertEquals(nome2, jose.getNome());
        assertEquals(peso2, jose.getPeso());
        assertEquals(altura2, jose.getAltura());
    }

    @Test
    public void dadosDaPessoaDevemSerOsMesmosInformados(){

        String nome = "Maria";
        double peso = 56.8;
        double altura = 1.65;
        int anoNascimento = 2002;

        Pessoa maria = new Pessoa(anoNascimento);

        maria.setNome(nome);
        maria.setPeso(peso);
        maria.setAltura(altura);

        assertEquals(nome, maria.getNome());
        assertEquals(peso, maria.getPeso());
        assertEquals(altura, maria.getAltura());
    }

    @Test
    public void naoDeveAlterarDadosQuandoForInvalido(){
        String nome = "Maria";
        double peso = 56.8;
        double altura = 1.65;
        int anoNascimento = 2002;

        Pessoa maria = new Pessoa(anoNascimento);

        maria.setNome(nome);
        maria.setPeso(peso);
        maria.setAltura(altura);

        String nomeInvalido = " ";
        double pesoInvalido = -1;
        double alturaInvalida = 0;

        maria.setNome(nomeInvalido);
        maria.setPeso(pesoInvalido);
        maria.setAltura(alturaInvalida);

        assertEquals(nome, maria.getNome());
        assertEquals(peso, maria.getPeso());
        assertEquals(altura, maria.getAltura());
    }

    @Test
    public void toStringDeveRetornarNaFormatacaoCorreta(){
        String nome = "Maria";
        double peso = 60.5;
        double altura = 1.65;
        int anoNascimento = 1990;

        Pessoa maria = new Pessoa(anoNascimento);

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
}
