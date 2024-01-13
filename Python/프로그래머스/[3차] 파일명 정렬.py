# 파이썬은 안정 정렬을 지원하므로 
# 파일명의 head, mid, tail을 
# head, tail은 문자열 기준 (대, 소문자 구분 X)
# mid 는 숫자기준으로 정렬하여 문제를 해결할 수 있다.

# 파이썬 풀이 핵심은 sort 함수나 메서드에 Key값을 주는 방법
# lambda 를 사용할 줄 알면 쉽게 풀 수 있다.
def seperate(file_name):
    flag = True
    
    # tail이 없을 경우를 대비해 문제의 파일명 길이 제한인 100을 임의로 넣어줌 
    # ex)) "abc"[:100]   ----->   ""
    # 이렇게 해야 tail이 없어도 return값이 길이가 3인 튜플로 잘 반환 
    end = 100
    for i in range(len(file_name)):
        
        #head가 끝나는 인덱스 찾기 
        if flag and file_name[i].isdigit():
            mid = i
            flag = False
        
        # mid가 끝나는 인덱스 찾기
        if not flag and not file_name[i].isdigit():
            end = i-1
            break
            
    return (file_name[:mid], file_name[mid:end+1], file_name[end+1:])

def solution(files):
    answer = []
    for i in files:
        answer.append(seperate(i))

    return list(map(lambda x : "".join(x), sorted(answer, key = lambda x:(x[0].lower(), int(x[1])))))