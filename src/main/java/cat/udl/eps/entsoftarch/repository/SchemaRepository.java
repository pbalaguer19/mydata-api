package cat.udl.eps.entsoftarch.repository;

import cat.udl.eps.entsoftarch.domain.Schema;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by gerard on 28/02/17.
 */
@RepositoryRestResource
public interface SchemaRepository extends PagingAndSortingRepository<Schema, Long> {
    List<Schema> findByTitleAndDescription(@Param("title") String title,
                                   @Param("description") String description);
}
