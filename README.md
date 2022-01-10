# Codingtest-Algorithm
<br>

#### Language: python
#### duration: 2022.01.05~

<br>
<br>

### 사용한 Python 문법
### List / Set 문법
* list(string): 한 문자씩 나누기([]배열)
* map(func,x): 리스트 x의 각 요소에 func을 적용
* set(list): list에서 중복된 값을 제거(set: 집합 자료형)
* len(list): list 요소 개수
* min(list) or max(list): list 요소 중 최소/최대 
* sum(list): list 모든 요소의 합
* set(): 집합 생성, 중복 값 x
* set(range(0,100)): 0-99까지의 값이 든 집합
* sorted(list or set): 정렬
* string.index(a): string안에 a가 존재하는 인덱스 반환
* input().split()하면 문자열 앞에 ' '공백이 와도 리스트에 포함되지 않는다.
* TypeError: 'set' object is not subscriptable -> list(set(upperlist))처럼 집합형태로 바꾼 후 리스트 형태로 바꿔야지 index를 통한 접근이 가능
* list.reverse(): 리스트 요소 순서 뒤집기
* reversed(string): 문자열 뒤집기-> reversed object 타입 반환
* "".join(reversed(string)): 문자열 뒤집어서 string 타입으로
* str.replace("aa","b"): str문자열에서 aa를 b로 변경, 삭제는 ""

<br>

### 기본 연산
* / : 나누기(float형)
* // : 몫(int형)
*  % : 나머지
* '%0.3f' % float(수): 소수점 표현하기
* '%0.3f%%' % float(수): 값 뒤에 % 붙음
* ord(문자): 아스키코드 값 반환
* chr(숫자): 아스키코드 값 반환
* string.upper(): 문자열 대문자로 (string에 원하는문자열)
* string.lower(): 문자열 소문자로
* string.isupper(): 문자가 대문자인지 확인
* string.islower(): 문자가 소문자인지 확인

<br>

### 라이브러리
* math.ceil(num): 소수점 올림 처리해서 정수로(import math)