for tc in range(1, int(input())+1):

    n = int(input())
    while n > 3:
        n = n // 2 + 1
        n = n // 2 - 1

    if n == 1:
        print(f'#{tc} Bob')
    else:
        print(f'#{tc} Alice')