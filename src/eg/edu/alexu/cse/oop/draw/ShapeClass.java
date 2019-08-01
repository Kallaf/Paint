package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Point;
import java.util.Map;

/**
 *
 * @author MFahmy
 */
public abstract class ShapeClass implements Shape{
    
    
    private Point position;
    private Map<String, Double> properties;
    Color color;
    Color fillColor;

    public ShapeClass(){
    }
    
    
    
    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.properties = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return properties;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(Color color){ 
            this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }
    
     @Override
    public abstract Object clone() throws CloneNotSupportedException;
}
