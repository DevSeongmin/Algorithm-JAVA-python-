# https://www.acmicpc.net/problem/1041


n = int(input())

# 1 일때 에외 ,2 일때 예외
one_side = (n - 2) ** 2  +  ((n - 2) ** 2 + (n-2)) * 4
two_side =int((n ** 2 * 5 - 12 - one_side) / 2)
three_side = 4

dice = list(map(int, input().split()))
arr = sorted([min(dice[0], dice[5]), min(dice[1], dice[4]), min(dice[2], dice[3]) ])


if n == 1:
    dice.sort()
    print(sum(dice[0:5]))
    
elif n == 2:
    print(4 * sum(arr) + 4 * sum(arr[:2]))
else:
    print(int(three_side * sum(arr) + one_side * arr[0] + two_side * (arr[0] + arr[1])))


