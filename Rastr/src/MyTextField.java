import java.awt.*;

public class MyTextField extends TextField {
    public MyTextField() throws HeadlessException {
        this.setLocation(2,120);
        this.setSize(6,60);
        setText("100");
    }
}
