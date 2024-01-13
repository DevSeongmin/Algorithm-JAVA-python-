# DP파트에 있는 문제인데...
# Dp문제가 아니였고 문제도 명확하지 않았다...

from collections import deque


for tc in range(1, int(input()) + 1):
    n = int(input())
    arr = list(map(int, input().split()))


    arr = [[arr[i], arr[i+1]] for i in range(0,n*2,2)]
    arr = deque(arr)
    answer = []

    while arr:
        if not answer:
            answer += arr.pop()

        else:
            if arr[0][0] == answer[-1]:
                answer = answer + list(arr.popleft())

            elif arr[0][1] == answer[0]:
                answer = list(arr.popleft()) + answer

            else:
                arr.rotate(1)
    print(f'#{tc}', end = ' ')
    print(*answer)