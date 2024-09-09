import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayInteirosTest
{
    @Test
    public void testArrayInteiros(){
        int tamanhoArray = 10;
        int[] valoresAInserir = new int[]{12, 99, 1, 7, 1, 4, 3, 5, 8, 3};
        ArrayInteiros array = new ArrayInteiros(tamanhoArray);

        for (int i = 0; i < valoresAInserir.length; i++)
            assertEquals(true, array.setValor(i, valoresAInserir[i]));

        //Não deve inserir valor em um index inválido.
        boolean inseriu = array.setValor(50, 834);
        assertEquals(false, inseriu);

        //Verificar se o array tem os mesmos valores que sua cópia estática:
        //ATENÇÃO, ARRAYS NÃO PODEM SER COMPARADOS USANDO O "assertEquals()".
        //PARA ISSO UTILIZAMOS O "assertArrayEquals()";
        assertArrayEquals(valoresAInserir, array.getArrayInteiros());

        //Testando o método contem()
        assertEquals(array.contem(3), true);
        assertEquals(array.contem(11), false);
        
        //Testando index do maior valor
        assertEquals(1, array.maior());
        
        //Testando o método de frequencia absoluta
        int[] arrayGabarito = new int[101]; //sabendo que o array de inteiros primitivos é iniciado com 0 em todas as posições;
        arrayGabarito[1]  = 2; //numero 01 aparece 2 vezes
        arrayGabarito[3]  = 2; //numero 03 aparece 2 vezes
        arrayGabarito[4]  = 1; //numero 04 aparece 1 vez
        arrayGabarito[5]  = 1; //numero 05 aparece 1 vez
        arrayGabarito[7]  = 1; //numero 07 aparece 1 vez
        arrayGabarito[8]  = 1; //numero 08 aparece 1 vez
        arrayGabarito[12] = 1; //numero 12 aparece 1 vez
        arrayGabarito[99] = 1; //numero 99 aparece 1 vez
        assertArrayEquals(arrayGabarito, array.frequenciaAbsoluta());

        //Testando se a ordenação está correta;
        String arrayOrdenado = "1,1,3,3,4,5,7,8,12,99";
        array.ordenar();
        assertEquals(arrayOrdenado, array.toString());
    }
}
