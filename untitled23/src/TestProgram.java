import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Hashtable;

public class TestProgram {
    private final String[] genderComboTexts = {"Male", "Female"};
    private static JFrame testFrame;
    private JPanel mainPanel;

    private JTextField nameTF;
    private JTextField familyNameTF;
    private JTextField ageTF;

    private JComboBox genderChoices = null;

    private JSlider heightSlider;
    private JSlider weightSlider;
    private JTextField BMI1 ;



    public TestProgram() {
        mainPanel = new JPanel();
        mainPanel.add(initPersonalDataPanel());
        mainPanel.add(initGenderPanel());
        mainPanel.add(initHeightSlider());
        mainPanel.add(initWeightPanel());
        mainPanel.add(calculatedBMI());




    }




    private JPanel initWeightPanel() {
        JPanel panel = new JPanel();
        JLabel weight = new JLabel("60");
        weightSlider = new JSlider(JSlider.VERTICAL, 40, 100, 60);

       weightSlider.setMinorTickSpacing(1);
        weightSlider.setMajorTickSpacing(5);
        weightSlider.setPaintTicks(true);

        Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(140, new JLabel("40"));
        labels.put(150, new JLabel("50"));
        labels.put(160, new JLabel("60"));
        labels.put(170, new JLabel("70"));
        labels.put(180, new JLabel("80"));
        labels.put(190, new JLabel("90"));
        labels.put(200, new JLabel("100"));

        weightSlider.setLabelTable(labels);
        weightSlider.setPaintLabels(true);

        panel.add(weight);
        panel.add(weightSlider);
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Weight"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        weightSlider.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent e) {

            }

            public void mouseDragged(MouseEvent e) {
                weight.setText("" + weightSlider.getValue());
            }


        });

        return panel;


    }

    private JPanel initHeightSlider() {
        JPanel panel = new JPanel();
        JLabel height = new JLabel("160");
        heightSlider = new JSlider(JSlider.VERTICAL, 140, 200, 160);

        heightSlider.setMinorTickSpacing(1);
        heightSlider.setMajorTickSpacing(5);
        heightSlider.setPaintTicks(true);

        Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(140, new JLabel("140"));
        labels.put(150, new JLabel("150"));
        labels.put(160, new JLabel("160"));
        labels.put(170, new JLabel("170"));
        labels.put(180, new JLabel("180"));
        labels.put(190, new JLabel("190"));
        labels.put(200, new JLabel("200"));

        heightSlider.setLabelTable(labels);
        heightSlider.setPaintLabels(true);

        panel.add(height);
        panel.add(heightSlider);
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Height"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        heightSlider.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent e) {

            }

            public void mouseDragged(MouseEvent e) {
                height.setText("" + heightSlider.getValue());
            }


        });

        return panel;

    }
    private JPanel initGenderPanel(){
        JPanel panel =new JPanel();
        genderChoices = new JComboBox(genderComboTexts);
        panel.add(genderChoices);
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Gender"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
        return panel;
    }
    private JPanel initPersonalDataPanel(){
        JPanel panel =new JPanel();
        JLabel name =new JLabel("Name");
        JLabel familyName = new JLabel("Family name");
        JLabel age = new JLabel("Age");

        nameTF= new JTextField();
        familyNameTF =new JTextField();
        ageTF =new JTextField();
        JButton print = new JButton("Print");

        panel.setLayout(new GridLayout(4,2,10,10));
        panel.add(name);
        panel.add(nameTF);
        panel.add(familyName);
        panel.add(familyNameTF);
        panel.add(age);
        panel.add(ageTF);
        panel.add(print);
        panel.add(new JLabel());
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Personal data"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Name : "+nameTF.getText());
                System.out.println("Family name : "+familyNameTF.getText());
                System.out.println("Age : "+ageTF.getText());
                System.out.println("Height : "+heightSlider.getValue());
                System.out.println("Weight : "+weightSlider.getValue());
                float weight = weightSlider.getValue();
                float height = heightSlider.getValue();
                float BMI = weight/((height/100)*(height/100));
                System.out.println("BMI :"+ BMI);
                String weightStatus =null;
                if (BMI <15){
                    weightStatus ="Anorexic";
                }
                if (BMI >=15&&BMI<18.5){
                    weightStatus="UnderWeight";
                }
                if (BMI>=18.5&&BMI<24.9){
                    weightStatus ="Normal";
                }
                if (BMI >=25&&BMI <29.9){
                    weightStatus ="OverWeight";
                }
                if (BMI>=30&&BMI<=35){
                    weightStatus="Obese";
                }
                if (BMI>35){
                    weightStatus =" Extreme Obese";
                }
                System.out.println("Your weight status : " +weightStatus);





            }
        });
    return panel;
    }
    private JPanel calculatedBMI (){
        JPanel panel =new JPanel();

        JLabel calculateBMI =new JLabel("BMI");






             float weight = weightSlider.getValue();
               float  height = heightSlider.getValue();
                float BMI = weight/((height/100)*(height/100));

                String weightStatus =null;
                if (BMI <15){
                    weightStatus ="Anorexic";
                }
                if (BMI >=15&&BMI<18.5){
                    weightStatus="UnderWeight";
                }
                if (BMI>=18.5&&BMI<24.9){
                    weightStatus ="Normal";
                }
                if (BMI >=25&&BMI <29.9){
                    weightStatus ="OverWeight";
                }
                if (BMI>=30&&BMI<=35){
                    weightStatus="Obese";
                }
                if (BMI>35){
                    weightStatus =" Extreme Obese";
                }




        BMI1=new JTextField(String.valueOf(BMI));
        panel.setLayout(new GridLayout(1,2,10,10));
        panel.add(calculateBMI);

        panel.add(BMI1);
        panel.add(new JLabel());

        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Calculated BMI"),
                BorderFactory.createEmptyBorder(5,5,5,5)));








        return panel;

    }



    public static void main(String[] args) {

            TestProgram testProgram =new TestProgram();
            testFrame = new JFrame("Test");
            testFrame.setContentPane(testProgram.mainPanel);
            testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            testFrame.pack();
            testFrame.setVisible(true);

        }


}


