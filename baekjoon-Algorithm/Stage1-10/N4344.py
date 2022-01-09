'''
대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.

각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
'''

testcaseNum = int(input())

for i in range(testcaseNum):
    testcase = list(map(int, input().split()))
    num = testcase[0]
    average = (sum(testcase)-num)/num
    count = 0
    for j in range(1,len(testcase)):
        if testcase[j] > average:
            count += 1
    print('%0.3f%%' % float(float(count*100)/float(num)))



# '%0.3f' % float(수): 소수점 표현하기
# '%0.3f%%' % float(수): 값 뒤에 % 붙음
# for score in testcase[1:]: 1번 인덱스부터 조회