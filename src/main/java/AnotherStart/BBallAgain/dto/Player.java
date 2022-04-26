package AnotherStart.BBallAgain.dto;

import AnotherStart.BBallAgain.enums.Positions;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Dictionary;
import java.util.List;

@Data
@Document
public class Player {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private List<Object> positions;
    private Season season;
    private double currentAverage;

    public Player(String name, double currentAverage, List<Object> positions, Season season) {
        this.name = name;
        this.positions = positions;
        this.currentAverage = currentAverage;
        this.season = season;

    }
}
