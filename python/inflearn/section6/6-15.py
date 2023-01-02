def dfs(v):
    global answer
    if v == n - 1:
        answer += 1
        return
    for i in range(n):
        if g[v][i] == 1 and ch[i] == 0:
            ch[i] = 1
            dfs(i)
            ch[i] = 0

n, m = map(int, input().split())
g = [[0] * n for _ in range(n)]
ch = [0] * n
answer = 0

for _ in range(m):
    a, b = map(int, input().split())
    g[a - 1][b - 1] = 1

ch[0] = 1
dfs(0)
print(answer)