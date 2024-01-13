# 에스토스테네스의 체를 이용한 소수 구하기
for tc in range(1, int(input()) + 1):
    a, b = map(int, input().split())


    arr = [True] * (b+1)


    for i in range(2, len(arr)// 2 + 1):
        if arr[i]:
            for j in range(i+i, len(arr), i):
                arr[j] = False

    answer = 0
    for i in range(a+1, b):
        if arr[i]:
            answer += i

    print(f'#{tc} {answer}')