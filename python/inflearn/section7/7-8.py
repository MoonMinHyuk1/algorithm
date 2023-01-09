from collections import deque

def bfs():
    global answer
    while dq:
        for _ in range(len(dq)):
            now = dq.popleft()
            for i in range(4):
                nx = now[0] + dx[i]
                ny = now[1] + dy[i]
                if nx < 0 or ny < 0 or nx == n or ny == n:
                    return
                if ch[nx][ny] == 0:
                    ch[nx][ny] = 1
                    answer += g[nx][ny]
                    dq.append((nx, ny))

n = int(input())
g = [list(map(int, input().split())) for _ in range(n)]
ch = [[0] * n for _ in range(n)]
dq = deque()
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
answer = 0

start = n // 2
dq.append((start, start))
ch[start][start] = 1
answer += g[start][start]

bfs()
print(answer)