package cat.udl.eps.entsoftarch.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerard on 28/02/17.
 */
@Entity
@Data
public class Schema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    @ManyToOne
    private DataOwner owner;

    @OneToMany(mappedBy = "schema", fetch = FetchType.EAGER)
    private List<Dataset> datasets = new ArrayList<>();

}
