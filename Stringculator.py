#tom
def main():
    x = input("Zahl 1: ")
    y = input("Zahl 2: ")

    if x == "":
        x = "0"
    if y == "":
        y = "0"
    print(stringculator(x, y))


def stringculator(x, y):
    z = x + y
    return str(z)

if __name__ == "__main__":
    main()