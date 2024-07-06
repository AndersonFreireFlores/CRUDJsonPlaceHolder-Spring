package andersonfflores.crudjsonplaceholder.Services;

import andersonfflores.crudjsonplaceholder.Models.Photo;
import andersonfflores.crudjsonplaceholder.Repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;
    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }

    public List<Photo> findAll() {
        return photoRepository.findAll();
    }
    public Optional<Photo> getPhotoById(UUID id) {
        return photoRepository.findById(id);
    }

    public Photo update(UUID id, Photo photo) {
        Optional<Photo> updatedPhoto = photoRepository.findById(id);
        if (updatedPhoto.isPresent()) {
            updatedPhoto.get().setUrl(photo.getUrl());
            updatedPhoto.get().setTitle(photo.getTitle());
            return photoRepository.save(updatedPhoto.get());
        }
        return null;
    }

    public void deleteById(UUID id) {
        photoRepository.deleteById(id);
    }

}
