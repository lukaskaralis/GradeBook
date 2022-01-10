package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class Lector extends Person implements WriteGrades {
    private String studies;

    public String getStudies() {
        return studies;
    }

    public void setStudies(String newStudies) {
        this.studies = newStudies;
    }

    @Override
    public void writeGrades() {

    }
}
