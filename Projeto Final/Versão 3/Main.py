import sys, os, re
import Classes
import msvcrt as m

# FUNCTIONS ==================================================================================================

def showMenu():

    print(
        
        "SENAC TECH - PROJETO\n\n"
        "1. Criar um elemento.\n"
        "2. Mostrar lista de elementos.\n"
        "3. Alterar propriedades de um elemento.\n"
        "4. Deletar um elemento.\n"
        "5. Encerrar aplicação.\n"
        
        )

# ------------------------------------------------------------------------------------------------------------

def selectedOption(user_input):

    global end_application

    if user_input == "1":

        createElement()

    elif user_input == "2":

        showElements(0)

    elif user_input == "3":

        alterElement()

    elif user_input == "4":

        deleteElement()

    elif user_input == "5":

        end_application = True
    
    else:

        print("Opção inválida. Insira qualquer valor para continuar.\n")
        m.getch()

# ------------------------------------------------------------------------------------------------------------

def createElement():

    global list_of_elements

    texts = ["\nDesejas inserir uma nota final? Sim ou não? (S/N): ",
             "\nDesejas inserir uma matéria? Sim ou não? (S/N): "]
    name = input("Insira o nome: ")
    id = input("\nInsira o número de CPF: ")
    phone_number = input("\nInsira o número de telefone: ")
    birth_date = input("\nInsira a data de aniversário: ")

    if yesOrNoQuestion(texts[0]) is True:

        final_grade = input("\nInsira a nota final: ")
        list_of_elements.append(Classes.Student(name, id, phone_number, birth_date, final_grade))

    else:

        if yesOrNoQuestion(texts[1]) is True:

            subject = input("\nInsira a matéria: ")
            list_of_elements.append(Classes.Professor(name, id, phone_number, birth_date, subject))

        else:

            list_of_elements.append(Classes.Person(name, id, phone_number, birth_date))

# ------------------------------------------------------------------------------------------------------------

def showElements(type):

    global list_of_elements
    index = 1

    if not len(list_of_elements) == 0:

        for element in list_of_elements:

            if isinstance(element, Classes.Professor):

                print(str(index) + ". Professor: " + element.name + "\n")
                print(element.showElement() + "\n")

            elif isinstance(element, Classes.Student):

                print(str(index) + ". Aluno: " + element.name + "\n")
                print(element.showElement() + "\n")

            else:

                print(str(index) + ". Pessoa: " + element.name + "\n")
                print(element.showElement() + "\n")

            index += 1

        if type == 0:

            print("Insira qualquer valor para encerrar a exibição.\n")
            m.getch()

    else:

        print("A lista está vazia. Insira qualquer valor para continuar.\n")
        m.getch()

# ------------------------------------------------------------------------------------------------------------

def alterElement():

    global list_of_elements

    texts = ["\nDesejas alterar o nome? Sim ou não? (S/N): ",
               "\nDesejas alterar o número de CPF? Sim ou não? (S/N): ",
               "\nDesejas alterar o número de telefone? Sim ou não? (S/N): ",
               "\nDesejas alterar a data de nascimento? Sim ou não? (S/N): ",
               "\nDesejas alterar a nota final? Sim ou não? (S/N): ",
               "\nDesejas alterar a cadeira? Sim ou não? (S/N): "]

    showElements(1)
    user_input = input("Insira o índice do elemento que desejas alterar: ")

    if user_input.isdigit() and int(user_input) > 0 and int(user_input) <= len(list_of_elements):

        index = int(user_input) - 1

        if yesOrNoQuestion(texts[0]) is True:

            list_of_elements[index].name = checkName()

        if yesOrNoQuestion(texts[1]) is True:

            list_of_elements[index].id = checkId()

        if yesOrNoQuestion(texts[2]) is True:

            list_of_elements[index].phone_number = checkPhoneNumber()

        if yesOrNoQuestion(texts[3]) is True:

            list_of_elements[index].birth_date = checkBirthDate()

        if isinstance(list_of_elements[int(user_input) - 1], Classes.Student):

            if yesOrNoQuestion(texts[4]) is True:

                print("hi")



        elif isinstance(list_of_elements[int(user_input) - 1], Classes.Professor):

            if yesOrNoQuestion(texts[4]) is True:

                print("hi")



    else: 

        print("\nÍndice inválido. Insira qulquer valor para continuar.\n")
        m.getch()

