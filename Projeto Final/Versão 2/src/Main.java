// +PraTi/Alfamídia - Projeto Final Versão 2
// Erick Larratéa Knoblich

// A segunda versão utiliza padrões para todos os parâmetros das pessoas e dos alunos, exceto o nome.
// Ela é uma versão mais complexa e mais completa.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;

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

                    addItem(list, scanner);
                    break;

                case "2":

                    showList(list, scanner, 0);
                    break;

                case "3":

                    alterList(list, scanner);
                    break;

                case "4":

                    removeItem(list, scanner);
                    break;

                case "5":

                    end_application = true;
                    break;

                default:

                    System.out.print("Resposta inválida. Por favor, tente novamente. ");
                    Thread.sleep(3000);

            }

        }

        scanner.close();
        System.out.println("A aplicação foi encerrada.");

    }

    // Função responsável por mostratr o menu a cada iteração para o usuário.

    public static void showMenu() {

        System.out.print(

                "+PraTi/Alfamídia - Projeto Final: Versão 2\n\n"
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

    // Função responsável por adicionar pessoas ou alunos à lista.
    // Ela recebe 'input' do usuário para cada parâmetro da pessoa ou aluno.
    // Ela pergunta se o usuário quer acrescentar uma nota final de curso.
    // A reposta para a nota final de curso determina se uma pessoa ou um aluno é criado.

    public static void addItem(ArrayList<Person> list, Scanner scanner) {

        int index;
        boolean auxiliary = false;
        String answer = "", name = "", phone_number = "", birth_date = "", registration_date = "", last_update_date = "", final_grade = "";
        String[] text = {"Exemplo de nome: Fulano Sicrano Beltrano\nInsira o nome: ",
                         "\nExemplo de número de telefone: 5551123456789\nInsira o número de telefone: ",
                         "\nExemplo de data de nascimento: 01/01/2001\nInsira a data de nascimento: ",
                         "\nExemplo de data de cadastro: 01/01/2001\nInsira a data de cadastro: ",
                         "\nExemplo de última data de alteração: 01/01/2001\nInsira a data da última alteração: ",
                         "\nDesejas inserir uma nota final de curso? Sim ou não? (S/N): ",
                         "\nExemplo de nota final do curso: 0 <= x <= 10\nInsira a nota final do curso: "};

        for (index = 0; index <= 4; index++){

            auxiliary = false;
            System.out.print(text[index]);

            switch (index){

                case 0:

                    name = scanner.nextLine();
                    break;

                case 1:

                    while (auxiliary == false){

                        phone_number = scanner.nextLine();
                        auxiliary = checkPhoneNumber(phone_number);

                        if (auxiliary == false){
                            
                            System.out.println("Número de telefone inválido. Por favor, tente novamente. ");
                            System.out.print(text[index]);

                        } 

                    }

                    break;

                case 2:

                    while (auxiliary == false){

                        birth_date = scanner.nextLine();
                        auxiliary = checkDate(birth_date);

                        if (auxiliary == false){

                            System.out.println("Data inválida. Por favor, tente novamente. ");
                            System.out.print(text[index]);

                        }

                    }

                    break;

                case 3:

                    while (auxiliary == false){

                        registration_date = scanner.nextLine();
                        auxiliary = checkDate(registration_date);

                        if (auxiliary == false){
 
                            System.out.println("Data inválida. Por favor, tente novamente. ");
                            System.out.print(text[index]);

                        }
                    }

                    break;

                case 4:

                    while (auxiliary == false){

                        last_update_date = scanner.nextLine();
                        auxiliary = checkDate(last_update_date);
                        
                        if (auxiliary == false){
                           
                            System.out.println("Data inválida. Por favor, tente novamente. ");
                            System.out.print(text[index]);

                        }                        

                    }

                    break;

            }

        }

        auxiliary = false;

        while (!(answer.equals("S") || answer.equals("N"))){

            System.out.print(text[5]);
            answer = scanner.nextLine();

            if (answer.equals("N")) {

                list.add(new Person(name, phone_number, birth_date, registration_date, last_update_date));

            }

            else if (answer.equals("S")) {

                while (auxiliary == false){

                    System.out.print(text[6]);
                    final_grade = scanner.nextLine();
                    auxiliary = checkFinalGrade(final_grade);

                    if (auxiliary == false){

                        System.out.println("Nota final de curso inválida. Por favor, tente novamente. ");

                    }

                }

                list.add(new Student(name, phone_number, birth_date, registration_date, last_update_date, final_grade));

            }

            else {

                System.out.println("Resposta inválida. Por favor, tente novamente. ");

            }

        }

    }

    // Função responsável por determinar se o número de telefone é válido.
    // Ele precisa ter treze dígitos e ser um número inteiro.
    
    public static boolean checkPhoneNumber(String phone_number){

        try{

            if (phone_number.length() == 13){

                Long.parseLong(phone_number);
                return true;

            }

            else{

                return false;

            }

        }catch(NumberFormatException e){

            return false;

        }

    }

    // Função responsável por determinar se a data é válida.
    // Ela precisa seguir o calendário gregoriano.

    public static boolean checkDate(String date){

        try{

            if (date.length() == 10){

                int day = Integer.parseInt(date.substring(0, 2));
                int month = Integer.parseInt(date.substring(3, 5));
                int year = Integer.parseInt(date.substring(6, 10));

                if (day < 1 || month < 1 || month > 12 || year < 1){

                    return false;

                }

                else if(month == 2 && day < 29){

                    return true;

                }

                else if(month == 4 || month == 6 || month == 9 || month == 11){

                    if (day < 31){

                        return true;

                    }

                    else{

                        return false;

                    }

                }

                else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){

                    if (day < 32){

                        return true;

                    }

                    else{

                        return false;

                    }

                }

                else{

                    return false;

                }

            }

            else{

                return false;

            }

        }catch(NumberFormatException e){

            return false;

        }

    }

    // Função responsável por determinar se nota final do curso é válida.
    // Ela precisa ser um número real entre zero e dez, ambos inclusos.
    // Apenas os dois primeiros dígitos da expansão decimal são considerados na hora de exibição, sem arredondamento.

    public static boolean checkFinalGrade(String final_grade){

        try{

            if (Float.parseFloat(final_grade) >= 0 && Float.parseFloat(final_grade) <= 10){

                return true;

            }

            else{

                return false;

            }
        
        }catch(NumberFormatException e){

            return false;

        }

    }

    // Função responsável por mostrar as pessoas e os alunos da lista na ordem em que foram acrescentados.
    // Ela usa um contador para listar os índices das pessoas e dos alunos.
    // Ela tem um inteiro 'type', que determina se o usuário escolheu a opção dois, de apenas mostrar a lista, ou...
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

    // Função principal responsável por alterar os parâmetros das pessoas e dos alunos.
    // As pessoas e os alunos são alteradas numa função secundária.

    public static void alterList(ArrayList<Person> list, Scanner scanner) throws Exception {

        int index;

        try {

            if (!list.isEmpty()) {

                showList(list, scanner, 1);
                System.out.print("\nInsira o índice da pessoa ou do aluno que desejas deletar: ");
                index = scanner.nextInt();
                scanner.nextLine();

                if (!(index < 1 || index > list.size())) {

                    alterItem(list.get(index - 1), scanner);

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

    // Função secundária responsável por alterar os parâmetros das pessoas e dos alunos.
    // Ela pergunta se o usário quer alterar cada um dos parâmetros.
    // Ela utuliza dois vetores de 'Strings' para ter um código mais limpo.

    public static void alterItem(Person item, Scanner scanner) {

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

        for (int index = 0; index <= 4; index++) {

            System.out.print(text_1[index]);
            answer = scanner.nextLine();

            if (auxiliary_alter(answer) == true) {

                switch (index) {

                    case 0:

                        System.out.print(text_2[index]);
                        name = scanner.nextLine();
                        item.setName(name);

                        break;

                    case 1:

                        System.out.print(text_2[index]);
                        phone_number = scanner.nextLine();
                        item.setPhoneNumber(phone_number);

                        break;

                    case 2:

                        System.out.print(text_2[index]);
                        birth_date = scanner.nextLine();
                        item.setBirthDate(birth_date);

                        break;

                    case 3:

                        System.out.print(text_2[index]);
                        registration_date = scanner.nextLine();
                        item.setRegistrationDate(registration_date);

                        break;

                    case 4:

                        System.out.print(text_2[index]);
                        last_update_date = scanner.nextLine();
                        item.setLastUpdateDate(last_update_date);

                        break;

                }

            }

        }

        if (item instanceof Student){

            System.out.print(text_1[5]);
            answer = scanner.nextLine();

            if (auxiliary_alter(answer) == true) {

                System.out.print(text_2[5]);
                final_grade = scanner.nextLine();
                ((Student) item).setFinalGrade(final_grade);

            }
            
        }

    }

    // Funçao auxiliar responsável por lidar com as respsotas do usuário na alteração das pessoas e dos alunos.
    // Ela retorna verdadeiro se a alteração será feita ou falso caso contrário.
    // Ela também retorna falso se a reposta for inválida, mas mostra no terminal que a resposta é inválida.

    public static boolean auxiliary_alter(String answer) {

        if (answer.equals("S")) {

            return true;

        }

        else if (!answer.equals("N")) {

            System.out.println("Resposta inválida. O parâmetro não foi alterado. ");
            return false;

        }

        return false;

    }

    // Função responsável por deleter uma pessoa ou um aluno da lista.
    // Ele recebe um 'input' índice da lista e então calcula o índice equivalente.

    public static void removeItem(ArrayList<Person> list, Scanner scanner) throws Exception {

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

}