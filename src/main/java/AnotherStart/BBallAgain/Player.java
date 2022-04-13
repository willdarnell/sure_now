package AnotherStart.BBallAgain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Player {
    @Id
    private String id;
    @Indexed
    private String name;
    private List<Positions> positions;
    //private List<Season> seasons;
    private double currentAverage;

    public Player(String name, double currentAverage, List<Positions> positions) {
        this.name = name;
        this.positions = positions;
        this.currentAverage = currentAverage;

    }
}
