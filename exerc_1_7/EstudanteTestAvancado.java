import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EstudanteTestAvancado
{
	private static final int    MATRICULA_FERNANDO = 556644;
	private static final int    MATRICULA_BETH = 579035;
	private static final String FERNANDO = "Fernando";
	private static final String BETH = "Beth";
	
    @Test
    @DisplayName("Deve criar um estudante.")
    public void deveCriarEstudante(){
        criarEValidarEstudante(FERNANDO, MATRICULA_FERNANDO);
    }

    @Test
    @DisplayName("Teste do enunciado do exercício.")
    public void deveCumprirEnunciadoDoExercicio(){
        final Estudante est1 = criarEValidarEstudante(FERNANDO, MATRICULA_FERNANDO);
        final Estudante est2 = criarEValidarEstudante(BETH, MATRICULA_BETH);

        est1.adicionarCreditos(35);
        est2.adicionarCreditos(80);

        operacoesEstudante1(est1);
        operacoesEstudante2(est2);
    }
    
    @Test
    @DisplayName("Os dados do estudante devem ser os mesmo informados na entrada.")
    public void dadosDoEstudanteDevemSerOsMesmosInformados(){
        final int creditosAdicionais = 10;
        final Estudante estudante = criarEValidarEstudante(FERNANDO, MATRICULA_FERNANDO);

        estudante.adicionarCreditos(creditosAdicionais);

        assertEquals(FERNANDO, estudante.getNome(), "Nome do estudante deve ser o mesmo informado.");
        assertEquals(MATRICULA_FERNANDO, estudante.getMatricula(), "Matricula do estudante deve ser a mesma informada.");
        assertEquals(creditosAdicionais, estudante.getCreditos(), "Créditos do estudante devem bater com a quantidade ganha.");
    }

    @Test
    @DisplayName("Dados não podem alterar quando inválidos.")
    public void naoDeveAlterarDadosQuandoForInvalido(){
        final int creditosAdicionais = 10;
        final int creditosAdicionaisInvalidos = -8;
        final String nomeInvalido = " ";

        final Estudante estudante = criarEValidarEstudante(FERNANDO, MATRICULA_FERNANDO);
        estudante.adicionarCreditos(creditosAdicionais);

        estudante.setNome(nomeInvalido);
        estudante.adicionarCreditos(creditosAdicionaisInvalidos);

        assertNotEquals(creditosAdicionais + creditosAdicionaisInvalidos, estudante.getCreditos(), "Os créditos inválidos não podem ser inseridos");
        assertNotEquals(nomeInvalido, estudante.getNome(), "Nome do estudante não deve ser inválido");

        assertEquals(creditosAdicionais, estudante.getCreditos(), "Quantidade de créditos do estudante deve ser mantida.");
        assertEquals(FERNANDO, estudante.getNome(), "Nome do estudante deve ser mantido.");
    }

    @Test
    @DisplayName("Login deve estar correto.")
    public void loginDeveEstarNoFormatoCorreto(){
        final Estudante estudante = criarEValidarEstudante(FERNANDO, MATRICULA_FERNANDO);

        final String primeirasLetrasDoNome = FERNANDO.substring(0, 3);
        final String matriculaString = String.valueOf(MATRICULA_FERNANDO);
        final String ultimosNumerosDaMatricula = matriculaString.substring(matriculaString.length() - 3);

        final String login = primeirasLetrasDoNome + ultimosNumerosDaMatricula;

        assertEquals(6, estudante.getLogin().length(), "Login deve ter um tamanho = 6");
        assertEquals(login, estudante.getLogin(), "Login do estudante deve ser igual ao gerado.");
        assertEquals(primeirasLetrasDoNome, estudante.getNome().substring(0, 3), "3 primeiras letras do login devem bater com as 3 primeiras letras do nome do estudante.");

        final String matriculaDoEstudante = String.valueOf(estudante.getMatricula());
        assertEquals(ultimosNumerosDaMatricula, matriculaDoEstudante.substring(matriculaDoEstudante.length() - 3), "3 ultimos numeros do login devem bater com os 3 ultimos numeros da matricula do estudante.");
    }

    @Test
    @DisplayName("Formatação do método toString() deve estar como no enunciado.")
    public void toStringDeveRetornarNaFormatacaoCorreta(){
        final String login = "Fer644";
        final int creditos = 10;
        final Estudante estudante = criarEValidarEstudante(FERNANDO, MATRICULA_FERNANDO);
        estudante.adicionarCreditos(creditos);

        final String formatoCorreto = "Nome: " + FERNANDO +
                ", Matrícula: " + MATRICULA_FERNANDO +
                ", Login: " + login + 
                ", Créditos: " + creditos;

        assertEquals(formatoCorreto, estudante.toString(), "O to String deve estar no formato determinado.");
    }

    private Estudante criarEValidarEstudante(String nome, int matricula){
        final Estudante estudante = new Estudante(nome, matricula);
        assertNotNull(estudante, "Estudante não pode ser nulo.");
        return estudante;
    }
    
    private void operacoesEstudante1(Estudante estudante){
        final String loginEsperado = "Fer644";
        final String novoNome = "Fernando dos Santos";

        //i. Retornar e imprimir o login
        assertEquals(loginEsperado, estudante.getLogin(), "Login deve estar como o esperado");
        System.out.println(estudante.getLogin());

        //ii. Retornar e imprimir a representação textual
        checarPadraoToString(estudante);
        System.out.println(estudante);

        //iii. Adicionar 4 créditos.
        final boolean adicionado = estudante.adicionarCreditos(4);
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
        final String novoNome = "Elizabeth";
        final String loginEsperadoAposMudancaDeNome = "Eli035";

        //i. Retornar e imprimir a representação textual.
        checarPadraoToString(estudante);
        System.out.println(estudante);

        //ii. Adicionar -8 créditos (atenção: valor negativo para testar).
        final boolean adicionado = estudante.adicionarCreditos(-8);
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
        final String toStringEsperado = "Nome: " + est.getNome() + ", Matrícula: " + est.getMatricula() + ", Login: " + est.getLogin() + ", Créditos: " + est.getCreditos();
        assertEquals(toStringEsperado, est.toString(), "ToString deve estar como o esperado");
    }
}
