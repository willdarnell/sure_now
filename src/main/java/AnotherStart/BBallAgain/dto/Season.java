package AnotherStart.BBallAgain.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Season {
    @Id
    private String id;
    private int year;
    private int gp;
    private int points;
    private int rebounds;
    private int steals;
    private int assists;
    private int threePointers;
    private int freeThrows;
    private int turnovers;
    private int doubleDoubles;
    private int tripleDoubles;
    private int fieldGoals;

}
