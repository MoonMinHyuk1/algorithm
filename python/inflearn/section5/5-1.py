n, m = map(str, input().split())
n = list(map(int, str(n)))
m = int(m)

s = []
s.append(n[0])
for i in range(1, len(n)):
    for j in range(len(s) - 1, -1, -1):
        if(n[i] > s[j] and m != 0):
            m -= 1
            s.pop()
            if(m == 0):
                s.append(n[i])
                break
        else:
            s.append(n[i])
            break
    else:
        s.append(n[i])
if(m != 0):
    s = s[:-m]

print(*s, sep = '')