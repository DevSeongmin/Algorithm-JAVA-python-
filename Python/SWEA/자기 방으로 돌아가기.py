
T = int(input())

for tc in range(1, T+1):
    n = int(input())
    # 인덱스로 접근하기 위해 방의 개수만큼(400개) 리스트 초기화
    rooms = [0] * 401

    for _ in range(n):
        s, e = map(int, input().split())

        # 시작 방이 수가 더 크면 s, e를 바꿔줌 
        if s > e:
            s,e = e, s

        if s % 2 == 0:
            s -= 1

        if e % 2 != 0:
            e += 1

        # 이동해야하는 거리들을 +1씩해줌 
        for i in range(s,e+1):
            rooms[i] += 1

    # 이동해야하는 거리들의 최댓값으로 최소 시간을 구함 
    print(f'#{tc} {max(rooms)}')
