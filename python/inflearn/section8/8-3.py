def dfs(n):
    if dp[n - 1] > 0:
        return dp[n - 1]
    if n == 1 or n == 2:
        dp[n - 1] = n
        return dp[n - 1]
    else:
        dp[n - 1] = dfs(n - 1) + dfs(n - 2)
        return dp[n - 1]

n = int(input())
dp = [0] * 45

print(dfs(n))