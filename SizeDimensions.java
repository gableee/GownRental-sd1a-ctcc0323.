package packageGui;

public class SizeDimensions {
    private String size;
    private int bust;
    private int waist;
    private int hips;
    private int length;

    public SizeDimensions(String size, int bust, int waist, int hips, int length) {
        this.size = size;
        this.bust = bust;
        this.waist = waist;
        this.hips = hips;
        this.length = length;
    }

    public String getSize() {
        return size;
    }

    public int getBust() {
        return bust;
    }

    public int getWaist() {
        return waist;
    }

    public int getHips() {
        return hips;
    }

    public int getLength() {
        return length;
    }
}
