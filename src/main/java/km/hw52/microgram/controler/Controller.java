package km.hw52.microgram.controler;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping
    public String rootHandler() {
        return "index";
    }

}
