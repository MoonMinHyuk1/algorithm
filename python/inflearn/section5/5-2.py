str = input()

s = []
stick = 0
answer = 0
for c in str:
    if c == '(':
        stick += 1
        s.append(c)
    elif c == ')':
        if s[-1] == '(':
            stick -= 1
            answer += stick
        elif s[-1] == ')':
            stick -= 1
            answer += 1
        s.append(c)
print(answer)