def binury(n):

    b = ''
    while n > 0:
        b += str(n % 2)
        n //= 2

    while len(b) != 4:
        b += '0'

    return b[::-1]




d = {str(i) : i for i in range(10)}
for num, s in zip(range(10,16),'ABCDEF'):
    d[s] = num


for tc in range(1,int(input()) + 1):

    n, hex = input().split()
    n = int(n)

    answer = ''

    for h in hex:
        answer += binury(d[h])

    print(f'#{tc} {answer}')