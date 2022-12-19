n = int(input())
l = list(map(int, input().split()))

answer = []
c = [0] * n
for i in range(n):
    for j in range(n):
        if(l[j] == 0 and c[j] != 1):
            answer.append(j + 1)
            c[j] = 1
            break
        else:
            l[j] -= 1
print(*answer)