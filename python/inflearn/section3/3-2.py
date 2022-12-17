str = input()

num = 0
for c in str:
    if c >= '0' and c <= '9':
        num *= 10
        num += int(c)
cnt = 0
for i in range(1, num + 1):
    if(num % i == 0):
        cnt += 1
print(num, cnt, sep = '\n')