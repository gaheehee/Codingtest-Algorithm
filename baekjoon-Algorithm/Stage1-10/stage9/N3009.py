''''
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
'''

xarr = []
yarr = []

for _ in range(3):
    x, y = map(int, input().split())
    if x in xarr:
        del xarr[xarr.index(x)]
    else:
        xarr.append(x)
    
    if y in yarr:
        del yarr[yarr.index(y)]
    else:
        yarr.append(y)


print(xarr[0], yarr[0], sep=' ')
    
