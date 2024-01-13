# https://www.acmicpc.net/problem/1107

# 처음 풀이 Product사용  90퍼센트대에서 메모리 초과 ... 

target = int(input())
error_num = int(input())

if error_num == 0:
    error_list = list()
else:
    error_list = list(map(str, input().split()))
    

def confirm(x):
    for s_x in str(x):
        if s_x in error_list:
            return False
    return True


solve = abs(100 - target)


for i in range(1_000_001):
    if confirm(i):
        solve = min(solve,
                    abs(target-i) + len(str(i)))
        
print(solve)