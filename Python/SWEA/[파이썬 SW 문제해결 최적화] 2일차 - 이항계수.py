for tc in range(1, int(input()) + 1):

    N, a, b = map(int, input().split())
    a = min(a,b)


    answer = 1

    for i in range(1,a+1):
        answer *= N
        N -= 1
        answer //= i

    print(f'#{tc} {answer}')