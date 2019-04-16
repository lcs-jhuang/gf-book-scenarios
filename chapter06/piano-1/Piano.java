import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A piano that can be played with the computer keyboard.
 * 
 * @author: M. Kölling
 * @version: 0.1
 */
public class Piano extends World
{
    /**
     * Instance Variables
     * (Can be used anywhere in the class)
     */
    int frames;

    // create the array
    String[] peopleInClass = {"Julio", "Liam", "Dima", "Osman", "Simon", "Eric", "Phillip", 
            "Joven", "Joe", "Gordon", "Jieun", "Selena", "Jason", "Sam", "Jeff"};
    
    // creaate two arrays
    // first array tracks the keyboard keys that we will use for white piano keys
    String[] whiteKeys = {"a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'", "\\"};
    // second array tracks the sound files for each note
    String[] whiteNotes = {"3c", "3d", "3e", "3f", "3g", "3a", "3b", "3c", "3d", "3e", "3f", "3g"};
    
    /**
     * Make the piano.
     */
    public Piano() 
    {
        super(800, 340, 1);

        // initialize instance variables
        frames = 0;
    }

    /**
     * act
     * (gets called repeatedly to creat animation)
     */
    public void act()
    {

        // say "hello" to a different person each second 
        int position = frames / 60;
        if ((frames % 60 == 0) && (position < whiteKeys.length))
        {
            // only show a message when in the bounds of the array
            showText("Array index is: " + position, 400, 250);
            
            // create an object to add to the world
            Key aKey = new Key(whiteKeys[position], whiteNotes[position]);
            // add the object to the world 
            addObject(aKey, 54 + position * 63, 140);
            // only say "hello" when in the bounds of the array

            // say hello to everyone in the class
            //showText("Hello" + peopleInClass[frames / 60], 400, 170);

        }

        // track frames
        frames += 1;

        // show frames
        //showText("" + frames, 100, 100);
    }
}