for tc in range(1, int(input()) + 1):
    n = int(input())

    chil = 1

    cnt = 10
    for i in range(n):
        chil *= cnt
        cnt -= 1

    print(f'#{tc}', end = ' ')
    print('%0.5f' % round(chil / 10 ** n, 6))
