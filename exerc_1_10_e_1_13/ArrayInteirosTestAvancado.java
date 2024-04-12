import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayInteirosTestAvancado
{
     @Test
    public void deveRetornaremFormatoDeString(){
        int tamanhoArray = 10;
        ArrayInteiros array = new ArrayInteiros(tamanhoArray);

        String saidaEsperada = "1, 3, 4, 5, 8, 9, 1, 7, 99, 12";
        System.out.println("Preencha o array com a seguinte ordem: 1, 3, 4, 5, 8, 9, 1, 7, 99, 12");
        array.preencherArray();

        assertEquals(saidaEsperada, array.imprimirArray());
    }

    @Test
    public void deveRetornarQueContemONumero(){
        int tamanhoArray = 5;
        ArrayInteiros array = new ArrayInteiros(tamanhoArray);

        System.out.println("adicione o número 45, mas não adicione o número 8;");
        array.preencherArray();

        assertTrue(array.contem(45));
        assertFalse(array.contem(8));
    }

    @Test
    public void deveRetornarMaiorValor(){
        int tamanhoArray = 5;
        int maiorNumero = 45;
        ArrayInteiros array = new ArrayInteiros(tamanhoArray);

        System.out.println("preencha o array de forma que o maior número seja 45.");
        array.preencherArray();

        assertEquals(maiorNumero, array.maiorValor());
    }

    @Test
    public void deveImprimirFrequenciaAbsoluta(){
        int tamanhoArray = 5;
        ArrayInteiros array = new ArrayInteiros(tamanhoArray);

        System.out.println("coloque o número 3 duas vezes e o número 1 três vezes: [1, 1, 1, 3, 3]");
        array.preencherArray();

        String frequenciaAbsoluta = array.frequenciaAbsoluta();

        //o método .contains() analisa se a String tem aquele trecho de texto.
        boolean contemContagemCorreta = frequenciaAbsoluta.contains("1 : 3") && frequenciaAbsoluta.contains("3 : 2");

        assertTrue(contemContagemCorreta);
    }

    @Test
    public void deveOrdenarArray(){
        int tamanhoArray = 6;
        String arrayOrdenado = "1, 3, 5, 6, 7, 9";
        ArrayInteiros array = new ArrayInteiros(tamanhoArray);

        System.out.println("Coloque os mesmos seguintes números em ordem diferente: 1, 3, 5, 6, 7, 9");
        array.preencherArray();
        array.ordenar();

        assertEquals(arrayOrdenado, array.imprimirArray());
    }
}
