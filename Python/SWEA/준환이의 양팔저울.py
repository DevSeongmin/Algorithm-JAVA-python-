def dfs(depth, left, right):
    global solve
    if left < right:
        return

    # 만약 현재 왼쪽 저울이 전체 추의 절반 무게보다 크거나 같다면
    # 즉 나머지 추는 어디에 어떤 순서로 놓든 상관이 없다.
    if left >= add:
        # 나머지 추를 left, right에 놓는 경우 2 ** (남은 추)와  각 순서가 있기에 (남은 추)! 을 곱해서 경우에 수를 더해준다.
        solve += 2 ** (n - depth) * fac[n-depth]
        return

    # 위 경우를 제외하고 추를 두면서 왼쪽이 전체 추의 절반이 안되고 모든 추를 올렸을 경우 += 1
    if depth == n:
        print(depth,left,right, 1)
        solve += 1
        return


    # 탐색 부분
    for i in range(n):
        if not visited[i]:

            visited[i] = True
            # 현재 추를 왼쪽 저울에 두는 경우
            dfs(depth + 1, left + arr[i], right)
            visited[i] = False

            visited[i] = True
            # 현재 추를 오른쪽 저울에 두는 경우
            dfs(depth + 1, left, right + arr[i])
            visited[i] = False



# 이걸로 시간초과 해결;;
# n의 입력값이 최대 9로 9까지의 팩토리얼 리스트를 만들어 둠
fac= [1, 1]
for i in range(2,10):
    fac.append(fac[-1] * i)



for tc in range(1,int(input()) + 1):
    n = int(input())
    arr = list(map(int, input().split()))
    visited = [False] * n


    # 전체 무게의 절반 값 구하기
    # 만약 전체 무게가 홀수면 //2 + 1
    tmp = sum(arr)
    if tmp % 2 == 0:
        add = tmp // 2
    else:
        add = tmp // 2 + 1

    solve = 0
    dfs(0,0,0)
    print(f'#{tc} {solve}')
