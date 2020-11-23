package pl.gregorymartin.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gregorymartin.post.ProjectFasade;

@Controller
//@RequestMapping("/view")
class ViewController {
    private final ProjectFasade projectFasade;

    public ViewController(final ProjectFasade projectFasade) {
        this.projectFasade = projectFasade;
    }

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("siema", "siema");

        return "test";
    }
}
