import com.wrapper.spotify.model_objects.specification.Album;
import com.wrapper.spotify.model_objects.specification.AudioFeatures;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.model_objects.specification.TrackSimplified;

import java.util.List;

/**
 * @author Eduarda de Brum Lucena
 */
public interface SpotifyService {

    AudioFeatures getAudioFeatures(String id);

    Track getTrack(String id);

    List<Album> getSeveralAlbums(String[] ids);

    List<TrackSimplified> getAlbumsTracks(String idAlbum);
}
