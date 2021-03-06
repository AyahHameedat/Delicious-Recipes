package com.example.Recipe.Models;

import javax.persistence.*;

@Entity
public class InstructionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private int position;

    @Column(columnDefinition = "TEXT")
    private String display_text;

    @ManyToOne
    RecipeModel recipes_instruction;

    public InstructionModel() {

    }
    public InstructionModel(int position, String display_text) {
        this.position = position;
        this.display_text = display_text;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getDisplay_text() {
        return display_text;
    }

    public void setDisplay_text(String display_text) {
        this.display_text = display_text;
    }

    public RecipeModel getRecipes_instruction() {
        return recipes_instruction;
    }

    public void setRecipes_instruction(RecipeModel recipes_instruction) {
        this.recipes_instruction = recipes_instruction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return display_text ;
    }
}
