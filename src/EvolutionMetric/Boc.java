/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EvolutionMetric;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aryan_000
 */

/*
This class is used to Maintain Birth of a class. It is a map of filename and parent of that filename to know
when the file was introduced in the system. Key values are file and file parent and the value is BOC
*/
public class Boc {
   public final static Map bocMap = new HashMap<>();
        static int curr_version  = 0;
}
