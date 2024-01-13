# 불량 사용자인지 체크하는 함수
def check(user,ban):
    if len(ban) != len(user):
        return False
    for i in  range(len(ban)):
        if ban[i] != '*':
            if ban[i] != user[i]:
                return False
    return True


from itertools import permutations

def solution(user_id, banned_id):
    # 유저 아이디를 불량 사용자의 개수만큼 뽑은 퍼뮤테이션 튜플을 만든다    
    user_id = tuple(permutations(user_id, len(banned_id)))
    cnt = 0
    
    check_list = []
    for users in user_id:
        
        #퍼뮤테이션으로 뽑은 사용자와 불량 사용자가 각각 일치하는지 체크
        for user, ban in zip(users, banned_id):
            if not check(user,ban):
                break
        # 만약 사용자들의 순서들이 불량 사용자 순서들에 check된다면 카운트를 해준다.
        else:
            # 이 조건으로 사용자가 같지만 순서가 다른 경우는 걸러준다.
            if set(users) not in check_list:
                check_list.append(set(users))
                cnt += 1

    print(check_list)
    return (cnt)