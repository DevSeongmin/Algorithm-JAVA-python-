for tc in range(1, int(input()) + 1):

    n = list(map(int, input()))
    l = len(n)
    init = [0] * l

    cnt = 0
    for i in range(l):
        if n[i] != init[i]:
            cnt += 1
            for j in range(i,l):
                init[j] = n[i]
    print(f'#{tc} {cnt}')