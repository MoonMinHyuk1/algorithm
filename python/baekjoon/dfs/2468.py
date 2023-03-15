import sys
sys.setrecursionlimit(100000)

def dfs(x, y):
    if ch[x][y] == 1:
        return
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < n and ny >= 0 and ny < n:
            ch[x][y] = 1
            dfs(nx, ny)

n = int(input())
l = [list(map(int, input().split())) for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
answer = 1

maxL = 0
for i in range(n):
    for j in range(n):
        maxL = max(maxL, l[i][j])

for i in range(1, maxL + 1):
    ch = [[0 for _ in range(n)] for _ in range(n)]
    cnt = 0
    for j in range(n):
        for k in range(n):
            if l[j][k] <= i:
                ch[j][k] = 1
    for j in range(n):
        for k in range(n):
            if ch[j][k] == 0:
                dfs(j, k)
                cnt += 1
    answer = max(answer, cnt)
print(answer)