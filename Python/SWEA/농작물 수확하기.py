for tc in range(1, int(input()) + 1):


    n = int(input())
    arr = [list(map(int, list(input()))) for _ in range(n)]

    answer = 0

    for i in range(n//2 + 1):
        for j in range(n//2 - i, n//2 + i + 1):
            answer += arr[i][j]


    arr = arr[::-1]
    for i in range(n//2):
        for j in range(n//2 - i, n//2 + i + 1):
            answer += arr[i][j]

    print(f'#{tc} {answer}')