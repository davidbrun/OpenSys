package fr.uha.ensisa.opensys.classloader;

import java.util.HashMap;

/**
 * Provide methods to load classes from external sources
 */
public abstract class MultiClassLoader extends ClassLoader
{
    protected HashMap classes = new HashMap();
    private char classNameReplacementChar;
    
    public MultiClassLoader()
    { }
    
    @Override
    public Class loadClass(String className) throws ClassNotFoundException
    {
        return (loadClass(className, true));
    }

    @Override
    public synchronized Class loadClass(String className, boolean resolveIt) throws ClassNotFoundException
    {
        Class result;
        byte[] classBytes;

        // Check our local cache of classes
        result = (Class) classes.get(className);
        if (result != null)
            return result;

        // Check with the primordial class loader
        try
        {
            result = super.findSystemClass(className);
            return result;
        }
        catch (ClassNotFoundException e)
        { }

        // Try to load it from preferred source
        // Note loadClassBytes() is an abstract method
        classBytes = loadClassBytes(className);
        if (classBytes == null)
            throw new ClassNotFoundException();

        // Define it (parse the class file)
        result = defineClass(className, classBytes, 0, classBytes.length);
        if (result == null)
            throw new ClassFormatError();
        
        // Resolve if necessary
        if (resolveIt)
            resolveClass(result);

        // Done
        classes.put(className, result);
        return result;
    }
    
    /**
     * This optional call allows a class name such as
     * "COM.test.Hello" to be changed to "COM_test_Hello",
     * which is useful for storing classes from different
     * packages in the same retrival directory.
     * In the above example the char would be '_'.
     */
    public void setClassNameReplacementChar(char replacement)
    {
        classNameReplacementChar = replacement;
    }
    
    protected abstract byte[] loadClassBytes(String className);

    protected String formatClassName(String className)
    {
        if (classNameReplacementChar == '\u0000')
            // '/' is used to map the package to the path
            return className.replace('.', '/') + ".class";
        else
            // Replace '.' with custom char, such as '_'
            return className.replace('.', classNameReplacementChar) + ".class";
    }
}