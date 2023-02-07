def dfs(x, y, sum):
    if x < 0 or x >= n or y < 0 or y >= n:
        return
    if x == 0 and y == 0:
        if dp[x][y] > sum + l[x][y]:
            dp[x][y] = sum + l[x][y]
        return
    if dp[x][y] <= sum:
        return
    else:
        dp[x][y] = sum
    dfs(x - 1, y, sum + l[x][y])
    dfs(x, y - 1, sum + l[x][y])

n = int(input())
l = [list(map(int, input().split())) for _ in range(n)]
dp = [[float('inf') for _ in range(n)] for _ in range(n)]
dp[n - 1][n - 1] = l[n - 1][n - 1]

dfs(n - 1, n - 1, 0)
print(dp[0][0])