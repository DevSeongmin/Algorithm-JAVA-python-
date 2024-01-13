
for tc in range(1, int(input()) + 1):

    n = float(input())
    answer = ''
    power = -1
    while n != 0:
        if n >= 2 ** power:
            n -= 2**power
            answer += '1'
        else:
            answer += '0'
        power -= 1

        if power <= -14:
            answer = 'overflow'
            break


    print(f'#{tc} {answer}')