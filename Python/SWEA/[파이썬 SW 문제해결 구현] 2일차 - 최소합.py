for tc in range(1, int(input()) + 1):

    n = int(input())

    arr = [list(map(int, input().split())) for _ in range(n)]


    for i in range(1,n):
        arr[0][i] += arr[0][i-1]
        arr[i][0] += arr[i-1][0]

    for y in range(1, n):
        for x in range(1, n):
            arr[y][x] += min(arr[y-1][x], arr[y][x-1])

    print(f'#{tc} {arr[-1][-1]}')