// +PraTi/Alfamídia - Projeto Final: Versão 2
// Erick Larratéa Knoblich

// A segunda versão utiliza padrões para todos as propriedades das pessoas e dos alunos, exceto para o nome.
// Ela é uma versão mais complexa e mais completa.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.NumberFormatException;

public class Main {

    // Função principal responsável por limpar o terminal e mostrar o menu, disponibilizando as opções para o usuário.
    // Um laço é usado com um booleano que representa o fim da aplicação.
    // Funções auxiliares são chamadas para cada opção selecionada pelo usuário.
    public static void main(String[] args) throws Exception {

        boolean end_application = false;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> list = new ArrayList<>();

        while (end_application == false) {

            clearTerminal();
            showMenu();
            String user_input = scanner.nextLine();
            clearTerminal();
            System.out.println("Opção selecionada: " + user_input);

            if (!user_input.equals("1")) {

                System.out.println();
                
            }

            switch (user_input) {

                case "1":

                    addItemToList(list, scanner);
                    break;

                case "2":

                    showList(list, scanner, 0);
                    break;

                case "3":

                    updateItemOnList(list, scanner);
                    break;

                case "4":

                    removeItemOnList(list, scanner);
                    break;

                case "5":

                    end_application = true;
                    break;

                default:

                    System.out.print("Resposta inválida. Por favor, tente novamente. ");
                    Thread.sleep(3000);
                    break;

            }

        }

        scanner.close();
        System.out.println("A aplicação foi encerrada. ");

    }

    // Função responsável por adicionar pessoas ou alunos à lista.
    // Ela recebe informação do usuário para cada propriedade das pessoas e dos alunos.
    // Ela pergunta se o usuário quer acrescentar uma nota final do curso.
    // A reposta para a nota final do curso determina se uma pessoa é criado ou um aluno é criado.

    public static void addItemToList(ArrayList<Person> list, Scanner scanner) {

        String name = null, phone_number = null, birth_date = null, registration_date = null, last_update_date = null, final_grade = null;
        String[] text = {"\nExemplo de nome: Fulano Sicrano Beltrano\nInsira o nome: ",
                         "\nExemplo de número de telefone: 5551123456789\nInsira o número de telefone: ",
                         "\nExemplo de data de nascimento: 01/01/2001\nInsira a data de nascimento: ",
                         "\nExemplo de data de cadastro: 01/01/2001\nInsira a data de cadastro: ",
                         "\nExemplo de última data de alteração: 01/01/2001\nInsira a data da última alteração: ",
                         "\nDesejas inserir uma nota final do curso? Sim ou não? (S/N): ",
                         "\nExemplo de nota final do curso: 0 <= x <= 10\nInsira a nota final do curso: "};

        for (int index = 0; index <= 4; index++) {

            System.out.print(text[index]);

            switch (index) {

                case 0:

                    name = checkProperty(text[index], scanner, "Name", 0);
                    break;

                case 1:

                    phone_number = checkProperty(text[index], scanner, "Phone Number", 0);
                    break;

                case 2:

                    birth_date = checkProperty(text[index], scanner, "Date", 0);
                    break;

                case 3:

                    registration_date = checkProperty(text[index], scanner, "Date", 0);
                    break;

                case 4:

                    last_update_date = checkProperty(text[index], scanner, "Date", 0);
                    break;

            }

        }

        System.out.print(text[5]);

        if (yesOrNoQuestion(text[5], scanner) == false) {

            list.add(new Person(name, phone_number, birth_date, registration_date, last_update_date));

        }

        else {

            System.out.print(text[6]);
            final_grade = checkProperty(text[6], scanner, "Final Grade", 0);
            list.add(new Student(name, phone_number, birth_date, registration_date, last_update_date, final_grade));

        }

    }

    // Função responsável por mostrar as pessoas e os alunos da lista na ordem em que foram acrescentados.
    // Ela usa um índice para listar as pessoas e os alunos.
    // Ela tem um inteiro tipo, que determina se o usuário escolheu a opção dois, de apenas mostrar a lista, ou...
    // ...se a função está sendo chamada dentro de outras, nas opções três e quatro, nas quais mudanças na lista podem ser feitas.

    public static void showList(ArrayList<Person> list, Scanner scanner, int type) throws Exception {

        int index = 1;

        if (!list.isEmpty()) {

            for (Person item : list) {

                if (item instanceof Student) {

                    System.out.println(index + ". Aluno: " + item.getName() + "\n");
                    System.out.println(item);

                }

                else {

                    System.out.println(index + ". Pessoa: " + item.getName() + "\n");
                    System.out.println(item);

                }

                System.out.println();
                index++;

            }

            if (type == 0) {

                System.out.print("Insira qualquer valor para encerrar a exibição de pessoas e alunos: ");
                scanner.nextLine();

            }

        }

        else {

            System.out.print("A lista está vazia. ");
            Thread.sleep(3000);

        }

    }

