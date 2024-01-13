def check(arr):

    for i in range(3,11):
        if min(arr[i-3:i]) == 1:
            return True
    return False


for tc in range(1, int(input()) + 1):

    arr = list(map(int, input().split()))

    one = [0] * 10
    two = [0] * 10


    for i in range(0,len(arr),2):

        one[arr[i]] += 1
        if max(one) >= 3 or check(one):
            answer = 1
            break

        two[arr[i+1]] += 1
        if max(two) >= 3 or check(two):
            answer = 2
            break

    else:
        answer = 0


    print(f'#{tc} {answer}')