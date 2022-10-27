# :coffee: +PraTi/Alfamídia: Desenvolvedor Java

Este repositório contém o projeto final proposto para a incubação mais dois jogos simples no terminal: a minha versão do jogo feito pelo professor Rodrigo durante o curso semelhante à batalha naval e o jogo da velha feito por mim.

## Projeto Final :books:

O projeto final é uma CRUD (Create, Read, Update e Delete) que lida com duas classes: a classe pessoa e a classe aluno. A classe pessoa possui as seguintes propriedades protegidas: nome, número de telefone, data de nascimento, data de cadastro e última data de alteração. Já a classe aluno, por ser uma classe herdada da classe pessoa, além das prorpiedades já mencionadas, possue a propriedade privada nota final do curso. A aplicação consiste numa Array List desses objetos com interação CRUD com o usário, ou seja, o usuário pode criar, atualizar e deletar pessoas e alunos nessa Array List. Como a classe aluno é uma classa herdada da classe pessoa, a ArrayList está configurada para o objeto pessoa. O uso de uma classe abstrata seria desnecessário.

- Versão 1: versão simples de teste.
- Versão 2: versão definitva.
- Versão 3: versão bônus.

### Versão 1 :coffee:

A primeira versão é a versão mais simples do projeto final, uma vez que aceita qualquer valor para as propriedades dos objetos: pessoas e alunos. Por exemplo, a string "abc" é uma data de nascimento válida para as pessoas e para os alunos. Ela é uma versão de teste no sentido em que as funcionalidades principais, acrescentar item à lista, mostrar a lista, alterar item da lista, remover item da lista e encerrar programa, funcionam, mas não contém boas interações com o usuário.

### Versão 2 :coffee:

A segunda versão é a versão mais complexa do projeto final, uma vez que tem parâmetros para as propriedades dos objetos: pessoas e alunos. Por exemplo, a string "abc" não é mais válida para uma data de nascimento. Agora, uma data válida do calendário gregoriano precisa ser inserida no formato dd/mm/aaaa. Todos as propriedades possuem parâmetros. Além disso, o usuário recebe exemplos de respostas válidas e é forçado a inserir uma resposta válida.

### Versão 3 :snake:

A terceira versão é uma aplicação semelhante, uma CRUD com objetos e propriedades diferentes, mas menos complexa feito na linguagem de programação Python ao invés da linguagem de programação Java, a linguagem estudada durante o curso. Ela é uma versão bônus e serve para mostrar outras habilidades minhas, assim como os meus outros repositórios, alguns sendo da faculdade de Ciência da Computação (UFRGS).
