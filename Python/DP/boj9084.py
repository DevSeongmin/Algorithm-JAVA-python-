# https://www.acmicpc.net/problem/9084


for _ in range(int(input())):

    _ = input()
    coins = list(map(int, input().split()))
    target = int(input())

    dp_arr = [0] * (target + 1)
    dp_arr[0] = 1


    for i in coins:
        for j in range(i,target+1):
            dp_arr[j] += dp_arr[j-i]
            
            
    print(dp_arr[-1])