'''
두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 

수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
'''


reminder_list = []
for i in range(10):
    inn = int(input())
    reminder_list.append(inn % 42)
set_list = set(reminder_list)    
print(len(set_list))


# map(func,x): 리스트 x의 각 요소에 func을 적용
# set(list): list에서 중복된 값을 제거(set: 집합 자료형)
# len(list): list 요소 개수
# input_list = list(map(int,input().split()))
