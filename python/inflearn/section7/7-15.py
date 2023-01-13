from collections import deque

def check():
    for i in range(n):
        for j in range(m):
            if g[i][j] == 0:
                return False
    return True

def bfs():
    answer = 0
    while dq:
        if check():
            return answer
        answer += 1
        size = len(dq)
        for _ in range(size):
            now = dq.popleft()
            for i in range(4):
                nx = now[0] + dx[i]
                ny = now[1] + dy[i]
                if 0 <= nx < n and 0 <= ny < m and g[nx][ny] == 0:
                    g[nx][ny] = 1
                    dq.append((nx, ny))
    if check():
        return answer
    else:
        return -1

m, n = map(int, input().split())
g = [list(map(int, input().split())) for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
dq = deque()

for i in range(n):
    for j in range(m):
        if g[i][j] == 1:
            dq.append((i, j))
print(bfs())