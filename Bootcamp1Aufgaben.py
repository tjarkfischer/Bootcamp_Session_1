def FizzBuzz():
    for i in range(1, 101):
        if i % 3 == 0 and i % 5 == 0:
            print("FizzBuzz")
        elif i % 3 == 0:
            print("Fizz")
        elif i % 5 == 0:
            print("Buzz")
        else:
            print(i)

def  Stringcalculator():
    first_number = int(input("Erste Zahl: \n"))
    second_number = int(input("Zweite Zahl: \n"))

    print(f"Das Ergebnis lautet: {first_number + second_number}")

Stringcalculator()