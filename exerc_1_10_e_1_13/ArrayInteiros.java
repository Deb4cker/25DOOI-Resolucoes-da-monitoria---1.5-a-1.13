import java.util.Arrays;
import java.util.Scanner;

public class ArrayInteiros {

    private final int[] array;

    public ArrayInteiros(int tamanho){
        array = new int[tamanho];
    }

    public String imprimirArray() {
        String resultado = "";
        boolean ehUltimoValor;

        for (int i = 0; i < array.length; i++) {
            ehUltimoValor = i == array.length - 1;

            if (ehUltimoValor)
                resultado += array[i];
            else
                resultado += array[i] + ", ";
        }

        System.out.println(resultado);
        return resultado;
    }

    public void preencherArray(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) array[i] = scanner.nextInt();
        scanner.close();
    }

    public void preencherArray(int[] valores){
        if (valores.length == array.length)
            for (int i = 0; i < array.length; i++)
                array[i] = valores[i];
    }

    public boolean contem(int numero){
        for (int i = 0; i < array.length; i++)
            if (array[i] == numero) return true;

        return false;
    }

    public int maiorValor(){
        int maiorValor = array[0];

        for (int i = 0; i < array.length; i++){
            maiorValor = Math.max(array[i], maiorValor);
        }

        return maiorValor;
    }

    public String frequenciaAbsoluta(){
        String resultado = "";
        int[] frequencias = new int[101];

        for (int i = 0; i < array.length; i++)
            if (array[i] >= 0 && array[i] <= 100)
                frequencias[array[i]]++;

        for (int i = 0; i < frequencias.length; i++)
                resultado += i + " : " + frequencias[i] + "\n";

        System.out.println(resultado);
        return resultado;
    }

    public void ordenar(){
        Arrays.sort(array);
    }
    
    @Override
    public String toString(){
        return Arrays.toString(array);
    }
}