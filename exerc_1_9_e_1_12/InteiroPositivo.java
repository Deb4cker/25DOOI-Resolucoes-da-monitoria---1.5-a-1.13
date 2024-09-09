public class InteiroPositivo 
{
    private int valor;
    
    /*
     * Não é requisitado um construtor para a classe no enunciado.
     * Podemos usar o construtor vazio implícito.
     */
    
    public boolean ehImpar(){
        return valor % 2 != 0;
    }

    public int[] getDivisores(){
        /*
         * Isso é uma solução de força bruta. 
         * Uma solução ótima para esse problema seria utilizar o conceito da simetria de raizes
         * Acesse a aba Optimal approach em: https://takeuforward.org/data-structure/print-all-divisors-of-a-given-number/*/
    	
    	if (valor == 0) return new int[]{0};

        int quantidadeDivisores = 0;
        for (int i = 1; i <= valor; i++){
            if (valor % i == 0) quantidadeDivisores++;
        }

        int lastIndexUsed = 0;
        int[] divisores = new int[quantidadeDivisores];
        for (int i = valor; i > 0; i--){
            if (valor % i == 0) {
                divisores[lastIndexUsed] = i;
                lastIndexUsed++;
            }
        }

        return divisores;
    }

    public long fatorial(){
        long resultado = 1;
        for (int i = 1; i <= valor; i++) resultado *= i;
        return resultado;
    }

    public double h(){
        double resultado = 0;
        for (int i = 1; i<= valor; i++) resultado += (double) 1 / i ;
        return resultado;
    }

    public double p(){
        double resultado = 0;
        final InteiroPositivo dobro = new InteiroPositivo();

        //Resolução por meio lógico:
        for (int i = 1; i <= valor; i++){
            dobro.setValor(i*2);

            if (i % 2 != 0)
                resultado += (double)i/dobro.fatorial();
            else
                resultado -= (double)i/dobro.fatorial();
        }

        return resultado;
        
        //Resolução por meio matemático
        /*
        
        double resultado = 0;
        final InteiroPositivo temp = new InteiroPositivo();
        
        for (int i = 1; i <= valor; i++) {
        	temp.setValor(2 * i);									       
            resultado += (Math.pow((-1), i + 1) * i) / temp.fatorial();
        }
        																 
        return resultado;
        
        */
        
        ///EXPLICAÇÃO///
        
        /* Funções periódicas como a função h e p podem ser representadas matematicamente
         * com a notação somatório. Em suma todas tem o seu TERMO GERAL.
         * O da funçao h(d), por exemplo, é o mais simples:
         * 
         *   n
         *   Σ     i
         * d = 1  ¨d¨
         *         
         * O da função p(x) passa a ser um pouco mais complexo:
         *     
         *   x
         *   Σ   (-1)^i+1 * i
         * i = 1 ¨¨¨(2*1)!¨¨¨
         *           
         * Ao lembrar que o laço "for" nada mais é do que uma abstração matemática do somatório,
         * podemos concluir que basta irmos somando o resultado dos termos gerais 1 a 1
         * para obtermos o resultado.
         */
    }
    public double raizQuadrada(){
        return Math.sqrt(valor);
    }

    public int getValor() {
        return valor;
    }

    public boolean setValor(int valor) {
        final boolean ehPositivo = valor > 0;
        if (ehPositivo) this.valor = valor;
        return ehPositivo;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}