## 스프링 부트 2.1 변경 내역 소개
- https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.1-Release-Notes
- 출시일: 2018년 10월
- 현재 시점 최신 버전: 2.6.1
- 주요 변경 내역
    * 자바 11 지원
    * 스프링 데이터 JPA, lazy 모드 지원
    * 의존성 변경
    * 빈 오버라이딩을 기본으로 허용하지 않도록 변경
    * Acutator에 “/info”와 “/health” 공개하도록 바뀜
    * 프로퍼티 변경
    * 로깅 그룹

## 의존성 변경
- 의존성 변경
  * 스프링 프레임워크 5.0 -> 스프링 프레임워크 버전 5.1
    * 로거 설정 개선 spring-jcl
    * 컴포넌트 스캐닝 성능 개선이 가능한 [“컴포넌트 인덱스"](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-scanning-index) 기능 제공
    * [함수형 프로그래밍 스타일 지원](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux-fn)
    * 코틀린 지원
    * [리액티브 프로그래밍 모델 지원](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#webflux)
    * JUnit 5 지원
    * [참고](https://github.com/spring-projects/spring-framework/wiki/Upgrading-to-Spring-Framework-5.x#upgrading-to-version-51)
  * JUnit 4.12 -> JUnit 5.2
    * Jupiter
    * Extension 모델
    * 람다 지원
    * [참고](https://junit.org/junit5/docs/current/user-guide/#overview-what-is-junit-5)
  * 톰캣 8.5.39 -> 톰캣 9
    * BIO 커넥터 사라지고 [NIO 커넥터](https://tomcat.apache.org/tomcat-9.0-doc/config/http.html#Connector_Comparison) 기본으로 사용
    * HTTP/2 지원
    * 웹소켓 2.0 지원
    * 서블릿 4.0 / JSP 2.4 지원
    * [참고](https://dzone.com/articles/what-do-we-know-about-tomcat-90)