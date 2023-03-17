import sys
sys.setrecursionlimit(100000)

def dfs(x, y):
    if x == n - 1 and y == m - 1:
        return 1
    if ch[x][y] != -1:
        return ch[x][y]
    ch[x][y] = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < n and ny >= 0 and ny < m:
            if l[x][y] > l[nx][ny]:
                ch[x][y] += dfs(nx, ny)
    return ch[x][y]

n, m = map(int, input().split())
l = [list(map(int, input().split())) for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
ch = [[-1] * m for _ in range(n)]

dfs(0, 0)
print(ch[0][0])