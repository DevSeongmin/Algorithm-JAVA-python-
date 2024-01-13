# https://www.acmicpc.net/problem/14500

# 그냥 구현 문제 

N,M = map(int, input().split())

maps = [list(map(int, input().split())) for _ in range(N)]


# 2 x 2 정사각형
def two_two():
    max_val = 0
    for i in range(N-1):
        for j in range(M-1):
            max_val = max(max_val, maps[i][j] + maps[i+1][j+1] + maps[i+1][j] + maps[i][j+1]) 
    return max_val

# 1 x 4 일자
def one_line():
    max_val = 0 
    for i in range(N):
        for j in range(M-3):
            max_val = max(max_val, maps[i][j] + maps[i][j+1] + maps[i][j+2] + maps[i][j+3])
            
    for i in range(N-3):
        for j in range(M):
            max_val = max(max_val, maps[i][j] + maps[i+1][j] + maps[i+2][j] + maps[i+3][j])
    return max_val


def L_line():
    max_val = 0
    for i in range(0,N-2):
        for j in range(0,M-1):
            max_val = max(max_val,
                          maps[i][j] + maps[i+1][j] + maps[i+2][j] + maps[i+2][j+1],
                          maps[i][j+1] + maps[i+1][j+1] + maps[i+2][j+1] + maps[i+2][j],
                          maps[i][j] + maps[i+1][j] + maps[i+2][j] + maps[i][j+1],
                          maps[i][j] + maps[i][j+1] +  maps[i+1][j+1] + maps[i+2][j+1])
    
            
    for i in range(0, N-1):
        for j in range(0, M-2):
            max_val = max(max_val,
                maps[i][j] + maps[i+1][j] + maps[i+1][j+1] + maps[i+1][j+2],
                maps[i+1][j] + maps[i+1][j+1] + maps[i+1][j+2] + maps[i][j+2],
                maps[i][j] + maps[i][j+1] + maps[i][j+2] + maps[i+1][j],
                maps[i][j] + maps[i][j+1] + maps[i][j+2] + maps[i+1][j+2])
    
    return max_val



def z_line():
    max_val = 0
    for i in range(0,N-1):
        for j in range(0,M-2):
            max_val = max(max_val,
                          maps[i][j] + maps[i][j+1] + maps[i+1][j+1] + maps[i+1][j+2],
                          maps[i+1][j] + maps[i+1][j+1] + maps[i][j+1] + maps[i][j+2])

    for i in range(0, N-2):
        for j in range(0, M-1):
            max_val = max(max_val,
                          maps[i][j] + maps[i+1][j] + maps[i+1][j+1] + maps[i+2][j+1],
                          maps[i][j+1] + maps[i+1][j+1] + maps[i+1][j] + maps[i+2][j])
    return max_val


def fuck():
    max_val = 0
    
     #
    ###
    for i in range(0,N-1):
        for j in range(0, M-2):
            max_val = max(max_val,
                          maps[i][j+1] + maps[i+1][j] + maps[i+1][j+1] + maps[i+1][j+2],
                          maps[i][j] + maps[i][j+1] + maps[i][j+2] + maps[i+1][j+1])
    
    
    
    for i in range(N-2):
        for j in range(0, M-1):
            max_val = max(max_val,
                          maps[i][j] + maps[i+1][j] + maps[i+2][j] + maps[i+1][j+1],
                          maps[i][j+1] + maps[i+1][j+1] + maps[i+2][j+1] + maps[i+1][j])
    
    return max_val



print(max(two_two(), one_line(), L_line(), z_line(), fuck()))
    