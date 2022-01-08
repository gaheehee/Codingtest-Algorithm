'''
N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
'''
# 2sec

n = int(input())
numbers = input()
numList = list(map(int, numbers))
print(sum(numList))