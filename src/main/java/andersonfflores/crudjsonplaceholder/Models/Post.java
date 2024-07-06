package andersonfflores.crudjsonplaceholder.Models;

import jakarta.persistence.*;
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
public class Post {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User userId;

    private String title;

    private String body;

    @OneToMany
    private ArrayList<Comment> comments;

}


