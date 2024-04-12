Deseja-se representar, através de objetos, valores inteiros positivos e operações sobre estes valores. Para isso, deve-se criar uma classe chamada `InteiroPositivo`.

Faça um diagrama de classes e depois crie um novo projeto BlueJ para implementar. A classe `InteiroPositivo` deve ter um único atributo encapsulado, para armazenar um valor inteiro `x`. Além disso, ela deve ter os seguintes métodos:

a) Um método `setValor`, que realiza a consistência necessária para garantir que `x` seja um inteiro positivo (encapsulamento).

b) Um método que retorna true caso `x` seja ímpar.

c) Um método que imprime os divisores inteiros de `x` e a quantidade de divisores. Por exemplo, para o número 12, os divisores são 12, 6, 4, 3, 2, 1 e a quantidade de divisores é 6. Para imprimir, use `System.out.printf()`.

d) Um método que calcula e retorna o fatorial de `x`: fatorial(x) = x * (x - 1) * (x - 2) * (x - 3) * ... * 2 * 1.

e) Um método que calcula e retorna a função `h(x)`, definida por: h(x) = 1 + 1/2 + 1/3 + 1/4 + ... + 1/x.

f) Um método que calcula e retorna a função `p(x)`, definida por: p(x) = 1/2! - 2/4! + 3/6! - 4/8! + 5/10!, sendo `x` a quantidade de frações calculadas.

g) Um método que calcula e retorna a raiz quadrada de `x`, isto é: √x.
