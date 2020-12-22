package pl.gregorymartin.post;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gregorymartin.post.dto.ProjectReadModel;
import pl.gregorymartin.post.dto.ProjectWriteModel;

import java.net.URI;
import java.util.List;

@RestController
@IllegalExceptionProcessing
@RequestMapping("/api")
class ProjectController {
    private final ProjectFasade projectFasade;

    ProjectController(final ProjectFasade projectFasade) {
        this.projectFasade = projectFasade;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectReadModel>> read(@RequestParam(required = false) Integer page, Sort.Direction sort, String sortBy
            /*@AuthenticationPrincipal UsernamePasswordAuthenticationToken user*/) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        String sortByVariable = sortBy != null ? sortBy : "id";

        return ResponseEntity.ok(projectFasade.getAll(pageNumber, sortDirection, sortByVariable, 25));
    }
    @GetMapping
    public ResponseEntity<ProjectReadModel> readSingle(@RequestParam int id) {
        return ResponseEntity.ok(projectFasade.getSingle(id));
    }
    @PostMapping
    public ResponseEntity<ProjectReadModel> createPost(@RequestBody ProjectWriteModel project/*, @RequestParam(name = "user-id") long userId*/) {
        ProjectReadModel result = projectFasade.save(project);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }
    @PutMapping
    public ResponseEntity<ProjectReadModel> updatePost(@RequestParam long id, @RequestBody ProjectWriteModel project/*, @RequestParam(name = "user-id") long userId*/) {
        ProjectReadModel result = projectFasade.modify(id, project);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @DeleteMapping
    public ResponseEntity deletePost(@RequestParam long id) {
        projectFasade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
