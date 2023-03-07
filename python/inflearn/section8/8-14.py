n = int(input())
dis = [[float('inf') for _ in range(n)] for _ in range(n)]
for i in range(n):
    dis[i][i] = 0
while True:
    x, y = map(int, input().split())
    if x == -1 and y == -1:
        break
    dis[x - 1][y - 1] = 1
    dis[y - 1][x - 1] = 1

for k in range(n):
    for i in range(n):
        for j in range(n):
            dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j])
score = [0] * n
for i in range(n):
    score[i] = max(dis[i])
answer = []
for i in range(n):
    if min(score) == score[i]:
        answer.append(i + 1)
print(min(score), len(answer))
print(*answer)