# 작성자 : 황성민
# 작성일자 : 24.01.20
# 문제 접근 및 풀이 : https://blog.naver.com/steadydeveloper/223328513149


N = int(input())

if N < 2:
    print(0)
    exit(0)

arr = [True] * (N + 1)
arr[0], arr[1] = False, False

primes = []
for i in range(N+1):
    if arr[i]:
        primes.append(i)
        for j in range(i+i, N+1, i):
            arr[j] = False
            

l = len(primes)
left, right = 0, 0
range_sum = primes[0]
answer = 0


while left <= right:
    
    if range_sum > N:
        range_sum -= primes[left]
        left+= 1
    
    
    elif range_sum < N:
        right+= 1
        
        if right >= l:
            break
        
        range_sum += primes[right]
    
    else:
        answer += 1
        range_sum -= primes[left]
        left+= 1

print(answer)