n = int(input())
l = [list(map(int, input().split())) for _ in range(n)]

l.sort(key = lambda x : (x[1], x[0]))
answer = 1
now = l[0]
for i in range(1, n):
    if(l[i][0] >= now[1]):
        answer += 1
        now = l[i]
print(answer)