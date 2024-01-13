# 두 리스트를 합치는 함수
def merge(left, right):

    global answer
    if left[-1] > right[-1]:
        answer += 1

    left_len = len(left)
    right_len = len(right)

    result = [0] * (left_len + right_len)

    left_idx = 0
    right_idx = 0
    i = 0

    while left_idx < left_len and right_idx < right_len:
        if left[left_idx] <= right[right_idx]:
            result[i] = left[left_idx]
            i += 1
            left_idx += 1
        else:
            result[i] = right[right_idx]
            i += 1
            right_idx += 1
    while left_idx < left_len:
        result[i] = left[left_idx]
        i += 1
        left_idx += 1
    while right_idx < right_len:
        result[i] = right[right_idx]
        i += 1
        right_idx+=1
    return result


# 리스트를 분할하는 함수
def partition(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr) // 2
    left = partition(arr[:mid])
    right = partition(arr[mid:])

    return merge(left, right)

for tc in range(1, int(input()) + 1):
    n = int(input())
    arr = list(map(int, input().split()))

    answer = 0
    arr = partition(arr)

    print(f'#{tc} {arr[n//2]} {answer}')