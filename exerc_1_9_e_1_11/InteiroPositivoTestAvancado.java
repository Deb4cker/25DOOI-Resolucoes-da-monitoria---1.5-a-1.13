import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InteiroPositivoTestAvancado
{
    @Test
    public void deveSerPositivo(){
        InteiroPositivo n1 = new InteiroPositivo(10);
        InteiroPositivo n2 = new InteiroPositivo(-2);
        InteiroPositivo n3 = new InteiroPositivo(-8);
        InteiroPositivo n4 = new InteiroPositivo(0);
        InteiroPositivo n5 = new InteiroPositivo(12092);

        assertTrue(n1.getValor() >= 0, "Valor deve ser maior que zero");
        assertTrue(n4.getValor() >= 0, "Valor deve ser maior que zero");
        assertTrue(n5.getValor() >= 0, "Valor deve ser maior que zero");

        assertEquals(0, n2.getValor(), "Valor deve ser igual a zero já que foi instanciado com valor negativo.");
        assertEquals(0, n3.getValor(), "Valor deve ser igual a zero já que foi instanciado com valor negativo.");
    }

    @Test
    public void naoDeveAlterarQuandoForNegativo(){
        InteiroPositivo numero = new InteiroPositivo(5);

        boolean alterouComInputNegativo = numero.setValor(-18);
        boolean alterouComInputPositivo = numero.setValor(120);

        assertFalse(alterouComInputNegativo, "Não deve alterar com input negativo.");
        assertTrue(alterouComInputPositivo, "Deve alterar com input positivo.");
    }

    @Test
    public void deveRetornarSeEhImpar(){
        InteiroPositivo n1 = new InteiroPositivo(10);
        InteiroPositivo n2 = new InteiroPositivo(-2);
        InteiroPositivo n3 = new InteiroPositivo(7);
        InteiroPositivo n4 = new InteiroPositivo(0);
        InteiroPositivo n5 = new InteiroPositivo(12095);

        assertFalse(n1.ehImpar(), "É falso que n1 é impar.");
        assertFalse(n2.ehImpar(), "É falso que n2 é impar.");
        assertFalse(n4.ehImpar(), "É falso que n4 é impar.");

        assertTrue(n3.ehImpar(), "É verdadeiro que n3 é impar.");
        assertTrue(n5.ehImpar(), "É verdadeiro que n5 é impar.");
    }

    @Test
    public void deveImprimirResultadoCorretamente(){
        String resultadoEsperado = "12 6 4 3 2 1 ";
        InteiroPositivo numero = new InteiroPositivo(12);

        assertEquals(resultadoEsperado, numero.imprimeDivisores(), "Os divisores devem bater.");
    }

    @Test
    public void deveRetornarFatorialCorreto(){
        InteiroPositivo numero = new InteiroPositivo(0);
        int[] fatoriaisDeZeroADez = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};

        long fatorialEsperado;
        for (int i = 0; i < fatoriaisDeZeroADez.length; i++){
            numero.setValor(i);
            fatorialEsperado = fatoriaisDeZeroADez[i];
            assertEquals(fatorialEsperado, numero.fatorial(), "Os fatorial de " + i + " deve ser " + fatorialEsperado);
        }
    }

    @Test
    public void deveRetornarFuncaoHCorreta(){

        int numeroDeCasasDepoisDaVirgula = 4;
        double[] resultadosEsperados = {
                0,      //i = 00;
                1,      //i = 01;
                1.5,    //i = 02;
                1.8333, //i = 03;
                2.0833, //i = 04;
                2.2833, //i = 05;
                2.45,   //i = 06;
                2.5928, //i = 07;
                2.7178, //i = 08;
                2.8289, //i = 09;
                2.9289  //i = 10;
        };

        InteiroPositivo numero = new InteiroPositivo(0);

        double hx;
        double resultadoEsperado;
        for (int i = 0; i < resultadosEsperados.length; i++){
            numero.setValor(i);
            hx = numero.funcaoH();
            resultadoEsperado = resultadosEsperados[i];
            assertEquals(resultadoEsperado, hx, numeroDeCasasDepoisDaVirgula, "h("+ i +") deve ser igual a " + resultadoEsperado);
        }
    }

    @Test
    public void deveRetornarFuncaoPCorreta(){

        int numeroDeCasasDepoisDaVirgula = 10;
        double[] resultadosEsperados = {
                0,           //i = 00;
                0.5,         //i = 01;
                0.4166,      //i = 02;
                0.4208,      //i = 03;
                0.420734127, //i = 04;
                0.420735505, //i = 05;
                0.420735492, //i = 06; #Daqui para baixo a calculadora não alcançava mais casas U_U;
                0.420735492, //i = 07;
                0.420735492, //i = 08;
                0.420735492, //i = 09;
                0.420735492  //i = 10;
        };

        InteiroPositivo numero = new InteiroPositivo(0);

        double px;
        double resultadoEsperado;
        for (int i = 0; i < resultadosEsperados.length; i++){
            numero.setValor(i);
            px = numero.funcaoP();
            resultadoEsperado = resultadosEsperados[i];
            assertEquals(resultadoEsperado, px, numeroDeCasasDepoisDaVirgula, "p("+ i +") deve ser igual a " + resultadoEsperado);
        }
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
        InteiroPositivo n5 = new InteiroPositivo(21_206_025);

        assertEquals(raizDe9, n1.raizQuadrada(), "Raiz de 9 deve ser igual a 3.");
        assertEquals(raizDe25, n2.raizQuadrada(), "Raiz de 25 deve ser igual a 5.");
        assertEquals(raizDe144, n3.raizQuadrada(), "Raiz de 144 deve ser igual a 12.");
        assertEquals(raizDe145161, n4.raizQuadrada(), "Raiz de 145.161 deve ser igual a 381.");
        assertEquals(raizDeNumeroBemGrande, n5.raizQuadrada(), "Raiz de 21.206.025 deve ser igual a 4605.");
    }
}
