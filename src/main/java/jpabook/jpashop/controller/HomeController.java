package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    /**
     * @Slf4j 와 같은 기능을 하는 코드
     * Logger log = (Logger) LoggerFactory.getLogger(getClass());
     */

    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "home";
    }
}
