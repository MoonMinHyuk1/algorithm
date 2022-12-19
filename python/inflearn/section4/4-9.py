n = int(input())
l = list(map(int, input().split()))

cnt = 0
answer = ''
last = 0
for _ in range(n):
    if(l[0] > last and l[len(l) - 1] > last):
        if(l[0] < l[len(l) - 1]):
            cnt += 1
            answer += 'L'
            last = l[0]
            l.pop(0)
        else:
            cnt += 1
            answer += 'R'
            last = l[len(l) - 1]
            l.pop(len(l) - 1)
    elif(l[0] > last):
        cnt += 1
        answer += 'L'
        last = l[0]
        l.pop(0)
    elif(l[len(l) - 1] > last):
        cnt += 1
        answer += 'R'
        last = l[len(l) - 1]
        l.pop(len(l) - 1)
print(cnt, answer, sep = '\n')