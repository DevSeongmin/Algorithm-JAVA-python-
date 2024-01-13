for tc in range(1,int(input()) + 1):

    N,K = map(int, input().split())

    cnt = 0
    arr = list(range(1,N+1))

    arr = arr[::-1]

    std = sum(arr)

    def dfs(i,value,std):
        global cnt

        # 조건에 맞으니 cnt += 1
        if value == K:
            cnt += 1
            return

        # 남은 집합들을 다 더해도 목표값보다 작으면 가지치기
        if std + value < K:
            return

        # 리스트의 인덱스의 끝까지 갔다면 리턴
        if i >= N:
            return

        # 현재 집합의 합이 목표값보다 크면 리턴
        if value > K:
            return


        # 현재 인덱스의 값을 더했을때와 안더하고 넘어갔을 때 2가지로 분기
        dfs(i + 1, arr[i] + value, std - arr[i])
        dfs(i + 1, value, std - arr[i])

    dfs(0,0, std)
    print(f'#{tc} {cnt}')