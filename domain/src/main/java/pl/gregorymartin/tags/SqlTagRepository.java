package pl.gregorymartin.tags;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface SqlTagRepository extends TagQueryRepository, JpaRepository<Tag, Long> {
    boolean existsByName(final String name);
}
