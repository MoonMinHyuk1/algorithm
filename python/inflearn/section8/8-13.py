n, m = map(int, input().split())
dis = [[float('inf') for _ in range(n)] for _ in range(n)]
for i in range(0, n):
    dis[i][i] = 0
for i in range(m):
    x, y, w = map(int, input().split())
    dis[x - 1][y - 1] = w

for k in range(n):
    for i in range(n):
        for j in range(n):
            dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j])

for i in range(n):
    for j in range(n):
        if dis[i][j] == float('inf'):
            print('M', end = ' ')
        else:
            print(dis[i][j], end = ' ')
    print()