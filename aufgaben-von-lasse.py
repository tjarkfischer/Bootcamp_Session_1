"""userName = input("Enter your name: ")
userAge = int(input("Enter your age: "))
print(f"My name ist {userName}.\nI am {userAge} years old.")"""
test = input("")
lower = 0
upper = 0
for i in test:
    if i.islower():
        lower += 1
    elif i.isupper():
        upper += 1
print(lower, " ", upper)