import math

n = int(input())
l = list(map(int, input().split()))

avg = round(sum(l) / n)

i = 0
min = abs(l[0] - avg)
for index, value in enumerate(l):
    if(min == abs(value - avg)):
        if(l[i] < value):
            i = index
            min = abs(value - avg)
    elif(min > abs(value - avg)):
        i = index
        min = abs(value - avg)

print(avg, i + 1)