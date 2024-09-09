import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArrayInteirosTestAvancado
{
	private String mensagem;
    private String mensagemBase;
    
    private static final int[] GABARITO = new int[]{12, 99, 1, 7, 1, 4, 3, 5, 8, 3};

    @Test
    public void testeConstrutorNaoDeveAceitarTamanhoNegativo(){
        final String titulo = "Teste de integridade do construtor:";
        mensagemBase = titulo +"\nO construtor da classe está permitindo a entrada de um valor negativo!\nValor testado no argumento: %d\nMensagem de erro:\n %s";
        final int negativoDeTeste = -1;

        try {
            ArrayInteiros array = new ArrayInteiros(negativoDeTeste);
            array = null;
        } catch (NegativeArraySizeException e){
            mensagem = String.format(mensagemBase, negativoDeTeste, e.getMessage());
            fail(mensagem);
        }
    }

    @Test
    public void testeSetValor(){
        final String titulo = "Teste do metodo \"setValor()\":";
        mensagem = titulo +"\nO metodo \"set\" permitiu a entrada de um index negativo!";

        final ArrayInteiros array = new ArrayInteiros(10);
        boolean entrouValorInvalidoNoArray = array.setValor(-1, 0);
        assertFalse(entrouValorInvalidoNoArray, mensagem);

    }

    @Test
    public void testeContem(){
        final String titulo = "Teste do método \"contem()\":";
        mensagemBase = titulo +"\nÉ %s que o número %d está no array, mas o código retornou %s.";

        final ArrayInteiros array = createArrayInteiros();
        final int[] arrayNaoContidos  = new int[]{78, 134, 13213, -1, 64, 98, 1300, 0, 63274, 13};

        boolean contem;
        for (int valor : arrayNaoContidos){
            contem = array.contem(valor);
            mensagem = String.format(mensagemBase, "falso", valor, "verdadeiro");
            assertFalse(contem, mensagem);
        }

        for(int valor : GABARITO){
            contem = array.contem(valor);
            mensagem = String.format(mensagemBase, "verdadeiro", valor, "falso");
            assertTrue(contem, mensagem);
        }
    }

    @Test
    public void testeRetornarIndexMaiorValor(){
        final String titulo = "Teste do metodo \"maior()\":";
        mensagemBase = titulo +"\nO maior valor está no index %d, mas foi retornado o index %d.\nArray de teste: %s";
        final int indexMaiorValorGabarito = 1; //99
        final ArrayInteiros array = createArrayInteiros();
        final int maiorRetornado = array.maior();
        mensagem = String.format(mensagemBase, indexMaiorValorGabarito, maiorRetornado, Arrays.toString(GABARITO));
        assertEquals(indexMaiorValorGabarito,maiorRetornado, mensagem);
    }

    @Test
    public void testeImprimirArray(){
        final String titulo = "Teste do método \"toString()\":";
        mensagemBase = titulo +"\nString do array parece estar incorreta!" +
                "\nEsperado: \"%s\"" +
                "\nEncontrado: \"%s\"" +
                "\nATENÇÃO: Se ambos parecem iguais, pode ser que esteja sobrando um espaço vazio no final." +
                "\n(Sim, eu testei isso.)\n";

        final String arrayString = "12,99,1,7,1,4,3,5,8,3";
        final ArrayInteiros array = createArrayInteiros();
        mensagem = String.format(mensagemBase, arrayString, array.toString());
        assertEquals(arrayString, array.toString(), mensagem);
    }

    @Test
    public void testeFrequenciaAbsoluta(){
        final String titulo = "Teste do método \"frequenciaAbsoluta()\":";
        mensagemBase = titulo +"\nO número %d aparece %d vez(es), mas a lógica apontou que ele aparece %d vez(es).";
 
            final ArrayInteiros array = createArrayInteiros();
            final int[] arrayGabarito = new int[101];
            arrayGabarito[1]  = 2; //numero 01 aparece 2 vezes
            arrayGabarito[3]  = 2; //numero 03 aparece 2 vezes
            arrayGabarito[4]  = 1; //numero 04 aparece 1 vez
            arrayGabarito[5]  = 1; //numero 05 aparece 1 vez
            arrayGabarito[7]  = 1; //numero 07 aparece 1 vez
            arrayGabarito[8]  = 1; //numero 08 aparece 1 vez
            arrayGabarito[12] = 1; //numero 12 aparece 1 vez
            arrayGabarito[99] = 1; //numero 99 aparece 1 vez

            int valorGabarito;
            int valorRecebido;
            final int[] frequenciaAbsolutaArrayInteiros = array.frequenciaAbsoluta();
            for (int i = 0; i < arrayGabarito.length; i ++){
                valorGabarito = arrayGabarito[i];
                valorRecebido = frequenciaAbsolutaArrayInteiros[i];
                mensagem = String.format(mensagemBase, i, valorGabarito, valorRecebido);
                assertEquals(valorGabarito, valorRecebido, mensagem);
            }
    }

    @Test
    public void testeOrdenarArray(){
        final String titulo = "Teste de ordenação do array:";
        mensagemBase = titulo +"\nArray ordenado incorreto! \nEsperado: %s \nRetornou: %s\n";

        final ArrayInteiros arrayInteiros = createArrayInteiros();
        final int[] gabaritoOrdenado = Arrays.copyOf(GABARITO, GABARITO.length);
        Arrays.sort(gabaritoOrdenado);

        arrayInteiros.ordenar();
        mensagem = String.format(mensagemBase, Arrays.toString(gabaritoOrdenado), arrayInteiros);
        assertArrayEquals(gabaritoOrdenado, arrayInteiros.getArrayInteiros(), mensagem);
    }

    private ArrayInteiros createArrayInteiros(){
        final String titulo = "Teste do metodo \"setValor()\":";
        final String tempMensagemBase = "\n"+ titulo + "\nAlgum erro ocorreu ao tentar adicionar o valor %d no index %d!\nConvém revisar a lógica!";
        final ArrayInteiros array = new ArrayInteiros(GABARITO.length);

        for (int i = 0; i < GABARITO.length; i++) {
            mensagem = String.format(tempMensagemBase, GABARITO[i], i);
            assertTrue(array.setValor(i, GABARITO[i]));
        }

        return array;
    }
}