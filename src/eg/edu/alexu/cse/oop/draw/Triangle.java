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


public class Triangle<T> extends Polygon{
    
    public int[] getXPoints()
{
        xPoints[0]=getPosition().x;
       // yPoints[0]=getPosition().y;
        for(int i=1;i<3;i++)
        {
        sideLengths[i]=getProperties().get("l"+Integer.toString(i));
        angles[i]=getProperties().get("a"+Integer.toString(i));
        xPoints[i]= (int) (xPoints[i-1] + sideLengths[i]*cos(angles[i]*PI/180));
      //  yPoints[i]= (int) (yPoints[i-1] + sideLengths[i]*sin(angles[i]*PI/180));
        }
        return xPoints;
}

public int[] getYPoints()
{
        yPoints[0]=getPosition().y;
        for(int i=1;i<3;i++)
        {
        sideLengths[i]=getProperties().get("l"+Integer.toString(i));
        angles[i]=getProperties().get("a"+Integer.toString(i));
        yPoints[i]= (int) (yPoints[i-1] + sideLengths[i]*sin(angles[i]*PI/180));
        }
        return yPoints;
}
    
   

    
  //  public Line() {
        
   // }
    
    
    

    @Override
    public void draw(Graphics canvas) {
      ((Graphics2D) canvas).setStroke(new BasicStroke(2));

        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawPolygon(getXPoints()
                ,getYPoints()
                , 3);

        ((Graphics2D) canvas).setColor(getFillColor());

        ((Graphics2D) canvas).fillPolygon(getXPoints()
                ,getYPoints()
                , 3);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
            Shape c = new Triangle();
            c.setPosition(new Point(getPosition()));
             c.setColor(new Color(getColor().getRGB()));
             c.setFillColor(new Color(getFillColor().getRGB()));
             c.setProperties(new HashMap<String,Double>(getProperties()));
                                
        
        return c;

    }

    
}
