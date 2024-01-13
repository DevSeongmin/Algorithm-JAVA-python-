from collections import deque

for tc in range(1, int(input()) + 1):

    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]

    pivot = 0
    arr.sort(key = lambda x: (x[1], x[0]))
    arr = deque(arr)

    answer = 0
    while arr:
        tmp = arr.popleft()
        if tmp[0] >= pivot:
            answer += 1
            pivot = tmp[1]

    print(f'#{tc} {answer}')