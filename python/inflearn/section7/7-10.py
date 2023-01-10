def dfs(x, y):
    global answer
    if x == 6 and y == 6:
        answer += 1
        return
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and g[nx][ny] == 0:
            g[nx][ny] = 1
            dfs(nx, ny)
            g[nx][ny] = 0

n = 7
g = [list(map(int, input().split())) for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
answer = 0

g[0][0] = 1
dfs(0, 0)
print(answer)