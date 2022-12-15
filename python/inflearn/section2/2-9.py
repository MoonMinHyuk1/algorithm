n = int(input())

answer = 0
for _ in range(n):
    l = list(map(int, input().split()))
    result = 0
    if(l[0] == l[1] and l[0] == l[2]):
        result = 10000 + (l[0] * 1000)
    elif(l[0] == l[1]):
        result = 1000 + (l[0] * 100)
    elif(l[0] == l[2]):
        result = 1000 + (l[0] * 100)
    elif(l[1] == l[2]):
        result = 1000 + (l[1] * 100)
    else:
        result = max(l) * 100
    if(result > answer):
        answer = result
print(answer)