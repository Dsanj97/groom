package jpabook.jpashop;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){ //Model model 에 데이터를 담아서 뷰에 넘김
        model.addAttribute("data", "hello!!!"); // 키-값
        return "hello"; // 화면 이름
    }
}
