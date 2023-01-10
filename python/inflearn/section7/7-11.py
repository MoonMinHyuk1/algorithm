def dfs(x, y):
    global answer
    if x == maxx and y == maxy:
        answer += 1
        return
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and ch[nx][ny] == 0:
            if g[x][y] < g[nx][ny]:
                ch[nx][ny] = 1
                dfs(nx, ny)
                ch[nx][ny] = 0

n = int(input())
g = [list(map(int, input().split())) for _ in range(n)]
ch = [[0] * n for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
minv = float('inf')
maxv = 0
minx, miny, maxx, maxy = 0, 0, 0, 0
answer = 0

for i in range(n):
    for j in range(n):
        if g[i][j] < minv:
            minv, minx, miny = g[i][j], i, j
        if g[i][j] > maxv:
            maxv, maxx, maxy = g[i][j], i, j

ch[minx][miny] = 1
dfs(minx, miny)
print(answer)