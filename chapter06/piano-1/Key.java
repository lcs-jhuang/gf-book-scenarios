import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Key extends Actor
{
    /**
     * Instance variables 
     * Can be used anywhere in the class below
     */
    // keep track of whether a key was just presseed
    private boolean keyAlreadyDown;
    
    
    /**
     * Create a new key.
     */
    public Key()
    {
        // no key has been pressed
        keyAlreadyDown = false;
        
    }

    /**
     * Do the action for this key.
     */
    public void act()
    {
        // animate the piano key being presssed
        // condition 1 - is the "g" key being pressed
        // condition 2 - was the "g" key already down
        if (Greenfoot.isKeyDown("g") && (keyAlreadyDown = false))
        {
            // key is down
            setImage("white-key-down.png");
            play();
            keyAlreadyDown = true;
        }
        
        // stop showing the key being pressed
        // condition 1 - the key was down the last time act() fired
        // condition 2 - the "g" has been released no longer being pressed
        if (keyAlreadyDown == true && Greenfoot.isKeyDown("g") == false)
        {
            // key is up
            setImage("white-key.png");  
            keyAlreadyDown = false;
        }
        
    }
    
    /**
     * Play the note of this key
     */
    public void play()
    {
        Greenfoot.playSound("3a.wav");
    }
}

