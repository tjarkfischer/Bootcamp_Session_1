def checkPrime(number):
    is_prime = True
    for i in range(2, int(number / 2) + 1):
        if number % i == 0:
            #print(number, " is not a prime number")
            is_prime = False
            break
    return is_prime



for i in range(101):
    if checkPrime(i):
        print("prime")
    elif i % 3 == 0:
        if i % 5 == 0:
            print("FizzBuzz")
        else:
            print("Fizz")
    elif i % 5 == 0:
        print("Buzz")
    else:
        print(i)


