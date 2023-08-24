import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame(Database database) {
        setTitle("City Game");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel(database);
        add(gamePanel);

        setVisible(true);
    }
}
