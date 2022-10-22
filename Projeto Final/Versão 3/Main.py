# IMPORTS ====================================================================================================

import os, re
import msvcrt as m

# CLASSSES ===================================================================================================

class Person:

    def __init__(self, name, id, phone_number, birth_date):

        self.name = name
        self.id = id
        self.phone_number = phone_number
        self.birth_date = birth_date

    def showObject(self):

        information = ["Nome: " + self.name + "\n" +
                       "Número de CPF: " + self.id + "\n" +
                       "Número de telefone: " + self.phone_number + "\n" +
                       "Data de nascimento: " + self.birth_date]
                    
        return information[0]

# ------------------------------------------------------------------------------------------------------------

class Student(Person):

    def __init__(self, name, id, phone_number, birth_date, grade):

        super().__init__(name, id, phone_number, birth_date)
        self.grade = grade

    def showObject(self):

        return super().showObject() + "\n" + "Nota: " + self.grade

# ------------------------------------------------------------------------------------------------------------

class Professor(Person):

    def __init__(self, name, id, phone_number, birth_date, course):

        super().__init__(name, id, phone_number, birth_date)
        self.course = course

    def showObject(self):

        return super().showObject() + "\n" + "Matéria: " + self.course

# FUNCTIONS ==================================================================================================

def showMenu():

    print("SENAC TECH - PROJETO\n\n"
          "1. Criar um elemento.\n"
          "2. Mostrar lista de elementos.\n"
          "3. Alterar propriedades de um elemento.\n"
          "4. Deletar um elemento.\n"
          "5. Encerrar aplicação.\n")

# ------------------------------------------------------------------------------------------------------------

def addElementToList(list):

    texts = ["\nDesejas inserir uma nota final? Sim ou não? (S/N): ",
             "\nDesejas inserir uma matéria? Sim ou não? (S/N): "]
    name = checkProperty("Name")
    id = checkProperty("Id")
    phone_number = checkProperty("Phone Number")
    birth_date = checkProperty("Birth Date")

    if yesOrNoQuestion(texts[0], 0) is True:

        grade = checkProperty("Grade")
        list.append(Student(name, id, phone_number, birth_date, grade))

    else:

        if yesOrNoQuestion(texts[1], 0) is True:

            course = checkProperty("Course")
            list.append(Professor(name, id, phone_number, birth_date, course))

        else:

            list.append(Person(name, id, phone_number, birth_date))

# ------------------------------------------------------------------------------------------------------------

def showList(list, identation):

    if len(list) != 0:

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

    else:

        print("A lista está vazia. Insira qualquer valor para continuar.\n")
        m.getch()

# ------------------------------------------------------------------------------------------------------------

def updateItemOnList(list):

    if len(list) != 0:

        texts = ["\nDesejas alterar o nome? Sim ou não? (S/N): ",
                "\nDesejas alterar o número de CPF? Sim ou não? (S/N): ",
                "\nDesejas alterar o número de telefone? Sim ou não? (S/N): ",
                "\nDesejas alterar a data de nascimento? Sim ou não? (S/N): ",
                "\nDesejas alterar a nota final? Sim ou não? (S/N): ",
                "\nDesejas alterar a cadeira? Sim ou não? (S/N): "]

        showList(list, 1)
        user_input = input("Insira o índice do elemento que desejas alterar: ")

        if user_input.isdigit() and int(user_input) > 0 and int(user_input) <= len(list):

            os.system('cls||clear')
            index = int(user_input) - 1
            object = list[index]
            print("Objeto selecionado:\n\n" + object.showElement())

            if yesOrNoQuestion(texts[0], 1) is True:

                list[index].name = checkProperty("Name")

            if yesOrNoQuestion(texts[1], 1) is True:

                list[index].id = checkProperty("Id")

            if yesOrNoQuestion(texts[2], 1) is True:

                list[index].phone_number = checkProperty("Phone Number")

            if yesOrNoQuestion(texts[3], 1) is True:

                list[index].birth_date = checkProperty("Birth Date")

            if isinstance(object, Student):

                if yesOrNoQuestion(texts[4], 1) is True:

                    list[index].grade = checkProperty("Grade")

            elif isinstance(object, Professor):

                if yesOrNoQuestion(texts[5], 1) is True:

                    list[index].course = checkProperty("Course")

        else: 

            print("\nÍndice inválido. Insira qulquer valor para continuar.\n")
            m.getch()

    else:

        print("A lista está vazia. Insira qualquer valor para continuar.\n")
        m.getch()

# ------------------------------------------------------------------------------------------------------------

def removeItemOnList(list):

    if len(list) != 0:

        showList(list, 1)
        user_input = input("Insira o índice do elemento que desejas deletar: ")

        if user_input.isdigit() and int(user_input) > 0 and int(user_input) <= len(list):

            list.pop(int(user_input) - 1)

        else: 

            print("\nÍndice inválido. Insira qulquer valor para continuar.\n")
            m.getch()

    else:

        print("A lista está vazia. Insira qualquer valor para continuar.\n")
        m.getch()

