n = int(input())

dp = [0] * 45
dp[0] = 1
dp[1] = 2
for i in range(2, 45):
    dp[i] = dp[i - 1] + dp[i - 2]

print(dp[n - 1])