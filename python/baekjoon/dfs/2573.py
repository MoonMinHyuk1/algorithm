import sys
sys.setrecursionlimit(100000)

def melt():
    for x in range(n):
        for y in range(m):
            if l[x][y] != 0:
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if nx >= 0 and nx < n and ny >= 0 and ny < m and l[nx][ny] == 0:
                        visited[x][y] += 1
    for x in range(n):
        for y in range(m):
            if l[x][y] != 0:
                l[x][y] = max(l[x][y] - visited[x][y], 0)

def search(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < n and ny >= 0 and ny < m and l[nx][ny] > 0 and visited[nx][ny] == 0:
            visited[nx][ny] = 1
            search(nx, ny)

n, m = map(int, input().split())
l = [list(map(int, input().split())) for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
answer = 0

while True:
    answer += 1
    visited = [[0] * m for _ in range(n)]
    melt()
    visited = [[0] * m for _ in range(n)]
    slice = 0
    for i in range(n):
        for j in range(n):
            if l[i][j] > 0 and visited[i][j] == 0:
                visited[i][j] = 1
                search(i, j)
                slice += 1
    if slice > 1:
        print(answer)
        break
    elif slice == 0:
        print(slice)
        break