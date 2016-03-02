/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myextenableapplication;

/**
 * This is a Concept of "extenable application" Implementation Application.
 * @author Myles
 * This client would try to run a application which is extenable. The application
 * is using the 多態 of java machanism to achieve code reusing and version updating.
 * Class Application: provide a interface for client to call and run the application.
 *                    it use the factory method to instanize the latest version of
 *                    Engine class. And it call the Engine instance with interface 
 *                    method so according to 多態 machanism, it will run the latest
 *                    technology.
 * Class EngineV1 implement Supportable.
 * Class EngineV2 implement Supportable.
 * Class EngineV3 implement Supportable.
 * The update of application becomes so easy that developer only needs to define 
 * a new Class with agreed naming and interface and thats it.
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Staticly call application builder to return an application with latest
         * core engine.
         * */
        Application a=Application.CreateApplicatoin();  
        a.runApplication();
        
    }
    
}
