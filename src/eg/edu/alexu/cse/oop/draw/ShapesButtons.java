package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class ShapesButtons implements ActionListener {

    private Frame frame;
    private Point currentPos;
    private String input;
    private HashMap<String, Double> properties;
    private Shape currShape;
    private Color color;
    private Color fillColor;
    private String buttonText;
    int noOfParams;
    String symbol;
    Double value;

    public ShapesButtons(Frame frame) {
        this.frame = frame;
        currentPos = new Point();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        currentPos = new Point();
        properties = new HashMap<String, Double>();
        buttonText = ae.getActionCommand();
        if(buttonText == "NewShape")
        {
            buttonText = (String) frame.getPShapeListCombo().getSelectedItem();
        }
        input = JOptionPane.showInputDialog(frame.getFrame(), "x coordinate");
        currentPos.x = Integer.parseInt(input);
        input = JOptionPane.showInputDialog(frame.getFrame(), "y coordinate");
        currentPos.y = Integer.parseInt(input);
        input = JOptionPane.showInputDialog(frame.getFrame(), "numb of parameter");
        noOfParams = Integer.parseInt(input);

        for (int i = 1; i <= noOfParams; i++) {
            symbol = JOptionPane.showInputDialog(frame.getFrame(), "Parameter " + i + "symbol:");
            input = JOptionPane.showInputDialog(frame.getFrame(), "Parameter " + i + " Value:");
            value = new Double(input);
            properties.put(symbol, value);
        }
        color = JColorChooser.showDialog(null, "Out Color", Color.BLACK);
        fillColor = JColorChooser.showDialog(null, "In Color", Color.WHITE);

                List<Class<? extends Shape>> shapeTypes = frame.getEngine().getSupportedShapes();
        Class c;
        for (int i = 0; i < shapeTypes.size(); i++) {
            if(shapeTypes.get(i).getCanonicalName().
                    equalsIgnoreCase(buttonText));
            try {
            c = Class.forName("eg.edu.alexu.cse.oop.draw."+buttonText);
            currShape = (ShapeClass)c.newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(ShapesButtons.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ShapesButtons.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ShapesButtons.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
        currShape.setPosition(currentPos);
        currShape.setColor(color);
        currShape.setFillColor(fillColor);
        currShape.setProperties(properties);
        
        
        frame.getEngine().addShape(currShape);
        frame.getEngine().addcomboShape(buttonText+Integer.toString(frame.getEngine().getShapes().length));
        frame.getEngine().refreshcombo(frame.getShapeListCombo());
        //frame.getShapeListCombo().addItem(buttonText+Integer.toString(frame.getEngine().getShapes().length));

        frame.getBoardPanel().repaint();
        
    

        }
       // view.board.repaint();
    

   

    public DrawingEngineClass getEngine() {
        return frame.getEngine();
    }
    
    
    public static void main(String args[])
    {
        //Circle c = new Circle();
        //System.out.println(c.getClass().getName());
    }
    
    
    
}
