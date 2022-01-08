'''
알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
'''
# 1sec

before = input()
if type(before) == 'int':
    print(chr(before))
else:
    print(ord(before))

# ord(문자): 아스키코드 값 반환
# chr(숫자): 아스키코드 값 반환