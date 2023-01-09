from collections import deque

def bfs():
    answer = 0
    while dq:
        answer += 1
        cnt = len(dq)
        for _ in range(cnt):
            now = dq.popleft()
            for i in range(4):
                nx = now[0] + dx[i]
                ny = now[1] + dy[i]
                if nx == n - 1 and ny == n - 1:
                    return answer
                if nx >= 0 and ny >= 0 and nx < n and ny < n and ch[nx][ny] == 0 and g[nx][ny] == 0:
                    ch[nx][ny] = 1
                    dq.append((nx, ny))
    return -1

n = 7
g = [list(map(int, input().split())) for _ in range(n)]
ch = [[0] * n for _ in range(n)]
dq = deque()
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

ch[0][0] = 1
dq.append((0, 0))

print(bfs())