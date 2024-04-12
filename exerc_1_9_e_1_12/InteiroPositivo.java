public class InteiroPositivo {

    private int valor;

    public InteiroPositivo(int valor) {
        this.valor = Math.max(valor, 0);
    }

    public boolean ehImpar(){
        return valor % 2 != 0;
    }

    public String imprimeDivisores(){
        int qtdDivisores = 0;
        String divisores = "";

        for (int i = 1; i <= valor; i++) {
            if (valor % i == 0){
                divisores += (valor / i) + " ";
                qtdDivisores++;
            }
        }

        System.out.printf("%sQuantidade de divisores: %d", divisores, qtdDivisores);
        return divisores;
    }

    public long fatorial(){
        long resultado = 1;
        for (int i = 1; i <= valor; i++){
            resultado *= i;
        }
        return resultado;
    }

    public double funcaoH(){
        double resultado = 0;

        for (int i = 1; i<= valor; i++)
            resultado += (double) 1 / i ;

        return resultado;
    }

    public double funcaoP(){
        double resultado = 0;
        InteiroPositivo dobro = new InteiroPositivo(0);

        for (int i = 1; i <= valor; i++){
            dobro.setValor(i*2);

            if (i % 2 != 0)
                resultado += (double)i/dobro.fatorial();
            else
                resultado -= (double)i/dobro.fatorial();

        }

        return resultado;
    }

    public double raizQuadrada(){
        return Math.sqrt(valor);
    }

    public int getValor() {
        return valor;
    }

    public boolean setValor(int valor) {
        boolean ehPositivo = valor >= 0;
        if (ehPositivo) this.valor = valor;

        return ehPositivo;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
