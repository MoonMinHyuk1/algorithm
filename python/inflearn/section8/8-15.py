from collections import deque

n, m = map(int, input().split())
g = [[0 for _ in range(n)] for _ in range(n)]
d = [0] * n
for _ in range(m):
    x, y = map(int, input().split())
    g[x - 1][y - 1] = 1
    d[y - 1] += 1

dq = deque()
for i in range(n):
    if d[i] == 0:
        dq.append(i)
while dq:
    now = dq.popleft()
    print(now + 1, end = ' ')
    for i in range(n):
        if g[now][i] == 1:
            d[i] -= 1
            if d[i] == 0:
                dq.append(i)