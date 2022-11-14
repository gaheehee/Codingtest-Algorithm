testNum = int(input())

for i in range(testNum):
    x1, y1 , x2, y2 = map(int, input().split())
    planetNum = int(input())
    cnt = 0

    for j in range(planetNum):
        cx, cy, r = map(int, input().split())

        if r**2 > ((cx - x1)**2 + (cy - y1)**2) and r**2 <= ((cx - x2)**2 + (cy - y2)**2):
            cnt += 1
        if r**2 > ((cx - x2)**2 + (cy - y2)**2) and r**2 <= ((cx - x1)**2 + (cy - y1)**2):
            cnt += 1

    print(cnt)

# 제곱은 1**2
# 반지름 제곱의 값이 
# (원의 중심 좌표 X - 임의의 좌표 TX)의 제곱 + (원의 중심 좌표 Y - 임의의 좌표 TY)
# 의 제곱 값보다 크다면 임의의 좌표는 원의 범위에 포함되어 있다고 할 수 있음