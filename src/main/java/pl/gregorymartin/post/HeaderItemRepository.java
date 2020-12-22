package pl.gregorymartin.view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface HeaderItemRepository extends JpaRepository<pl.gregorymartin.view.HeaderItem, Long> {
}
