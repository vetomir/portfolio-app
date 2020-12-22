package pl.gregorymartin.view;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.gregorymartin.view.dto.HeaderReadModel;

import java.util.List;

@Controller
class PortfolioController {
    private final pl.gregorymartin.view.ViewFasade viewFasade;

    private static final int HEADER_ITEMS = 3;

    PortfolioController(final pl.gregorymartin.view.ViewFasade viewFasade) {
        this.viewFasade = viewFasade;
    }


    @GetMapping
    String header(
            Model model
    ){
        List<HeaderReadModel> headerItem = viewFasade.getAll(0, Sort.Direction.DESC, "priority", HEADER_ITEMS);
        model.addAttribute("header", headerItem);
        return "home";
    }
}
