#https://www.acmicpc.net/problem/2096


# 이 문제는 https://www.acmicpc.net/problem/1932 정수삼각형 과 매우 유사함 
# 하지만 메모리 제한이 엄격해서 
# DP를 하면서 메모리가 넘치지 않도록 필요없어지는 값들을 삭제해주는게 핵심 
import copy 

N = int(input()) 
tmp = map(int,input().split())

max_arr = list(tmp)
min_arr = copy.deepcopy(max_arr)


for i in range(N-1):
    a,b,c = map(int,input().split())
    
    max_tmp = []
    min_tmp = []
    
    max_tmp.append(a + max(max_arr[:2]))
    min_tmp.append(a + min(min_arr[:2]))
    
    
    max_tmp.append(b + max(max_arr))
    min_tmp.append(b + min(min_arr))
    
    
    max_tmp.append(c+ max(max_arr[1:]))
    min_tmp.append(c+ min(min_arr[1:]))
    
    max_arr = max_tmp 
    min_arr = min_tmp 
    

print(max(max_arr), min(min_arr))