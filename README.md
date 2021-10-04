# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## Domain
- [X] 3자리 수의 랜덤 생성을 담당하는 클래스(BallCreator) 구현
- [X] 컴퓨터의 3자리와 사용자의 3자리를 비교 판단하는 클래스(BallJudge) 구현
  - [X] 게임 종료 여부 반환 기능 구현
- [X] 스트라이크 개수와 볼의 개수를 담는 클래스(BallJudgeResult) 구현
  - [X] 스트라이크 개수 증가 기능 구현
  - [X] 볼 개수 증가 기능 구현
- [X] 1에서 9를 표현하는 숫자(BallNumber) 클래스 구현
- [X] 숫자를 여러개 가질 수 있는 일급콜렉션(BallNumbers) 클래스 구현
  - [X] 입력받은 숫자가 3자리가 아니면 예외 발생
  - [X] 입력받은 숫자가 중복될 경우 예외 발생

## View
- [X] 입력 기능 클래스(InputView) 구현
  - [X] 3자리 숫자 입력 기능 구현
  - [X] 게임 재시도 입력 기능 구현
- [X] 출력 기능 클래스(ResultView) 구현 
  - [X] 계산 결과를 출력 기능 구현
  - [X] 에러 메시지 출력 기능 구현

## Controller
- [X] 게임을 구동하는 보조 클래스(BaseBallController)의 구현
