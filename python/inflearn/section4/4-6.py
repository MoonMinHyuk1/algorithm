n = int(input())
l = [list(map(int, input().split())) for _ in range(n)]

l.sort(key = lambda x : (x[0], [1]))
answer = n
for i in range(n - 1):
    for j in range(i + 1, n):
        if(l[i][1] < l[j][1]):
            answer -= 1
            break
print(answer)