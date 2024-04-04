import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstudanteTestAvancado
{
       @Test
    public void deveCriarEstudante(){
        String nome = "Fernando";
        int matricula = 556644;
        criarEValidarEstudante(nome, matricula);
    }

    @Test
    public void deveCumprirEnunciadoDoExercicio(){
        String nome1 = "Fernando";
        int matricula1 = 556644;

        String nome2 = "Beth";
        int matricula2 = 579035;

        Estudante est1 = criarEValidarEstudante(nome1, matricula1);
        Estudante est2 = criarEValidarEstudante(nome2, matricula2);

        est1.adicionarCreditos(35);
        est2.adicionarCreditos(80);

        operacoesEstudante1(est1);
        operacoesEstudante2(est2);
    }
    
    @Test
    public void dadosDoEstudanteDevemSerOsMesmosInformados(){
        String nome = "Fernando";
        int matricula = 556644;
        int creditosAdicionais = 10;
        Estudante estudante = criarEValidarEstudante(nome, matricula);

        estudante.adicionarCreditos(creditosAdicionais);

        assertEquals(nome, estudante.getNome(), "Nome do estudante deve ser o mesmo informado.");
        assertEquals(matricula, estudante.getNumeroMatricula(), "Matricula do estudante deve ser a mesma informada.");
        assertEquals(creditosAdicionais, estudante.getCreditos(), "Créditos do estudante devem bater com a quantidade ganha.");
    }

    @Test
    public void naoDeveAlterarDadosQuandoForInvalido(){
        String nome = "Fernando";
        int matricula = 556644;
        int creditosAdicionais = 10;

        String nomeInvalido = " ";
        int creditosAdicionaisInvalidos = -8;

        Estudante estudante = criarEValidarEstudante(nome, matricula);
        estudante.adicionarCreditos(creditosAdicionais);

        estudante.setNome(nomeInvalido);
        estudante.adicionarCreditos(creditosAdicionaisInvalidos);

        assertNotEquals(creditosAdicionais + creditosAdicionaisInvalidos, estudante.getCreditos(), "Os créditos inválidos não podem ser inseridos");
        assertNotEquals(nomeInvalido, estudante.getNome(), "Nome do estudante não deve ser inválido");

        assertEquals(creditosAdicionais, estudante.getCreditos(), "Quantidade de créditos do estudante deve ser mantida.");
        assertEquals(nome, estudante.getNome(), "Nome do estudante deve ser mantido.");
    }

    @Test
    public void loginDeveEstarNoFormatoCorreto(){
        String nome = "Fernando";
        int matricula = 556644;
        Estudante estudante = criarEValidarEstudante(nome, matricula);

        String primeirasLetrasDoNome = nome.substring(0, 3);
        String matriculaString = String.valueOf(matricula);
        String ultimosNumerosDaMatricula = matriculaString.substring(matriculaString.length() - 3);

        String login = primeirasLetrasDoNome + ultimosNumerosDaMatricula;

        assertEquals(6, estudante.getLogin().length(), "Login deve ter um tamanho = 6");
        assertEquals(login, estudante.getLogin(), "Login do estudante deve ser igual ao gerado.");
        assertEquals(primeirasLetrasDoNome, estudante.getNome().substring(0, 3), "3 primeiras letras do login devem bater com as 3 primeiras letras do nome do estudante.");

        String matriculaDoEstudante = String.valueOf(estudante.getNumeroMatricula());
        assertEquals(ultimosNumerosDaMatricula, matriculaDoEstudante.substring(matriculaDoEstudante.length() - 3), "3 ultimos numeros do login devem bater com os 3 ultimos numeros da matricula do estudante.");
    }

    @Test
    public void toStringDeveRetornarNaFormatacaoCorreta(){
        String nome = "Fernando";
        int matricula = 556644;
        int creditos = 10;
        Estudante estudante = criarEValidarEstudante(nome, matricula);
        estudante.adicionarCreditos(creditos);

        String formatoCorreto = "Nome: " + nome +
                ", Matricula: " + matricula +
                ", Créditos: " + creditos +
                '.';

        assertEquals(formatoCorreto, estudante.toString(), "O to String deve estar no formato determinado.");
    }

    private Estudante criarEValidarEstudante(String nome, int matricula){
        Estudante estudante = new Estudante(nome, matricula);
        assertNotNull(estudante, "Estudante não pode ser nulo.");
        return estudante;
    }
    
    private void operacoesEstudante1(Estudante estudante){
        String loginEsperado = "Fer644";
        String novoNome = "Fernando dos Santos";

        //i. Retornar e imprimir o login
        assertEquals(loginEsperado, estudante.getLogin(), "Login deve estar como o esperado");
        System.out.println(estudante.getLogin());

        //ii. Retornar e imprimir a representação textual
        checarPadraoToString(estudante);
        System.out.println(estudante);

        //iii. Adicionar 4 créditos.
        boolean adicionado = estudante.adicionarCreditos(4);
        assertTrue(adicionado, "Os créditos devem ser adicionados.");

        //iv. Retornar e imprimir a representação textual.
        checarPadraoToString(estudante);
        System.out.println(estudante);

        //v. Alterar o nome para Fernando Santos.
        estudante.setNome(novoNome);
        assertEquals(novoNome, estudante.getNome(), "Nome deve ser igual o alterado");

        //vi. Retornar e imprimir o login
        assertEquals(loginEsperado, estudante.getLogin(), "Login deve estar como o esperado");
        System.out.println(estudante.getLogin());

        //vii. Retornar e imprimir a representação textual
        checarPadraoToString(estudante);
        System.out.println(estudante);
    }

    private void operacoesEstudante2(Estudante estudante){
        String novoNome = "Elizabeth";
        String loginEsperadoAposMudancaDeNome = "Eli035";

        //i. Retornar e imprimir a representação textual.
        checarPadraoToString(estudante);
        System.out.println(estudante);

        //ii. Adicionar -8 créditos (atenção: valor negativo para testar).
        boolean adicionado = estudante.adicionarCreditos(-8);
        assertFalse(adicionado, "Os créditos NÃO devem ser adicionados.");

        //iii. Retornar e imprimir a representação textual.
        checarPadraoToString(estudante);
        System.out.println(estudante);

        //iv. Alterar o nome para Elizabeth.
        estudante.setNome(novoNome);
        assertEquals(novoNome, estudante.getNome(), "Nome deve ser igual o alterado");

        //v. Retornar e imprimir o login.
        assertEquals(loginEsperadoAposMudancaDeNome, estudante.getLogin(), "Login deve estar como o esperado");
        System.out.println(estudante.getLogin());
    }

    private void checarPadraoToString(Estudante est){
        String toStringEsperado = "Nome: " + est.getNome() + ", Matricula: " + est.getNumeroMatricula() + ", Créditos: " + est.getCreditos() + '.';
        assertEquals(toStringEsperado, est.toString(), "ToString deve estar como o esperado");
    }
}
