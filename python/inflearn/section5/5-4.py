str = input()

s = []
for c in str:
    if c == '+':
        b = s.pop()
        a = s.pop()
        s.append(a + b)
    elif c == '-':
        b = s.pop()
        a = s.pop()
        s.append(a - b)
    elif c == '*':
        b = s.pop()
        a = s.pop()
        s.append(a * b)
    elif c == '/':
        b = s.pop()
        a = s.pop()
        s.append(a // b)
    else:
        s.append(int(c))
print(s[0])