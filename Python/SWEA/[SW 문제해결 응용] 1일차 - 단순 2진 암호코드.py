import sys
sys.stdin = open("input.txt", "r")


T = int(input())

for tc in range(1, T+1):

    d = {
        '0001101' : 0,
        '0011001' : 1,
        '0010011' : 2,
        '0111101' : 3,
        '0100011' : 4,
        '0110001' : 5,
        '0101111' : 6,
        '0111011' : 7,
        '0110111' : 8,
        '0001011' : 9
    }

    y,x = map(int, input().split())

    code = [list(input()) for _ in range(y)]


    for i in range(y):
        for j in range(x-1, -1, -1):
            if code[i][j] == '1':
                secret = code[i][j-55:j+1]
                break

    secret = [d[''.join(secret[i:i+7])] for i in range(0, 56,7)]

    if (sum(secret[1::2])  + sum(secret[::2])* 3) % 10 == 0:
        print(f'#{tc} {sum(secret)}')
    else:
        print(f'#{tc} 0')