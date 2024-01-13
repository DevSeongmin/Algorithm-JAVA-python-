for tc in range(1, int(input()) + 1):

    n, second, bread = map(int, input().split())
    stock = 0
    time = 0
    person = sorted([0] + list(map(int, input().split())))
    answer = 'Possible'
    for i in range(1, n + 1):
        time += person[i] - person[i-1]
        if time >= second:
            stock += time //second * bread
            time = time % second
        if stock == 0:
            answer = 'Impossible'
        stock -=1
    print(f'#{tc} {answer}')