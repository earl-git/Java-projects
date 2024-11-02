import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 The OrderCalculatorGUI class creates the GUI for the
 Bagel House application.
 */

public class OrderCalculatorGUI extends JFrame
{
    private JPanel bagels;     // Bagel panel
    private JPanel toppings; // Topping panel
    private JPanel coffee;    // Coffee panel
    private JPanel banner;  // To display a greeting
    private JLabel greeting; // To display a greeting
    // The following constants are used to indicate
    // the cost of each type of bagel.
    public final double WHITE_BAGEL = 1.25;
    public final double WHEAT_BAGEL = 1.50;
    private JRadioButton whiteBagel;  // To select white
    private JRadioButton wheatBagel;  // To select wheat
    private ButtonGroup bg;           // Radio button group

    // The following constants are used to indicate
    // the cost of toppings.
    public final double CREAM_CHEESE = 0.50;
    public final double BUTTER = 0.25;
    public final double PEACH_JELLY = 0.75;
    public final double BLUEBERRY_JAM = 0.75;

    private JCheckBox creamCheese;  // To select cream cheese
    private JCheckBox butter;       // To select butter
    private JCheckBox peachJelly;   // To select peach jelly
    private JCheckBox blueberryJam; // To select blueberry jam

    // The following constants are used to indicate
    // the cost of coffee.
    public final double NO_COFFEE = 0.0;
    public final double REGULAR_COFFEE = 1.25;
    public final double DECAF_COFFEE = 1.25;
    public final double CAPPUCCINO = 2.00;

    private JRadioButton noCoffee;      // To select no coffee
    private JRadioButton regularCoffee; // To select regular coffee
    private JRadioButton decafCoffee;   // To select decaf
    private JRadioButton cappuccino;    // To select cappuccino
    private ButtonGroup bg2;             // Radio button group


    private JPanel buttonPanel;    // To hold the buttons
    private JButton calcButton;    // To calculate the cost
    private JButton exitButton;    // To exit the application
    private final double TAX_RATE = 0.06; // Sales tax rate
    //menu
    private JMenuBar jMenuBar;//menu bar
    private JMenu fileMenu; //file menu
    private JMenuItem aboutItem;//about menu item for file menu
    private JMenuItem calculateItem;//calculate menu item for file menu
    private JMenuItem exitItem;//exit menu item for file menu
    private JMenu helpMenu;//help menu
    private JMenuItem browseItem;//browser menu item for help menu

    /**
     Constructor
     */

