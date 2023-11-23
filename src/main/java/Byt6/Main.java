package Byt6;

public class Main {
    public static void main(String[] args) {
        IBuilder iBuilder = new SkincareRoutineBuilder();
        SkincareRoutineDirector director = new SkincareRoutineDirector();
        SkincareRoutine routine = director.createSkincareRoutine(iBuilder);

        System.out.println("Skincare Routine:");
        System.out.println(routine);

        IBuilder alternativeBuilder = new AlternativeSkincareRoutineBuilder();
        SkincareRoutine alternateRoutine = director.createSkincareRoutine(alternativeBuilder);

        System.out.println("Alternative Skincare Routine:");
        System.out.println(alternateRoutine);


    }
}