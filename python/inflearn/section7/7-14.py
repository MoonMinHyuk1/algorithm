from collections import deque

def bfs(r):
    while dq:
        size = len(dq)
        for _ in range(size):
            now = dq.popleft()
            for i in range(4):
                nx = now[0] + dx[i]
                ny = now[1] + dy[i]
                if 0 <= nx < n and 0 <= ny < n and ch[nx][ny] == 0 and g[nx][ny] > r:
                    ch[nx][ny] = 1
                    dq.append((nx, ny))

n = int(input())
g = [list(map(int, input().split())) for _ in range(n)]
ch = [[0] * n for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
answer = 0

for r in range(1, 101):
    ch = [[0] * n for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if ch[i][j] == 0 and g[i][j] > r:
                ch[i][j] = 1
                dq = deque()
                dq.append((i, j))
                cnt += 1
                bfs(r)
    if cnt > answer:
        answer = cnt
print(answer)