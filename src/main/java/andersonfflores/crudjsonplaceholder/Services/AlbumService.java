package andersonfflores.crudjsonplaceholder.Services;

import andersonfflores.crudjsonplaceholder.Models.Album;
import andersonfflores.crudjsonplaceholder.Repositories.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> findAll() {
        return albumRepository.findAll();
    }
    public Optional<Album> findById(UUID id) {
        return albumRepository.findById(id);
    }

    public Optional<Album> update(Album album, UUID id) {
        Optional<Album> updatedAlbum = albumRepository.findById(id);
        if(updatedAlbum.isPresent()){
            updatedAlbum.get().setTitle(album.getTitle());
            updatedAlbum.get().setPhotos(album.getPhotos());
            return Optional.of(albumRepository.save(updatedAlbum.get()));
        }
        return Optional.empty();
    }

    public void deleteById(UUID id) {
        albumRepository.deleteById(id);
    }
}
