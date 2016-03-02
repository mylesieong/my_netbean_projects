/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojava3d;

import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.DirectionalLight;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author Myles
 */
public class HelloWorld {
    public HelloWorld(){
                // create an Universe and a branchGroup, A BranchGroup is a node in a Tree
        // data structure that can have child nodes
        SimpleUniverse universe= new SimpleUniverse();
        BranchGroup group=new BranchGroup();
        //Create and define the sphere
        Sphere sphere= new Sphere(0.5f);          
        //put all the group child into the group
        group.addChild(sphere);
        addLights(group);
        //setup camera for universe
        universe.getViewingPlatform().setNominalViewingTransform();
        //embedd the group into the universe
        universe.addBranchGraph(group);
    }

    /*
    * Add a directional light to the BranchGroup.
    */
    public void addLights( BranchGroup bg ){
        // create the color for the light
        Color3f color = new Color3f(1.8f, 0.1f, 0.1f);
        // create a vector that describes the direction that the light is shining.
        Vector3f lightDirection = new Vector3f(-1.0f,-1.0f,-1.0f );
        // create the directional light with the color and direction
        DirectionalLight light = new DirectionalLight( color, lightDirection );
        // set the volume of influence of the light. Only objects within the Influencing 
        // Bounds will be illuminated.
        BoundingSphere bounds= new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        light.setInfluencingBounds(bounds);
        // add the light to the BranchGroup
        bg.addChild( light );
    }     
}
