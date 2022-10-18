import Classes
import sys, os
import msvcrt as m

# FUNÇÕES ============================================================

def showMenu():

    print(
        
        "SENAC TECH - PROJETO\n\n"
        "1. Criar um elemento.\n"
        "2. Mostrar lista de elementos.\n"
        "3. Alterar propriedades de um elemento.\n"
        "4. Deletar um elemento.\n"
        "5. Encerrar aplicação.\n"
        
        )

# --------------------------------------------------------------------

def selectedOption(user_input):

    global end_application

    if user_input == "1":

        createElement()

    elif user_input == "2":

        showElements()

    elif user_input == "3":

        alterElement()

    elif user_input == "4":

        deleteElement()

    elif user_input == "5":

        end_application = True
    
    else:

        print("Opção inválida. Insira qualquer valor para continuar.\n")
        m.getch()

# --------------------------------------------------------------------

def createElement():

    global list_of_elements

    texts = ["Desejas inserir uma nota final? Sim ou não? (S/N): ",
             "Desejas inserir uma matéria? Sim ou não? (S/N): "]
    name = input("Insira o nome: ")
    id = input("Insira o número de CPF: ")
    phone_number = input("Insira o número de telefone: ")
    birth_date = input("Insira a data de aniversário: ")
    answer = yesOrNoQuestion(texts[0])

    if answer is True:

        final_grade = input("Insira a nota final: ")
        list_of_elements.append(Classes.Student(name, id, phone_number, birth_date, final_grade))

    else:

        answer = yesOrNoQuestion(texts[1])

        if answer is True:

            subject = input("Insira a matéria: ")
            list_of_elements.append(Classes.Professor(name, id, phone_number, birth_date, subject))

        else:

            list_of_elements.append(Classes.Person(name, id, phone_number, birth_date))

def showElements():

    global list_of_elements
    index = 1

    for element in list_of_elements:

        print(str(index) + ". " + element.name + "\n")
        print(element.showElement())

    print("Insira qualquer valor para encerrar a exibição de elementos.\n")
    m.getch()



def alterElement():

    print("PIZZA")

def deleteElement():

    print("PIZZA")

def yesOrNoQuestion(text):

    user_input = input(text)

    while not (user_input == "S" or user_input == "N"):

        print("Resposta inválida. Por favor, tente novamente. ")
        user_input = input(text)

    output = True if (user_input == "S") else False
    return output

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

