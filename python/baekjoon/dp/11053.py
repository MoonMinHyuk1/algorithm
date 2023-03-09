n = int(input())
l = list(map(int, input().split()))
dp = [0] * n
dp[0] = 1

for i in range(n):
    maxDP = 0
    for j in range(i - 1, -1, -1):
        if l[i] > l[j] and maxDP < dp[j]:
            maxDP = dp[j]
    dp[i] = maxDP + 1
print(max(dp))