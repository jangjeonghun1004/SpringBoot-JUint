# 스프링 부트의 테스트 설정

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

# JUnit 의 생명 주기

    @BeforeAll      최초 실행시 1회 실행
    @BeforeEach     각 테스트 시작 전 실행
    @AfterEach      각 테스트 종료 후 실행
    @AfterAll       최초 종료시 1회 실행

    @Test           테스트 설정
    @Disabled       테스트 생략
    @DisplayName    테스트 설명

    * "TestLifeCycle.java" 코드를 참조하세요.

# Mock 객체

    독립적인 테스트 코드를 작성하지 위해서는 Mock 객체를 활용해야 합니다.

# Controller Test

    @WebMvcTest
    웹에서 사용되는 요청과 응답에 대한 테스트를 수행할 수 있습니다.

    @Mockbean
    실제 빈(bean) 객체가 아닌 Mock 객체를 생성해서 주입하는 역할을 수행합니다.
    실제 객체가 아니기 때문에 실제 행위를 수행하지 않습니다.

    given()
    테스트에 필요한 환경 설정을 설정합니다.

    MockMvc
    가상의 MVC 환경에서 모의 HTTP 서블릿을 요청하는 유틸리티 클래스입니다.

    perform()
    서버로 URL 요청을 보내는 것처럼 통신 테스트 코드를 작성해서 컨트롤러를 테스트 할 수 있다.
    MockMvc를 이용해서 가상의 MVC 환경을 설정한 후 실제 controller를 호출한다.

    andDo()
    요청과 응답의 전체 내용을 출력합니다.

    verify()
    지정된 메서드가 실행 되었는지 검증하는 역활을 합니다.

     * "ProductControllerTest.java" 코드를 참조하세요.
