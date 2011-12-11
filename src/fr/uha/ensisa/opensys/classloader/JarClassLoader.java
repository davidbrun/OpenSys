package fr.uha.ensisa.opensys.classloader;

import java.util.Set;

/**
 * Provide methods to load classes from external jar files
 */
public class JarClassLoader extends MultiClassLoader
{
    private JarResources jarResources;
    
    public JarClassLoader(String jarName)
    {
        // Create the JarResource and suck in the jar file
        jarResources = new JarResources(jarName);
    }
    
    @Override
    protected byte[] loadClassBytes(String className)
    {
        // Support the MultiClassLoader's class name munging facility
        className = formatClassName(className);
        // Attempt to get the class data from the JarResource
        return (jarResources.getResource(className));
    }
    
    public Set<String> getClasseNamesFromJar()
    {
    	return jarResources.getClasseNamesFromJar();
    }
}