import sys
sys.stdin = open("input.txt", "r")

for tc in range(1, 11):

    n = int(input())
    buildings = list(map(int, input().split()))
    answer = 0
    for i in range(2,n-2):

        if buildings[i] == max(buildings[i],buildings[i-2],buildings[i-1],buildings[i+1],buildings[i+2]):
            answer += min(buildings[i] - buildings[i-1],
            buildings[i] - buildings[i-2],
            buildings[i] - buildings[i+1],
            buildings[i] - buildings[i+2],)

    print(f'#{tc} {answer}')