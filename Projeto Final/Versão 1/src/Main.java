// Alfamídia - Projeto Final Versão 1
// Erick Larratéa Knoblich
// A primeira versão utiliza dois Array Lists e usa o Scanner para cada 'input' do usuário.

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
        ArrayList<Person> list_of_people = new ArrayList<>();
        ArrayList<Student> list_of_students = new ArrayList<>();

        while (end_application == false) {

            clearTerminal();
            showMenu();
            user_input = scanner.nextLine();
            clearTerminal();
            System.out.println("Opção selecionada: " + user_input + "\n");

            switch (user_input) {

                case "1":

                    addInformation(list_of_people, list_of_students, scanner);
                    break;

                case "2":

                    showList(list_of_people, list_of_students, scanner, 0);
                    break;

                case "3":

                    alterList(list_of_people, list_of_students, scanner);
                    break;

                case "4":

                    deleteInformation(list_of_people, list_of_students, scanner);
                    break;

                case "5":

                    end_application = true;
                    break;

                default:

                    System.out.print("\nResposta inválida. ");
                    Thread.sleep(3000);

            }

        }

        scanner.close();
        System.out.println("A aplicação foi encerrada.");

    }

    // Função responsável por mostratr o menu a cada iteração para o usuário.

    public static void showMenu() {

        System.out.print(

            "CURSO DE JAVA - PROJETO FINAL\n\n"
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

    // Função responsável por adicionar informações, pessoas ou alunos, à "lista" principal, uma fusão das duas listas secundárias.
    // Ela recebe 'input' do usuário para cada parâmetro de pessoa ou aluno, perguntando se o usuário quer acrescentar uma nota final de curso.
    // A reposta para a nota final de curso determina se uma pessoa ou um aluno é criado.

    public static void addInformation(ArrayList<Person> list_of_people, ArrayList<Student> list_of_students, Scanner scanner) throws Exception {

        String name, phone_number, birth_date, registration_date, last_update_date, answer, final_grade;
        System.out.print("Insira o nome: ");
        name = scanner.nextLine();
        System.out.print("Insira o número de telefone: ");
        phone_number = scanner.nextLine();
        System.out.print("Insira a data de nascimento: ");
        birth_date = scanner.nextLine();
        System.out.print("Insira a data de cadastro: ");
        registration_date = scanner.nextLine();
        System.out.print("Insira a data da última alteração: ");
        last_update_date = scanner.nextLine();
        System.out.print("\nDesejas inserir uma nota final do curso? Sim ou não? (S/N): ");
        answer = scanner.nextLine();

        if (answer.equals("N")) {

            list_of_people.add(new Person(name, phone_number, birth_date, registration_date, last_update_date));

        }

        else if (answer.equals("S")) {

            System.out.print("Insira a nota final do curso: ");
            final_grade = scanner.nextLine();
            list_of_students.add(new Student(name, phone_number, birth_date, registration_date, last_update_date, final_grade));

        }

        else {

            System.out.print("\nResposta inválida. ");
            Thread.sleep(3000);

        }

    }

    // Função responsável por mostrar a "lista" principal, uma fusão das listas secundárias.
    // Ela usa um contador para listar os índices das pessoas e dos alunos.
    // A lista secundária de pessoas é exibida antes da lista secundária de alunos.
    // Ela tem um inteiro tipo, que determina se o usuário escolheu a opção dois de mostrar a "lista" principal, zero, ou...
    // ...se a função está sendo chamada dentro de outras, nas opções três e quatro.

    public static void showList(ArrayList<Person> list_of_people, ArrayList<Student> list_of_students, Scanner scanner, int type) throws Exception {

        int counter = 1;

        if (!list_of_people.isEmpty() || !list_of_students.isEmpty()) {

            for (Person person : list_of_people) {

                System.out.print(counter + ". ");
                System.out.println(person);
                counter++;

            }

            for (Student student : list_of_students) {

                System.out.print(counter + ". ");
                System.out.println(student);
                counter++;

            }

            if (type == 0) {

                System.out.print("\nInsira qualquer valor para encerrar a exibição de pessoas e alunos: ");
                scanner.nextLine();

            }

        }

        else {

            System.out.print("A lista está vazia. ");
            Thread.sleep(3000);

        }

    }

    // Função principal responsável por alterar os parâmetros de pessoas e alunos.
    // Ele recebe um 'input' do usário como índice da "lista" principal e calcula o índice equivalente nas listas secundárias.
    // As pessoas e os alunos são alteradas numa função secundária.

    public static void alterList(ArrayList<Person> list_of_people, ArrayList<Student> list_of_students, Scanner scanner) throws Exception {

        int index;

        try{

            if (!list_of_people.isEmpty() || !list_of_students.isEmpty()) {

                showList(list_of_people, list_of_students, scanner, 1);
                System.out.print("\nInsira o índice da pessoa ou de aluno que desejas deletar: ");
                index = scanner.nextInt();
                scanner.nextLine();

                if (!(index < 1 || index > list_of_people.size() + list_of_students.size())) {

                    if (index <= list_of_people.size()) {

                        alterPersonOrStudent(list_of_people, list_of_students, scanner, index, 0);

                    }

                    else {

                        alterPersonOrStudent(list_of_people, list_of_students, scanner, index, 1);

                    }

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

        }catch(InputMismatchException e){

            System.out.print("\nResposta inválida. ");
            scanner.nextLine();
            Thread.sleep(3000);

        }

    }

    // Função secundária responsável por alterar os parâmetros de pessoas e alunos.
    // Ela pergunta se o usário quer alterar cada um dos parâmetros.
    // Ela utuliza dois vetores de 'Strings' para ter um código mais limpo.
    // Ela tem um inteiro tipo, que determina se o usuário quer alterar uma pessoa, um, ou um aluno, zero.

    public static void alterPersonOrStudent(ArrayList<Person> list_of_people, ArrayList<Student> list_of_students, Scanner scanner, int index, int type) {

        int counter = 0;
        String answer, name, phone_number, birth_date, registration_date, last_update_date, final_grade;
        String[] text_1 = {

                "\nDesejas alterar o nome? (S/N): ",
                "\nDesejas alterar o número de telefone? (S/N): ",
                "\nDesejas alterar a data de nascimento? (S/N): ",
                "\nDesejas alterar a data de cadastro? (S/N): ",
                "\nDesejas alterar a última data de alteração? (S/N): ",

        };
        String[] text_2 = {

                "Insira o novo nome: ",
                "Insira o novo número de telefone: ",
                "Insira a nova data de nascimento: ",
                "Insira a nova data de cadastro: ",
                "Insira o nova última data de alteração: ",

        };

        for (String auxiliary_text : text_1) {

            System.out.print(auxiliary_text);
            answer = scanner.nextLine();

            if (auxiliary_alter(answer) == true) {

                switch (counter) {

                    case 0:

                        System.out.print(text_2[counter]);
                        name = scanner.nextLine();

                        if (type == 0) {

                            list_of_people.get(index - 1).setName(name);

                        }

                        else {

                            list_of_students.get(index - list_of_people.size() - 1).setName(name);

                        }

                        break;

                    case 1:

                        System.out.print(text_2[counter]);
                        phone_number = scanner.nextLine();

                        if (type == 0) {

                            list_of_people.get(index - 1).setPhoneNumber(phone_number);

                        }

                        else {

                            list_of_students.get(index - list_of_people.size() - 1).setPhoneNumber(phone_number);

                        }

                        break;

                    case 2:

                        System.out.print(text_2[counter]);
                        birth_date = scanner.nextLine();

                        if (type == 0) {

                            list_of_people.get(index - 1).setBirthDate(birth_date);

                        }

                        else {

                            list_of_students.get(index - list_of_people.size() - 1).setBirthDate(birth_date);

                        }

                        break;

                    case 3:

                        System.out.print(text_2[counter]);
                        registration_date = scanner.nextLine();

                        if (type == 0) {

                            list_of_people.get(index - 1).setRegistrationDate(registration_date);

                        }

                        else {

                            list_of_students.get(index - list_of_people.size() - 1)
                                    .setRegistrationDate(registration_date);

                        }

                        break;

                    case 4:

                        System.out.print(text_2[counter]);
                        last_update_date = scanner.nextLine();

                        if (type == 0) {

                            list_of_people.get(index - 1).setLastUpdateDate(last_update_date);

                        }

                        else {

                            list_of_students.get(index - list_of_people.size() - 1).setLastUpdateDate(last_update_date);
                            System.out.print("\nDesejas alterar a nota final do curso? (S/N): ");
                            answer = scanner.nextLine();

                            if (auxiliary_alter(answer) == true) {

                                System.out.print("Insira a nova nota final do curso: ");
                                final_grade = scanner.nextLine();
                                list_of_students.get(index - list_of_people.size() - 1).setFinalGrade(final_grade);

                            }

                        }

                        break;

                }

            }

            counter++;

        }

    }

    // Funçao auxiliar responsável por lidar com as respsotas do usuária na alteração de pessoas e alunos.
    // Ela retorna verdadeiro se a alteração será feita ou falso caso contrário.
    // Ela também retorna falso se a reposta for inválida, mas mostra no terminal que a resposta é inválida.

    public static boolean auxiliary_alter(String answer) {

        if (answer.equals("S")) {

            return true;

        }

        else if (!answer.equals("N")) {

            System.out.println("Resposta inválida.");
            return false;

        }

        return false;

    }

    // Função responsável por deleter uma pessoa ou um aluno da "lista" principal.
    // Ele recebe um 'input' do usário como índice da "lista" principal e calcula o índice equivalente nas listas secundárias.

    public static void deleteInformation(ArrayList<Person> list_of_people, ArrayList<Student> list_of_students, Scanner scanner) throws Exception {

        int index;

        try{

            if (!list_of_people.isEmpty() || !list_of_students.isEmpty()) {

                showList(list_of_people, list_of_students, scanner, 1);
                System.out.print("\nInsira o índice da pessoa ou de aluno que desejas deletar: ");
                index = scanner.nextInt();
                scanner.nextLine();

                if (!(index < 1 || index > list_of_people.size() + list_of_students.size())) {

                    if (index > list_of_people.size()) {

                        list_of_students.remove(index - list_of_people.size() - 1);

                    }

                    else {

                        list_of_people.remove(index - 1);

                    }

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

        }catch(InputMismatchException e){

            System.out.print("\nResposta inválida. ");
            scanner.nextLine();
            Thread.sleep(3000);

        }

    }

}