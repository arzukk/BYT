package Byt6;
import lombok.*;

@AllArgsConstructor
class AlternativeSkincareRoutineBuilder implements IBuilder {
    private SkincareRoutine skincareRoutine;

    public AlternativeSkincareRoutineBuilder() {
        this.skincareRoutine = new SkincareRoutine();
    }

    @Override
    public void buildCleanser() {
        skincareRoutine.setCleanser("Foaming Cleanser");
    }

    @Override
    public void buildToner() {
        skincareRoutine.setToner("Refreshing Toner");
    }

    @Override
    public void buildMoisturizer() {
        skincareRoutine.setMoisturizer("Oil-Free Moisturizer");
    }

    @Override
    public void buildSunscreen() {
        skincareRoutine.setSunscreen("SPF 50 Sunscreen");
    }

    @Override
    public SkincareRoutine makeRoutine() {
        return skincareRoutine;
    }
}

