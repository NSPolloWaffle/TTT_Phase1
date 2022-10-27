
package TTT_Phase1;

public class Box {
    private int row;
    private int col;
    private final static String DASH = "-";
    private String placeHolder = Box.DASH;

    public Box(int row, int col) {
        this.row = row;
        this.col = col;
    }
    boolean isAvailable(){
        return placeHolder.equals(Box.DASH);
    }
    public String getPlaceHolder() {
        return placeHolder;
    }
    public boolean setPlaceHolder(String placeHolder) {
        if(isAvailable()) {
            this.placeHolder = placeHolder;
            return true;
        }
        return false;
    }
    void print(){
        System.out.print(placeHolder + " ");
    }
}
