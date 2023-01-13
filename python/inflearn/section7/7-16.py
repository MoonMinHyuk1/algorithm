def dfs(x, y):
    if x == 0:
        return y
    for i in range(3):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and g[nx][ny] == 1 and ch[nx][ny] == 0:
            ch[nx][ny] = 1
            return dfs(nx, ny)

n = 10
g = [list(map(int, input().split())) for _ in range(n)]
ch = [[0] * n for _ in range(n)]
dx = [0, 0, -1]
dy = [1, -1, 0]

for i in range(n):
    if g[n - 1][i] == 2:
        ch[n - 2][i] = 1
        print(dfs(n - 2, i))