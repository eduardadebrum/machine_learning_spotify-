import com.wrapper.spotify.model_objects.specification.AudioFeatures;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.model_objects.specification.TrackSimplified;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eduarda de Brum Lucena
 */
public class UserServiceImpl {


    public List<Music> getListMusicas(List<Cd> cds) {
        SpotifyServiceImpl spotifyServiceImpl = new SpotifyServiceImpl();
        spotifyServiceImpl.setSpotifyApi(spotifyServiceImpl.getToken());

        List<Music> music = new ArrayList<>();

        cds.forEach(album -> {

            List<TrackSimplified> musicasAlbums = spotifyServiceImpl.getAlbumsTracks(album.getId());

            musicasAlbums.forEach(track -> {
                AudioFeatures audioFeatures = spotifyServiceImpl.getAudioFeatures(track.getId());

                music.add(MusicaBuilder.builder(audioFeatures, track.getName(), album.getPreferencia()));
            });
        });

        return music;
    }


    public Music findMusic(String idTrack) {
        SpotifyServiceImpl spotifyServiceImpl = new SpotifyServiceImpl();
        spotifyServiceImpl.setSpotifyApi(spotifyServiceImpl.getToken());

        Track track = spotifyServiceImpl.getTrack(idTrack);

        AudioFeatures audioAnalysis = spotifyServiceImpl.getAudioFeatures(track.getId());

        return MusicaBuilder.builder(audioAnalysis, track.getName(), null);
    }
}
