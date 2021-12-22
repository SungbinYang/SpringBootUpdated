## 빈 오버라이딩 기본 설정 변경
- (스프링 프레임워크가 아니라) 스프링 부트는 빈 등록 과정이 두 개.
    * 애플리케이션에 정의한 빈 등록
    * 자동설정이 제공하는 빈 등록
- 이때 1번에서 정의한 빈을 2번 과정에 등록하는 빈이 재정의(overriding) 할 수도 있는데, 스프링 부트 2.1 이전까지는 그런 기능을 기본으로 허용했지만 2.1 이후부터는 허용하지 않는다.
    * 자동 설정으로 등록하는 빈이 오버라이딩을 시도한 경우 애플리케이션 구동을 멈춤.
    
    ```bash
    ***************************
    APPLICATION FAILED TO START
    ***************************
    
    Description:
    
    The bean 'familyMan', defined in class path resource [me/whiteship/demofamiliymanprep/FamilyManAutoConfiguration.class], could not be registered. A bean with that name has already been defined in me.whiteship.demobootoverriding.App and overriding is disabled.
    
    Action:
    
    Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true
    
    ```
- 프로퍼티를 변경해서 빈 오버라이딩을 허용할 수도 있다.
- spring.main.allow-bean-definition-overriding=true
    * 오버라이딩이 일어나지 않도록, 자동 설정을 제공하는 쪽에 @Condition* 애노테이션을 활용할 것
    ```java
    @Configuration
    public class FamilyManAutoConfiguration {
    
        @Bean
        @ConditionalOnMissingBean
        public FamilyMan familyMan() {
            FamilyMan familyMan = new FamilyMan();
            familyMan.setName("whiteship");
            return familyMan;
        }
    
    }
    
    ```