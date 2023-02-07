n = int(input())
l = [list(map(int, input().split())) for _ in range(n)]
dx = [0, 1]
dy = [1, 0]
dp = [[float('inf') for _ in range(n)] for _ in range(n)]

dp[0][0] = l[0][0]
for i in range(n):
    for j in range(n):
        for k in range(2):
            nx = i + dx[k]
            ny = j + dy[k]
            if nx >= 0 and nx < n and ny >= 0 and ny < n:
                if dp[nx][ny] > dp[i][j] + l[nx][ny]:
                    dp[nx][ny] = dp[i][j] + l[nx][ny]
print(dp[n - 1][n - 1])