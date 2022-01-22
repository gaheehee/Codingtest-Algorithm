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
* sorted(list or set): 정렬 / listname.sort()
* arr.sort(reverse=True): 내림차순 정렬
* 문자열리스트 sort -> 알파벳 사전순: arr.sort()
* 길이 순으로 정렬: arr.sort(key = len)
* string.index(a): string안에 a가 존재하는 인덱스 반환
* input().split()하면 문자열 앞에 ' '공백이 와도 리스트에 포함되지 않는다.
* TypeError: 'set' object is not subscriptable -> list(set(upperlist))처럼 집합형태로 바꾼 후 리스트 형태로 바꿔야지 index를 통한 접근이 가능
* list.reverse(): 리스트 요소 순서 뒤집기
* reversed(string): 문자열 뒤집기-> reversed object 타입 반환
* "".join(reversed(string)): 문자열 뒤집어서 string 타입으로
* str.replace("aa","b"): str문자열에서 aa를 b로 변경, 삭제는 ""
* '구분자'.join(리스트): ex)'_'.join(['a', 'b', 'c']) -> "a_b_c"

<br>

### 문법
* '구분자'.join(리스트): ex)'_'.join(['a', 'b', 'c']) -> "a_b_c"
* readline().strip(): 개행문자 제거



<br>

### 기본 연산
* / : 나누기(float형)
* // : 몫(int형)
*  % : 나머지
* '%0.3f' % float(수): 소수점 표현하기
* '%0.3f%%' % float(수): 값 뒤에 % 붙음
* ord(문자): 아스키코드 값 반환
* chr(숫자): 아스키코드 값 반환
* abs(num): 절대값
* string.upper(): 문자열 대문자로 (string에 원하는문자열)
* string.lower(): 문자열 소문자로
* string.isupper(): 문자가 대문자인지 확인
* string.islower(): 문자가 소문자인지 확인

<br>

### 라이브러리
* math.ceil(num): 소수점 올림 처리해서 정수로(import math)
* math.sqrt(num): 제곱근
* combinations(반복 가능한 객체, n): n=몇개를 뽑을 것인지, 순서 의미 X, 중복 X (import itertools 필요)
* numpy.median(list): 중간값(numpy import 필요) *데이터가 짝수 개일 경우에는 가운데 두 값의 평균 리턴
* count = collections.Counter(arr).most_common(2): arr리스트에서 빈도 가장 높은거 2개 리턴  -> [(-2, 2), (-1, 2)] 이런 식으로 [(값, 빈도수) 리턴