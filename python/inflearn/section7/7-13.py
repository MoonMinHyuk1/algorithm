from collections import deque

def bfs():
    while dq:
        size = len(dq)
        for _ in range(size):
            now = dq.popleft()
            for i in range(8):
                nx = now[0] + dx[i]
                ny = now[1] + dy[i]
                if 0 <= nx < n and 0 <= ny < n and g[nx][ny] == 1 and ch[nx][ny] == 0:
                    ch[nx][ny] = 1
                    dq.append((nx, ny))

n = int(input())
g = [list(map(int, input().split())) for _ in range(n)]
ch = [[0] * n for _ in range(n)]
dx = [0, 0, 1, -1, 1, 1, -1, -1]
dy = [1, -1, 0, 0, 1, -1, 1, -1]
answer = 0

for i in range(n):
    for j in range(n):
        if g[i][j] == 1 and ch[i][j] == 0:
            dq = deque()
            dq.append((i, j))
            answer += 1
            ch[i][j] = 1
            bfs()
print(answer)