Deseja-se representar os funcionários de uma empresa através de objetos. De cada funcionário são informados os seguintes dados, que podem ser alterados a qualquer momento:

Nome.
Quantidade de horas trabalhadas no mês (pode ser fracionada, ex: 4.5).
Salário por hora (pode conter centavos).
Quantidade de dependentes.
Um objeto de funcionário deve ter métodos para calcular e retornar:

a) O salário bruto.
b) O valor de desconto de INSS.
c) O valor de desconto de IR.
d) O salário líquido.
e) Uma String, com a representação textual do funcionário, que inclui os seguintes dados: Nome:, Dependentes:, Sal. Hora:, Qtd. Horas Trab. :, Sal. Bruto: , INSS: , IR: , Sal. Líquido:

Fórmulas para Cálculo:

Salário bruto = horas trabalhadas * salário hora + (50 * número de dependentes)
Desconto INSS:
Salário bruto ≤ 1000 INSS = 8,5% do salário bruto
Salário bruto > 1000 INSS = 9% do salário bruto
Desconto IR:
Salário bruto ≤ 500 IR = 0
Salário bruto > 500 e ≤ 1000 IR = 5% do salário bruto
Salário bruto > 1000 IR = 7% do salário bruto
Roteiro para resolver o exercício:

Elabore um diagrama de classes.
Elabore um diagrama de objetos, contendo os objetos fun1 e fun2 conforme descrito a seguir:
fun1: Bob, com 2 dependentes, salário hora de R$ 6,15, e trabalhou 160 horas.
fun2: Bia, sem dependentes, salário hora de 12.50 e trabalhou 200 horas.
Desenvolva um projeto BlueJ com a implementação. Instancie os dois objetos acima para testar os métodos.
Crie uma classe com um método main e implemente a criação dos objetos fun1 e fun2 modelados no seu diagrama de objetos. Ative os métodos necessários para que o estado destes objetos fique igual ao diagrama de objetos. Após criados e inicializados, implemente as seguintes manipulações dos objetos nesta ordem. Atenção: os objetos devem permanecer consistentes ao longo das manipulações.
Para fun1:
i. Retornar e imprimir o salário bruto.
ii. Retornar e imprimir o desconto de INSS.
iii. Retornar e imprimir o desconto de IR.
iv. Retornar e imprimir o salário líquido.
v. Alterar o salário por hora para R$ 8,00.
vi. Retornar e imprimir o salário líquido.
vii. Retornar e imprimir a representação textual.

Para fun2:
i. Retornar e imprimir a representação textual.
ii. Alterar a quantidade de dependentes para -2 (permitido?).
iii. Alterar o nome para Bianca.
iv. Retornar e imprimir a representação textual.
v. Alterar a quantidade de dependentes para 1.
vi. Alterar o salário por hora para R$ 15,00.
vii. Alterar a quantidade de horas trabalhadas para 750 (permitido?).
viii. Retornar e imprimir a representação textual.
