def dfs(pw):
    global cnt
    if len(l) == 0:
        cnt += 1
        print(pw)
        return
    if l[0] == '0':
        return
    n = l.pop(0)
    dfs(pw + str(chr(ord('A') + int(n) - 1)))
    l.insert(0, n)
    if len(l) > 1 and (int(l[0] + l[1]) <= 26 or l[1] == '0'):
        n = l[0] + l[1]
        l.pop(0)
        l.pop(0)
        dfs(pw + str(chr(ord('A') + int(n) - 1)))
        l.insert(0, n[1])
        l.insert(0, n[0])

l = list(map(str, input()))
cnt = 0

dfs('')
print(cnt)