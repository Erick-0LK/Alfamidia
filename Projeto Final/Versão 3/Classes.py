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