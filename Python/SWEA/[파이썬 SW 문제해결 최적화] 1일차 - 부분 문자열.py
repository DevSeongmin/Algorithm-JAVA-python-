for tc in range(1, int(input()) + 1):


    n,s = input().split()
    n = int(n)

    l = len(s)
    lcp = [0] * l


    # 접미사 배열 생성
    suffix = []
    for i in range(l):
        suffix.append(s[i:])

    suffix.sort()

    #lcp 배열 만들기
    # 이 전의 접미어와 앞에서부터 몇 칸 일치하는지
    for i in range(1,l):

        cnt = 0
        for j in range(len(suffix[i-1])):
            if suffix[i][j] == suffix[i-1][j]:
                cnt += 1
            else:
                break
        lcp[i] = cnt


    # lcp 배열을 이용해 중복되는 문자의 개수를 빼주며 n의 값이 넘을 때 까지 cnt를 세어준다.
    cnt = 0
    i = -1
    while cnt < n:
        i += 1
        cnt += len(suffix[i]) - lcp[i]


    #현재 접미사에서 첫 문자부터:(cnt - n)까지의 문자가 n번째 문자가 된다.
    answer = suffix[i][0:len(suffix[i]) - (cnt - n)]

    print(f'#{tc} {answer[0]} {len(answer)}')