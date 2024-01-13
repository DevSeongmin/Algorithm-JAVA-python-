for tc in range(1, int(input()) + 1):
    a, b = map(int, input().split())
    arr = []

    
    # 각 피라미드에서의 인덱스를 구해줌 
    for a in sorted([a,b]):
        tmp = 1
        i = 0
        while 1:
            a -= tmp
            if a <= 0:
                arr.append([i,a+tmp-1])
                break
            tmp += 1
            i += 1


    # 각 인덱스를 피라미드에서의 위치에 맞게 계산한...
    if arr[1][1] <= arr[0][1]:
        answer = (arr[1][0] - arr[0][0] + abs(arr[1][1] - arr[0][1]))
    else:
        if arr[1][0] - arr[0][0] < arr[1][1]-arr[0][1]:
            answer = ((arr[1][1]-arr[0][1]))
        else:
            answer = (arr[1][0] - arr[0][0])

    print(f'#{tc} {answer}')
