package eg.edu.alexu.cse.oop.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


public class Circle<T> extends ShapeClass{
    
    @Override
    public void draw(Graphics canvas) {
      ((Graphics2D) canvas).setStroke(new BasicStroke(2));

        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawOval(
                getPosition().x,
                getPosition().y,
                getProperties().get("d").intValue(),
                getProperties().get("d").intValue());
        ((Graphics2D) canvas).setColor(getFillColor());

        ((Graphics2D) canvas).fillOval(
                getPosition().x,
                getPosition().y,
                getProperties().get("d").intValue(),
                getProperties().get("d").intValue());
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
            Shape c = new Circle();
            c.setPosition(new Point(getPosition()));
             c.setColor(new Color(getColor().getRGB()));
             c.setFillColor(new Color(getFillColor().getRGB()));
             c.setProperties(new HashMap<String,Double>(getProperties()));
                                
        
        return c;

    }

    
}
