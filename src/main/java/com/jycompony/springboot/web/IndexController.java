package com.jycompony.springboot.web;

import com.jycompony.springboot.service.posts.PostsService;
import com.jycompony.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @RequiredArgsContstructor 는 final 필드나 @NonNull이 붙은 객체를 생성자를 생성한다는 얘기
@RequiredArgsConstructor
@Controller
public class IndexController {

    // final 선언은 상수가 아니라, 한번만 초기화 가능하다임.
    // 위 어노테이션 중 @RequiredArgsContstructor에서 초기화 됨.
    // 의존성 주입으로 PostService를 계속 사용한다는 뜻임
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.FindAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
