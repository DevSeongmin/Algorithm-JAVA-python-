def move(coord, direction):
    if direction == 'U':
        return coord[0], coord[1] + 1
    elif direction == 'D':
        return coord[0], coord[1] - 1
    elif direction == 'L':
        return coord[0] - 1, coord[1]
    elif direction == 'R':
        return coord[0] + 1, coord[1]

N, K = map(int, input().split())
S = input().strip()

L = N * K
cycle_length = L % N

# 주기의 길이만큼 문자열을 잘라서 새로운 문자열 P를 만듦
P = S[:cycle_length]

# P를 2번 이어 붙여 새로운 문자열 T를 만듦
T = P * 2

current_coord = (0, 0)

for direction in T:
    current_coord = move(current_coord, direction)

if current_coord == (0, 0):
    print("YES")
else:
    print("NO")
