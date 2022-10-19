class Person:

    def __init__(self, name, id, phone_number, birth_date):

        self.name = name
        self.id = id
        self.phone_number = phone_number
        self.birth_date = birth_date

    def showElement(self):

        print(str(self.name) + "\n" + str(self.id) + "\n" + str(self.phone_number) + "\n" + str(self.birth_date))

class Student(Person):

    def __init__(self, name, phone_number, birth_date, final_grade):

        super().__init__(name, phone_number, birth_date)
        self.final_grade = final_grade

    def showElement(self):

        super().showElement
        print("\n" + str(self.final_grade))

class Professor(Person):

    def __init__(self, name, id, phone_number, birth_date, subject):

        super().__init__(name, id, phone_number, birth_date)
        self.subject = subject

    def showElement(self):

        super().showElement
        print("\n" + str(self.subject))