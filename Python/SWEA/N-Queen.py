

# 퀸을 뒀을 때 같은 열, 대각선 상에 있는지 확인하는 함수
def check(x):
    for i in range(x):
        if arr[i] == arr[x] or abs(x-i) == abs(arr[x] - arr[i]):
            return False
    return True


def N_queen(x):
    global answer

    # 모든 열에 하나씩 뒀으므로 정답 += 1
    if x == n:
        answer += 1
        return
    else:

        for i in range(n):
            # 퀸을 두고 이전에 둔 퀸이랑 서로 잡을 수 있는 위치인지 체크
            arr[x] = i
            # 서로 잡을 수 없는 위치라면 퀸의 다음 단계 재귀적으로 수행
            if check(x):
                N_queen(x+1)


for tc in range(1, int(input())+1):


    n = int(input())

    arr = [0]*n
    answer = 0

    N_queen(0)
    print(f'#{tc} {answer}')