n = int(input())
l = [list(map(int, input().split())) for _ in range(n)]
m = int(input())

for _ in range(m):
    i, d, num = map(int, input().split())
    i = i - 1
    num = num % n
    if(d == 0):
        r = l[i][0:num]
        for _ in range(num):
            l[i].pop(0)
        l[i] = l[i] + r
    elif(d == 1):
        r = l[i][n - num:n]
        for _ in range(num):
            l[i].pop(len(l[i]) - 1)
        l[i] = r + l[i]

lt = 0
rt = n
answer = 0
for i in range(n):
    for j in range(lt, rt):
        answer += l[i][j]
    if(i < n // 2):
        lt += 1
        rt -= 1
    else:
        lt -= 1
        rt += 1
print(answer)