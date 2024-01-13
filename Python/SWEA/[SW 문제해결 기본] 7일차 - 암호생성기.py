from collections import deque

for _ in range(8):

    tc = int(input())

    arr = deque(list(map(int, input().split())))


    flag = True
    while flag:

        for i in range(1, 6):
            tmp = arr.popleft()

            if tmp - i <= 0:
                arr.append(0)
                flag = False
                break
            arr.append(tmp - i)


    print(f'#{tc}' , end = ' ')
    print(*arr)

