# Adam Boyd
# CS 311 01
# ID xv3543
#Investigate the following features or constructs as they pertain to Python:

# 1. interpretation
print("interpretation")
x = 10
print(x)
#print(y) #<- Gives error as y is yet to be defined (commented out so I can run the rest)
y = 20

# 2. Boolean expressions
print("\nBoolean expressions")
print(x<y)
print(x>y)
print(15<20)
print(x < 15 >= 5)
print(x > 15 >= 5)
print(x < 15 <= 5)

# 3. short circuit evaluation
print("\nShort Circuit Evaluation")
def check():
    return "Test"
print(1 or check())
print(0 or check())
print(0 or check() or 1)
print(0 or 1 or check())

# 4. numeric types
print("\nNumeric Types")
print(type(x))
x = float(x)
print(type(x))
x = complex(10,15)
print(type(x))
x = 100000000000000000000000000000000000000000000000000000  #long is not a type anymore, returns int
print(type(x), "<--- Older versions would return long")

# 5. strings
print("\nStrings")
str = "Hello how are "
print(str)
print(str[0:9])
str = str + "you"
print(str)
print("Hello " * 2)
print(str[6])

# 6. arrays
# Arrays not supported without library - see lists

# 7. lists
print("\nLists")
moto = ["Harley", "Honda", "Suzuki"]
print(moto)
print(moto[0])
print(moto[0:2])
moto += ["Yamaha", "Polaris"]
print(moto)
print(moto[-2])
moto[2] = 1234
print(moto)
print(len(moto))
print(moto[0][2])
moto.pop()
print(moto)

# 8. tuples
print("\nTuples")
tup = ()
print(tup)
tup = ('Hi','Hello')
print(tup)
print(tup[0])
print(tup[1])
#tup[0] = {'Yo', 'Sup'} #Error tuple does not support assignment
#tup[0] = 'Yo' #Error tuple does not support assignment
tup2 = ('Yo', 'Sup')
#tup3 = tup + tup2 #Error tuple does not support assignment
print(tup + tup2)
tup3 = (tup, tup2)
print(tup3)
tup3 = ('test',)*3
print(tup3)
tup = (1, 2, 3, 4)
print(tup[1:]) 
print(tup[::-1]) 
print(tup[2:4]) 
print(len(tup))
print(tuple(moto))
del tup
#print(tup)  #Error, tup not defined

# 9. slices
print("\nSlices")
x = [0,1,2,3,4,5,6,7,8,9]
print(x)
print(x[0:3])
print(x[0:9:2])
print(x[0:len(x):3])
print(x[:5])
print(x[5:])
print(x[-3])
print(x[-3:])

# 10. index range checking
print("\nIndex Range Checking")
#print(x[len(x)]) #IndexError: list index out of range
print(len(x))
print(x[-1])

# 11. dictionaries
print("\nDictionaries")
d = dict()
print(d)
d = {'Hello':'Hi','Yo':'Sup'}
print(d)
print(d['Hello'])
print(d['Yo'])
print(d.keys())
d['Hello'] = 'Howdy'
print(d)
del d['Hello']
print(d)
d['Hi'] = 'Howdy'
print(d)

# 12. if statement
print("\nIf Statement")
z = 30
if y<z:
    print('y', y)
elif y == z:
    print('Equal')
else:
    print('z', z)
y = 40
if y<z:
    print('y', y)
elif y == z:
    print('Equal')
else:
    print('z', z)
y = 30
if y<z:
    print('y', y)
elif y == z:
    print('Equal')
else:
    print('z', z)
if 1 > 0 and 0 < 1: print('Yay')
if 1 < 0 or 0 < 1: print('Yay')
if 1 < 0:
    pass


# 13. switch statement
#Python does not natively support switch.

# 14. for loop
print("\nLoop")
for i in x:
    print(i)
print('Even numbers')
for i in range(1,11):
    if i % 2 == 0:
        print(i)

# 15. while loop
print("\nWhile Loop")
count = 1
while count < 6:
    print(count)
    count = count + 1

# 16. indentation to denote code blocks
print("\nIndentation to Denote Code Blocks")
if 1 < 0:
#print('Nope') #IndentationError: expected an indented block
    print('Nope') #again with indention
else:
    print('Yay')

# 17. type binding
print("\nType Binding")
#code from Numeric Types above
print(type(x))
x = 10.1
print(type(x))
x = complex(10,15)
print(type(x))
x = 'Hello'
print(type(x))

# 18. type checking
print("\nType Checking")
print(x)
print(type(x))

# 19. functions
print("\nFunctions")
def printHi():
    print('Hi')
def addNums(e,f):
    return e + f

printHi()
print(addNums(2,3))

# 20. one other feature - your choice
print("\nOther Feature")
x = lambda a : a + 5
print(x(5))

x = lambda a, b : a + b
print(x(10,20))

x = lambda a, b, c : (a + b) / c
print(x(10,15,5))

def muln(n):
    return lambda x : x * n

z = muln(3) #sets n in z to 3
y = muln(2) #sets n in y to 2
print(z(11)) #uses lambda -> 11 * 3
print(y(11)) #uses lambda -> 11 * 2