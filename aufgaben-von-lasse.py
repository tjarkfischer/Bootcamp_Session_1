#Aufgaben 1-3
userName = input("Enter your name: ")
userAge = int(input("Enter your age: "))
print(f"My name ist {userName}.\nI am {userAge} years old.")


#check how many upper and lower case characters are in text
test = input("")
lower = 0
upper = 0
for i in test:
    if i.islower():
        lower += 1
    elif i.isupper():
        upper += 1
print("lower case: ", lower, "upper case: ", upper)