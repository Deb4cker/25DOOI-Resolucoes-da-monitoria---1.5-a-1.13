import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InteiroPositivoTest 
{
    @Test
    public void testInteiroPositivo(){
        //Testando se são construídos números negativos.
        InteiroPositivo n1 = new InteiroPositivo();
        n1.setValor(11);
        InteiroPositivo n2 = new InteiroPositivo();
        n2.setValor(-2);
        
        assertEquals(n1.getValor() >= 0, true);
        assertEquals(n2.getValor() >= 0, true);
        
        //Testando se inteiros são alterados para valores negativos.
        boolean alterouComInputNegativo = n1.setValor(-18);
        boolean alterouComInputPositivo = n2.setValor(12);

        assertEquals(alterouComInputNegativo, false);
        assertEquals(alterouComInputPositivo, true);
        
        //Testando se o metodo ehImpar retorna corretamente
        assertEquals(n1.ehImpar(), true);
        assertEquals(n2.ehImpar(), false);
        
        //Testando divisores.
        int[] divisoresEsperados = new int[] {12, 6, 4, 3, 2, 1};
        assertArrayEquals(divisoresEsperados, n2.getDivisores());
        
        //Testando fatoriais
        long fatorialDe5 = 120;
        long fatorialDe7 = 5040;
        
        n1.setValor(5);
        n2.setValor(7);
        
        assertEquals(fatorialDe5, n1.fatorial());
        assertEquals(fatorialDe7, n2.fatorial());
        
        InteiroPositivo n3 = new InteiroPositivo();
        n3.setValor(5);
        double formatoDeCasasDepoisDaVirgula = 0.0001;
        
        //Testando o h(x)
        double resultadoEsperado = 2.2833; //h(5) = 2.2833
        double hx = n3.h();
        
        assertEquals(resultadoEsperado, hx, formatoDeCasasDepoisDaVirgula);
        
        //Testando o p(x)
        resultadoEsperado = 0.420735492; //p(10) = 0.420735492
        double px = n3.p();
        
        assertEquals(resultadoEsperado, px, formatoDeCasasDepoisDaVirgula);
        
        //Testando raiz quadrada
        n1.setValor(144);
        n2.setValor(21206025);
        
        int raizDe144 = 12;
        int raizDeNumeroBemGrande = 4605;
        
        assertEquals(raizDe144, n1.raizQuadrada());
        assertEquals(raizDeNumeroBemGrande, n2.raizQuadrada());
        
        //Testando impressão do valor
        assertEquals("144", n1.toString());
    }
}