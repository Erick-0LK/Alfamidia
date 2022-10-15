// +PraTi/Alfamídia - Projeto Final: Versão 1
// Erick Larratéa Knoblich

// A primeira versão aceita qualquer String como válida para todos os parâmetros das pessoas e dos alunos e não contém algumas funções secundárias.
// Ela é uma versão de teste rápido para checar se as funções principais funcionam.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    // Função principal responsável por limpar o terminal e mostrar o menu, disponibilizando as opções para o usuário.
    // Um laço é usado com um booleano que representa o fim da aplicação como parâmetro.
    // Funções auxiliares são chamadas para cada opção selecionada pelo usuário.
    public static void main(String[] args) throws Exception {

        boolean end_application = false;
        String user_input;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> list = new ArrayList<>();

        while (end_application == false) {

            clearTerminal();
            showMenu();
            user_input = scanner.nextLine();
            clearTerminal();
            System.out.println("Opção selecionada: " + user_input + "\n");

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

                    System.out.print("Resposta inválida. ");
                    Thread.sleep(3000);

            }

        }

        scanner.close();
        System.out.println("A aplicação foi encerrada.");

    }

    // Função responsável por adicionar pessoas ou alunos à lista.
    // Ela recebe informação do usuário para cada parâmetro das pessoas ou dos alunos.
    // Ela pergunta se o usuário quer acrescentar uma nota final do curso.
    // A reposta para a nota final do curso determina se uma pessoa é criado ou um aluno é criado.

    public static void addItemToList(ArrayList<Person> list, Scanner scanner) throws Exception {

        String answer, name, phone_number, birth_date, registration_date, last_update_date, final_grade;

        System.out.print("Insira o nome: ");
        name = scanner.nextLine();
        System.out.print("\nInsira o número de telefone: ");
        phone_number = scanner.nextLine();
        System.out.print("\nInsira a data de nascimento: ");
        birth_date = scanner.nextLine();
        System.out.print("\nInsira a data de cadastro: ");
        registration_date = scanner.nextLine();
        System.out.print("\nInsira a data da última alteração: ");
        last_update_date = scanner.nextLine();
        System.out.print("\nDesejas inserir uma nota final de curso? Sim ou não? (S/N): ");
        answer = scanner.nextLine();

        if (answer.equals("N")) {

            list.add(new Person(name, phone_number, birth_date, registration_date, last_update_date));

        }

        else if (answer.equals("S")) {

            System.out.print("\nInsira a nota final do curso: ");
            final_grade = scanner.nextLine();
            list.add(new Student(name, phone_number, birth_date, registration_date, last_update_date, final_grade));

        }

        else {

            System.out.print("\nResposta inválida. Nenhuma pessoa ou aluno será criado. ");
            Thread.sleep(3000);

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

                if (item instanceof Student){

                    System.out.println(index + ". Aluno: " + item.getName() + "\n");
                    System.out.println(item);

                }

                else{

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

    // Função responsável por alterar a lista mudando os parâmetros das pessoas e dos alunos.
    // As pessoas e os alunos são alterados numa função secundária.

    public static void updateItemOnList(ArrayList<Person> list, Scanner scanner) throws Exception {

        int index;

        try {

            if (!list.isEmpty()) {

                showList(list, scanner, 1);
                System.out.print("Insira o índice da pessoa ou do aluno que desejas alterar: ");
                index = scanner.nextInt();
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

    // Função responsável por alterar os parâmetros das pessoas e dos alunos.
    // Ela pergunta se o usário quer alterar cada um dos parâmetros.

    public static void updateItem(Person item, Scanner scanner) {

        int index;
        String answer, name, phone_number, birth_date, registration_date, last_update_date, final_grade;
        String[] text_1 = {"\nDesejas alterar o nome? (S/N): ",
                           "\nDesejas alterar o número de telefone? (S/N): ",
                           "\nDesejas alterar a data de nascimento? (S/N): ",
                           "\nDesejas alterar a data de cadastro? (S/N): ",
                           "\nDesejas alterar a última data de alteração? (S/N): ",
                           "\nDesejas alterar a nota final do curso? (S/N): "};
        String[] text_2 = {"Insira o novo nome: ",
                           "Insira o novo número de telefone: ",
                           "Insira a nova data de nascimento: ",
                           "Insira a nova data de cadastro: ",
                           "Insira a nova última data de alteração: ",
                           "Insira a nova nota final do curso: "};

        for (index = 0; index <= 4; index++) {

            System.out.print(text_1[index]);
            answer = scanner.nextLine();

            if (auxiliary_update(answer) == true) {

                System.out.print(text_2[index]);

                switch (index) {

                    case 0:

                        name = scanner.nextLine();
                        item.setName(name);

                        break;

                    case 1:

                        phone_number = scanner.nextLine();
                        item.setPhoneNumber(phone_number);

                        break;

                    case 2:

                        birth_date = scanner.nextLine();
                        item.setBirthDate(birth_date);

                        break;

                    case 3:

                        registration_date = scanner.nextLine();
                        item.setRegistrationDate(registration_date);

                        break;

                    case 4:

                        last_update_date = scanner.nextLine();
                        item.setLastUpdateDate(last_update_date);

                        break;

                }

            }

        }

        if (item instanceof Student){

            System.out.print(text_1[5]);
            answer = scanner.nextLine();

            if (auxiliary_update(answer) == true) {

                System.out.print(text_2[5]);
                final_grade = scanner.nextLine();
                ((Student) item).setFinalGrade(final_grade);

            }
            
        }

    }

    // Função auxiliar responsável por lidar com as respsotas do usuário na alteração das pessoas e dos alunos.
    // Ela retorna verdadeiro se a alteração será feita ou falso caso contrário.
    // Ela também retorna falso se a reposta for inválida, mas mostra no terminal que a resposta é inválida.

    public static boolean auxiliary_update(String answer) {

        if (answer.equals("S")) {

            return true;

        }

        else if (!answer.equals("N")) {

            System.out.println("Resposta inválida. O parâmetro não foi alterado. ");
            return false;

        }

        return false;

    }

    // Função responsável por deletar uma pessoa ou um aluno da lista.
    // Ele recebe um inteiro índice do usário e então calcula o índice equivalente na lista para a remoção.

    public static void removeItemOnList(ArrayList<Person> list, Scanner scanner) throws Exception {

        int index;

        try {

            if (!list.isEmpty()) {

                showList(list, scanner, 1);
                System.out.print("\nInsira o índice da pessoa ou de aluno que desejas deletar: ");
                index = scanner.nextInt();
                scanner.nextLine();

                if (!(index < 1 || index > list.size())) {

                    list.remove(index - 1);

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

    // Função responsável por mostratr o menu a cada iteração para o usuário.

    public static void showMenu() {

        System.out.print(

                "+PraTi/Alfamídia - Projeto Final: Versão 1\n\n"
                        +
                        "1. Criar pessoa ou aluno.\n"
                        +
                        "2. Mostrar pessoas e alunos criados.\n"
                        +
                        "3. Atualizar pessoa ou aluno.\n"
                        +
                        "4. Deletar uma pessoa ou aluno.\n"
                        +
                        "5. Encerrar programa.\n\n"
                        +
                        "Insira sua opção: "

        );

    }

    // Função responsável por limpar o terminal a cada iteração.

    public static void clearTerminal() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

}