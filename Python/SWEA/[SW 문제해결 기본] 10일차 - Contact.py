from collections import deque

# BFS를 활용하여 해결

for tc in range(1,11):

    L, start_point = map(int, input().split())

    arr = list(map(int, input().split()))
    distinct = set()

    graph = {}
    for i in range(0,L,2):
        distinct.add((arr[i], arr[i+1]))

    for i in distinct:
        if i[0] not in graph:
            graph[i[0]] = [i[1]]
        else:
            graph[i[0]].append(i[1])

    visited = set()

    queue = deque([start_point])
    tmp_queue = deque()


    # 이 부분잉 핵심
    # 마지막 연결이 말단이 없이 연결될 수도 있고 말단이 있게 연결될 수도 있다. 
    solve = deque([[], []])
    answer = []
    while queue:
        tmp_queue = deque(queue)
        queue = deque()

        while tmp_queue:
            tmp = tmp_queue.popleft()
            if tmp not in visited:
                answer.append(tmp)
            visited.add(tmp)

            if tmp in graph:
                for g in graph[tmp]:
                    if g not in visited:
                        queue.append(g)

        solve.append(answer)
        solve.popleft()
        answer= []

    # 이 부분에서 말단이 없이 끝나는 경우에는 덱에 
    # [말단 이전], [말단]  형식이고 
    # 말단이 있이 끝나는 경우에는
    # [말단], [] 으로 끝나서 아래와 같이 처리해줌
    while not solve[-1]:
        solve.pop()

    print(f'#{tc} {max(solve[-1])}')

# 야매 풀이 같기도...