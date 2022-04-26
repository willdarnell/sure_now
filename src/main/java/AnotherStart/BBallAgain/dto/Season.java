package AnotherStart.BBallAgain.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Season {
    @Id
    private String id;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getGp() {
        return gp;
    }

    public void setGp(double gp) {
        this.gp = gp;
    }

    public double getAverage() {
        return Average;
    }

    public void setAverage(double average) {
        Average = average;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getRebounds() {
        return rebounds;
    }

    public void setRebounds(double rebounds) {
        this.rebounds = rebounds;
    }

    public double getSteals() {
        return steals;
    }

    public void setSteals(double steals) {
        this.steals = steals;
    }

    public double getAssists() {
        return assists;
    }

    public void setAssists(double assists) {
        this.assists = assists;
    }

    public double getThreePointers() {
        return threePointers;
    }

    public void setThreePointers(double threePointers) {
        this.threePointers = threePointers;
    }

    public double getFreeThrows() {
        return freeThrows;
    }

    public void setFreeThrows(double freeThrows) {
        this.freeThrows = freeThrows;
    }

    public double getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(double turnovers) {
        this.turnovers = turnovers;
    }

    public double getDoubleDoubles() {
        return doubleDoubles;
    }

    public void setDoubleDoubles(double doubleDoubles) {
        this.doubleDoubles = doubleDoubles;
    }

    public double getTripleDoubles() {
        return tripleDoubles;
    }

    public void setTripleDoubles(double tripleDoubles) {
        this.tripleDoubles = tripleDoubles;
    }

    public double getFieldGoals() {
        return fieldGoals;
    }

    public void setFieldGoals(double fieldGoals) {
        this.fieldGoals = fieldGoals;
    }

    private int year;
    private double gp;
    private double Average;
    private double points;
    private double rebounds;
    private double steals;
    private double assists;
    private double threePointers;
    private double freeThrows;
    private double turnovers;
    private double doubleDoubles;
    private double tripleDoubles;
    private double fieldGoals;
    private double minutes;

    public Season(int year, double gp, double Average, double points, double rebounds, double steals, double assists, double threePointers, double freeThrows, double turnovers, double doubleDoubles, double tripleDoubles, double fieldGoals, double minutes){
        this.year = year;
        this.gp = gp;
        this.Average = Average;
        this.points = points;
        this.rebounds = rebounds;
        this.steals = steals;
        this.assists = assists;
        this.threePointers = threePointers;
        this.freeThrows = freeThrows;
        this.turnovers = turnovers;
        this.doubleDoubles = doubleDoubles;
        this.tripleDoubles = tripleDoubles;
        this.fieldGoals = fieldGoals;
        this.minutes = minutes;
    }
}
