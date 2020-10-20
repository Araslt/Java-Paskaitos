package subclasses;

import ds.LectureTypes;
import ds.Person;
import ds.StudySubject;

import java.util.ArrayList;

public final class Lecturer extends Person {        //final - ir sitos klases negalima bus extendinti
    private String position;                        //sakykim bus profesorius
    private ArrayList<StudySubject> subjects = new ArrayList<StudySubject>();

    public Lecturer() {
    }

    public Lecturer(String name, String surName, int birthDay, String position) {
        super(name, surName, birthDay);
        this.position = position;
    }

    public void addSubject(String nameOfSubject, int credits, LectureTypes type){
        if (type.equals(LectureTypes.THEORY)) {
            subjects.add(new StudySubject(nameOfSubject, credits) {

            })
        }
    }
}
