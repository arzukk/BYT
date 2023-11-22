package Byt6;

public class Main {
    public static void main(String[] args) {
        IBuilder iBuilder = new Builder();
        SkincareRoutineDirector director = new SkincareRoutineDirector();
        SkincareRoutine routine = director.createSkincareRoutine(iBuilder);

        System.out.println("Basic Skincare Routine:");
        System.out.println(routine);
    }
}