/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cNk;

/**
 *
 * @author aryan_000
 */ 

import com.scitools.understand.*;

public class apitest {
    public static String projPath = "C:\\Users\\aryan_000\\Desktop\\test.udb";
    public static void main(String args[])
    {
    try{
//Open the Understand Database
Database db = Understand.open(projPath);
// Get a list of all functions and methods
Entity [] funcs = db.ents("function ~unknown ~unresolved,method ~unknown ~unresolved");
for(Entity e : funcs){
System.out.print(e.name()+"(");
//Find all the parameters for the given method/function and build them into a string
StringBuilder paramList = new StringBuilder();
Reference [] paramterRefs = e.refs("define","parameter",true);
for( Reference pRef : paramterRefs){
Entity pEnt = pRef.ent();
paramList.append(pEnt.type()+" "+ pEnt.name());
paramList.append(",");
}
//Remove trailing comma from parameter list
if(paramList.length() > 0){   
paramList.setLength(paramList.length() - 1);
}
System.out.print(paramList+")\n");
}
}catch (UnderstandException e){
System.out.println("Failed opening Database:" + e.getMessage());
System.exit(0);
}
}
}
