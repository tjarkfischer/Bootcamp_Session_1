"""
Tasks of Kevin for the Tech-Bootcamp 2024
"""


"""
FizzBuzz
"""
def fizzbuzz() -> None:
    cap: int = 0
    while True:
        try:
            cap: int = int(str.strip(input("Give me a range: ")))
            break
        except ValueError:
            print("Not a number, please try again!")
            continue

    for i in range(cap):
        if i % 3 == 0:
            print("Fizz")
        elif i % 5 == 0:
            print("Buzz")
        elif i % 3 == 0 and i % 5 == 0:
            print("FizzBuzz")
        else:
            print(i)


"""
Fibonacci
"""
def fibonacci() -> None:
    lastlast: int = 0
    last: int = 1

    print(lastlast)
    print(last)

    cap: int = 0
    while True:
        try:
            cap = int(str.strip(input("Give me a range: ")))
            break
        except ValueError:
            print("Not a number, please try again!")
            continue

    for i in range(cap):
        new: int = last + lastlast
        lastlast = last
        last = new

        print(new)


"""
Stringculator
"""
def stringculator() -> None:
    while True:
        try:
            first: int = int(str.strip(input("Give me a number: ")))
            second: int = int(str.strip(input("Give me a second number: ")))
            operation: str = str.strip(input("Give me an operation sign [+, -, *, /, %]: "))
        except ValueError:
            print("Not a number, please try again!")
            continue

        if operation == "+":
            print(f"Their sum is: {first + second}")
        elif operation == "-":
            print(f"Their difference is: {first - second}")
        elif operation == "*":
            print(f"Their product is: {first * second}")
        elif operation == "*":
            print(f"Their quotient is: {first / second}")
        elif operation == "%":
            print(f"Their remainer is: {first % second}")
        else:
            print("Not an operator, please try again!")
            continue

        break


"""
Stringionary
"""
def stringionary() -> None:
    phrase: str = input("Give me a phrase: ").strip()

    chars: dict[str, int] = {
        "lowercase": 0,
        "uppercase": 0,
        "number": 0,
        "whitespace": 0,
    }

    for char in phrase:
        if char.islower():
            chars["lowercase"] += 1
        elif char.isupper():
            chars["uppercase"] += 1
        elif char.isdecimal():
            chars["number"] += 1
        elif char.isspace():
            chars["whitespace"] += 1

    for area, number in chars.items():
        print(f"{area.capitalize()}: {number}")


"""
Modulonary
"""
def modulonary() -> None:
    cap: int = 0
    while True:
        try:
            cap: int = int(str.strip(input("Give me a range: ")))
            break
        except ValueError:
            print("Not a number, please try again!")
            continue

    for i in range(cap):
        if i % 2 == 0:
            print(f"{i} is even")
        else:
            print(f"{i} is odd")


"""
Getraenkeautomat
"""
def getraenkeautomat() -> None:
    drinks: list[str] = ["Cola", "Spezi", "RedBull"]

    print("Welcome! What drink can I serve you?")
    i: int = 1
    for drink in drinks:
        print(f"{i}. {drink}")
        i += 1

    while True:
        print("Please enter a drink code")

        order: int = 0
        while True:
            try:
                order = int(input(">> ").strip())
                break
            except ValueError:
                print("Not a number, please try again!")
                continue

        if 1 <= order <= len(drinks):
            print(f"Here's your {drinks[order - 1]}, have fun!")
            break
        else:
            print("Error 404 Not Found, please try again")
            continue


def main() -> None:
    task_list: list[str] = [
        "fizzbuzz",
        "fibonacci",
        "stringculator",
        "stringionary",
        "modulonary",
        "getraenkeautomat",
    ]

    while True:
        task: str = str.lower(input(f"Which task do you want to execute?\n{task_list}\n")).strip()

        if task == "fizzbuzz":
            fizzbuzz()
        elif task == "fibonacci":
            fibonacci()
        elif task == "stringculator":
            stringculator()
        elif task == "stringionary":
            stringionary()
        elif task == "modulonary":
            modulonary()
        elif task == "getraenkeautomat":
            getraenkeautomat()
        else:
            print("task not in list, please try again.\n")
            continue

        break


main()
