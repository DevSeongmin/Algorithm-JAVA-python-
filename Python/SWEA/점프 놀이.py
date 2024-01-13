# 탐색인줄알고 엄청 해맸는데
# 결국 디피였다....
# 1부터 target 까지 순서대로
# dp의 숫자가 2인 칸에 1에서 올 수 있는 가장 짧은 경우를 갱신
# 위 과정을 반복하고 target값이 있는 위치에서 가장 최솟값을 출력해준다.

for tc in range(1, int(input()) + 1):
    n, target = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    dp = [[float('inf')] * n for _ in range(n)]


    #좌표를 담기 위한 딕셔너리 
    d = {i : [] for i in range(1,target + 1)}

    for i in range(n):
        for j in range(n):
            for t in range(1, target + 1):
                if arr[i][j] == t:
                    d[t].append((i, j))

    # 초기 시작인 1의 값이 있는 좌표는 DP테이블에 0으로 초기화
    for y, x in d[1]:
        dp[y][x] = 0

    
    # 2 부터 목표값까지 차근차근 DP테이블 업데이트 
    # DP[현재 좌표] = min(DP[현재 좌표], 현재 좌표-1에서 올 수 있는 맨허튼 거리 값)
    for i in range(2, target + 1):
        for y, x in d[i]:
            for by, bx in d[i-1]:
                dp[y][x] = min(dp[by][bx] + (abs(y-by) + abs(x-bx)), dp[y][x])

    answer = float('inf')

    # 목표 값들의 저장된 맨허튼 거리의 최솟 값을 정답으로
    for y, x in d[target]:
        answer = min(answer, dp[y][x])

    # 초기값은 무한대라면 도달이 불가능함으로 -1 을 정답으로 
    if answer == float('inf'):
        answer = -1

    print(f'#{tc} {answer}')