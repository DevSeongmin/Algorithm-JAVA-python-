def check(x,y,board):
    '''2 * 2 모두 같은 블럭이라면 제거하기 위해 set()자료 구조에 해당 좌표를 넣어주고 반환해 주는 함수
    중복을 피하기 위해 set 자료구조 사용 '''
    check_set = set()
    for i in range(y-1):
        for j in range(x-1):
            if board[i][j] == board[i+1][j] == board[i][j+1] == board[i+1][j+1] != '':
                check_set.update(((i,j), (i+1,j), (i,j+1), (i+1,j+1)))
    return check_set

def fall(x,y,board):
    '''2*2 블럭이 모두 같아 없애준 후 나머지 공백을 떨어뜨리는 함수'''
    for idx, i in enumerate(board):
        if '' in i:
            new = [''] * i.count('')
            
            for j in i:
                if j != '':
                    new.append(j)
            board[idx] = new
    return board
            
    
    
def solution(x, y, board):
    
    answer = 0
    
    # 2 x 2 블록들이 떨어지는 것을 슬라이싱으로 간단하게 구현하기 위해 전치 행렬로 변환
    board = [[board[i][j] for i in range(x)] for j in range(y)]

    while 1:
        
        tmp_set = check(x,y,board)
            
        # 더 이상 2*2 같은 블럭이 없다면 실행 중단 
        if tmp_set == set():
            break
        
        # 없애는 블록들 수 카운트
        answer += len(tmp_set)

        for i, j in tmp_set:
            board[i][j] = ''

        board = fall(x,y,board)
        
    return answer