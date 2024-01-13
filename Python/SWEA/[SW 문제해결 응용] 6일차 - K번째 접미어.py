
for tc in range(1, int(input()) + 1):
    n = int(input())
    word = input()

    answer = sorted([word[i:] for i in range(len(word))])


    try:
        print(f'#{tc} {answer[n-1]}')
    except:
        print(f'#{tc} none')
