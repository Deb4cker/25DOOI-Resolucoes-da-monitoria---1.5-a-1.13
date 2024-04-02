###Crie um novo projeto no BlueJ e desenvolva a classe Pessoa, conforme diagrama de
classes a seguir.
*Observe que há um construtor com um argumento: o ano de nascimento.
*Através do encapsulamento, garanta a consistˆencia do estado dos objetos.

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
+----------------------------------------+

####Instancie os dois objetos mostrados no diagrama de objetos abaixo.

+---------------------+
|    maria: Pessoa    |
+---------------------+
|anoNascimento = 1990 |
|nome = "Maria"       |
|peso = 60,5          |
|altura = 1,75        |
+---------------------+

+---------------------+
|    jose: Pessoa     |
+---------------------+
|anoNascimento = 1985 |
|nome = "José"        |
|peso = 80,0          |
|altura = 1,85        |
+---------------------+

####Execute os setters e inspecione os objetos para verificar se estão consistentes.
