package andersonfflores.crudjsonplaceholder.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String email;

    @OneToMany
    private ArrayList<Post> posts;

    @OneToMany
    private ArrayList<Album> albums;

    @OneToMany
    private ArrayList<Todo> todos;

}
