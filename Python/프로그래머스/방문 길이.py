# 2차원 좌표 평면상에서 이동 한 길의 개수를 구하는 문제
# set 자료구조를 이용하여 풀이하였고 이동한 직선에 대해 
# x1, y1 --> y2, x2
# x2, y2 --> x1, y1  
# 위 두 가지의 경우를 set에 넣어주고 
# 마지막에 set의 길이 // 2 를 리턴하여 답을 구할 수 있었다.

def solution(dirs):
    
    move_d = {'U' : (0,1), 'D' : (0,-1), 'R' : (1,0), 'L' : (-1,0)}
    current = [0,0]
    length_set = set()
    
    for d in dirs:
        if -5 <= current[0] + move_d[d][0] <= 5 and -5 <= current[1] + move_d[d][1] <= 5:
            tmp = tuple(current)
            current[0] += move_d[d][0]
            current[1] += move_d[d][1]
            length_set.add(tmp + tuple(current))
            length_set.add(tuple(current) + tmp)
            
    return length_set.__len__() // 2