import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.*;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.albums.GetAlbumsTracksRequest;
import com.wrapper.spotify.requests.data.albums.GetSeveralAlbumsRequest;
import com.wrapper.spotify.requests.data.tracks.GetAudioFeaturesForTrackRequest;
import com.wrapper.spotify.requests.data.tracks.GetTrackRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Eduarda de Brum Lucena
 */
public class SpotifyServiceImpl implements SpotifyService {

    private SpotifyApi spotifyApi;

    @Override
    public AudioFeatures getAudioFeatures(String id) {
        try {

            GetAudioFeaturesForTrackRequest getAudioFeaturesForTrackRequest =
                    spotifyApi.getAudioFeaturesForTrack(id)
                            .build();

            return getAudioFeaturesForTrackRequest.execute();

        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage()); // TODO
        }

        return null;
    }

    @Override
    public Track getTrack(String id) {
        try {

            GetTrackRequest getTrackRequest =
                    spotifyApi.getTrack(id)
                            .build();

            return getTrackRequest.execute();

        } catch (IOException | SpotifyWebApiException e) {
            e.printStackTrace();  // TODO
        }
        return null;

    }


    public List<Album> getSeveralAlbums(String[] ids) {
        try {

            GetSeveralAlbumsRequest getSeveralAlbumsRequest = spotifyApi.getSeveralAlbums(ids)
                    .build();

            Album[] albums = getSeveralAlbumsRequest.execute();

            System.out.println("Total Albuns: " + albums.length);  // TODO

            return Arrays.asList(albums);
        } catch (IOException | SpotifyWebApiException e) {

            System.out.println("Error: " + e.getMessage());   // TODO
        }

        return new ArrayList<>();
    }

    public String getToken() {
        //TODO
        try {
            SpotifyApi spotifyApi = SpotifyApi.builder()
                    .setClientId("2536bdf981254a2785f878443f995d66")
                    .setClientSecret("7c91bdb094f4429190aaa382faa4a06e")
                    .setRedirectUri(SpotifyHttpManager.makeUri("https://example.com/spotify-redirect"))
                    .build();

            ClientCredentialsRequest build = spotifyApi.clientCredentials().build();

            ClientCredentials clientCredentials = build.execute();
            return clientCredentials.getAccessToken();

        } catch (IOException | SpotifyWebApiException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<TrackSimplified> getAlbumsTracks(String idAlbum) {
        try {

            GetAlbumsTracksRequest getAlbumsTracksRequest = getSpotifyApi().getAlbumsTracks(idAlbum)
                    .build();
            final Paging<TrackSimplified> trackSimplifiedPaging = getAlbumsTracksRequest.execute();

            System.out.println("Total Musicas do Album: " + trackSimplifiedPaging.getTotal());

            return Arrays.asList(trackSimplifiedPaging.getItems());

        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }

    public void setSpotifyApi(String token) {
        this.spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(token)
                .build();

    }

    public SpotifyApi getSpotifyApi() {
        return spotifyApi;
    }
}
