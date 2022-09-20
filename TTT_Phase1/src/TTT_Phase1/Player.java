package TTT_Phase1;
import java.util.*;

class Player {
    private String name;
    private String mark;
    public Player(String name, String mark) {
        setName(name);
        setMark(mark);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
