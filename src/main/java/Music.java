import lombok.Builder;
import lombok.Data;

/**
 * @author Eduarda de Brum Lucena
 */
@Data
@Builder
public class Music {

    private String name;
    private Float acousticness;
    private Float danceability;
    private Integer durationMs;
    private Float energy;
    private Float instrumentalness;
    private Integer key;
    private Float liveness;
    private Float loudness;
//    private Integer mode;
    private Float speechiness;
//    private Float tempo;
    private Integer timeSignature;
    private Float valence;
    private Preferencia preferencia; // TODO
}
