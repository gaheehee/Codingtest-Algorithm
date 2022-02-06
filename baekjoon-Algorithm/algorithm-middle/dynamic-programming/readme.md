### DP 풀이 단계

1. 해결하고자 하는 문제가 DP 문제인지 확인한다.
    * 전체 optimal solution에는 subproblem의 optimal solution이 포함되어야한다.
2. 최소한의 매개변수를 가지고 상태 표현식(state expression)을 결정한다.
3. 상태의 관계를 수립한다. -> 점화식 세우기
4. Tabulation(테이블-상향식) or Memoization(메모-하향식)을 이용하여 문제를 해결한다.

출처: https://cotak.tistory.com/51 [TaxFree]