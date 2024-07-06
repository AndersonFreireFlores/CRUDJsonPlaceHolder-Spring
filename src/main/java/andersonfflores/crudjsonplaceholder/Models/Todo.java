package andersonfflores.crudjsonplaceholder.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User userId;

    private String title;

    private Boolean completed;
}
