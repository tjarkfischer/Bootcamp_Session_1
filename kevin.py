"""
FizzBuzz
"""
def fizzbuzz() -> None:
    cap: int = int(str.strip(input("Give me a range: ")))

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

    cap: int = int(str.strip(input("Give me a range: ")))

    for i in range(cap):
        new: int = last + lastlast
        lastlast = last
        last = new

        print(new)


"""
Stringculator
"""
def stringculator() -> None:
    first: int = int(str.strip(input("Give me a number: ")))
    second: int = int(str.strip(input("Give me a second number: ")))
    operation: str = str.strip(input("Give me an operation sign [+, -, *, /, %]: "))

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
    cap: int = int(str.strip(input("Give me a range: ")))

    for i in range(cap):
        if i % 2 == 0:
            print(f"{i} is even")
        else:
            print(f"{i} is odd")


def main() -> None:
    task_list: list[str] = ["fizzbuzz", "fibonacci", "stringculator", "stringionary", "modulonary"]
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
        else:
            print("task not in list, please try again.\n")
            continue

        break


main()
