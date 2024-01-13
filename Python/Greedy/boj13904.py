# https://www.acmicpc.net/submit/13904/60427551

# 문제 핵심
# 그리디하게 과제를 배정하는 테크닉이 필요함 
# schedule 이라는 리스트를 만들어서 구현 


N = int(input())

arr = sorted([list(map(int, input().split())) for i in range(N)], key = lambda x : x[1])

schedule = [0] * (max(arr)[0] + 1)



while arr:
    time, score = arr.pop()
    while time > 0:
        if schedule[time] < score:
            schedule[time] = score
            break
        else:
            time -= 1
        
        
print(sum(schedule))
    

