package andersonfflores.crudjsonplaceholder.Services;

import andersonfflores.crudjsonplaceholder.Models.Album;
import andersonfflores.crudjsonplaceholder.Repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> findAll() {
        return albumRepository.findAll();
    }
    public Optional<Album> findById(UUID id) {
        return albumRepository.findById(id);
    }

    public Album update(Album album, UUID id) {
        Optional<Album> optionalAlbum = albumRepository.findById(id);
        if (optionalAlbum.isPresent()) {
            optionalAlbum.get().setTitle(album.getTitle());
            return albumRepository.save(optionalAlbum.get());
        }
        return null;
    }

    public void deleteById(UUID id) {
        albumRepository.deleteById(id);
    }
}
