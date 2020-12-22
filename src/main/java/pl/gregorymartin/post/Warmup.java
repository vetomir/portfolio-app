package pl.gregorymartin.view;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.gregorymartin.view.dto.HeaderWriteModel;

import java.util.ArrayList;
import java.util.List;

@Component("viewWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {
    private pl.gregorymartin.view.ViewFasade viewFasade;

    Warmup(final pl.gregorymartin.view.ViewFasade viewFasade) {
        this.viewFasade = viewFasade;
        System.out.println("WARMUP");
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {
        loadHeaderItems();
    }

    private void loadHeaderItems() {
        List<HeaderWriteModel> list = new ArrayList<>();

        list.add(new HeaderWriteModel(2,1,
                "https://images.unsplash.com/photo-1557672172-298e090bd0f1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2134&q=80",
                "white"));

        list.add(new HeaderWriteModel(1,2,
                "https://images.unsplash.com/photo-1558358994-86ce9a4724ca?ixlib=rb-1.2.1&auto=format&fit=crop&w=1934&q=80",
                "gold"));

        list.add(new HeaderWriteModel(3,3,
                "https://images.unsplash.com/photo-1518112166137-85f9979a43aa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2134&q=80",
                ""));

        System.out.println("WARMUP2");

        list.forEach(viewFasade::save);
    }
}
