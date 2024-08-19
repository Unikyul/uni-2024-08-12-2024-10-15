package shop.mtcoding.blog.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// 식별자 요청 받기, 응답 하기
@Controller // 식별자 요청을 받을 수 있다.
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    // subtitle=제목1&postContent=내용1
    @PostMapping("/board/save")
    public String save(String title, String content) { // 스프링 기본전략 = x-www-form-urlencoded 파싱

        boardRepository.save(title, content);

        return "redirect:/board";
    }


    // get, post
    @GetMapping("/board")
    public String list() {
        return "board/list";
    }

    // 1. 메서드 : Get
    // 2. 주소 : /board/1
    // 3. 응답 : board/detail
    @GetMapping("/board/1")
    public String detail() {
        return "board/detail";
    }

    // 1. 메서드 : Get
    // 2. 주소 : /board/save-form
    // 3. 응답 : board/save-form
    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    // 1. 메서드 : Get
    // 2. 주소 : /board/1/update-form
    // 3. 응답 : board/update-form
    @GetMapping("/board/1/update-form")
    public String updateForm() {
        return "board/update-form";
    }
}
