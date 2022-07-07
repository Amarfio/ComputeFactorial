package com.example.ComputeFactorial.model;

import javax.persistence.*;

@Entity
@Table(name = "factorials")
public class Factorial {

    //factorial computation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //datafield to store the figure passed for computation
    @Column(name = "figure")
    private long figure;

    //datafield to store the result of computing the factorial
    @Column(name = "outcome")
    private long outcome;

    //default constructor
    public Factorial(){super();}

    //value specifying constructor
    public Factorial(long figure, long outcome){
        super();
        this.figure = figure;
        this.outcome = outcome;
    }

    //get factorial id
    public long getId(){
        return id;
    }

    //set factorial id
    public void setId(long id){
        this.id = id;
    }

    //get figure
    public long getFigure(){
        return figure;
    }

    //set figure
    public void setFigure(long figure){
        this.figure = figure;
    }

    //get outcome
    public long getOutcome(){
        return outcome;
    }

    //set outcome
    public void setOutcome(long outcome){
        this.outcome = outcome;
    }

    //this is the method to compute the factorial
    public long computeFactorial(long figure){
        if(figure==0){
            return 1;
        }
        else{
            return figure * computeFactorial(figure - 1);
        }
    }
}
