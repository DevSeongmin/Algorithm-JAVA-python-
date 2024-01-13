# 시간 초과가 뜬 코드 

# def solution(X, Y):
#     X, Y = sorted(X), sorted(Y)
    
#     answer = ''
    
#     while X and Y:
#         if X[-1] == Y[-1]:
#             answer += X[-1]
#             X.pop()
#             Y.pop()
            
#         elif X[-1] > Y[-1]:
#             X.pop()
            
#         else:
#             Y.pop()
            
#     return str(int(answer)) if answer else "-1"   



# 두번째 시간초과가 난 코드 


# def solution(X, Y):
    
#     x_d = dict(zip('0123456789',(0,) * 10))
#     y_d = dict(zip('0123456789',(0,) * 10))
    
#     for i in X:
#         x_d[i] += 1
    
#     for i in Y:
#         y_d[i] += 1
        
#     answer= ''
#     for i in '9876543210':
#         answer += i * min(x_d[i], y_d[i])
        
#     return str(int(answer)) if answer else "-1"






# 최종 풀이 코드 




def solution(X, Y):
    
    x_d = dict(zip('0123456789',(0,) * 10))
    y_d = dict(zip('0123456789',(0,) * 10))
    
    for i in X:
        x_d[i] += 1
    
    for i in Y:
        y_d[i] += 1
        
    answer= ''
    for i in '9876543210':
        answer += i * min(x_d[i], y_d[i])
    
    
    # answer의 길이 범위가 최대 3,000,000으로 int형으로 반환하고 str형으로 다시 반환해주는 코드 대신
    # 아래의 코드로 해결
    while len(answer) > 1 and answer[0] == '0':
        answer = answer[1:]
    
    return answer if answer else "-1"