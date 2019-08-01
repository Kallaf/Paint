package eg.edu.alexu.cse.oop.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.HashMap;
import java.util.Map;


public class Line<T> extends ShapeClass{
    
    @Override
    public void draw(Graphics canvas) {
      ((Graphics2D) canvas).setStroke(new BasicStroke(2));

        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawLine(
                getPosition().x,
                getPosition().y,
                (int) (getPosition().x + getProperties().get("l")*cos(getProperties().get("a")*PI/180)),
                (int) (getPosition().y + getProperties().get("l")*sin(getProperties().get("a")*PI/180)));
        ((Graphics2D) canvas).setColor(getFillColor());

    }
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
            Shape c = new Line();
            c.setPosition(new Point(getPosition()));
             c.setColor(new Color(getColor().getRGB()));
             c.setFillColor(new Color(getFillColor().getRGB()));
             c.setProperties(new HashMap<String,Double>(getProperties()));
                                
        
        return c;

    }

    
}
