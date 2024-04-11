import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InteiroPositivoTest {

    @Test
    public void deveSerPositivo(){
        InteiroPositivo n1 = new InteiroPositivo(10);
        InteiroPositivo n2 = new InteiroPositivo(-2);
        InteiroPositivo n3 = new InteiroPositivo(-8);
        InteiroPositivo n4 = new InteiroPositivo(0);
        InteiroPositivo n5 = new InteiroPositivo(12092);

        assertEquals(n1.getValor() >= 0, true);
        assertEquals(n4.getValor() >= 0, true);
        assertEquals(n5.getValor() >= 0, true);
        assertEquals(0, n2.getValor());
        assertEquals(0, n3.getValor());
    }

    @Test
    public void naoDeveAlterarQuandoForNegativo(){
        InteiroPositivo numero = new InteiroPositivo(5);

        boolean alterouComInputNegativo = numero.setValor(-18);
        boolean alterouComInputPositivo = numero.setValor(120);

        assertEquals(alterouComInputNegativo, false);
        assertEquals(alterouComInputPositivo, true);
    }

    @Test
    public void deveRetornarSeEhImpar(){
        InteiroPositivo n1 = new InteiroPositivo(10);
        InteiroPositivo n2 = new InteiroPositivo(-2);
        InteiroPositivo n3 = new InteiroPositivo(7);
        InteiroPositivo n4 = new InteiroPositivo(0);
        InteiroPositivo n5 = new InteiroPositivo(12095);

        assertEquals(n1.ehImpar(), false);
        assertEquals(n2.ehImpar(), false);
        assertEquals(n4.ehImpar(), false);

        assertEquals(n3.ehImpar(), true);
        assertEquals(n5.ehImpar(), true);
    }

    @Test
    public void deveImprimirResultadoCorretamente(){
        String resultadoEsperado = "12 6 4 3 2 1 ";
        InteiroPositivo numero = new InteiroPositivo(12);

        assertEquals(resultadoEsperado, numero.imprimeDivisores());
    }

    @Test
    public void deveRetornarFatorialCorreto(){
        
        long fatorialDe3 = 6;
        long fatorialDe5 = 120;
        long fatorialDe7 = 5040;
    
        InteiroPositivo n1 = new InteiroPositivo(3);
        InteiroPositivo n2 = new InteiroPositivo(5);
        InteiroPositivo n3 = new InteiroPositivo(7);
        
        assertEquals(fatorialDe3, n1.fatorial());
        assertEquals(fatorialDe5, n2.fatorial());
        assertEquals(fatorialDe7, n3.fatorial());
    }

    @Test
    public void deveRetornarFuncaoHCorreta(){
        int numeroDeCasasDepoisDaVirgula = 4;
        double resultadoEsperado = 2.9289; //h(10) = 2.9289

        InteiroPositivo numero = new InteiroPositivo(10);
        double px = numero.funcaoP();
        
        assertEquals(resultadoEsperado, px, numeroDeCasasDepoisDaVirgula);
    }

    @Test
    public void deveRetornarFuncaoPCorreta(){
        int numeroDeCasasDepoisDaVirgula = 10;
        double resultadoEsperado = 0.420735492; //p(10) = 0.420735492

        InteiroPositivo numero = new InteiroPositivo(10);
        double px = numero.funcaoP();
        
        assertEquals(resultadoEsperado, px, numeroDeCasasDepoisDaVirgula);
    }

    @Test
    public void deveRetornarRaizQuadradaCorretamente(){
        int raizDe9 = 3;
        int raizDe25 = 5;
        int raizDe144 = 12;
        int raizDe145161 = 381;
        int raizDeNumeroBemGrande = 4605;

        InteiroPositivo n1 = new InteiroPositivo(9);
        InteiroPositivo n2 = new InteiroPositivo(25);
        InteiroPositivo n3 = new InteiroPositivo(144);
        InteiroPositivo n4 = new InteiroPositivo(145_161);
        InteiroPositivo n5 = new InteiroPositivo(21206025);

        assertEquals(raizDe9, n1.raizQuadrada());
        assertEquals(raizDe25, n2.raizQuadrada());
        assertEquals(raizDe144, n3.raizQuadrada());
        assertEquals(raizDe145161, n4.raizQuadrada());
        assertEquals(raizDeNumeroBemGrande, n5.raizQuadrada());
    }
}
