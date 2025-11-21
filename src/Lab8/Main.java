package Lab8;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        var eq = new EventQueue();
        var executor = Executors.newFixedThreadPool(5);
        var disp = new Dispatcher(eq);


        List<Sensor> sensors = List.of(
                new Sensor(1, "fire", eq),
                new Sensor(2, "smoke", eq),
                new Sensor(3, "burglar", eq),
                new Sensor(4, "fire", eq)
        );

        JFrame frame = new JFrame("Sensor monitoring");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 1000);

        JTextArea textArea = new JTextArea();
        PrintStream out = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                textArea.append(""+(char)(b & 0xFF));
            }
        });
        System.setOut(out);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();

        for (var sensor : sensors) {
            JButton button = new JButton(sensor.getId().toString());
            buttonsPanel.add(button);
            executor.execute(sensor);
            button.addActionListener(e -> {
                if (sensor.getRunning())
                    sensor.pause();
                else
                    sensor.resume();
            });
        }

        executor.execute(disp);
        frame.add(buttonsPanel, BorderLayout.SOUTH);



        frame.setVisible(true);
    }
}
