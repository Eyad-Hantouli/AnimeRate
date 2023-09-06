
public class Anime {
    private final String name;
    private final String normalizedName;
    private final float rate;

    public Anime(String name, float rate) {
        this.normalizedName = General.normalize(name);
        this.name = name;
        General.checkRate(rate);
        this.rate = rate;
    }

    public String getNormalizedName() {return normalizedName;}

    public String getName() {
        return name;
    }

    public float getRate() {
        return rate;
    }
}
