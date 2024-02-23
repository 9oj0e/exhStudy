package shop.mtcoding.blog.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.blog._core.util.ApiUtil;
import shop.mtcoding.blog._core.util.Script;


@RequiredArgsConstructor // final이 붙은 애들에 대한 생성자를 만들어줌
@Controller
public class UserController {

    // 자바는 final 변수는 반드시 초기화가 되어야함.
    private final UserRepository userRepository;
    private final HttpSession session;

    @GetMapping("/api/username-same-check/{username}")
    public @ResponseBody ApiUtil<?> usernameSameCheck(@PathVariable String username) {
        System.out.println("입력받은 username : " + username);
        User user = userRepository.findByUsername(username);
        System.out.println("DB에서 조회된 username : " + user.getUsername());
        if(user != null)
            if (username == user.getUsername())
                return new ApiUtil<>(false);
        return new ApiUtil<>(true);
    }

    // 왜 조회인데 post임? 민간함 정보는 body로 보낸다.
    // 로그인만 예외로 select인데 post 사용
    // select * from user_tb where username=? and password=?
    @PostMapping("/login")
    public String login(UserRequest.LoginDTO requestDTO) {


        System.out.println(requestDTO); // toString -> @Data

        if (requestDTO.getUsername().length() < 3) {
            throw new RuntimeException("유저 네임이 너무 짧아요"); // ViewResolver 설정이 되어 있음. (앞 경로, 뒤 경로)
        }

        User user = userRepository.findByUsername(requestDTO.getUsername());

        if (!BCrypt.checkpw(requestDTO.getPassword(), user.getPassword())) { // 조회 안됨 (401)
            // if문에 부정문을 쓰지말라는게 정론. 하지만 filter에는 쓰는게 좋다고 생각합니다.
            throw new RuntimeException("PW가 틀렸습니다.");// 구체적으로 알려주지 않는다. 상대가 본인이 아닐 수도 있으니까.
        }
        session.setAttribute("sessionUser", user); // 락카에 담음 (StateFul)

        return "redirect:/"; // 컨트롤러가 존재하면 무조건 redirect 외우기
    }

    @PostMapping("/join")
    public @ResponseBody String join(UserRequest.JoinDTO requestDTO) {
        System.out.println(requestDTO);

        String rawPassword = requestDTO.getPassword();
        String encPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt()); // (pw, salt)
        requestDTO.setPassword(encPassword);
        try {
            userRepository.save(requestDTO); // 모델에 위임하기
        } catch (Exception e) {
            throw new RuntimeException("아이디가 중복되었습니다.");
        }
        return Script.href("/loginForm");
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}
