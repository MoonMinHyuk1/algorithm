str = input()

s = []
answer = []
for c in str:
    if c.isdigit():
        answer.append(c)
    else:
        if c == '(':
            s.append(c)
        if c == '+' or c == '-':
            while s and s[-1] != '(':
                answer.append(s.pop())
            s.append(c)
        if c == '*' or c == '/':
            while s and (s[-1] == '*' or s[-1] == '/'):
                answer.append(s.pop())
            s.append(c)
        if c == ')':
            while s and s[-1] != '(':
                answer.append(s.pop())
            s.pop()
while s:
    answer.append(s.pop())
print(*answer, sep = '')