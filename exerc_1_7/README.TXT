Deseja-se representar os estudantes da turma através de objetos. Além do nome e do número de matrícula do estudante, o objeto deve armazenar também a quantidade de créditos já cursados. O objeto deve encapsular os dados do estudante, atentando para os seguintes detalhes:

a) Após criado o objeto, não é possível alterar o número de matrícula do estudante, apenas seu nome.

b) Deve haver um método para adicionar créditos, que incrementa a quantidade de créditos já cursados pelo estudante. Não deve haver método para setar diretamente a quantidade de créditos.

c) Deve haver um método para calcular e retornar o login do aluno, que é formado pelos três primeiros caracteres do nome do aluno + os 3 últimos dígitos da matrícula. Exemplo: Nome: “Fernando”; Matrícula: 556644; Login = “Fer644”.

d) Deve haver um método para retornar uma String com a representação textual do aluno. Formato: Nome: , Matrícula: , Login: , Créditos: . Exemplo: Nome: Fernando, Matrícula: 556644, Login: Fer644, Créditos: 36

Roteiro para resolver o exercício:

Elabore um diagrama de classes.

Elabore um diagrama de objetos, contendo os objetos est1 e est2 a seguir:

est1: Fernando, matrícula 556644, cursou 35 créditos.

est2: Beth, matrícula 579035, cursou 80 créditos.

Desenvolva um projeto BlueJ com a implementação. Instancie os dois objetos acima para testar os métodos.

Crie uma classe com um método main e implemente a criação dos objetos est1 e est2 modelados no seu diagrama de objetos. Ative os métodos necessários para que o estado destes objetos fique igual ao diagrama de objetos. Após criados e inicializados, implemente as seguintes manipulações dos objetos nesta ordem. Atenção: os objetos devem permanecer consistentes ao longo das manipulações.

est1:

i. Retornar e imprimir o login.

ii. Retornar e imprimir a representação textual.

iii. Adicionar 4 créditos.

iv. Retornar e imprimir a representação textual.

v. Alterar o nome para Fernando Santos.

vi. Retornar e imprimir o login.

vii. Retornar e imprimir a representação textual.

est2:

i. Retornar e imprimir a representação textual.

ii. Adicionar -8 créditos (atenção: valor negativo para testar).

iii. Retornar e imprimir a representação textual.

iv. Alterar o nome para Elizabeth.

v. Retornar e imprimir o login.
