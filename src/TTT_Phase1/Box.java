package TTT_Phase1;

public class Box {
    private int row;
    private int col;
    private String placeHolder = "-";
    boolean isAvailable(){
        if(this.getPlaceHolder() == placeHolder){
            return true;
        }
        return false;
    }
    public Box(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    void print(){
        System.out.print(placeHolder + " ");
    }
}
