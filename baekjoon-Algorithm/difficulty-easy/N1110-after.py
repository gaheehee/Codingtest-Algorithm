def getCycle(n):
    comparetarget = n
    num = 0
    while True:
        first = n // 10
        second = n % 10
        sumresult = first  + second
        sumfirst = sumresult // 10
        sumsecond = sumresult % 10
        n = second*10 + sumsecond
        num += 1
        if comparetarget == n:
            break
    return num


result = getCycle(int(input()))
print(result)


# / : 나누기(float형)
# // : 몫(int형)
# % : 나머지