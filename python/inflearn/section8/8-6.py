n = int(input())
l = list(map(int, input().split()))
dp = [[0] * 2] * n

dp[0] = [1, l[0]]
for i in range(1, n):
    cnt = 0
    for j in range(i - 1, -1, -1):
        if dp[j][1] < l[i] and dp[j][0] > cnt:
            cnt = dp[j][0]
    dp[i] = [cnt + 1, l[i]]

answer = 0
for i in range(n):
    if answer < dp[i][0]:
        answer = dp[i][0]

print(answer)