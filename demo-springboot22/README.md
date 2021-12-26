## 의존성 및 프로퍼티 변경
- 의존성 변경
    * [스프링 프레임워크 5.2](https://github.com/spring-projects/spring-framework/wiki/What%27s-New-in-Spring-Framework-5.x#whats-new-in-version-52)
        * [스프링 웹플럭스 기반 코틀린 코루틴 지원](https://docs.spring.io/spring-framework/docs/current/reference/html/languages.html#coroutines)
        * [RSocket](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html#rsocket) 지원
        * [R2DBC](https://spring.io/projects/spring-data-r2dbc) 지원
        * JUnit Jupiter 5.7 지원
        * @Configuration에 proxyBeanMethods 속성 추가
    * [스프링 시큐리티 5.2](https://docs.spring.io/spring-security/site/docs/5.2.0.RELEASE/reference/htmlsingle/#new)
        * OAuth 2.0 클라이언트 기능 추가
        * OAuth 2.0 리소스 서버 기능 추가
        * [OAuth 2.0 인증 서버](https://github.com/spring-projects/spring-authorization-server) 기능은 별도의 커뮤니티 프로젝트로 분리
        * [스프링 시큐리티 5.2 소개 영상](https://www.youtube.com/watch?v=WbnuwpSBXPs)
    * [스프링 데이터 Moore](https://spring.io/blog/2019/10/08/what-s-new-in-spring-data-moore)
        * 선언전인 리액티브 트랜잭션 지원 (@Transactional)
        * 리액티브 QueryDSL
        * 성능 향상
    * [스프링 HATEOAS 0.25 -> 1.0.*](https://spring.io/blog/2019/03/05/spring-hateoas-1-0-m1-released#overhaul)
        * API가 바뀌어 버림!
        * 마이그레이션 사례 커밋 참고.
    * JUnit 5
- 프로퍼티 변경
    * logging.file -> logging.file.name
    * logging.path -> logging.file.path
    * https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.2.0-Configuration-Changelog

## 성능 개선
- 스프링 부트 애플리케이션을 최대한 빠르게 띄우고 싶다면?
    * @Configuration(proxyBeanMethods = false) 적용
    * spring.main.lazy-initialization=true
    * spring.data.jpa.repositories.bootstrap-mode=lazy
    * spring.jmx.enabled=false (이미 기본으로 적용되어 있음)
- 실제로 모든 옵션 적용시 구동 시간이 3초에서 1.5초로 줄어듬.
- 단점은?
    * 요청 처리 시간이 느려질 수 있다. 아직 초기화 하지 않은 빈을 만드느라...
    * 애플리케이션 구동시 발생해야 했던 에러가 애플리케이션 동작 중에 발생할 수 있다.