/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydynamiccreation;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Locale;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * This is a application implements the concept of "Creating a non-exist class during run-time".
 * There is a java file pre-built named NewCreature.java in the src but no class compiled
 * from it yet. The client will try to compile NewCreature.java file and instanize it.
 * @author Myles
 * Demo Guidance: Please follow below instruction to watch this demo again:
 * 1. make sure there are 3 java file in the src/mydynamiccreation folder under the root(and NewCreature.java among).
 * 2. make sure there are only 2 class file in the build/classes/mydynamiccreation folder(w/o NewCreature.class).
 * 3. Run the Client.class alone (dont build the whole project again, that will allow the IDE to compile all java file before the run-time).
 * 4. You will see NewCreature instance works in the System.out msg panel and a new NewCreature.class is build during the run-time.
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, FileNotFoundException, ClassNotFoundException {
        /**
         * Create NewCreature.java according to className which is implementing interface Speakable
         */
        Client client=new Client();
        File file= client.prepareFile("NewCreature.java");   //The NewCreature.java is exist already and syntax checked.
        
        /**
         * Comiler the file created
         */
        client.compileFile(file);
        
        /**
         * Instanize NewCreature class and call its speak method
         */
        Class clazz= Class.forName("mydynamiccreation.NewCreature");
        Speakable creature= (Speakable) clazz.newInstance();
        creature.speak();       
    }

    private File prepareFile(String fileName) {
        File file= new File ("src\\mydynamiccreation\\NewCreature.java");
        return file;
    }

    private void compileFile(File file) {
        /**
         * Use javax.tool.JavaCompiler to compile the existed NewCreature.java
         */
        JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostic= new DiagnosticCollector<JavaFileObject>();
        StandardJavaFileManager fileManager=compiler.getStandardFileManager(diagnostic, null, null);
        ArrayList<File> files=new ArrayList();  //since the compilationUnits require a Iterable list of files
        files.add(file);                        //We create a temporary list for the para passing.
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(files);
        CompilationTask task = compiler.getTask(null, fileManager, diagnostic, null, null, compilationUnits);
        Boolean success= task.call();
        System.out.println("Compilation result:"+success);
        
        /**
         * Copy the result class file to the build directory so that the new class can be used during run-time
         */
        File source = new File("src\\mydynamiccreation\\NewCreature.class");
        File target = new File( "build\\classes\\mydynamiccreation\\NewCreature.class");
        try {
            Files.copy(source.toPath(),target.toPath());
        }catch (Exception e){
            e.printStackTrace();
        }
        source.delete();
 
    }
    
}
