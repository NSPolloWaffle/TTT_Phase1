package TTT_Phase1;

public enum Mark {

    X("X"),
    O("O"),
    DASH("-");

    private String mark;

    Mark(String mark){
        this.mark = mark;
    }
    String getMark(){
        return mark;
    }
}
