n = int(input())
l = [int(input()) for _ in range(n)]
dp = [0] * n
dp[0] = l[0]

if n > 1:
    dp[1] = l[0] + l[1]
for i in range(2, n):
    dp[i] = max(dp[i - 2] + l[i], dp[i - 3] + l[i - 1] + l[i])
print(dp[n - 1])