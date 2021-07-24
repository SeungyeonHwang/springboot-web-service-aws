package com.hwang.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * JpaRepository<EntityClass,PKType>을 상속하면 기본적인 CRUD 생성됨
 * Entity 클래스와 기본 Entity Repository 함께 위치 해야함
 *
 * @Repository 불필요
 */
//Posts 클래스로 DataBase 접근하게 해줄 JpaRepository 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {

    //Spring DtaJPA에서 제공하지 않는 메소드는 아래 쿼리처럼 작성해도 무방
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
