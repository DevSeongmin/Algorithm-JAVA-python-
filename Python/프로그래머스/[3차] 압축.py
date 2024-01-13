# 올바르게 문자열의 위치에 대한 포인터의 증감과 
# 슬라이싱의 이해도를 높일 수 있는 문제

def solution(msg):
    
    # 딕셔너리 컴프리헨션으로 A : 1 ~ Z : 26 인 딕셔너리 생성
    d = {chr(i):i - 64  for i in range(65,91)}
    d_s = 27 
    l = len(msg)
    s = 0 
    answer = []
    
    # 문자열의 시작인덱스를 가르키는 s 가 문자열 전체 길이보다 길어지면 중단 
    while s < l:
        add = 1
        # s인덱스부터 문자열의 길이를 한칸씩 늘려가며 딕셔너리 안에 있는지 확인 
        while s + add <= l and msg[s:s+add] in d:
            add += 1
        
        # 시작 인덱스 s부터 한 칸씩 늘려가며 딕셔너리 안에 있는 가장 긴 문자열의 벨류값을 정답 리스트에 어펜드
        answer.append(d[msg[s:s+add-1]])
        
        # 시작 인덱스 s부터 한 칸씩 늘려가며 딕셔너리 안에 있는 가장 긴 문자열보다 1칸 더 긴 문자열을 딕셔너리에 업데이트
        d[msg[s: s+add]] = d_s
        d_s += 1
        
        # 문자열 시작 인덱스 s를 알맞게 오른쪽으로 밀어줌 
        s += add-1
    
    return answer
        