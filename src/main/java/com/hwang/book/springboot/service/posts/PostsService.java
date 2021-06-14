package com.hwang.book.springboot.service.posts;

import com.hwang.book.springboot.domain.posts.Posts;
import com.hwang.book.springboot.domain.posts.PostsRepository;
import com.hwang.book.springboot.web.dto.PostsResponseDto;
import com.hwang.book.springboot.web.dto.PostsSaveRequestDto;
import com.hwang.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    /**
     *
     * @param id
     * @param requestDto
     * @return id
     *
     * update에 쿼리 날리는 부분이 없다. -> JPA 영속성 컨텍스트 때문
     * 영속성 컨텍스트 : 엔티티를 영구 저장하는 환경(논리적 개념)
     * JPA의 핵심은 엔티티가 영속성 컨텍스트에 포함 되어있냐 아니냐에 따라 갈림
     *      - 활성화 : 트랜젝션 안에서 데이터베이스에서 데이터를 가져오면 데이터의 영속성 컨텍스트가 유지된 상태(기본 값)
     * 이상태에서 해당 데이터의 값을 변경하면 트랜젝션이 끝나는 시점에 해당 테이블 변경분을 반영 즉, Entity의 객체만 변경하면 별도로 쿼리를 날릴 필요가 없음 -> 더티 체킹
     */
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));

        return new PostsResponseDto(entity);
    }
}
