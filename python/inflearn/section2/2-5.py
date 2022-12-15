n, m = map(int, input().split())

d = dict()
for i in range(1, n + 1):
    for j in range(1, m + 1):
        d[i + j] = d.get(i + j, 0) + 1
max = 0
answer = []
for key, value in d.items():
    if(max < value):
        max = value
        answer.clear()
        answer.append(key)
    elif(max == value):
        answer.append(key)
print(*answer)