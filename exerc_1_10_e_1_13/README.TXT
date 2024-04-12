Deseja-se representar, através de objetos, arrays de valores inteiros e operações sobre estes arrays. Para isso, crie uma classe chamada ArrayInteiros.

Faça um diagrama de classes e depois crie um novo projeto BlueJ para implementar. A classe ArrayInteiros deve ter um único atributo encapsulado, para armazenar um array de inteiros. Os valores armazenados no array serão todos entre 0 e 100 (não é necessário fazer consistência). A classe deve ter os seguintes métodos:

a) Um construtor, que recebe por parâmetro o tamanho do array e cria o array.

b) Um método que preenche o array, solicitando que o usuário digite cada valor. Para ler valores, use um objeto Scanner visto antes na disciplina.

c) Um método que imprime os valores do array em uma única linha. Os valores devem estar separados por vírgula. Exemplo: array: [1 5 8 2]; impressão: 1, 5, 8, 2 (não há vírgula após o último elemento).

d) Um método que verifica se um dado valor existe no array (retorna true/false).

e) Um método que encontra e imprime o maior valor do array e sua posição.

f) Um método que calcula e imprime a frequência absoluta de cada valor possível. A frequência absoluta é a quantidade de vezes que cada valor possível aparece no array. Por exemplo, para um array com os valores [3 2 99 2 1 3] seria impresso:

valor frequência absoluta
0 : 0
1 : 1
2 : 2
3 : 2
...
98 : 0
99 : 1
100 : 0
g) Um método que ordena o array, em ordem crescente de valores.
