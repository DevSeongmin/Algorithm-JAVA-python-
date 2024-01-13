# DP를 활용한 0-1 배낭문제 풀이

for tc in range(1, int(input()) + 1):
    box, n = map(int, input().split())

    arr = [0]
    for _ in range(n):
        arr.append(list(map(int, input().split())))

    #DP 테이블 생성
    dp = [[-1] * (box + 1) for _ in range(n+1)]

    # 첫 열과 첫 행은 모두 0으로 초기화
    for i in range(box+1):
        dp[0][i] = 0

    for i in range(n+1):
        dp[i][0] = 0


    for i in range(1, n+1):
        for w in range(1, box+1):
            # 배낭 용량이 현재 넣을 아이템 무게 보다용량이 낮다면 DP테이블의 윗값 대입
            if w < arr[i][0]:
                dp[i][w] = dp[i-1][w]
            # 배낭 용량이 현재 넣으려는 아이템 무게보다 용량이 크다면
            # max(dp[i-1][w-arr[i][0]]+arr[i][1], dp[i-1][w]) 대입
            # Ex) 만약 현재 넣을 수 있는 용량이 10인데 5인 아이템이 들어 왔다면
            # (이전 행의 (10 - 5) 와 현재 아이템의 가치를 더한값)과 (바로 위 행의값)중 큰값을 대입
            else:
                dp[i][w] = max(dp[i-1][w-arr[i][0]]+arr[i][1], dp[i-1][w])


    print(f'#{tc} {dp[-1][-1]}')