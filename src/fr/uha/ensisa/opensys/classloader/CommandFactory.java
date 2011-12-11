package fr.uha.ensisa.opensys.classloader;

import fr.uha.ensisa.opensys.core.ICommand;

/**
 * Provide methods to load ICommands from external jar files
 * 
 */
public class CommandFactory
{
    /**
     * Represent the default full qualified name of the class that contains the main ICommand
     */
    public static final String MAIN_CLASS_NAME = "fr.uha.ensisa.opensys.commands.**";
    
    private CommandFactory()
    { }
    
    /**
     * Get the main ICommand from the specified jar file
     * @param jarFileName The name of the jar file
     * @return The main ICommand from the specified jar file
     */
    public static ICommand getICommandFromJarFile(String jarFileName)
    {
        // Create a jar class loader to extract the command class
        JarClassLoader jarLoader = new JarClassLoader(jarFileName);

        try
        {
            // Load the command class from the jar file and resolve it
            Class c = jarLoader.loadClass(MAIN_CLASS_NAME, true);
            
            // Create an instance of the class
            Object o = c.newInstance();

            if (o instanceof ICommand)
                return (ICommand) o;
            else
                return null;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}