# ------------------------------------------------------------------------------------------------------------

def yesOrNoQuestion(text, identation):

    answer = input(text)
    if identation == 1: print()

    while not (answer == "S" or answer == "N"):

        print("Resposta inválida. Por favor, tente novamente.")
        answer = input(text)
        if identation == 1: print()

    output = True if answer == "S" else False
    return output

# ------------------------------------------------------------------------------------------------------------

def checkProperty(property_type):

    acceptance = False

    if property_type != "Name": print()

    while acceptance is False:

        if property_type == "Name":

            acceptance, property = checkName()

        elif property_type == "Id":

            acceptance, property = checkId()

        elif property_type == "Phone Number":

            acceptance, property = checkPhoneNumber()

        elif property_type == "Birth Date":

            acceptance, property = checkBirthDate()

        elif property_type == "Grade":

            acceptance, property = checkGrade()

        else:

            acceptance, property = checkCourse()

        if acceptance is False:

            print("Resposta inválida. Por favor, tente novamente.\n")

    return property

# ------------------------------------------------------------------------------------------------------------

def checkName():

    name = input("Exemplo de nome: Fulano Sicrano Beltrano\nInsira nome: ")
    acceptance = True if bool(re.match('[a-zA-Z\s]+$', name)) is True and not name.isspace() else False
    return acceptance, name

# ------------------------------------------------------------------------------------------------------------

def checkId():

    id = input("Exemplo de número de CPF: 01234567890\nInsira o novo número de CPF: ")
    acceptance = True if len(id) == 11 and id.isdigit() else False
    return acceptance, id

# ------------------------------------------------------------------------------------------------------------

def checkPhoneNumber():

    phone_number = input("Exemplo de número de telefone: 5551123456789\nInsira o número de telefone: ")
    acceptance = True if len(phone_number) == 13 and phone_number.isdigit() else False
    return acceptance, phone_number

# ------------------------------------------------------------------------------------------------------------

def checkBirthDate():

    birth_date = input("Exemplo de data de aniversário: 01/01/2022\nInsira a data de aniversário: ")

    if len(birth_date) == 10:
        
        if birth_date[0:2].isdigit() and birth_date[3:5].isdigit() and birth_date[6:10].isdigit():

            if birth_date[2] == "/" and birth_date[5] == "/":

                day = int(birth_date[0:2])
                month = int(birth_date[3:5])
                year = int(birth_date[6:10])

                if day > 0 and month > 0 and month < 13 and year > 0:

                    if month == 4 or month == 6 or month == 9 or month == 11:

                        acceptance = True if day < 31 else False
                        return acceptance, birth_date

                    if month == 2:

                        if year % 4 == 0 and year % 100 != 0 or year % 4 == 0 and year % 100 == 0 and year % 400 == 0:

                            acceptance = True if day < 30 else False
                            return acceptance, birth_date

                        acceptance = True if day < 29 else False
                        return acceptance, birth_date

                    acceptance = True if day < 32 else False
                    return acceptance, birth_date

    return False, None

# ------------------------------------------------------------------------------------------------------------

def checkGrade():

    try:

        grade = input("Exemplo de nota: 0 <= x <= 10\nInsira a nota: ")
        acceptance = True if 0 <= float(grade) <= 10 else False
        return acceptance, grade

    except ValueError: return False, None

# ------------------------------------------------------------------------------------------------------------

def checkCourse():

    index = input("Insira o valor correspondente à matéria.\n\n"
                  "1. Programação C\n"
                  "2. Programação C++\n"
                  "3. Programação C#\n"
                  "4. Programação Python\n"
                  "5. Programação Java\n"
                  "6. Programação Haskell\n\n"
                  "Insira o valor: ")

    if not index.isdigit() or int(index) < 1 or int(index) > 6: return False, None

    map = {"1" : "Programação C", "2" : "Programação C++", "3" : "Programação C#",
           "4" : "Programção Python", "5" : "Programação Java", "6" : "Programação Haskell"}

    return True, map[index]

# MAIN PROGRAM ===============================================================================================

end_application = False
list = []

list.append(Person("Person", "11111111111", "1111111111111", "01/01/2000"))
list.append(Student("Student", "11111111111", "1111111111111", "01/01/2000", "10"))
list.append(Professor("Professor", "11111111111", "1111111111111", "01/01/2000", "Programação C#"))
list.append(Student("Student", "11111111111", "1111111111111", "01/01/2000", "5.2"))

while end_application == False:

    os.system('cls||clear')
    showMenu()
    user_input = input("Insira a sua opção: ")
    os.system('cls||clear')
    print("\nOpção selecionada: " + user_input + "\n")

    if user_input == "1":

        addElementToList(list)

    elif user_input == "2":

        showList(list, 0)

    elif user_input == "3":

        updateItemOnList(list)

    elif user_input == "4":

        removeItemOnList(list)

    elif user_input == "5":

        end_application = True

    else:

        print("Opção inválida. Insira qualquer valor para continuar.\n")
        m.getch()

print("A aplicação foi encerrada.")