'''
과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 
주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
'''

import sys

while True:
    num = list(map(int, sys.stdin.readline().split()))
    num.sort()
    if num[0] == 0 and num[1] == 0 and num[2] == 0:
        break
    
    if num[0]**2 + num[1]**2 == num[2]**2:
        print("right")
    else:
        print("wrong")