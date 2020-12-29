package pl.gregorymartin.post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.gregorymartin.post.dto.ProjectWriteModel;

import java.util.ArrayList;
import java.util.List;

@Component("projectWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {
    private final ProjectFasade projectFasade;

    Warmup(final ProjectFasade projectFasade) {
        this.projectFasade = projectFasade;
    }


    @Override
    public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {

        List<ProjectWriteModel> list = new ArrayList<>();
        list.add(new ProjectWriteModel(
                "Travello",
                "Travel Booking Application",
                "http://cv.gregorymartin.pl/tourist-app.jpg",
                "",
                "",
                "https://github.com/vetomir/Travel-Application",
                "",
                "",
                List.of(
                        "REST",
                        "MS Azure",
                        "MySql",
                        "Java",
                        "Spring Boot",
                        "Clean Architecture",
                        "Spring Security"
                ))
        );
        list.add(new ProjectWriteModel(
                "Photoblog",
                "Rest Application",
                "http://cv.gregorymartin.pl/photoblog.jpg",
                "",
                "",
                "https://github.com/vetomir/Travel-Application",
                "",
                "",
                List.of(
                        "REST",
                        "MS Azure",
                        "MySql",
                        "Java",
                        "Spring Boot",
                        "Clean Architecture",
                        "Spring Security"
                ))
        );


        list.forEach(projectFasade::save);

    }
}
