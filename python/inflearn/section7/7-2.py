def dfs(t, p):
    global answer
    if t > n:
        return
    if t <= n:
        if p >= answer:
            answer = p
    for i in range(t, n):
        dfs(i + l[i][0], p + l[i][1])

n = int(input())
l = [list(map(int, input().split())) for _ in range(n)]
answer = 0

dfs(0, 0)
print(answer)