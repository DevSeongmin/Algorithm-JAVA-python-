def is_p(s):
    for i in range(len(s)//2):
        if s[i] != s[-i - 1]:
            return False
    return True

for tc in range(1, 11):
    l = int(input())

    arr = [list(input()) for _ in range(8)]


    cnt = 0
    for i in range(8):
        for j in range(8-l+1):
            if is_p(arr[i][j:j+l]):
                cnt += 1

    n_arr = [[0] * 8 for _ in range(8)]
    for i in range(8):
        for j in range(8):
            n_arr[i][j] = arr[j][i]

    for i in range(8):
        for j in range(8-l+1):
            if is_p(n_arr[i][j:j+l]):
                cnt += 1

    print(f'#{tc} {cnt}')
