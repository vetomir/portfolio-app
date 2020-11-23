package pl.gregorymartin.tags;

import java.util.Optional;

public interface TagQueryRepository {
    boolean existsByName(final String name);

    Tag save(Tag tag);

    Optional<Tag> getByName(String name);
}
