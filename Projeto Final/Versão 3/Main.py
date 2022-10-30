# INFORMATION ================================================================================================

# +PraTi/Alfamídia - Projeto Final: Versão 3 | Erick Larratéa Knoblich
# A terceira versão é uma versão bônus semelhante à versão dois.

# IMPORTS ====================================================================================================

import os, re, msvcrt as m
from Classes import Person, Student, Professor

# FUNCTIONS ==================================================================================================

def showMenu():

    print("+PraTi/Alfamídia - Projeto Final: Versão 3\n\n"
          "1. Criar uma pessoa, aluno ou professor e adicioná-lo à lista.\n"
          "2. Mostrar lista de pessoas, alunos e professores.\n"
          "3. Alterar propriedades de uma pessoa, aluno ou professor.\n"
          "4. Deletar uma pessoa, aluno ou professor da lista.\n"
          "5. Encerrar a aplicação.\n"
          "6. Adicionar exemplos à lista.\n")

# ------------------------------------------------------------------------------------------------------------

def addItemToList(list):

    texts = ["\nDesejas inserir uma nota final? Sim ou não? (S/N): ",
             "\nDesejas inserir uma matéria? Sim ou não? (S/N): "]
    name = checkName()
    id = checkId()
    phone_number = checkPhoneNumber()
    birth_date = checkBirthDate()

    if yesOrNoQuestion(texts[0], 0) is True:

        grade = checkGrade()
        list.append(Student(name, id, phone_number, birth_date, grade))

    else:

        if yesOrNoQuestion(texts[1], 0) is True:

            course = checkCourse()
            list.append(Professor(name, id, phone_number, birth_date, course))

        else:

            list.append(Person(name, id, phone_number, birth_date))

# ------------------------------------------------------------------------------------------------------------

def showList(list, identation):

    index = 1

    for object in list:

        if isinstance(object, Professor):

            print(str(index) + ". Professor: " + object.name + "\n")
            print(object.showObject() + "\n")

        elif isinstance(object, Student):

            print(str(index) + ". Aluno: " + object.name + "\n")
            print(object.showObject() + "\n")

        else:

            print(str(index) + ". Pessoa: " + object.name + "\n")
            print(object.showObject() + "\n")

        index += 1

    if identation == 0:

        print("Insira qualquer valor para encerrar a exibição.\n")
        m.getch()

# ------------------------------------------------------------------------------------------------------------

def updateItemOnList(list):

    try:

        texts = ["\nDesejas alterar o nome? Sim ou não? (S/N): ",
                 "\nDesejas alterar o número de CPF? Sim ou não? (S/N): ",
                 "\nDesejas alterar o número de telefone? Sim ou não? (S/N): ",
                 "\nDesejas alterar a data de nascimento? Sim ou não? (S/N): ",
                 "\nDesejas alterar a nota final? Sim ou não? (S/N): ",
                 "\nDesejas alterar a matéira? Sim ou não? (S/N): "]
        
        showList(list, 1)
        user_input = int(input("Insira o índice da pessoa, aluno ou professor que desejas alterar: "))
        index = user_input - 1
        object = list[index]
        os.system('cls||clear')
        print("Pessoa, aluno ou professor selecionado:\n\n" + object.showObject())

        if yesOrNoQuestion(texts[0], 1) is True:

            list[index].name = checkName()

        if yesOrNoQuestion(texts[1], 1) is True:

            list[index].id = checkId()
        if yesOrNoQuestion(texts[2], 1) is True:

            list[index].phone_number = checkPhoneNumber()

        if yesOrNoQuestion(texts[3], 1) is True:

            list[index].birth_date = checkBirthDate()

        if isinstance(object, Student):

            if yesOrNoQuestion(texts[4], 1) is True:

                list[index].grade = checkGrade()

        elif isinstance(object, Professor):

            if yesOrNoQuestion(texts[5], 1) is True:

                list[index].course = checkCourse()

    except (IndexError, ValueError):

        print("\nÍndice inválido. Insira qualquer valor para continuar.\n")
        m.getch()

# ------------------------------------------------------------------------------------------------------------

def removeItemOnList(list):

    try:
        
        showList(list, 1)
        user_input = input("Insira o índice do elemento que desejas deletar: ")
        list.pop(int(user_input) - 1)

    except (IndexError, ValueError):

        print("\nÍndice inválido. Insira qulquer valor para continuar.\n")
        m.getch()

# ------------------------------------------------------------------------------------------------------------

def addExamplesToList(list):

    list.append(Person("Pessoa Exemplo", "12345678910", "5551123456789", "01/01/2022"))
    list.append(Student("Aluno Exemplo", "12345678910", "5551123456789", "01/01/2022", "10"))
    list.append(Professor("Professor Exemplo", "12345678910", "5551123456789", "01/01/2022", "Programção C"))
    
    print("Exemplos foram adicionados. Insira qulquer valor para continuar.\n")
    m.getch()

# ------------------------------------------------------------------------------------------------------------

