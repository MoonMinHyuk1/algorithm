def check(str):
    for i in range(len(str) // 2 + 1):
        if(str[i] != str[len(str) - i - 1]):
            return "NO"
    return "YES"

n = int(input())

for i in range(n):
    str = input().lower()
    answer = check(str)
    print("#%d %s" %(i + 1, answer))