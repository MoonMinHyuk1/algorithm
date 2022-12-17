n = int(input())
l = [[0] * n for i in range(n)]

for i in range(n):
    l[i] = list(map(int, input().split()))
sum1, sum2, sum3, sum4, max = 0, 0, 0, 0, 0
for i in range(n):
    sum1, sum2 = 0, 0
    sum3 += l[i][i]
    sum4 += l[n - i - 1][i]
    for j in range(n):
        sum1 += l[i][j]
        sum2 += l[j][i]
    if(sum1 > max):
        max = sum1
    if(sum2 > max):
        max = sum2
    if(sum3 > max):
        max = sum3
    if(sum4 > max):
        max = sum4
print(max)