def yesOrNoQuestion(text, identation):

    answer = input(text)

    while not (answer == "S" or answer == "N"):
        
        if identation == 1:

            print("\nResposta inválida. Por favor, tente novamente.")
        
        else:
            
            print("Resposta inválida. Por favor, tente novamente.")
            
        answer = input(text)

    output = True if answer == "S" else False
    return output

# ------------------------------------------------------------------------------------------------------------

def checkList(list):
    
    if len(list) == 0:
        
        print("A lista está vazia. Insira qualquer valor para continuar.\n")
        m.getch()
        return False
    
    return True

# ------------------------------------------------------------------------------------------------------------

def checkName():

    name = input("Exemplo de nome: Fulano Sicrano Beltrano\nInsira o nome: ")
    if bool(re.match('[a-zA-Z\s]+$', name)) is True and not name.isspace(): return name
    print("Nome inválido. Por favor, tente novamente.\n")
    checkName()

# ------------------------------------------------------------------------------------------------------------

def checkId():
    
    try:
    
        id = input("\nExemplo de número de CPF: 012.345.678-90\nInsira o número de CPF: ")
        test_1 = len(id) == 14
        test_2 = id[0:3].isdigit() and id[4:7].isdigit() and id[8:11].isdigit() and id[12:14].isdigit()
        test_3 = id[3] == "." and id[7] == "." and id[11] == "-"
        
        if test_1 and test_2 and test_3: return id
        
        print("Número de CPF inválido. Por favor, tente novamente.\n")
        checkId()
    
    except IndexError:
        
        print("Número de CPF inválido. Por favor, tente novamente.\n")
        checkId()

# ------------------------------------------------------------------------------------------------------------

def checkPhoneNumber():

    phone_number = input("\nExemplo de número de telefone: 5551123456789\nInsira o número de telefone: ")
    if len(phone_number) == 13 and phone_number.isdigit(): return phone_number
    print("Número de telefone inválido. Por favor, tente novamente.\n")
    checkPhoneNumber()

# ------------------------------------------------------------------------------------------------------------

def checkBirthDate():
    
    try:

        birth_date = input("\nExemplo de data de aniversário: 01/01/2022\nInsira a data de aniversário: ")
        day = int(birth_date[0:2])
        month = int(birth_date[3:5])
        year = int(birth_date[6:10])
        test_1 = len(birth_date) == 10
        test_2 = birth_date[0:2].isdigit() and birth_date[3:5].isdigit() and birth_date[6:10].isdigit()
        test_3 = birth_date[2] == "/" and birth_date[5] == "/"
        test_4 = day >= 1 and day <= 31 and month >= 1 and month <= 12 and year >= 1
        test_5 = year % 4 == 0 and year % 100 != 0 or year % 4 == 0 and year % 100 == 0 and year % 400 == 0

        if test_1 and test_2 and test_3 and test_4:

            if (month == 4 or month == 6 or month == 9 or month == 11) and day != 31: return birth_date
            if month != 2 and month != 4 and month != 6 and month != 9 and month != 11: return birth_date
            if day <= 28 or day <= 29 and test_5: return birth_date

        print("Data de aniverário inválida. Por favor tente novamente.\n")
        checkBirthDate()
    
    except IndexError:
        
        print("Data de aniverário inválida. Por favor tente novamente.\n")
        checkBirthDate()
        
# ------------------------------------------------------------------------------------------------------------

def checkGrade():

    try:

        grade = input("\nExemplo de nota: 0 <= x <= 10\nInsira a nota: ")
        if 0 <= float(grade) <= 10: return grade
        print("Nota inválida. Por favor, tente novamente.\n")
        checkGrade()

    except ValueError:
        
        print("Nota inválida. Por favor, tente novamente.\n")
        checkGrade()

# ------------------------------------------------------------------------------------------------------------

def checkCourse():

    try:
        
        index = int(input("\nInsira o índcice correspondente à matéria.\n\n"
                          "1. Programação C\n"
                          "2. Programação C++\n"
                          "3. Programação C#\n"
                          "4. Programação Python\n"
                          "5. Programação Java\n"
                          "6. Programação Haskell\n\n"
                          "Insira o índcice: "))

        map = {"1" : "Programação C",
               "2" : "Programação C++",
               "3" : "Programação C#",
               "4" : "Programção Python",
               "5" : "Programação Java",
               "6" : "Programação Haskell"}

        return map[index]
    
    except (IndexError, ValueError):
        
        print("Índcice inválido. Por favor, tente novamente.\n")
        checkCourse()

# MAIN PROGRAM ===============================================================================================

end_application = False
list = []

while end_application is False:

    os.system('cls||clear')
    showMenu()
    user_input = input("Insira a sua opção: ")
    os.system('cls||clear')
    print("Opção selecionada: " + user_input + "\n")

    match user_input:

        case "1":
            
            addItemToList(list)

        case "2":
            
            if checkList(list): showList(list, 0)

        case "3":
            
            if checkList(list): updateItemOnList(list)

        case "4":
            
            if checkList(list): removeItemOnList(list)

        case "5":
            
            end_application = True

        case "6":
            
            addExamplesToList(list)

        case other:

            print("Opção inválida. Insira qualquer valor para continuar.\n")
            m.getch()

print("A aplicação foi encerrada.")