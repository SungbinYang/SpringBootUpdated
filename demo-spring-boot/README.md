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

## Spring-JCL
- Logging Facade
  * JCL, SLF4J
- Logger
  * JUL, Log4j2, Log4j, Logback
- 로깅 퍼사드가 로거를 골라 씀
  * why? 라이브러리나 프레임워크 성 코드들이 로거중에 1개를 쓰면 그 app이 특정 로거를 쓰니까 그걸 강제하지 않으려고 로깅 퍼사드를 쓴다.
  * 스프링은 기본적으로 JCL을 썼다.
  * JCL의 문제점은 런타임시에, 로거를 고르는 동적바인딩으로 인하여 꽤 복잡하고 심오한 문제가 생겼다.
  * 그래서 거의 안쓰고 SLF4J를 쓴다.
  * SLF4J는 컴파일 타임에 로거를 고르고 심플한 로직
  * JCL은 레거시코드에 볼수 있고 보통은 SLF4J를 쓴다. 로거는 Logback을 쓴다.
  * 최근 Log4j 보안이슈로 인하여 Logback으로 바뀌는 추세 갔다.
- 문제1. 기존에 이미 다른 로깅 퍼사드나 로거를 사용중인 프로젝트는 어떻게 할까?
  * 해결: SLF4J로 통하는 브릿지 (JCL - over - SLF4J와 Log4J to SLF4J)를 놓는다.
- 문제2. SLF4J가 사용할 로거는 어떻게 정할까?
  * 해결: 사용할 로거를 정해준다. (Binder)
- slf4j 설정
  * 필요없는 의존성을 spring framework에서 exclusion한다.
  * 레거시 코드용 브릿지 -> 보통 jcl over slf4j
  * slf4j
  * slf4j binder
  * 로거
  * 문제는 너무 많은 설정이 필요하다.
  * 해결책으로 spring-jcl이 등장
- spring jcl
  * 기존 스프링프레임워크에서 로깅하는 코드를 전부 고칠 수 없다.
  * JCL 사용을 권장 x, slf4j 씀
  * 복잡한 설정 강요 x
  * 그래서 스프링이 만든 JCL용 브릿지
  * jcl over slf4j 대체제
  * 클래스패스에 log4j가 있다면 jcl을 사용하는 코드가 log4j를 사용
  * 클래스패스에 slf4j가 있다면 jcl을 사용하는 브릿지나 바인더가 필요 없다.
  * slf4j를 사용할때도 jcl을 굳이 exclusion하거나 jcl용 브릿지를 추가할 필요가 없다.