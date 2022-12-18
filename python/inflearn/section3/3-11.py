l = [list(map(int, input().split())) for _ in range(7)]

answer = 0
for i in range(7):
    for j in range(3):
        #가로
        s = l[i][j:j + 5]
        if(s == s[::-1]):
            answer += 1
        s.clear()
        #세로
        for k in range(5):
            s.append(l[j + k][i])
        if(s == s[::-1]):
            answer += 1
print(answer)