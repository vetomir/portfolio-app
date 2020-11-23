package pl.gregorymartin.post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.gregorymartin.post.dto.ProjectWriteModel;

import java.util.List;

@Component("projectWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {
    private final ProjectFasade projectFasade;
    private final ProjectQueryRepository projectQueryRepository;

    Warmup(final ProjectFasade projectFasade, final ProjectQueryRepository projectQueryRepository) {
        this.projectFasade = projectFasade;
        this.projectQueryRepository = projectQueryRepository;
    }


    @Override
    public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {

        if(projectQueryRepository.count() == 0){
            var project = new ProjectWriteModel();
            project.setTitle("Project 1");
            project.setDescription("Lorem Ipsum");
            project.setGithubUrl("https://github.com/vetomir/SpaceTravel");
            project.setScreenImgUrl("https://images.unsplash.com/photo-1547253291-1337138b39e0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80");
            project.setTags(List.of("Foo","Bar","FooBar"));
            projectFasade.save(project);
            project.setTitle("Project 2");
            projectFasade.save(project);
            project.setTitle("Project 3");
            projectFasade.save(project);

        }
    }
}
