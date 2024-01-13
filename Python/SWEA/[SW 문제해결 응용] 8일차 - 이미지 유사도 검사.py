# 이 문제는 최장 공통 부분수열 찾기(LCS)와 동일한 문제이다.

# 점화식

# 첫 번째 문자의 i번짜 문자와 두 번 째 문자열의 j 번째 문자가 같을경우
# dp[i][j] = dp[i-1][j-1] + 1

# 다를 경우
# dp[i][j] = max(dp[i-1][j], dp[i][j-1])

# 다음과 같이 점화식을 세워서
# 가장 긴 공통 부분 수열의 최장 길이를 구할 수 있다.

for tc in range(1, int(input()) + 1):

    n= int(input())

    a, b = ' ' +  input(), ' ' + input()

    dp = [[0] * (n+1) for _ in range(n+1)]


    for i in range(1, n+1):
        for j in range(1, n+1):
            if a[i] == b[j]:
                dp[i][j] = dp[i-1][j-1] + 1
            elif a[i] != b[j]:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    answer = dp[-1][-1] / n


                    # f-string에서의 포맷팅 하는 방법
    print(f'#{tc} {answer*100:.2f}')