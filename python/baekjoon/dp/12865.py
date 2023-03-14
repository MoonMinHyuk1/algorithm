n, k = map(int, input().split())
l = [list(map(int, input().split())) for _ in range(n)]
l.sort(key = lambda x : (x[0], -x[1]))
dp = [0] * (k + 1)

for i in range(n):
    for j in range(k, l[i][0] - 1, -1):
        dp[j] = max(dp[j], dp[j - l[i][0]] + l[i][1])
print(max(dp))