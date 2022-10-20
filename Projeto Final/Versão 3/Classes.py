# CLASSSES ===================================================================================================

class Person:

    def __init__(self, name, id, phone_number, birth_date):

        self.name = name
        self.id = id
        self.phone_number = phone_number
        self.birth_date = birth_date

    def showElement(self):

        return self.name + "\n" + self.id + "\n" + self.phone_number + "\n" + self.birth_date

class Student(Person):

    def __init__(self, name, id, phone_number, birth_date, final_grade):

        super().__init__(name, id, phone_number, birth_date)
        self.final_grade = final_grade

    def showElement(self):

        return super().showElement() + "\n" + self.final_grade

class Professor(Person):

    def __init__(self, name, id, phone_number, birth_date, subject):

        super().__init__(name, id, phone_number, birth_date)
        self.subject = subject

    def showElement(self):

        return super().showElement() + "\n" + self.subject