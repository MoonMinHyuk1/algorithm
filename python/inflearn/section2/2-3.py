n, k = map(int, input().split())
l = list(map(int, input().split()))

answer = []
for i in range(len(l)):
    for j in range(i + 1, len(l)):
        for m in range(j + 1, len(l)):
            answer.append(l[i] + l[j] + l[m])
answer = list(set(answer))
answer.sort(reverse=True)

print(answer[k - 1])