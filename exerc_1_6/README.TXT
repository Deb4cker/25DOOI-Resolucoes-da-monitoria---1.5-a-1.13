Modifique a classe Pessoa conforme diagrama de classes a seguir.

O método casar() seta o conjuge da pessoa.
O método ehCasado() retorna true se a pessoa tiver um conjuge (ou seja, seconjuge != null).
O método getNomeConjuge() deve retornar o nome do conjuge.

+----------------------------------------+
|                 Pessoa                 |
+----------------------------------------|
|-anoNascimento: int                     |
|-nome: String                           |
|-peso: double                           |
|-altura: double                         |
+----------------------------------------+
|+Pessoa (anoNascimento : int)           |
|+setNome (nome : String) : boolean      |
|+getNome() : String                     | 
|+setPeso (peso : double): boolean       |
|+getPeso() : double                     |
|+setAltura (altura : double) : boolean  |
|+getAltura() : double                   |
|+casar( outraPessoa : Pessoa) : void    |
|+ehCasado () : boolean                  |
|+getNomeConjuge () : String             |
+----------------------------------------+

Em seguida, realize as seguintes operações:
1. Crie os objetos maria e jose do exercício anterior.
2. Case o objeto maria com o objeto jose.
3. Execute o método ehCasado() nos dois objetos. O resultado é consistente?
4. Execute o método getNomeConjuge() do objeto jose. O resultado é consistente?
5. Execute o método getNomeConjuge() do objeto maria. O resultado é consistente?
	* Qual erro ocorreu? Por que ocorreu este erro?
6. Modifique a classe Pessoa para garantir a consistência de estado:
 	*Uma pessoa só pode casar com outra pessoa que não é casada.
	*A relação de conjuge deve ser consistente nas duas pessoas.