# ------------------------------------------------------------------------------------------------------------

def checkName():

    global list_of_elements

    while True:

        print("Exemplo de nome: Fulano Sicrano Beltrano")
        name = input("Insira o novo nome: ")

        if bool(re.match('[a-zA-Z\s]+$', name)) is True and name.isspace() is False:

            break

        else:

            print("Nome inválido. Por favor, tente novamente.\n")

    return name

# ------------------------------------------------------------------------------------------------------------

def checkId():

    global list_of_elements

    while True:

        print("Exemplo de número de CPF: 01234567890")
        id = input("Insira o novo número de CPF: ")

        if len(id) == 11 and id.isdigit():

            break

        else:

            print("Número de CPF inválido. Por favor, tente novamente.\n")

    return id

# ------------------------------------------------------------------------------------------------------------

def checkPhoneNumber():

    global list_of_elements

    while True:

        print("Exemplo de número de telefone: 5551123456789")
        phone_number = input("Insira o novo número de telefone: ")

        if len(phone_number) == 13 and phone_number.isdigit():

            break

        else:

            print("Número de telefone inválido. Por favor, tente novamente.\n")

    return phone_number

# ------------------------------------------------------------------------------------------------------------

def checkBirthDate():

    global list_of_elements

    while True:

        print("Exemplo de data de aniversário: 01/01/2022")
        birth_date = input("Insira o novo número de telefone: ")

        if len(birth_date) == 10:
            
            if birth_date[0:2].isdigit() and birth_date[3:5].isdigit() and birth_date[6:10].isdigit():

                if birth_date[2] == "/" and birth_date[5] == "/":

                    day = int(birth_date[0:2])
                    month = int(birth_date[3:5])
                    year = int(birth_date[6:10])

                    if day > 0 and month > 0 and month < 13 and year > 0:

                        if month == 4 or month == 6 or month == 9 or month == 11:

                            if day < 31:

                                return birth_date

                        elif month == 2:

                            if year % 4 == 0 and year % 100 != 0 or year % 4 == 0 and year % 100 == 0 and year % 400 == 0:

                                if day < 30:

                                    return birth_date

                            elif day < 29:

                                return birth_date

                        else:

                            if day < 32:

                                return birth_date

            print("Data de aniversário inválida. Por favor, tente novamente.\n")                  

        else:

            print("Data de aniversário inválida. Por favor, tente novamente.\n")

# ------------------------------------------------------------------------------------------------------------

def deleteElement():

    global list_of_elements

    showElements(1)
    user_input = input("Insira o índice do elemento que desejas deletar: ")

    if user_input.isdigit() and int(user_input) > 0 and int(user_input) <= len(list_of_elements):

        list_of_elements.pop(int(user_input) - 1)

    else: 

        print("\nÍndice inválido. Insira qulquer valor para continuar.\n")
        m.getch()

def yesOrNoQuestion(text):

    user_input = input(text)

    while not (user_input == "S" or user_input == "N"):

        print("Resposta inválida. Por favor, tente novamente.")
        user_input = input(text)

    output = True if (user_input == "S") else False
    return output

# MAIN PROGRAM ===============================================================================================

end_application = False
list_of_elements = []

os.system('cls||clear')

while end_application == False:

    os.system('cls||clear')
    showMenu()
    user_input = input("Insira a sua opção: ")
    os.system('cls||clear')
    print("\nOpção selecionada: " + user_input + "\n")
    selectedOption(user_input)

print("A aplicação foi encerrada.")