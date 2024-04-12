import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EstudanteTest
{
    @Test
    public void testeEstudante1() {
        Estudante est1 = new Estudante("Fernando",556644);
        est1.adicionarCreditos(35);

        // verificar o estado inicial do objeto
        assertEquals(556644, est1.getMatricula());
        assertEquals("Fernando", est1.getNome());
        assertEquals(35, est1.getCreditos());

        // verificar login
        System.out.println(est1.getLogin());
        assertEquals("Fer644", est1.getLogin());

        // verificar representação textual
        assertEquals("Nome: Fernando, Matrícula: 556644, Login: Fer644, Créditos: 35", est1.toString());

        // manipular o objeto
        est1.adicionarCreditos(4);
        est1.setNome("Fernando Santos");

        // verificar estado e representação textual após manipulações
        assertEquals(556644, est1.getMatricula());
        assertEquals("Fernando Santos", est1.getNome());
        assertEquals(39, est1.getCreditos());
        assertEquals("Fer644", est1.getLogin());
        assertEquals("Nome: Fernando Santos, Matrícula: 556644, Login: Fer644, Créditos: 39", est1.toString());
    }
    
    @Test
    public void testeEstudante2() {
        Estudante est2 = new Estudante("Beth", 579035);
        est2.adicionarCreditos(80);

        // verificar o estado inicial do objeto
        assertEquals(579035, est2.getMatricula());
        assertEquals("Beth", est2.getNome());
        assertEquals(80, est2.getCreditos());

        // verificar login
        System.out.println(est2.getLogin());
        assertEquals("Bet035", est2.getLogin());

        // verificar representação textual
        assertEquals("Nome: Beth, Matrícula: 579035, Login: Bet035, Créditos: 80", est2.toString());

        // manipular o objeto
        est2.adicionarCreditos(-8);
        est2.setNome("Elizabeth");

        // verificar estado e representação textual após manipulações
        assertEquals(579035, est2.getMatricula());
        assertEquals("Elizabeth", est2.getNome());
        assertEquals(80, est2.getCreditos());
        assertEquals("Eli035", est2.getLogin());
        assertEquals("Nome: Elizabeth, Matrícula: 579035, Login: Eli035, Créditos: 80", est2.toString());
    }
}
