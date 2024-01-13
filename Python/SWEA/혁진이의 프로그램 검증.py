# 빡구현 문제

# 현재 위치에서 아래칸으로 가려면 y 좌표에 +1을 해줘야하는데
# 리스트에서 아래로 간다고 생각하고 -1해줘서 엄청 헤맨 문제...
# 혁진이 딱밤 마렵다...

from collections import deque

move = {'L': (0, -1),
        'R': (0, 1),
        'U': (-1, 0),
        'D': (1, 0)}

numbers = '0123456789'

for tc in range(1, int(input()) + 1):

    visited = set()
    memory = 0
    moving = 'R'


    y,x = map(int, input().split())
    code = [list(input()) for _ in range(y)]
    answer = 'NO'

    Q = deque()

    Q.append((0, 0, 0, moving))
    visited.add((0, 0, 0, moving))

    while Q:
        cy, cx, m, moving = Q.popleft()

        if code[cy][cx] == '@':
            answer = 'YES'
            break

        if code[cy][cx] in numbers:
            m = int(code[cy][cx])
        if code[cy][cx] == '<':
            moving = 'L'
        if code[cy][cx] == '>':
            moving = 'R'
        if code[cy][cx] == '^':
            moving = 'U'
        if code[cy][cx] == 'v':
            moving = 'D'
        if code[cy][cx] == '_':
            if m == 0:
                moving = 'R'
            else:
                moving = 'L'
        if code[cy][cx] == '|':
            if m == 0:
                moving = 'D'
            else:
                moving = 'U'
        if code[cy][cx] == '+':
            m += 1
            if m == 16:
                m = 0

        if code[cy][cx] == '-':
            m -= 1
            if m == -1:
                m = 15

        if code[cy][cx] == '?':
            for t in 'LRUD':
                ny = (cy + move[t][0]) % y
                nx = (cx + move[t][1]) % x
                if ny == -1:
                    ny = y
                if nx == -1:
                    nx = x
                if (ny,nx,m,t) not in visited:
                    Q.append((ny,nx,m,t))
                    visited.add((ny,nx,m,t))


        else:
            ny = (cy + move[moving][0]) % y
            nx = (cx + move[moving][1]) % x
            if ny == -1:
                ny = y
            if nx == -1:
                nx = x
            if (ny, nx, m, moving) not in visited:
                Q.append((ny, nx, m, moving))
                visited.add((ny, nx, m, moving))




    print(f'#{tc} {answer}')