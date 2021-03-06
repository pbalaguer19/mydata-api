package cat.udl.eps.entsoftarch.repository;

import cat.udl.eps.entsoftarch.domain.Comment;
import cat.udl.eps.entsoftarch.domain.Dataset;
import cat.udl.eps.entsoftarch.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by Chaimae
 */
@RepositoryRestResource
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    List<Comment> findByAbout(@Param("dataset")Dataset dataset);
    List<Comment> findByUser(@Param("user")User user);

}
