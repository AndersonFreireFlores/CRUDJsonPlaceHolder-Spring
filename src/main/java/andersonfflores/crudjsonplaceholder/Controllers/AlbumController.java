package andersonfflores.crudjsonplaceholder.Controllers;

import andersonfflores.crudjsonplaceholder.Models.Album;
import andersonfflores.crudjsonplaceholder.Services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping(value = "/albums")
    public List<Album> getAllAlbums() {
        return albumService.findAll();
    }

    @GetMapping(value = "/album/{id}")
    public Optional<Album> getAlbumById(@PathVariable UUID id) {
        return albumService.findById(id);
    }

    @PostMapping(value = "/album")
    public Album createAlbum(@RequestBody Album album) {
        return albumService.save(album);
    }

    @PutMapping(value = "/album/{id}")
    public Album updateAlbum(@RequestBody Album album, @PathVariable UUID id) {
        return albumService.update(album, id);
    }

    @DeleteMapping(value = "/album/{id}")
    public void deleteAlbum(@PathVariable UUID id) {
        albumService.deleteById(id);
    }

}
