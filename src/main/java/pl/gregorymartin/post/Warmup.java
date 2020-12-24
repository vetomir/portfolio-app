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
                "https://cdn.dribbble.com/users/1124467/screenshots/3782251/attachments/852171/page_speed_test_conversations.png",
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
                "PicApp",
                "Photoblog Application",
                "https://cdn.dribbble.com/users/1124467/screenshots/3782251/attachments/852171/page_speed_test_conversations.png",
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
                "Langer",
                "Language Learning Application",
                "https://cdn.dribbble.com/users/1124467/screenshots/3782251/attachments/852171/page_speed_test_conversations.png",
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
