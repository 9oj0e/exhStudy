package shop.mtcoding.blog.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

// user로 테이블명을 만들면, 키워드여서 안만들어질 수 있다. _tb 컨벤션 지키자.
@Table(name="user_tb")
@Data
@Entity
public class User {
    @Id // PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 전략
    private Integer id;

    @Column(unique = true)
    private String username;
    private String password;
    private String email;

    // 카멜 표기법으로 만들면 DB는 created_at 으로 만들어진다. (언더스코어 기법)
    private LocalDateTime createdAt;
}
