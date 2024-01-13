# BFS 문제

from collections import deque

for tc in range(1, int(input()) + 1):

    # BFS중 Queue가 너무 커지는 것을 방지하고 중복된 값이면 반복하지 않기위해 방문 셋 생성 
    visited = set()
    start, target = map(int, input().split())


    queue = deque()
    queue.append([start,0])
    visited.add(start)


    while 1:
        num, depth = queue.popleft()

        if num -1 not in visited and num-1 <= 1_000_000:
            visited.add(num-1)
            queue.append(([num-1, depth+1]))

        if num +1 not in visited and num + 1 <= 1_000_000:
            visited.add(num+1)
            queue.append(([num+1, depth+1]))

        if num * 2 not in visited and num * 2 <= 1_000_000:
            visited.add(num*2)
            queue.append(([num*2, depth+1]))

        if num -10 not in visited and num - 10 <= 1_000_000:
            visited.add(num-10)
            queue.append(([num-10, depth+1]))



        if num == target:
            break



    print(f'#{tc} {depth}')