import greenfoot.*;
// In order to use a list, we must import it
import java.util.List;

/**
 * A block that bounces back and forth across the screen.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Block extends Actor
{
    private int delta = 2;
    
    /**
     * Move across the screen, bounce off edges. Turn leaves, if we touch any.
     */
    public void act() 
    {
        move();
        checkEdge();
        checkMouseClick();
        checkForLeafCollision();
    }
    
    
    /**
     * remove a Leaf object if we are intersectng with it.
     */
    private void checkForLeafCollision()
    {
        // get an object reference to a single leaf from any leaf objects we are currently intersecting
        // by placing a type in brackets before the call to getOneIntersectingObject
        // we ***cast*** (or force) the type to change from Actor to Leaf
        Leaf someLeaf = (Leaf) getOneIntersectingObject(Leaf.class);
        
        // check that the someLeaf object actully has a reference to an object
        // if it is a null, that means there was no leaf intersecting the Block this time around
        if (someLeaf != null)
        {
            // someLeaf is NOT null, remove
            World myWorld = getWorld();
            myWorld.removeObject(someLeaf);
        }
        
    }
    
    /**
     * Move sideways, either left or right.
     */
    private void move()
    {
        setLocation(getX()+delta, getY());
    }
    
    /**
     * Check whether we are at the edge of the screen. If we are, turn around.
     */
    private void checkEdge()
    {
        if (isAtEdge()) 
        {
            delta = -delta;  // reverse direction
            
            // add a new leaf object to the world
            // 1. add a reference to the world
            World myWorld = getWorld();
            // 2. use the object reference to call, or use, a method on the World object
            myWorld.addObject(new Leaf(), getX(), getY());
        }
    }
    
    /**
     * Check whether the mouse button was clicked. If it was, change all leaves.
     */
    private void checkMouseClick()
    {
        // when null is the argument, Greenfoot responds to a mouse click anywhere on screen 
        // when this is the argument, Greenfoot responds to a mouse click only on Block object
        if (Greenfoot.mouseClicked(this)) 
        {
            // 1. get an object reference to the world 
            World myWorld = getWorld();
            
            // make a messge show on screen when the mouse is clicked
            myWorld.showText("mouse was clicked", 200, 200);
        }
    }
    
}
