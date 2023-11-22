package Byt6;

class Builder implements IBuilder {
    private SkincareRoutine skincareRoutine;

    public Builder() {
        this.skincareRoutine = new SkincareRoutine();
    }

    @Override
    public void buildCleanser() {
        skincareRoutine.setCleanser("Gentle Cleanser");
    }

    @Override
    public void buildToner() {
        skincareRoutine.setToner("Alcohol-Free Toner");
    }

    @Override
    public void buildMoisturizer() {
        skincareRoutine.setMoisturizer("Hydrating Moisturizer");
    }

    @Override
    public void buildSunscreen() {
        skincareRoutine.setSunscreen("SPF 30 Sunscreen");
    }

    @Override
    public SkincareRoutine makeRoutine() {
        return skincareRoutine;
    }
}
