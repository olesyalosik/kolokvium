import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Window extends JFrame {
    ProductData productData;
    JTextArea processedData;
    JTextArea inputtedData;
    JDialog jDialog;

    Window() {
        super("Production");
        productData = new ProductData();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(500, 400, 600, 400);
        setResizable(false);
        setLayout(null);

        textAreas();

        JButton open = new JButton("Open");
        open.setBounds(getSize().width / 2 - 250 - open.getSize().width / 2, getSize().height / 3 + 150, 100, 50);
        add(open);

        JButton addNew = new JButton("Add");
        addNew.setBounds(getSize().width / 2 - 120 - addNew.getSize().width / 2, getSize().height / 3 + 150, 100, 50);
        add(addNew);

        jDialog = new JDialog();
        jDialog.setBounds(200, 200, 100, 100);
        jDialog.setLayout(new BorderLayout());



        open.addActionListener((e -> {
            JFileChooser fileChooser = new JFileChooser(".");
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    productData.readData(fileChooser.getSelectedFile());
                    updateWindow();
                } catch (IOException | IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }));
        addNew.addActionListener(e -> {
            Dialog dialog = new Dialog(this);
        });
    }

    void updateWindow() {
        List<String> sortedNames = productData.getNamesByProdCount();
        StringBuilder processedDataText = new StringBuilder();
        for (String note : sortedNames) {
            processedDataText.append(note).append("\n");
        }
        inputtedData.setText(productData.products.toString());
        processedData.setText(processedDataText.toString());
    }

    void textAreas() {

        processedData = new JTextArea("result here");
        processedData.setBounds(getSize().width / 2 - processedData.getSize().width / 2, getSize().height / 3 - 100, 200, 200);
        processedData.setEditable(false);
        processedData.setLineWrap(true);
        add(processedData);

        inputtedData = new JTextArea("inputted data here");
        inputtedData.setBounds(getSize().width / 2 - 220 - inputtedData.getSize().width / 2, getSize().height / 3 - 100, 200, 200);
        inputtedData.setEditable(false);
        inputtedData.setLineWrap(true);
        add(inputtedData);
    }

    public static void main(String[] args) {
        Window window = new Window();
        window.setVisible(true);
    }
}