# :coffee: +PraTi/Alfamídia: Desenvolvedor Java

<p align="justify">
Este repositório contém duas versões do projeto final proposto como projeto de incubação do curso Desenvolvedor Java (+PraTi/Alfamídia). Além dele, também possuo outros repositórios com projetos feitos em outras linguagens, muitos deles do curso Bacharelado em Ciência da Computação da Universidade Federal do Rio Grande do Sul (UFRGS). Além de Java, também sei Python e LaTeX.
</p>

## Projeto Final :books:

<p align="justify">
O projeto final é uma CRUD (Create, Read, Update e Delete) que lida com duas classes: a classe pessoa e a classe aluno. A classe pessoa possui as seguintes propriedades protegidas: nome, número de telefone, data de nascimento, data de cadastro e última data de alteração. Já a classe aluno, por ser uma classe herdada da classe pessoa, além das prorpiedades já mencionadas, possue a propriedade privada nota final do curso. A aplicação consiste numa Array List desses objetos com interação CRUD com o usário, ou seja, o usuário pode criar, atualizar e deletar pessoas e alunos nessa Array List. Como a classe aluno é uma classa herdada da classe pessoa, a Array List está configurada para a classe pessoa. O uso de uma classe abstrata seria desnecessário.
</p>

- Versão 1: versão simples de teste.
- Versão 2: versão definitva.

### Versão 1

<p align="justify">
A primeira versão é a versão mais simples do projeto final, uma vez que aceita qualquer valor para as propriedades dos objetos: pessoas e alunos. Por exemplo, a string "abc" é uma data de nascimento válida para as pessoas e para os alunos. Ela é uma versão de teste no sentido em que as funcionalidades principais, acrescentar item à lista, mostrar a lista, alterar item da lista, remover item da lista e encerrar programa, funcionam, mas não contém boas interações com o usuário.
</p>

### Versão 2

<p align="justify">
A segunda versão é a versão mais complexa do projeto final, uma vez que tem parâmetros para todas as propriedades dos objetos: pessoas e alunos. Por exemplo, a string "abc" não é mais válida para uma data de nascimento. Agora, uma data válida do calendário gregoriano precisa ser inserida no formato dd/mm/aaaa. Além disso, o usuário recebe exemplos de respostas válidas e é forçado a inserir uma resposta válida. Os padrões de cada propriedade são explicados por meio de comentários no código.
</p>

### Padrões

- Nome: não pode ser vazio ou conter caracteres especias
- Número de telefone: precisa ser um número inteiro de treze dígitios
- Data: precisa seguir o calendário gregoriano e leva em conta anos bissextos
- Última data de alteração: armazena automaticamente a data atual do computador
- Nota final do curso: precisa ser um número real entre zero e dez, ambos inclusos
