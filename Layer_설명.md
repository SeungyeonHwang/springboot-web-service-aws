### 등록/수정/조회 API 만들기

---

API를 만들기 위해 총 3가지의 클래스 필요

- Request를 받을 Dto
- API요청을 받을 Controller
- 트랜잭션, 도메인 기능 간의 순서를 보장하는 **Service**

---
###Layer

- Web Layer 
  - controller, exception handler, filters, view templates...
  - 컨트롤러 , 뷰 템플릿, 필터, 인터셉터, 어드바이스 등 외부요청과 응답에대한 전반적

  
DTOs : Data Transfer Object, 계층간 데이터 교환을 위한 객 
- Service Layer 
  - application services and Infrastructure service
  - @Service, Controller / Dao 중간, @Transaction 사용 
  
DomainModel : domainService, entities, and value objects, 도메인이라고 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해하고 공유할 수 있도록 단순화 시킨 것을 도메인 모델이라고 한다. ex) 택시 앱 -> 배차, 탑승, 요금 등, VO와 같은 객체들도 이 영역에 해당
- Repository Layer 
    - repository interfaces and their implementations
    - Database와 같이 데이터 접근 하는 영역(Dao:Data access Object)
  
---

비즈니스 처리를 담당하는 영역 -> Domain(Not Service)

서비스메소드는 트랜잭션과 도메인간의 순서만 보장

---

###DI에 관하여..

Controller와 Service에서 @Autowired 없는것이 어색하다.
스프링에서 Bean을 주입받는 방법은 다음과 같다 

1. @Autowired -> 권장하지 않음
2. setter
3. *생성자 -> 가장 추천 -> @RequiredArgsConstructor 에서 해결 (final이 선언된 모든 필드)를 인자값으로 하는 생성자를 대신 생성 해줌