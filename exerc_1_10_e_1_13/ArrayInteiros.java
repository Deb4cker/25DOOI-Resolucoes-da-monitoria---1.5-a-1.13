import java.util.Arrays;

public class ArrayInteiros 
{
    private final int[] array;

    public ArrayInteiros(int tamanho){
        array = new int[Math.max(tamanho, 0)];
    }

    public int[] getArrayInteiros(){
        return array;
    }

    public boolean setValor(int index, int valor){
        final boolean indexValido = index >= 0 && index < array.length;
        if (indexValido) array[index] = valor;
        return indexValido;
    }

    public boolean contem(int numero){
    	for (int i = 0; i < array.length; i++) 
    		if (array[i] == numero) return true;
        return false;
    }

    public int maior(){
        int indexMaior = 0;
        int maiorValor = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > maiorValor) {
                maiorValor = array[i];
                indexMaior = i;
            }
        }

        return indexMaior;
    }

    public int[] frequenciaAbsoluta(){
        int[] frequencias = new int[101];
        for (int i = 0; i < array.length; i++) 
        	if (array[i] >= 0 && array[i] <= 100) frequencias[array[i]]++;
        return frequencias;
    }

    public void ordenar(){
        Arrays.sort(array);
    }
    
    @Override
    public String toString(){
        final String arrayString = Arrays.toString(array);// = "[ a, b, c, d ]"
        
        return arrayString
        		.substring(1, arrayString.length() - 1) // = " a, b, c, d "
        		.replace(" ", ""); // = "a,b,c,d"
    }
}