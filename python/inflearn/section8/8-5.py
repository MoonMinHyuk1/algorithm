n = int(input())
l = list(map(int, input().split()))
dp = [0] * n
dp[0] = 1

for i in range(1, n):
    cnt = 0
    for j in range(i - 1, -1, -1):
        if l[i] > l[j] and dp[j] > cnt:
            cnt = dp[j]
    dp[i] = cnt + 1
print(max(dp))