    // Função responsável por alterar a lista mudando as propriedades das pessoas e dos alunos.
    // As pessoas e os alunos são alterados numa função secundária.

    public static void updateItemOnList(ArrayList<Person> list, Scanner scanner) throws Exception {

        try {

            if (!list.isEmpty()) {

                showList(list, scanner, 1);
                System.out.print("Insira o índice da pessoa ou do aluno que desejas alterar: ");
                int index = scanner.nextInt();
                scanner.nextLine();

                if (!(index < 1 || index > list.size())) {

                    updateItem(list.get(index - 1), scanner);

                }

                else {

                    System.out.print("\nResposta inválida. ");
                    Thread.sleep(3000);

                }

            }

            else {

                System.out.print("A lista está vazia. ");
                Thread.sleep(3000);

            }

        } catch (InputMismatchException e) {

            System.out.print("\nResposta inválida. ");
            scanner.nextLine();
            Thread.sleep(3000);

        }

    }

    // Função responsável por alterar as propriedades das pessoas e dos alunos.
    // Ela pergunta se o usário quer alterar cada uma das propriedades.

    public static void updateItem(Person item, Scanner scanner) {

        String[] text_1 = {"\nDesejas alterar o nome? Sim ou não? (S/N): ",
                           "\nDesejas alterar o número de telefone? Sim ou não? (S/N): ",
                           "\nDesejas alterar a data de nascimento? Sim ou não? (S/N): ",
                           "\nDesejas alterar a data de cadastro? Sim ou não? (S/N): ",
                           "\nDesejas alterar a última data de alteração? Sim ou não? (S/N): ",
                           "\nDesejas alterar a nota final do curso? Sim ou não? (S/N): "};
        String[] text_2 = {"Exemplo de nome: Fulano Sicrano Beltrano\nInsira o novo nome: ",
                           "Exemplo de número de telefone: 5551123456789\nInsira o novo número de telefone: ",
                           "Exemplo de data de nascimento: 01/01/2001\nInsira a nova data de nascimento: ",
                           "Exemplo de data de cadastro: 01/01/2001\nInsira a nova data de cadastro: ",
                           "Exemplo de última data de alteração: 01/01/2001\nInsira a nova última data de alteração: ",
                           "Exemplo de nota final do curso: 0 <= x <= 10\nInsira a nova nota final do curso: "};

        for (int index = 0; index <= 4; index++) {

            System.out.print(text_1[index]);

            if (yesOrNoQuestion(text_1[index], scanner) == true) {

                System.out.print(text_2[index]);

                switch (index) {

                    case 0:

                        item.setName(checkProperty(text_2[index], scanner, "Name", 1));
                        break;

                    case 1:

                        item.setPhoneNumber(checkProperty(text_2[index], scanner, "Phone Number", 1));
                        break;

                    case 2:

                        item.setBirthDate(checkProperty(text_2[index], scanner, "Date", 1));
                        break;

                    case 3:

                        item.setRegistrationDate(checkProperty(text_2[index], scanner, "Date", 1));
                        break;

                    case 4:

                        item.setLastUpdateDate(checkProperty(text_2[index], scanner, "Date", 1));
                        break;

                }

            }

        }

        if (item instanceof Student) {

            System.out.print(text_1[5]);

            if (yesOrNoQuestion(text_1[5], scanner) == true) {

                System.out.print(text_2[5]);
                ((Student) item).setFinalGrade(checkProperty(text_2[5], scanner, "Final Grade", 1));

            }
            
        }

    }

    // Função responsável por deletar uma pessoa ou um aluno da lista.
    // Ele recebe um inteiro índice do usário e então calcula o índice equivalente na lista para a remoção.

    public static void removeItemOnList(ArrayList<Person> list, Scanner scanner) throws Exception {

        try {

            if (!list.isEmpty()) {

                showList(list, scanner, 1);
                System.out.print("Insira o índice da pessoa ou de aluno que desejas deletar: ");
                int index = scanner.nextInt();
                scanner.nextLine();

                if (!(index < 1 || index > list.size())) {

                    list.remove(index - 1);

                }

                else {

                    System.out.print("\nResposta inválida. Por favor, tente novamente. ");
                    Thread.sleep(3000);

                }

            }

            else {

                System.out.print("A lista está vazia. ");
                Thread.sleep(3000);

            }

        } catch (InputMismatchException e) {

            System.out.print("\nResposta inválida. Por favor, tente novamente. ");
            scanner.nextLine();
            Thread.sleep(3000);

        }

    }

