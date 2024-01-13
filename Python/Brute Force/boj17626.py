# https://www.acmicpc.net/problem/17626

# 수학적 구현 문제 
# DP로도 풀 수 있다고 한다.

N = int(input())


def four_squares(N):
    if int(N**0.5) == N**0.5:
        return 1
    
    for i in range(1,int(N**0.5) + 1):
        if (N - i**2) ** 0.5 == int((N - i**2) ** 0.5):
            return 2
        
    
    for i in range(1,int(N**0.5) + 1):
        
        for j in range(1,int((N - i**2) ** 0.5) + 1):
            
            if (N - i**2 - j**2) ** 0.5 == int((N - i**2 - j**2) ** 0.5):
                return 3
            
            
    return 4
    
print(four_squares(N))