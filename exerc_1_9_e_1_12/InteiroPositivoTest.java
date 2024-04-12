import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InteiroPositivoTest {

    @Test
    public void testInteiroPositivo(){
        //Testando se são construídos números negativos.
        InteiroPositivo n1 = new InteiroPositivo(11);
        InteiroPositivo n2 = new InteiroPositivo(-2);
        
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
        
        //Testando impressão de valores.
        String impressaoEsperada = "12 6 4 3 2 1 ";
        assertEquals(impressaoEsperada, n2.imprimeDivisores());
        
        //Testando fatoriais
        long fatorialDe5 = 120;
        long fatorialDe7 = 5040;
        
        n1.setValor(5);
        n2.setValor(7);
        
        assertEquals(fatorialDe5, n1.fatorial());
        assertEquals(fatorialDe7, n2.fatorial());
        
        InteiroPositivo n3 = new InteiroPositivo(10);
        double formatoDeCasasDepoisDaVirgula = 0.0001;
        
        //Testando o h(x)
        double resultadoEsperado = 2.9289; //h(10) = 2.9289
        double hx = n3.funcaoH();
        
        assertEquals(resultadoEsperado, hx, formatoDeCasasDepoisDaVirgula);
        
        //Testando o p(x)
        resultadoEsperado = 0.420735492; //p(10) = 0.420735492
        double px = n3.funcaoP();
        
        assertEquals(resultadoEsperado, px, formatoDeCasasDepoisDaVirgula);
        
        //Testando raiz quadrada
        n1.setValor(144);
        n2.setValor(21206025);
        
        int raizDe144 = 12;
        int raizDeNumeroBemGrande = 4605;
        
        assertEquals(raizDe144, n1.raizQuadrada());
        assertEquals(raizDeNumeroBemGrande, n2.raizQuadrada());
    }
}
