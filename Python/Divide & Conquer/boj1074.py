#https://www.acmicpc.net/problem/1074

N, r, c = map(int, input().split())

# 처음 사각형의 1,2,3,4분면으로 나누고 r,c가 포함하는 분면에 또 들어가 
# 1,2,3,4분면으로 나눠가며 N번의 반복으로 문제를 해결 할 수 있음  
solve = 0

for i in range(N,0,-1):
    divide = 2 ** i // 2
    
    if r < divide:
        
        # 1사분면에 있는 경우
        if c < divide:
            pass
        # 2사분면에 있는 경우 
        elif c >= divide:
            c -= divide
            solve += divide**2
            
    
    elif r >= divide:
        
        # 3사분면에 있는경우 
        if c < divide:
            r -= divide
            solve += (divide ** 2) * 2
            pass
        
        # 4사분면에 있는경우 
        elif c >= divide:
            c -= divide
            r-= divide
            solve += (divide ** 2) * 3
            
            
print(solve)
