## 개발 환경 만들기

### 과제 1. IDE 설치
#### 현재 사용하고있는 컴퓨터에 IntelliJ Community 버전 설치 하기 (IDE는 통일 하겠습니다.)

[IntelliJ Community 다운로드 페이지](https://www.jetbrains.com/ko-kr/idea/download/#section=windows)

오른쪽에 있는 Community 버전 받으시면 됩니다.

### 과제 2. 인프라 환경 만들기
#### 현재 사용하고 있는 컴퓨터에 도커(Docker)환경을 구성해 주세요.

[Docker Desktop 다운로드 페이지](https://docs.docker.com/desktop/windows/install/)

위 링크에서 Docker Desktop for Windows 버튼을 눌러 설치해 주세요.

### 과제 3. 현재 저장소를 클론해서 테스트 실행해보기

#### 도커 실행 해서 MariaDB 실행 하기
```shell
$ ./gradlew.bat startDocker # linux or mac -> ./gradlew startDocker 
# 도커 실행 성공 로그
> Task :startDocker
Network infra_default  Creating
Network infra_default  Created
Container local-mariadb  Creating
Container local-mariadb  Created
Container local-mariadb  Starting
Container local-mariadb  Started

BUILD SUCCESSFUL in 1s
1 actionable task: 1 executed

```
#### 애플리케이션 테스트 실행해보기 
```shell
$ ./gradlew.bat clean test # linux or mac -> ./gradlew clean test

# 애플리케이션 테스트 성공 로그
> Task :test
2022-06-07 00:33:57.809  INFO 71207 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2022-06-07 00:33:57.820  INFO 71207 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

BUILD SUCCESSFUL in 3s
5 actionable tasks: 5 executed
```

### 위 내용까지 완료 되었으면 DB 연동 까지 완료 했습니다.

### 실패시 확인 사항

#### 1. 도커가 제대로 설치 되었는가?
#### 2. JDK 17이 설치되었는가?
#### 그 이외의 문제는 자세한 상황과 함께 슬랙으로 알려주세요. 