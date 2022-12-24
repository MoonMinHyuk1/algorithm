str1 = input()
str2 = input()

d = dict()
for c in str1:
    d[c] = d.get(c, 0) + 1
for c in str2:
    d[c] = d.get(c, 0) - 1
for key, val in d.items():
    if val != 0:
        print("NO")
        break
else:
    print("YES")