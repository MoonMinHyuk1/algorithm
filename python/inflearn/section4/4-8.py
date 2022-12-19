n, m = map(int, input().split())
l = list(map(int, input().split()))

l.sort()
c = [0] * n
answer = 0
for i in range(n):
    for j in range(n - 1, i, -1):
        if(c[j] != 1 and l[i] + l[j] <= m):
            answer += 1
            c[i] = 1
            c[j] = 1
            break
for i in range(n):
    if(c[i] == 0):
        answer += 1
print(answer)