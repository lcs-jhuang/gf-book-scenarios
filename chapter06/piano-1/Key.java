import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Key extends Actor
{
    /**
     * Instance variables 
     * Can be used anywhere in the class below
     */
    // keep track of whether a key was just presseed
    private boolean keyAlreadyDown;
    
    // will contain the key and sound file that ehis instance of the class will play
    private String key;
    private String sound;

    /**
     * Create a new key.
     */
    public Key(String keyName, String soundFile)
    {
        // no key has been pressed
        keyAlreadyDown = false;
        
        // set the instance variables using the parameters
        key = keyName;
        sound = soundFile;
    }

    /**
     * Do the action for this key.
     */
    public void act()
    {
        // animate the piano key being presssed
        // condition 1 - is the key being pressed
        // condition 2 - was the key already down
        if (Greenfoot.isKeyDown(key) && (keyAlreadyDown = false))
        {
            // key is down
            setImage("white-key-down.png");
            play();
            keyAlreadyDown = true;
        }
        
        // stop showing the key being pressed
        // condition 1 - the key was down the last time act() fired
        // condition 2 - the key has been released no longer being pressed
        if (keyAlreadyDown == true && !Greenfoot.isKeyDown(key))
        {
            // key is up
            setImage("white-key.png");  
            keyAlreadyDown = false;
        }
        
        // black key
        if (Greenfoot.isKeyDown(key) && (keyAlreadyDown = false))
        {
            // key is down
            setImage("black-key-down.png");
            play();
            keyAlreadyDown = true;
        }
        if (keyAlreadyDown == true && !Greenfoot.isKeyDown(key))
        {
            // key is up
            setImage("black-key.png");  
            keyAlreadyDown = false;
        }
    }
    
    /**
     * Play the note of this key
     */
    public void play()
    {
        Greenfoot.playSound(sound + ".wav");
    }
}

