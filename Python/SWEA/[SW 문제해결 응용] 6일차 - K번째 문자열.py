
#LCP 배열을 통한 K번째 문자열 구하기 

for tc in range(1, int(input()) + 1):

    n = int(input())
    string = input()

    l = len(string)
    lcp = [0] * l
    
    # 접두사 배열을 만들어줌 
    prefix_arr = [string[i:] for i in range(l)]
    prefix_arr.sort()

    
    # 접두사 배열을 정렬 후 
    # 이전 접두사와 앞에서부터 몇칸 겹치는지 카운트하여 lcp 배열 생성 
    for i in range(1, l):

        tl = min(len(prefix_arr[i]), len(prefix_arr[i-1]))

        cnt = 0
        for j in range(tl):
            if prefix_arr[i][j] == prefix_arr[i-1][j]:
                cnt += 1
            else:
                break

        lcp[i] = cnt


    # 해당 문자열의 글자수의 길이가 부분 문자열의의 개수이고 lcp배열을 통해 몇개가 겹치는지 알 수 있으므로
    # check에 문자열 길이를 n보다 작을 때 까지 더한 후
    # 답 출력
    try:
        check = 0
        i = -1
        while check < n:
            i += 1
            check += len(prefix_arr[i]) - lcp[i]

        answer = prefix_arr[i][:len(prefix_arr[i]) - (check - n)]

        print(f'#{tc} {answer}')
        
    #k값이 만들 수 있는 모든 문자열의 개수보다 크다면 인덱스 에러 발생  #예외처리
    except:
        print(f'#{tc} none')