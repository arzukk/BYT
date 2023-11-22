package Byt6;

class SkincareRoutineDirector {
    public SkincareRoutine createSkincareRoutine(IBuilder iBuilder) {
        iBuilder.buildCleanser();
        iBuilder.buildToner();
        iBuilder.buildMoisturizer();
        iBuilder.buildSunscreen();
        return iBuilder.makeRoutine();
    }
}