    public OrderCalculatorGUI()
    {
        // Display a title.
        setTitle("Order Calculator with menu");

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BorderLayout manager.
        setLayout(new BorderLayout());

        //beginning of menu creation
        jMenuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        aboutItem = new JMenuItem("About");
        aboutItem.setMnemonic('A');
        calculateItem = new JMenuItem("Calculate");
        calculateItem.setMnemonic('C');
        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('X');
        fileMenu.add(aboutItem);
        fileMenu.add(calculateItem);
        //adding event to about menu item
        aboutItem.addActionListener(new ActionListener() {//anonymous class
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(OrderCalculatorGUI.this,
                        "Quiz 8 solution with menu items", "INSY 4305 | Quiz 8", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        //adding event to calculate menu item
        calculateItem.addActionListener(new CalcButtonListener());//inner class object
        //adding event to exit menu item
        exitItem.addActionListener(new ExitButtonListener());//inner class object
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        browseItem = new JMenuItem("Browse");
        browseItem.setMnemonic('B');
        helpMenu.add(browseItem);
        //adding event to Browse menu item
        browseItem.addActionListener(new BrowserHandler());
        fileMenu.add(exitItem);//adding menu item to menu
        jMenuBar.add(fileMenu);//adding file menu to menu bar
        jMenuBar.add(helpMenu);//adding help menu to menu bar
        setJMenuBar(jMenuBar);//setting the bar to JFrame
        //end of menu

        greeting = new JLabel("Welcome to Bagel House");
        // Add the label to this panel.
        banner = new JPanel();
        banner.setLayout(new FlowLayout());
        banner.add(greeting);

        bagels = new JPanel();
        bagels.setLayout(new GridLayout(2, 1));
        // Create the radio buttons.
        whiteBagel = new JRadioButton("White", true);
        wheatBagel = new JRadioButton("Wheat");

        // Group the radio buttons.
        bg = new ButtonGroup();
        bg.add(whiteBagel);
        bg.add(wheatBagel);
        // Add a border around the panel.
        bagels.setBorder(BorderFactory.createTitledBorder("Bagel"));

        // Add the radio buttons to the panel.
        bagels.add(whiteBagel);
        bagels.add(wheatBagel);

        // Create the checkboxes.
        creamCheese = new JCheckBox("Cream cheese");
        butter = new JCheckBox("Butter");
        peachJelly = new JCheckBox("Peach jelly");
        blueberryJam = new JCheckBox("Blueberry jam");

        toppings = new JPanel();
        toppings.setLayout(new GridLayout(4, 1));
        // Add a border around the panel.
        toppings.setBorder(BorderFactory.createTitledBorder("Toppings"));

        // Add the checkboxes to the panel.
        toppings.add(creamCheese);
        toppings.add(butter);
        toppings.add(peachJelly);
        toppings.add(blueberryJam);

        coffee = new JPanel();
        // Create a GridLayout manager with
        // four rows and one column.
        coffee.setLayout(new GridLayout(4, 1));
        // Create the radio buttons.
        noCoffee = new JRadioButton("None");
        regularCoffee = new JRadioButton("Regular coffee", true);
        decafCoffee = new JRadioButton("Decaf coffee");
        cappuccino = new JRadioButton("Cappuccino");

        // Group the radio buttons.
        bg2 = new ButtonGroup();
        bg2.add(noCoffee);
        bg2.add(regularCoffee);
        bg2.add(decafCoffee);
        bg2.add(cappuccino);
        // Add a border around the panel.
        coffee.setBorder(BorderFactory.createTitledBorder("Coffee"));
        // Add the radio buttons to the panel.
        coffee.add(noCoffee);
        coffee.add(regularCoffee);
        coffee.add(decafCoffee);
        coffee.add(cappuccino);

        // Create the button panel.
        // Create a panel for the buttons.
        buttonPanel = new JPanel();

        // Create the buttons.
        calcButton = new JButton("Calculate");
        exitButton = new JButton("Exit");

        // Register the action listeners.
        calcButton.addActionListener(new CalcButtonListener());
        exitButton.addActionListener(new ExitButtonListener());

        // Add the buttons to the button panel.
        buttonPanel.add(calcButton);
        buttonPanel.add(exitButton);

        // Add the components to the content pane.
        add(banner, BorderLayout.NORTH);
        add(bagels, BorderLayout.WEST);
        add(toppings, BorderLayout.CENTER);
        add(coffee, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);
        setSize(400,300);
//        pack();
        setVisible(true);
    }
    public double getBagelCost()
    {
        double bagelCost = 0.0;

        if (whiteBagel.isSelected())
            bagelCost = WHITE_BAGEL;
        else
            bagelCost = WHEAT_BAGEL;

        return bagelCost;
    }
    public double getToppingCost()
    {
        double toppingCost = 0.0;

        if (creamCheese.isSelected())
            toppingCost += CREAM_CHEESE;
        if (butter.isSelected())
            toppingCost += BUTTER;
        if (peachJelly.isSelected())
            toppingCost += PEACH_JELLY;
        if (blueberryJam.isSelected())
            toppingCost += BLUEBERRY_JAM;

        return toppingCost;
    }
    /**
     getCoffeeCost method
     @return The cost of the selected coffee.
     */
    public double getCoffeeCost()
    {
        double coffeeCost = 0.0;

        if (noCoffee.isSelected())
            coffeeCost = NO_COFFEE;
        else if (regularCoffee.isSelected())
            coffeeCost = REGULAR_COFFEE;
        else if (decafCoffee.isSelected())
            coffeeCost = DECAF_COFFEE;
        else if (cappuccino.isSelected())
            coffeeCost = CAPPUCCINO;

        return coffeeCost;
    }

    /**
     Private inner class that handles the event when
     the user clicks the Calculate button.
     */

    private class CalcButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Variables to hold the subtotal, tax, and total
            double subtotal, tax, total;

            // Calculate the subtotal.
            subtotal = getBagelCost() +
                    getToppingCost() +
                    getCoffeeCost();

            // Calculate the sales tax.
            tax = subtotal * TAX_RATE;

            // Calculate the total.
            total = subtotal + tax;

            // Display the charges.
            JOptionPane.showMessageDialog(null,
                    String.format("Subtotal: $%,.2f\n" +
                                    "Tax: $%,.2f\n" +
                                    "Total: $%,.2f",
                            subtotal, tax, total));
        }
    }

    /**
     Private inner class that handles the event when
     the user clicks the Exit button.
     */

    private class ExitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
         int r = JOptionPane.showConfirmDialog(null,
                 "Are you sure?", "Confirmation window", JOptionPane.YES_NO_OPTION);
         if(r == 0)
            System.exit(0);
        }
    }
    /**
     Private inner class that handles the event when
     the user clicks the Browse menu item.
     */

    private class BrowserHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           String url = "http://www.uta.edu";
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(url));
                } catch (IOException | URISyntaxException exception) {
                    // TODO Auto-generated catch block
                    exception.printStackTrace();
                }
            }
        }
    }
        
    public static void main(String[] args)
    {
        new OrderCalculatorGUI();
    }
}

