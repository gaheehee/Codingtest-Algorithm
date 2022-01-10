'''
알파벳 대소문자로 된 단어가 주어지면, 

이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 

단, 대문자와 소문자를 구분하지 않는다.
'''
# 30 sec

string = input()
upperlist = list(string.upper())
setlist = list(set(upperlist))
freqlist = []
for i in setlist:
    freqlist.append(upperlist.count(i))
if freqlist.count(max(freqlist)) == 1:
    print(setlist[freqlist.index(max(freqlist))])
else:
    print('?')



# string.upper(): 문자열 대문자로 (string에 원하는문자열)
# string.lower(): 문자열 소문자로
# string.isupper(): 문자가 대문자인지 확인
# string.islower(): 문자가 소문자인지 확인
# TypeError: 'set' object is not subscriptable -> list(set(upperlist))처럼 집합형태로 바꾼 후 리스트 형태로 바꿔야지 index를 통한 접근이 가능

