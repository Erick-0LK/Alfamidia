// +PraTi/Alfamídia - Projeto Final: Versão 2
// Erick Larratéa Knoblich
// A segunda versão utiliza padrões para todos as propriedades das pessoas e dos alunos e força o usuário a inserir uma resposta válida.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.InputMismatchException;
import java.time.LocalDate;

public class Main {

    // Função principal responsável por limpar o terminal, mostrar o menu e lidar com as opções selecionadas pelo o usuário.
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

            if (!user_input.equals("1"))  System.out.println();
            
            switch (user_input) {

                case "1":

                    addItemToList(list, scanner);
                    break;

                case "2":

                    if (checkList(list)) showList(list, scanner, 0);
                    break;

                case "3":

                    if (checkList(list)) updateItemOnList(list, scanner);
                    break;

                case "4":

                    if (checkList(list)) removeItemOnList(list, scanner);
                    break;

                case "5":

                    end_application = true;
                    break;

                case "6":

                    addExamplesToList(list, scanner);
                    break;

                default:

                    System.out.print("Opção inválida. Por favor, tente novamente. ");
                    Thread.sleep(3000);
                    break;

            }

        }

        scanner.close();
        System.out.print("A aplicação foi encerrada. ");

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
                         "\nDesejas inserir uma nota final do curso? Sim ou não? (S/N): ",
                         "\nExemplo de nota final do curso: 0 <= x <= 10\nInsira a nota final do curso: "};

        for (int index = 0; index < 4; index++) {

            System.out.print(text[index]);

            switch (index) {

                case 0:

                    name = checkName(text[index], scanner);
                    break;

                case 1:

                    phone_number = checkPhoneNumber(text[index], scanner);
                    break;

                case 2:

                    birth_date = checkDate(text[index], scanner);
                    break;

                case 3:

                    registration_date = checkDate(text[index], scanner);
                    break;

            }

        }

        last_update_date = convertDate(LocalDate.now());
        System.out.print(text[4]);

        if (yesOrNoQuestion(text[4], scanner) == false) {

            list.add(new Person(name, phone_number, birth_date, registration_date, last_update_date));

        }

        else {

            System.out.print(text[5]);
            final_grade = checkFinalGrade(text[5], scanner);
            list.add(new Student(name, phone_number, birth_date, registration_date, last_update_date, final_grade));

        }

    }

    // Função responsável por mostrar as pessoas e os alunos da lista na ordem em que foram acrescentados.
    // Ela tem um inteiro tipo, que determina se o usuário escolheu a opção dois, de apenas mostrar a lista, ou...
    // ...se a função está sendo chamada dentro de outras, nas opções três ou quatro, nas quais mudanças na lista podem ser feitas.

    public static void showList(ArrayList<Person> list, Scanner scanner, int identation) {

        int index = 1;

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

        if (identation == 0) {

            System.out.print("Insira qualquer valor para encerrar a exibição de pessoas e alunos: ");
            scanner.nextLine();

        }

    }

    // Função responsável por determinar qual pessoa ou aluno da lista será alterado.
    // As pessoas e os alunos são alterados numa função secundária.

    public static void updateItemOnList(ArrayList<Person> list, Scanner scanner) throws Exception {

        try {

            showList(list, scanner, 1);
            System.out.print("Insira o índice da pessoa ou do aluno que desejas alterar: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            updateItem(list.get(index - 1), scanner);

        } catch (InputMismatchException error) {

            System.out.print("\nÍndice inválido. Por favor, tente novamente.");
            scanner.nextLine();
            Thread.sleep(3000);

        } catch (IndexOutOfBoundsException error) {

            System.out.print("\nÍndice inválido. Por favor, tente novamente.");
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
                           "\nDesejas alterar a nota final do curso? Sim ou não? (S/N): "};
        String[] text_2 = {"\nExemplo de nome: Fulano Sicrano Beltrano\nInsira o novo nome: ",
                           "\nExemplo de número de telefone: 5551123456789\nInsira o novo número de telefone: ",
                           "\nExemplo de data de nascimento: 01/01/2001\nInsira a nova data de nascimento: ",
                           "\nExemplo de data de cadastro: 01/01/2001\nInsira a nova data de cadastro: ",
                           "\nExemplo de nota final do curso: 0 <= x <= 10\nInsira a nova nota final do curso: "};

        clearTerminal();
        System.out.println("Item selecionado: \n\n" + item);

        for (int index = 0; index < 4; index++) {

            System.out.print(text_1[index]);

            if (yesOrNoQuestion(text_1[index], scanner) == true) {

                System.out.print(text_2[index]);

                switch (index) {

                    case 0:

                        item.setName(checkName(text_2[index], scanner));
                        break;

                    case 1:

                        item.setPhoneNumber(checkPhoneNumber(text_2[index], scanner));
                        break;

                    case 2:

                        item.setBirthDate(checkDate(text_2[index], scanner));
                        break;

                    case 3:

                        item.setRegistrationDate(checkDate(text_2[index], scanner));
                        break;

                }

            }

        }

        item.setLastUpdateDate(convertDate(LocalDate.now()));

        if (item instanceof Student) {

            System.out.print(text_1[4]);

            if (yesOrNoQuestion(text_1[4], scanner) == true) {

                System.out.print(text_2[4]);
                ((Student) item).setFinalGrade(checkFinalGrade(text_2[4], scanner));

            }
            
        }

    }

    // Função responsável por deletar uma pessoa ou um aluno da lista.
    // Ele recebe um inteiro índice do usário e então calcula o índice equivalente na lista para a remoção.

    public static void removeItemOnList(ArrayList<Person> list, Scanner scanner) throws Exception {

        try {

            showList(list, scanner, 1);
            System.out.print("Insira o índice da pessoa ou de aluno que desejas deletar: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            list.remove(index - 1);

        } catch (InputMismatchException error) {

            System.out.print("\nÍndice inválido. Por favor, tente novamente. ");
            scanner.nextLine();
            Thread.sleep(3000);

        } catch (IndexOutOfBoundsException error) {

            System.out.print("\nÍndice inválido. Por favor, tente novamente. ");
            Thread.sleep(3000);

        }

    }

    // Função responsável por adicionar dos exemplos válidos à lista, uma pessoa e um aluno.

    public static void addExamplesToList(ArrayList<Person> list, Scanner scanner) throws Exception {

        list.add(new Person("Pessoa Exemplo", "5551123456789", "01/01/2022", "01/01/2022", "01/01/2022"));
        list.add(new Student("Pessoa Exemplo", "5551123456789", "01/01/2022", "01/01/2022", "01/01/2022", "10"));
        System.out.print("Exemplos foram adicionados à lista. ");
        Thread.sleep(3000);

    }

    // Função responsável por mostratr o menu para o usuário.

    public static void showMenu() {

        System.out.print("+PraTi/Alfamídia - Projeto Final: Versão 2\n\n" +
                         "1. Criar pessoa ou aluno e adicioná-lo à lista.\n" +
                         "2. Mostrar lista de pessoas e alunos.\n" +
                         "3. Atualizar pessoa ou aluno da lista.\n" +
                         "4. Deletar uma pessoa ou aluno da lista.\n" +
                         "5. Encerrar programa.\n" +
                         "6. Adicionar exemplos de pessoas e alunos à lista.\n\n" +
                         "Insira sua opção: ");

    }

    // Função responsável por checar se a lista está vazia, alertando o usuário caso esteja.

    public static boolean checkList(ArrayList <Person> list) throws Exception {

        if (list.isEmpty() == false) return true;
        System.out.print("A lista está vazia. ");
        Thread.sleep(3000);
        return false;

    }

    // Função responsável por determinar se o nome é válido: ele precisa não ser vazio e ter apenas espaços e letras.

    public static String checkName(String text, Scanner scanner){

        String name = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[ A-Za-z]+$");
        Matcher matcher = pattern.matcher(name);

        if (!name.trim().isEmpty() && matcher.matches()) {

            return name;

        }

        System.out.print("Nome inválido. Por favor, tente novamente.\n" + text);
        return checkName(text, scanner);

    }

    // Função responsável por determinar se o número de telefone é válido: ele precisa ter treze dígitos e ser um número inteiro.
    
    public static String checkPhoneNumber(String text, Scanner scanner) {

        String phone_number = scanner.nextLine();
        
        try {

            Long.parseLong(phone_number);

            if (phone_number.length() == 13) {

                return phone_number;

            }

            System.out.print("Número de telefone inválido. Por favor, tente novamente.\n" + text);
            return checkPhoneNumber(text, scanner);

        } catch (NumberFormatException error) {

            System.out.print("Número de telefone inválido. Por favor, tente novamente.\n" + text);
            return checkPhoneNumber(text, scanner);

        }

    }

    // Função responsável por determinar se a data é válida: ela precisa seguir o calendário gregoriano.

    public static String checkDate(String text, Scanner scanner) {
        
        String date = scanner.nextLine();

        try {

            int day = Integer.parseInt(date.substring(0, 2));
            int month = Integer.parseInt(date.substring(3, 5));
            int year = Integer.parseInt(date.substring(6, 10));

            if (date.length() == 10 && date.charAt(2) == '/' && date.charAt(5) == '/' && day > 0 && month > 0 && month < 13 && year > 0) {

                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    
                    if (day < 31) return date;
                    System.out.print("Data inválida. Por favor, tente novamente.\n" + text);
                    return checkDate(text, scanner);

                }

                if (month == 2) {
                    
                    if (day < 29) return date;
                    if ((year % 4 == 0 && year % 100 != 0 || year % 4 == 0 && year % 100 == 0 && year % 400 == 0) && day < 30) return date;
                    System.out.print("Data inválida. Por favor, tente novamente.\n" + text);
                    return checkDate(text, scanner);

                }

                if (day < 32) return date;
                System.out.print("Data inválida. Por favor, tente novamente.\n" + text);
                return checkDate(text, scanner);

            }

            System.out.print("Data inválida. Por favor, tente novamente.\n" + text);
            return checkDate(text, scanner);

        } catch (NumberFormatException error) {

            System.out.print("Data inválida. Por favor, tente novamente.\n" + text);
            return checkDate(text, scanner);

        } catch (IndexOutOfBoundsException error) {

            System.out.print("Data inválida. Por favor, tente novamente.\n" + text);
            return checkDate(text, scanner);

        }

    }

    // Função responsável por converter a data atual para o formato dia/mês/ano.

    public static String convertDate(LocalDate current_date) {

        String date = current_date.toString();
        String day = date.substring(8, 10);
        String month = date.substring(5, 7);
        String year = date.substring(0, 4);
        return day + "/" + month + "/" + year;

    }

    // Função responsável por determinar se nota final do curso é válida: ela precisa ser um número real entre zero e dez, ambos inclusos.
    // Apenas os dois primeiros dígitos da expansão decimal são considerados na hora da exibição, com arredondamento.

    public static String checkFinalGrade(String text, Scanner scanner) {

        String final_grade = scanner.nextLine();

        try {

            if (Float.parseFloat(final_grade) >= 0 && Float.parseFloat(final_grade) <= 10) return final_grade;
            System.out.print("Noto final do curso inválida. Por favor, tente novamente.\n" + text);
            return checkFinalGrade(text, scanner);
        
        } catch (NumberFormatException error) {

            System.out.print("Noto final do curso inválida. Por favor, tente novamente.\n" + text);
            return checkFinalGrade(text, scanner);

        }

    }

    // Função responsável por lidar com as perguntas que aceitam apenas sim ou não como respostas.

    public static boolean yesOrNoQuestion(String text, Scanner scanner) {

        String answer = scanner.nextLine();

        while (!(answer.equals("S") || answer.equals("N"))) {

            System.out.println("Resposta inválida. Por favor, tente novamente. ");
            System.out.print(text);
            answer = scanner.nextLine();

        }

        return answer.equals("S") ? true : false;

    }

    // Função responsável por limpar o terminal para o usuário.

    public static void clearTerminal() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

}