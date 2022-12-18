l = [list(map(int, input().split())) for _ in range(9)]

check = "YES"
for i in range(9):
    s1 = set(list(l[i]))
    s2 = set()
    for j in range(9):
        s2.add(l[j][i])
    if(len(s1) != 9):
        check = "NO"
    if(len(s2) != 9):
        check = "NO"
for i in range(0, 7, 3):
    for j in range(0, 7, 3):
        s = set()
        for x in range(i, i + 3):
            for y in range(j, j + 3):
                s.add(l[x][y])
        if(len(s) != 9):
            check = "NO"
print(check)