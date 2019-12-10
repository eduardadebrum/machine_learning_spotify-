import com.wrapper.spotify.model_objects.specification.AudioFeatures;
import lombok.Data;

/**
 * @author Eduarda de Brum Lucena
 */
@Data
public class MusicaBuilder {

    public static Music builder(AudioFeatures audioFeatures, String nome, Preferencia preferencia) {
        return Music.builder()
                .name(nome)
                .acousticness(audioFeatures.getAcousticness())
                .danceability(audioFeatures.getDanceability())
                .durationMs(audioFeatures.getDurationMs())
                .energy(audioFeatures.getEnergy())
                .instrumentalness(audioFeatures.getInstrumentalness())
                .key(audioFeatures.getKey())
                .liveness(audioFeatures.getLiveness())
                .loudness(audioFeatures.getLoudness())
//                .mode(audioFeatures.getMode().mode)
                .speechiness(audioFeatures.getSpeechiness())
//                .tempo(audioFeatures.getTempo())
                .timeSignature(audioFeatures.getTimeSignature())
                .valence(audioFeatures.getAcousticness())
                .preferencia(preferencia)
                .build();
    }
}
