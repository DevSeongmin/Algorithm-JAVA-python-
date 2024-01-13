# 디피 문제
#answer.sort(key = lambda x : (x[0] * x[1], x[0]))
# 람다 x[0] + x[1]로해서 1시간 삽질했다...

#n*n메트리스의 화학물질이 담겨있으면 [1,1] 없으면 [0, 0]으로 저장하고
# 행렬을 순서대로 반복하며
# 해당 인덱스가 [0,0] 이 아니면 [위 인덱스의 첫값 + 1, 왼쪽 인덱스의 두 번째값 + 1]
#의 점화식으로 계산해 나가다가 오른쪽 아래쪽이 모두 [0,0] 이면 정답 리스트에 삽입


for tc in range(1, int(input()) + 1):
    n = int(input())

    arr = [list(map(lambda x : [1,1] if x >= 1 else [0, 0], list(map(int, input().split())))) + [[0,0]] for _ in range(n)]
    arr.append([[0, 0]] * (n + 1))

    answer = []
    for i in range(n):
        for j in range(n):

            if arr[i][j] != [0, 0]:
                if 0 <= j - 1 < n:
                    arr[i][j][1] = arr[i][j-1][1] + 1
                if 0 <= i -1 < n:
                    arr[i][j][0] = arr[i-1][j][0] + 1

                if arr[i][j+1] == [0,0] and arr[i+1][j] == [0, 0]:
                    answer.append(arr[i][j])


    answer.sort(key = lambda x : (x[0] * x[1], x[0]))
    l = len(answer)
    answer = [j for i in answer for j in i]

    print(f'#{tc} {l}', end = ' ')
    print(*answer)