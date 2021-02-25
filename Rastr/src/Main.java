import javax.swing.*;
import java.awt.*;

public class Main {
    private static Graphics gr;
    public static void main(String[] args) {
        createAndShowGUI();

        int n = 10;

        paintLines(n);
    }

    public static void paintLines(int n){
        gr.clearRect(0,0,500,500);
        for (int i = 0; i < n; i++) {
            double x1 = Math.random()*500;
            double x2 = Math.random()*500;
            double y1 = Math.random()*500;
            double y2 = Math.random()*500;

            drawMyLine(x1,x2,y1,y2,gr);
        }
    }

    private static void drawMyLine(double x1, double x2, double y1, double y2, Graphics gr){
        Color color = Color.RED;
        gr.setColor(color);

        int xStart = (int)Math.round(x1);
        int yStart = (int)Math.round(y1);
        int xEnd = (int)Math.round(x2);
        int yEnd = (int)Math.round(y2);

        int deltaX = Math.abs(xStart - xEnd);
        int deltaY = Math.abs(yStart - yEnd);

        int length = Math.max(deltaX, deltaY);
//        System.out.println(length);
//        System.out.println("dX" + deltaX);
//        System.out.println("dY" + deltaY);
//        System.out.println("xS" + xStart);
//        System.out.println("xE" + xEnd);
//        System.out.println("yS" + yStart);
//        System.out.println("yE" + yEnd);


        if (length == 0){
            gr.drawLine(xStart,yStart,xStart,yStart);
            return;
        }

        double dX = (x2 - x1) / length;
        double dY = (y2 - y1) / length;

        double x = x1;
        double y = y1;

        while (length-- > 0)
        {
            x += dX;
            y += dY;
//            System.out.printf("Точка на %f, %f", x, y);
//            System.out.println();
            gr.drawLine((int)Math.round(x),(int)Math.round(y),(int)Math.round(x),(int)Math.round(y));
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Рисунок");
        frame.setSize(500,510);
        frame.setBackground(Color.WHITE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(500,510));
        mainPanel.setBackground(new Color(220, 220,250));

        DrawingPanel panel = new DrawingPanel();

        MyTextField textField = new MyTextField();

        MyButton button = new MyButton();
        button.addActionListener(actionEvent -> {
            String text = textField.getText();
            int n = 100;
            try {
                n = Integer.parseInt(text);
                if (n>9999) n = 9999;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            Main.paintLines(n);
        });

        mainPanel.add(textField);
        mainPanel.add(button);

        mainPanel.add(panel);
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);

        gr = panel.getGraphics();
    }
}
