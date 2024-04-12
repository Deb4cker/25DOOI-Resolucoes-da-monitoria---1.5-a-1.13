import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class ArrayInteirosTest
{
    @Test
    public void testArrayInteiros(){
        int tamanhoArray = 10;
        ArrayInteiros array = new ArrayInteiros(tamanhoArray);

        String saidaEsperada = "1, 3, 4, 5, 8, 9, 1, 7, 99, 12";
        System.out.println("Preencha o array com a seguinte ordem: 1, 3, 4, 5, 8, 9, 1, 7, 99, 12");
        array.preencherArray();

        //Testando saída
        assertEquals(saidaEsperada, array.imprimirArray());
        
        //Testando o método contem()
        assertEquals(array.contem(3), true);
        assertEquals(array.contem(11), false);
        
        //Testando maior valor
        assertEquals(99, array.maiorValor());
        
        //Testando o método de frequencia absoluta
        //o método .contains() analisa se a String tem o trecho de texto informado.
        String frequenciaAbsoluta = array.frequenciaAbsoluta();
        boolean contemContagemCorreta = frequenciaAbsoluta.contains("1 : 2") && frequenciaAbsoluta.contains("3 : 1");
        
        assertEquals(contemContagemCorreta, true);

        //Testando se a ordenação está correta;
        String arrayOrdenado = "1, 1, 3, 4, 5, 7, 8, 9, 12, 99";
        array.ordenar();
        assertEquals(arrayOrdenado, array.imprimirArray());
    }
}
