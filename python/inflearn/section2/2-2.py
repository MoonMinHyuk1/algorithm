t = int(input())

for i in range(t):
    n, s, e, k = map(int, input().split())
    L = list(map(int, input().split()))
    L2 = L[s - 1:e]
    L2.sort()
    print('#%d' %(i + 1) + ' %d' %L2[k - 1])