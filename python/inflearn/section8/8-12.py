n, m = map(int, input().split())
l = [list(map(int, input().split())) for _ in range(n)]
dp = [0] * (m + 1)

for i in range(n):
    for j in range(m, l[i][1] - 1, -1):
        if dp[j] < dp[j - l[i][1]] + l[i][0]:
            dp[j] = dp[j - l[i][1]] + l[i][0]
print(max(dp))