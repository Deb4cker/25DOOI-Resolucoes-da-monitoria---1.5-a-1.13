import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstudanteTest
{
    @Test
    public void deveCumprirEnunciadoDoExercicio(){
        String nome1 = "Fernando";
        int matricula1 = 556644;

        String nome2 = "Beth";
        int matricula2 = 579035;

        Estudante est1 = new Estudante(nome1, matricula1);
        Estudante est2 = new Estudante(nome2, matricula2);

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
        Estudante estudante = new Estudante(nome, matricula);

        estudante.adicionarCreditos(creditosAdicionais);

        assertEquals(nome, estudante.getNome());
        assertEquals(matricula, estudante.getNumeroMatricula());
        assertEquals(creditosAdicionais, estudante.getCreditos());
    }

    @Test
    public void naoDeveAlterarDadosQuandoForInvalido(){
        String nome = "Fernando";
        int matricula = 556644;
        int creditosAdicionais = 10;

        String nomeInvalido = " ";
        int creditosAdicionaisInvalidos = -8;

        Estudante estudante = new Estudante(nome, matricula);
        estudante.adicionarCreditos(creditosAdicionais);

        estudante.setNome(nomeInvalido);
        estudante.adicionarCreditos(creditosAdicionaisInvalidos);

        assertEquals(creditosAdicionais, estudante.getCreditos());
        assertEquals(nome, estudante.getNome());
    }

    @Test
    public void loginDeveEstarNoFormatoCorreto(){
        String nome = "Fernando";
        int matricula = 556644;
        Estudante estudante = new Estudante(nome, matricula);

        String primeirasLetrasDoNome = nome.substring(0, 3);
        String matriculaString = String.valueOf(matricula);
        String ultimosNumerosDaMatricula = matriculaString.substring(matriculaString.length() - 3);

        String login = primeirasLetrasDoNome + ultimosNumerosDaMatricula;

        assertEquals(6, estudante.getLogin().length());
        assertEquals(login, estudante.getLogin());
        assertEquals(primeirasLetrasDoNome, estudante.getNome().substring(0, 3));

        String matriculaDoEstudante = String.valueOf(estudante.getNumeroMatricula());
        assertEquals(ultimosNumerosDaMatricula, matriculaDoEstudante.substring(matriculaDoEstudante.length() - 3));
    }

    @Test
    public void toStringDeveRetornarNaFormatacaoCorreta(){
        String nome = "Fernando";
        int matricula = 556644;
        int creditos = 10;
        Estudante estudante = new Estudante(nome, matricula);
        estudante.adicionarCreditos(creditos);

        String formatoCorreto = "Nome: " + nome +
                ", Matricula: " + matricula +
                ", Créditos: " + creditos +
                '.';

        assertEquals(formatoCorreto, estudante.toString());
    }
    
    private void operacoesEstudante1(Estudante est1){
        String loginEsperado = "Fer644";
        String novoNome = "Fernando dos Santos";

        //i. Retornar e imprimir o login
        assertEquals(loginEsperado, est1.getLogin());
        System.out.println(est1.getLogin());

        //ii. Retornar e imprimir a representação textual
        checarPadraoToString(est1);
        System.out.println(est1);

        //iii. Adicionar 4 créditos.
        boolean adicionado = est1.adicionarCreditos(4);
        assertEquals(true, adicionado);

        //iv. Retornar e imprimir a representação textual.
        checarPadraoToString(est1);
        System.out.println(est1);

        //v. Alterar o nome para Fernando Santos.
        est1.setNome(novoNome);
        assertEquals(novoNome, est1.getNome());

        //vi. Retornar e imprimir o login
        assertEquals(loginEsperado, est1.getLogin());
        System.out.println(est1.getLogin());

        //vii. Retornar e imprimir a representação textual
        checarPadraoToString(est1);
        System.out.println(est1);
    }

    private void operacoesEstudante2(Estudante est2){
        String novoNome = "Elizabeth";
        String loginEsperadoAposMudancaDeNome = "Eli035";

        //i. Retornar e imprimir a representação textual.
        checarPadraoToString(est2);
        System.out.println(est2);

        //ii. Adicionar -8 créditos.
        boolean adicionado = est2.adicionarCreditos(-8);
        assertEquals(false, adicionado);

        //iii. Retornar e imprimir a representação textual.
        checarPadraoToString(est2);
        System.out.println(est2);

        //iv. Alterar o nome para Elizabeth.
        est2.setNome(novoNome);
        assertEquals(novoNome, est2.getNome());

        //v. Retornar e imprimir o login.
        assertEquals(loginEsperadoAposMudancaDeNome, est2.getLogin());
        System.out.println(est2.getLogin());
    }

    private void checarPadraoToString(Estudante est){
        String toStringEsperado = "Nome: " + est.getNome() + ", Matricula: " + est.getNumeroMatricula() + ", Créditos: " + est.getCreditos() + '.';
        assertEquals(toStringEsperado, est.toString());
    }
}
