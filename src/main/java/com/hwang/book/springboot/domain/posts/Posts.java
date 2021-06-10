package com.hwang.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//어노테이션 정렬 기준 : 주요 어노테이션을 가깝게 둠, Entity -> JPA / Getter, NoArgsConstructor -> Lombok
@Getter
@NoArgsConstructor      //기본 생성자 자동 추가, public Post(){} 와 같은 효과
@Entity     //테이블과 링크, 카멜케이스(테이블 이름) ex)sales_manager table, Setter 없다 -> 변경 필요한 곳을 명확히 구분하기 힘들어서 만들면 안됨, 메소드 추가로 수정하게 됨
public class Posts {    //Entity 클래스, DB 테이블과 매칭, JPA 사용시 실제 DB에 쿼리 날리는 것보다 Entity 수정을 통해 작업함

    /**
     * Entity의 PK는 long Type auto_increment 추천
     * 주민등록번호와 같이 비즈니스 상 유니크한 값, 키를 조합한 PK로 설정한경우 난감한 경우 발생함
     * 1. FK를 맺을 때, 다른 테이블에서 복합키 전부 가지고 있거나, 중간테이블을 둬야하는 경우 발생
     * 2. 인덱스에 좋은 영향X
     * 3. 유니크한 조건이 변경될 경우 PK 전체를 수정해야 하는 경우 발생할 수도
     * -> 주민등록번호, 복합키 등은 유니크 키로 별도로 추가하는 것을 추천
     */
    @Id     //PK field
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //PK 생성규칙, GenerationType.IDENTITY : auto_increment
    private Long id;

    @Column(length = 500, nullable = false)     //생각가능, but 기본값 이외에 추가변경 필요옵션 있으면 기재(타입, 길이 등)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    //빌더 패턴 클래스 생성, 생성자 상단에 선언시, 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
