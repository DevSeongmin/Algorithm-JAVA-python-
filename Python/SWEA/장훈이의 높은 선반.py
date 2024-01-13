# DFS로 가지를 뻗어나가며 탐색

def dfs(depth, high):
    global solve

    # 가지치기 target값 보다 큰 값으로 solve값을 갱신하고
    # solve 값보다 현재 high값이 크다면 리턴
    if high >= solve:
        return


    if depth >= n:
        if high >= target:
            solve = high
        return

    # 이 부분이 핵심

    # 현재 인덱스의 값을 더해서 재귀 수행
    dfs(depth +1, high + arr[depth])

    # 현재 인덱스의 값을 더하지 않고 재귀 수행
    dfs(depth+1, high)

    # deqpth가 n이 되면 각각의 요소들을 뽑고 안뽑고의 조합들의 합으로 구성된다.

for tc in range(1, int(input()) + 1):

    n, target = map(int, input().split())
    arr= list(map(int, input().split()))

    solve = float('inf')
    dfs(0, 0)

    print(f'#{tc} {solve - target}')