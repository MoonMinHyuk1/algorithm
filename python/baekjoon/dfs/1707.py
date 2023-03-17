import sys
sys.setrecursionlimit(100000)

def dfs(u):
    global answer
    if answer == "NO":
        return
    for v in G[u]:
        if len(ch[v]) == 0:
            ch[v].append(not ch[u][0])
            dfs(v)
        elif ch[u][0] == ch[v][0]:
            answer = "NO"
            return

k = int(input())
for _ in range(k):
    V, E = [int(x) for x in sys.stdin.readline().split()]
    G = [[] for _ in range(V + 1)]
    for _ in range(E):
        u, v = [int(x) for x in sys.stdin.readline().split()]
        G[u].append(v)
        G[v].append(u)
    ch = [[] for _ in range(V + 1)]
    answer = "YES"
    for i in range(1, V + 1):
        if len(ch[i]) == 0:
            ch[i].append(True)
            dfs(i)
    print(answer)