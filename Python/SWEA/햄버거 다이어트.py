def search(happy, kal, depth):
    global answer
    if kal > maximum:
        return

    answer = max(answer, happy)

    if depth == n:
        return

    search(happy, kal, depth + 1)
    search(happy + arr[depth][0], kal + arr[depth][1], depth + 1)

for tc in range(1, int(input()) + 1):
    n, maximum = map(int, input().split())
    arr = []
    for i in range(n):
        arr.append(list(map(int, input().split())))
    answer = 0
    search(0,0,0)
    print(f'#{tc} {answer}')