    // Função responsável por mostratr o menu a cada iteração para o usuário.

    public static void showMenu() {

        System.out.print("+PraTi/Alfamídia - Projeto Final: Versão 2\n\n" +
                         "1. Criar pessoa ou aluno.\n" +
                         "2. Mostrar pessoas e alunos criados.\n" +
                         "3. Atualizar pessoa ou aluno.\n" +
                         "4. Deletar uma pessoa ou aluno.\n" +
                         "5. Encerrar programa.\n\n" +
                         "Insira sua opção: ");

    }

    // Função responsável por limpar o terminal a cada iteração.

    public static void clearTerminal() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    // Função responsável por lidar com as perguntas que aceitam apenas sim ou não como respostas.
    // Ela força o usuário a inserir uma resposta válida e mantém a identação no terminal.

    public static boolean yesOrNoQuestion(String text, Scanner scanner) {

        String answer = scanner.nextLine();

        while (!(answer.equals("S") || answer.equals("N"))) {

            System.out.println("Resposta inválida. Por favor, tente novamente. ");
            System.out.print(text);
            answer = scanner.nextLine();

        }

        boolean output = answer.equals("S") ? true : false;
        return output;

    }

    // Função responsável por determinar se as propriedades dos objetos são válidas.
    // Ela chama funções auxiliares para cada propriedade.

    public static String checkProperty(String text, Scanner scanner, String property, int identation) {

        boolean auxiliary = false;
        String user_input = null;

        while (auxiliary == false) {

            user_input = scanner.nextLine();

            switch (property) {

                case "Name":

                    auxiliary = checkName(user_input);
                    break;

                case "Phone Number":

                    auxiliary = checkPhoneNumber(user_input);
                    break;

                case "Date":

                    auxiliary = checkDate(user_input);
                    break;

                case "Final Grade":

                    auxiliary = checkFinalGrade(user_input);
                    break;

            }
           
            if (auxiliary == false) {
                
                System.out.println("Resposta inválida. Por favor, tente novamente. ");

                if (identation == 1) {

                    System.out.println();

                }

                System.out.print(text);

            } 

        }

        return user_input;

    }

    // Função responsável por determinar se o nome é válido.
    // Ele precisa não ser vazio e ter apenas espaços e letras.

    public static boolean checkName(String name){

        Pattern pattern = Pattern.compile("^[ A-Za-z]+$");
        Matcher matcher = pattern.matcher(name);
        boolean output = !name.trim().isEmpty() && matcher.matches() ? true : false;
        return output;

    }

    // Função responsável por determinar se o número de telefone é válido.
    // Ele precisa ter treze dígitos e ser um número inteiro.
    
    public static boolean checkPhoneNumber(String phone_number) {

        try {

            Long.parseLong(phone_number);
            boolean output = phone_number.length() == 13 ? true : false;
            return output;

        } catch (NumberFormatException e) {

            return false;

        }

    }

    // Função responsável por determinar se a data é válida.
    // Ela precisa seguir o calendário gregoriano.

    public static boolean checkDate(String date) {

        boolean output;

        try {

            if (date.length() == 10) {
                
                if (date.charAt(2) == '/' && date.charAt(5) == '/') {

                    int day = Integer.parseInt(date.substring(0, 2));
                    int month = Integer.parseInt(date.substring(3, 5));
                    int year = Integer.parseInt(date.substring(6, 10));

                    if (day > 0 && month > 0 && month < 13 && year > 0) {

                        if (month == 2) {

                            if (year % 4 == 0 && year % 100 != 0 || year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
    
                                output = day < 30 ? true : false;
                                return output;
    
                            }
    
                            output = day < 29 ? true : false;
                            return output;
    
                        }

                        if (month == 4 || month == 6 || month == 9 || month == 11) {

                            output = day < 31 ? true : false;
                            return output;
    
                        }

                        output = day < 32 ? true : false;
                        return output;

                    }

                }

            }

            return false;

        } catch (NumberFormatException e) {

            return false;

        }

    }

    // Função responsável por determinar se nota final do curso é válida.
    // Ela precisa ser um número real entre zero e dez, ambos inclusos.
    // Apenas os dois primeiros dígitos da expansão decimal são considerados na hora da exibição, com arredondamento.

    public static boolean checkFinalGrade(String final_grade) {

        try {

            boolean output = (Float.parseFloat(final_grade) >= 0 && Float.parseFloat(final_grade) <= 10) ? true : false;
            return output;
        
        } catch (NumberFormatException e) {

            return false;

        }

    }

}