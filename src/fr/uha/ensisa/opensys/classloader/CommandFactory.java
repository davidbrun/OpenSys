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
    @SuppressWarnings("rawtypes")
	public static List<ICommand> getCommandsFromJarFile(String jarFileName)
    {
        // Create a jar class loader to extract the command class
        JarClassLoader jarLoader = new JarClassLoader(jarFileName);
        ArrayList<ICommand> result = new ArrayList<ICommand>();
        
        // Load the command class from the jar file and resolve it
        for (String key : jarLoader.getClasseNamesFromJar())
        {
        	Class c = null;
        	try
            {
    			c = jarLoader.loadClass(key.substring(0, key.length() - ".class".length()), true);
    			// Create an instance of the class
                Object o = c.newInstance();
                if (o instanceof ICommand)
                    result.add((ICommand) o);
            }
            catch (Exception e)
            { }
        }
        return result;
    }
}