package andersonfflores.crudjsonplaceholder.Controllers;

import andersonfflores.crudjsonplaceholder.Models.Photo;
import andersonfflores.crudjsonplaceholder.Services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/photos")
    public List<Photo> getAllPhotos() {
        return photoService.findAll();
    }

    @GetMapping("/photo/{id}")
    public Optional<Photo> getPhotoById(@PathVariable UUID id) {
        return photoService.getPhotoById(id);
    }

    @PostMapping("/photo")
    public Photo createPhoto(@RequestBody Photo photo) {
        return photoService.save(photo);
    }

    @PutMapping("/photo/{id}")
    public Photo updatePhoto(@PathVariable UUID id, @RequestBody Photo photo) {
        return photoService.update(id, photo);
    }

    @DeleteMapping("/photo/{id}")
    public void deletePhoto(@PathVariable UUID id) {
        photoService.deleteById(id);
    }
}
