n = int(input())

d = dict()
for i in range(n * 2 - 1):
    str = input()
    d[str] = d.get(str, 0) + 1
for key, val in d.items():
    if val == 1:
        print(key)
        break