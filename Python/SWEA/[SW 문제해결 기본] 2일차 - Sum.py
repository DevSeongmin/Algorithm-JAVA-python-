import sys
sys.stdin = open("input.txt", "r")

for _ in range(10):
    t = int(input())


    arr = [list(map(int, input().split())) for _ in range(100)]

    answer = 0

    for i in arr:
        answer = max(answer, sum(i))

    for i in range(100):
        tmp1 = 0
        tmp2 = 0
        for j in range(100):
            tmp1 += arr[i][j]
            tmp2 += arr[j][i]
        answer = max(tmp1,tmp2,answer)


    tmp = 0
    for i in range(100):
        tmp += arr[i][i]
    answer = max(answer, tmp)

    tmp = 0
    for i in range(99,-1,-1):
        tmp += arr[i][i]
    answer = max(answer, tmp)

    print(f'#{t} {answer}')
