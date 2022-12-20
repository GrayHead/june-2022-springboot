package ua.com.owu.june2022springboot.models;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    private String avatar; // path to image

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, String email, String avatar) {
        this.name = name;
        this.email = email;
        this.avatar = avatar;
    }
}
