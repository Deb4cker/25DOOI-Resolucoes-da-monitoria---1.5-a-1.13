import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class InteiroPositivoTestAvancado
{
    private static final double DELTA = 0.0001;
    private String mensagemBase; //Variável de escopo para a mensagem formatada;
    private String mensagem;     //Variável de escopo para a mensagem da assertiva;

    @Test
    public void testeValorNegativo() {
        final String titulo = "Teste de verificação entrada de valores negativos:";
        final InteiroPositivo inteiroPositivo = new InteiroPositivo();
        final boolean alterouComInputNegativo = inteiroPositivo.setValor(-18);
        final boolean alterouComInputPositivo = inteiroPositivo.setValor(120);

        assertFalse(alterouComInputNegativo, titulo + "\nNão deve alterar com input negativo.\n");
        assertTrue(alterouComInputPositivo, titulo + "\nDeve alterar com input positivo.\n");
    }

    @Test
    public void testeValorZero() {
        final String titulo = "Teste de verificação de entrada de valor 0:";
        final InteiroPositivo inteiroPositivo = new InteiroPositivo();
        final boolean alterouComInputNegativo = inteiroPositivo.setValor(0);
        
        assertFalse(alterouComInputNegativo, titulo + "\nNão deve alterar com valor 0!.\n");
    }

    @Test
    public void testeEhImpar() {
        final String titulo = "Teste do metodo \"ehImpar()\":";
        mensagemBase = titulo + "\nÉ %s que %d é impar!\n";

        final int[] valoresDeTeste = new int[]{10, 2, 7, 1, 12095};

        final InteiroPositivo inteiroPositivo = new InteiroPositivo();
        boolean ehImpar;

        for (int valor : valoresDeTeste) {
            ehImpar = valor % 2 != 0;
            inteiroPositivo.setValor(valor);
            mensagem = String.format(mensagemBase, ehImpar ? "verdadeiro" : "falso", valor);
            assertEquals(ehImpar, inteiroPositivo.ehImpar(), mensagem);
        }
    }

    @Test
    public void testeDivisores() {
        final String titulo = "Teste de verificação de divisores:";
        mensagemBase = titulo + "\nArray incorreto! \nNúmero testado: %d \nEsperado: %s \nRetornou: %s\n";

        final int[] valoresTeste = new int[]{12, 36, 1, 7, 8, 41, 57, 13, 11, 5, 19, 24, 76, 22, 100};
        final Map<Integer, int[]> tabelaDivisores = gerarTabelaDivisores();

        final InteiroPositivo inteiroPositivo = new InteiroPositivo();
        int[] arrayEsperado;
        int[] arrayGerado;
        for (int valor : valoresTeste){
            inteiroPositivo.setValor(valor);
            arrayEsperado = tabelaDivisores.get(valor);
            arrayGerado = inteiroPositivo.getDivisores();
            mensagem = String.format(mensagemBase, valor, Arrays.toString(arrayEsperado), Arrays.toString(arrayGerado));
            assertArrayEquals(arrayEsperado, arrayGerado, mensagem);
        }
    }

    @Test
    public void testeFatorial() {
        final String titulo = "Teste do método \"fatorial()\":";
        mensagemBase = titulo + "\nO fatorial de %d é %d, mas o cálculo retornou %d";
        final InteiroPositivo inteiroPositivo = new InteiroPositivo();
        final int[] fatoriaisDeZeroADez = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};

        long fatorialEsperado;
        long fatorialGerado;
        for (int i = 0; i < fatoriaisDeZeroADez.length; i++) {
            inteiroPositivo.setValor(i);
            fatorialEsperado = fatoriaisDeZeroADez[i];
            fatorialGerado = inteiroPositivo.fatorial();
            mensagem = String.format(mensagemBase, i, fatorialEsperado, fatorialGerado);
            assertEquals(fatorialEsperado, fatorialGerado, mensagem);
        }
    }

    @Test
    public void testeFuncaoH() {
        final String titulo = "Teste do método \"h()\":";
        mensagemBase = titulo + "\nh(%d) deve ser igual a %.4f\n";
        
        final double[] resultadosEsperados = {
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

        final InteiroPositivo inteiroPositivo = new InteiroPositivo();

        double hx;
        double resultadoEsperado;
        for (int i = 1; i < resultadosEsperados.length; i++) {
            inteiroPositivo.setValor(i);
            hx = inteiroPositivo.h();
            resultadoEsperado = resultadosEsperados[i - 1];
            mensagem = String.format(mensagemBase, i, resultadoEsperado);
            assertEquals(resultadoEsperado, hx, DELTA, mensagem);
        }
    }

    @Test
    public void testeFuncaoP() {
        final String titulo = "Teste do método \"p()\":";
        mensagemBase = titulo + "\np(%d) deve ser igual a %.4f\n";

        final double[] resultadosEsperados = {
                0.5,         //i = 01;
                0.4166,      //i = 02;
                0.4208,      //i = 03;
                0.420734127, //i = 04;
                0.420735505, //i = 05;
                0.420735492, //i = 06; #Daqui para baixo a calculadora não alcançava mais casas ( ._.)
                0.420735492, //i = 07;
                0.420735492, //i = 08;
                0.420735492, //i = 09;
                0.420735492  //i = 10;
        };

        final InteiroPositivo numero = new InteiroPositivo();
        double px;
        double resultadoEsperado;
        for (int i = 1; i < resultadosEsperados.length; i++) {
            numero.setValor(i);
            px = numero.p();
            resultadoEsperado = resultadosEsperados[i - 1];
            mensagem = String.format(mensagemBase, i, resultadoEsperado);
            assertEquals(resultadoEsperado, px, DELTA, mensagem);
        }
    }

    @Test
    public void testeRaizQuadrada() {
        final String titulo = "Teste do método \"raizQuadrada()\":";
        mensagemBase = titulo + "\nA raiz quadrada de %d é %d.\nResultado obtido: %.4f\n";
        final int iNumero = 0;
        final int iRaiz = 1;

        final int[][] raizes = new int[][]{
                new int[]{9, 3},
                new int[]{25, 5},
                new int[]{144, 12},
                new int[]{145_161, 381},
                new int[]{21_206_025, 4605}
        };

        InteiroPositivo numero;
        int numeroReal;
        int raiz;
        for (int[] tupla : raizes) {
            numeroReal = tupla[iNumero];
            numero = new InteiroPositivo();
            numero.setValor(tupla[iNumero]);
            raiz = tupla[iRaiz];
            mensagem = String.format(mensagemBase, numeroReal, raiz, numero.raizQuadrada());
            assertEquals(raiz, numero.raizQuadrada(), DELTA, mensagem);
        }
    }

    private Map<Integer, int[]> gerarTabelaDivisores() {
        final Map<Integer, int[]> tabelaDivisores = new HashMap<>();
        tabelaDivisores.put(12,  new int[]{12, 6, 4, 3, 2, 1});
        tabelaDivisores.put(36,  new int[]{36, 18, 12, 9, 6, 4, 3, 2, 1});
        tabelaDivisores.put( 1,  new int[]{1});
        tabelaDivisores.put( 7,  new int[]{7, 1});
        tabelaDivisores.put( 8,  new int[]{8, 4, 2, 1});
        tabelaDivisores.put(41,  new int[]{41, 1});
        tabelaDivisores.put(57,  new int[]{57, 19, 3, 1});
        tabelaDivisores.put(13,  new int[]{13, 1});
        tabelaDivisores.put(11,  new int[]{11, 1});
        tabelaDivisores.put( 5,  new int[]{5, 1});
        tabelaDivisores.put(19,  new int[]{19, 1});
        tabelaDivisores.put(24,  new int[]{24, 12, 8, 6, 4, 3, 2, 1});
        tabelaDivisores.put(76,  new int[]{76, 38, 19, 4, 2, 1});
        tabelaDivisores.put(22,  new int[]{22, 11, 2, 1});
        tabelaDivisores.put(100, new int[]{100, 50, 25, 20, 10, 5, 4, 2, 1});

        return tabelaDivisores;
    }
}
