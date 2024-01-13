# 모름... 페르마 소정리라는딩...

for tc in range(1, int(input()) + 1):
    N, R = map(int, input().split())

    arr = [1] * (N + 1)

    for i in range(2, N + 1):
        arr[i] = arr[i - 1] * i % 1234567891

    denominator = (arr[R] * arr[N - R]) % 1234567891
    denominator_inverse = pow(denominator, 1234567891 - 2, 1234567891)

    answer = (arr[N] * denominator_inverse) % 1234567891

    print(f'#{tc} {answer}')