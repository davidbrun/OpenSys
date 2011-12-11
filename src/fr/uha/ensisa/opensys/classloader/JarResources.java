package fr.uha.ensisa.opensys.classloader;

import java.io.*;
import java.util.*;
import java.util.zip.*;

/**
 * Map all resources included in a zip or a jar file<br/>
 * Provide a method to extract resource one by one
 */
public final class JarResources
{
    // Mapping tables
    @SuppressWarnings("rawtypes")
	private HashMap mapSizes = new HashMap();
    @SuppressWarnings("rawtypes")
	private HashMap mapJarContents = new HashMap();
    // A jar file
    private String jarFileName;
    
    /**
     * Extract all resources from a zip or a jar into an internal hashmap, keyed by resource names
     * @param jarFileName A jar or a zip file
     */
    public JarResources(String jarFileName)
    {
        this.jarFileName = jarFileName;
        init();
    }
    
    
    public Set<String> getClasseNamesFromJar()
    {
    	Set<String> result = new TreeSet<String>();
    	
    	for (Object o : mapJarContents.keySet())
    		result.add(o.toString().replaceAll("/", "."));
    		
    	return result;
    }
    
    /**
     * Extract a jar or a zip resource
     * @param name A resource name
     * @return A byte array that represents the specified resource
     */
    public byte[] getResource(String name)
    {
        return (byte[]) mapJarContents.get(name);
    }
    
    /**
     * Initializes internal hashmaps with jar or zip file resources
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void init()
    {
        try
        {
            // Extracts just sizes only
            ZipFile zf = new ZipFile(jarFileName);
            Enumeration e = zf.entries();
            while (e.hasMoreElements())
            {
                ZipEntry ze = (ZipEntry) e.nextElement();

                mapSizes.put(ze.getName(), new Integer((int) ze.getSize()));
            }
            zf.close();

            // Extract resources and put them into the hashtable
            FileInputStream fis = new FileInputStream(jarFileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ZipInputStream zis = new ZipInputStream(bis);
            ZipEntry ze = null;
            while ((ze = zis.getNextEntry()) != null)
            {
                if (ze.isDirectory())
                    continue;

                int size = (int) ze.getSize();
                // -1 means unknown size
                if (size == -1)
                {
                    size = ((Integer) mapSizes.get(ze.getName())).intValue();
                }

                byte[] b = new byte[(int) size];
                int rb = 0;
                int chunk = 0;
                while (((int) size - rb) > 0)
                {
                    chunk = zis.read(b, rb, (int) size - rb);
                    if (chunk == -1)
                    {
                        break;
                    }
                    rb += chunk;
                }

                // Add to internal resource hashtable
                mapJarContents.put(ze.getName(), b);
            }
        }
        catch (NullPointerException e)
        { }
        catch (FileNotFoundException e)
        { }
        catch (IOException e)
        { }
    }
}