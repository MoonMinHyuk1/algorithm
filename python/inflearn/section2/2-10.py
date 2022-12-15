n = int(input())
l = list(map(int, input().split()))

answer = 0
score = 1
for i in l:
    if(i == 1):
        answer += score
        score += 1
    else:
        score = 1
print(answer)