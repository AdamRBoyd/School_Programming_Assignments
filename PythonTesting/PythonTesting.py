myStr = "Hello, how are you a programmer, and elephant is big, they eat them grass."
st = {" a ", " an ", " the "}
t = 0;

for i in st:
    t = myStr.find(i)
    if t != -1:
        break

if t == -1:
    print("There is not a singular noun")
else:
    print("There is a singular noun")