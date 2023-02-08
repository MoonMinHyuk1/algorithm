n = int(input())
l = list(map(int, input().split()))
m = int(input())
dp = [float('inf')] * (m + 1)

dp[0] = 0
l.sort()
for i in range(l[0], m + 1):
    for j in range(n):
        if dp[i] > dp[i - l[j]] + 1:
            dp[i] = dp[i - l[j]] + 1
print(dp[m])