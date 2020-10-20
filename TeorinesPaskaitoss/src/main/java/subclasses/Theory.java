package subclasses;

import ds.StudySubject;

public class Theory extends StudySubject {

    @Override
    public int creditsToHours() {
        return credits * 20;
    }

}
