n = int(input())

l = [0] * (n + 1)
for i in range(2, len(l)):
    if(l[i] == 1):
        continue
    for j in range(2 * i, len(l), i):
        l[j] = 1
answer = 0
for i in range(2, len(l)):
    if(l[i] == 0):
        answer += 1
print(answer)