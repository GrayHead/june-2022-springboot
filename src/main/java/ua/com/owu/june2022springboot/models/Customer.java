package ua.com.owu.june2022springboot.models;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import ua.com.owu.june2022springboot.models.views.Views;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({Views.Admin.class})
    private int id;
    @NotEmpty
    @Length(min = 3, max = 12, message = "achtung name")
    @JsonView({Views.Admin.class, Views.Client.class})
    private String name;
    @JsonView({Views.Admin.class, Views.Client.class})
    private boolean isActivated = false;

    @JsonView({Views.Admin.class, Views.Client.class})
    private String email;


    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ActivationToken activationToken;

    public Customer(String name) {
        this.name = name;
    }
}
