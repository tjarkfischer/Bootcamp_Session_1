#tom
from sys import excepthook


def main():

    x = input("Zahl 1: ")
    y = input("Zahl 2: ")
    try:
        x = int(x)
    except ValueError:
        x = 0
    try:
        y = int(y)
    except ValueError:
        y = 0

    print(stringculator(x, y))


def stringculator(x, y):
    z = x + y
    return str(z)

if __name__ == "__main__":
    main()