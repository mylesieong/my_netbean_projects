/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myextenableapplication;

/**
 *
 * @author Myles
 */
class Application {
    public Supportable engine;
    public static Application CreateApplicatoin() throws Exception {
        Application result=new Application();
        String latestEngineVersion=new String("");
        String enginePrefix="EngineV";
        int version=1;
        /**
         * We use factory method to dynamically alocated latest Engine Version to instanize.
         * In the try and catch block, we try to use Class.forName to iterate Engine
         * names until it throws exception. In this way we confirm the final version 
         * name and assign it to String latestEngineVersion. And in the finally block,
         * we instanize the engine.
         */
        try{
            while(true){
                Class.forName("myextenableapplication."+enginePrefix+Integer.toString(version));
                version++;
            }
        }catch(Exception e){
            latestEngineVersion=enginePrefix+Integer.toString(version-1);
        }finally{
            Class cl=Class.forName("myextenableapplication."+latestEngineVersion);
            result.engine=(Supportable)cl.newInstance();            
        }
        //result.engine=new EngineV2();
        return result;
    }

    public void runApplication() {
        System.out.println("Application runs.");
        engine.performCoreWork();
        System.out.println("Application finishes.");
    }
    
}
