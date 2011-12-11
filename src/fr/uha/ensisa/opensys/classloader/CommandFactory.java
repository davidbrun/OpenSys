package fr.uha.ensisa.opensys.classloader;

import java.util.ArrayList;
import java.util.List;

import fr.uha.ensisa.opensys.core.ICommand;

/**
 * Provide methods to load ICommands from external jar files
 * 
 */
public class CommandFactory
{
    private CommandFactory()
    { }
    
    /**
     * Get the ICommands from the specified jar file
     * @param jarFileName The name of the jar file
     * @return The main ICommand from the specified jar file
     */
    public static List<ICommand> getCommandsFromJarFile(String jarFileName)
    {
        // Create a jar class loader to extract the command class
        JarClassLoader jarLoader = new JarClassLoader(jarFileName);
        ArrayList<ICommand> result = new ArrayList<ICommand>();
        
        try
        {
            // Load the command class from the jar file and resolve it
            for (Object key : jarLoader.classes.keySet())
            {
            	@SuppressWarnings("rawtypes")
    			Class c = jarLoader.loadClass(key.toString(), true);
            	
            	// Create an instance of the class
                Object o = c.newInstance();
                if (o instanceof ICommand)
                    result.add((ICommand) o);
            }
            return result;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}