package com.hwang.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository<EntityClass,PKType>을 상속하면 기본적인 CRUD 생성됨
 * Entity 클래스와 기본 Entity Repository 함께 위치 해야함
 *
 * @Repository 불필요
 */
//Posts 클래스로 DataBase 접근하게 해줄 JpaRepository 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
