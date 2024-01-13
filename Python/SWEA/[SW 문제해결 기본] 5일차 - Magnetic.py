for tc in range(1,11):

    n = int(input())

    arr = [list(map(int, input().split())) for i in range(n)]

    cnt = 0
    for i in range(n):
        flag = False
        for j in range(n):
            if arr[j][i] == 1:
                flag = True

            if flag and arr[j][i] == 2:
                cnt += 1
                flag = False
    print(f'#{tc} {cnt}')