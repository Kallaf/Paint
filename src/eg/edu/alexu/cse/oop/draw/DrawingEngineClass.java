package eg.edu.alexu.cse.oop.draw;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JComboBox;
public class DrawingEngineClass implements DrawingEngine{

    public static ArrayList<String> ComboBoxShapes;
    public ArrayList<Shape> shapes;
   Stack<ArrayList<Shape>> undoStack;
    Stack<ArrayList<Shape>> redoStack;
       Stack<ArrayList<String>> undocomboStack;
    Stack<ArrayList<String>> redocomboStack;
        List<Class<? extends Shape>> supportedShapes;
    public DrawingEngineClass() {
        ComboBoxShapes = new ArrayList<String>();
        shapes = new ArrayList<Shape>();
        undoStack = new Stack<ArrayList<Shape>>();
        redoStack = new Stack<ArrayList<Shape>>();
        undocomboStack = new Stack<ArrayList<String>>();
        redocomboStack = new Stack<ArrayList<String>>();
        supportedShapes = new ArrayList<Class<? extends Shape>>();
    }
    
    
    @Override
    public void addShape(Shape shape) {
        try {
            undostep();
        } catch (CloneNotSupportedException ex) {
        }
        shapes.add(shape);
    }
    public void addcomboShape(String shape) {
        undocombostep();
        ComboBoxShapes.add(shape);
    }
    
    
    
    @Override
    public void removeShape(Shape shape) {
        try {
            undostep();
        } catch (CloneNotSupportedException ex) {
        }
        shapes.remove(shape);
    }
        public void removecomboShape(String shape) {
        undocombostep();
        ComboBoxShapes.remove(shape);
    }

    @Override
    public Shape[] getShapes() {
        Shape []a = new Shape[shapes.size()];
        shapes.toArray(a);
        return a;
    }
    

    @Override
    public void refresh(Graphics canvas) {
        for (int i = 0 ; i < shapes.size() ; i++)
        {
            shapes.get(i).draw(canvas);
        }
    }

        public void refreshcombo(JComboBox comboBox) {
            comboBox.removeAllItems();
        for (int i = 0 ; i < ComboBoxShapes.size() ; i++)
        {
            comboBox.addItem(ComboBoxShapes.get(i));
        }
    }
    
    @Override
    public List<Class<? extends Shape>> getSupportedShapes() {
        return supportedShapes;
    }

    @Override
    public void installPluginShape(Class<? extends Shape> shapeClass) {
        supportedShapes.add(shapeClass);

    }

    @Override
    public void undo() {
        if (!undoStack.isEmpty()) {
                    redoStack.push(shapes);
                    redocomboStack.push(ComboBoxShapes);
                    shapes = (undoStack.pop());
                    ComboBoxShapes=(undocomboStack.pop());
                }
    }

    @Override
    public void redo() {
                if (!redoStack.isEmpty()) {
                    undoStack.push(shapes);
                    undocomboStack.push(ComboBoxShapes);
                    shapes = (redoStack.pop());
                    ComboBoxShapes = (redocomboStack.pop());
                }
    }
    
    public void undostep() throws CloneNotSupportedException {

        ArrayList<Shape> temp = new ArrayList<Shape>();
        for (int i = 0; i < shapes.size(); i++) {
            temp.add((Shape)shapes.get(i).clone());
        }

        undoStack.push(temp);
        redoStack.clear();

    }
        public void undocombostep() {

        ArrayList<String> copyList = new ArrayList<String>();
        for (int i = 0; i < ComboBoxShapes.size(); i++) {
           copyList.add(ComboBoxShapes.get(i));
        }

        undocomboStack.push(copyList);
        redocomboStack.clear();

    }

    
}
