/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artemis_warp_monitor;

/**
 *
 * @author Andy
 */

import java.io.IOException;

public class Warp480 {
    
    public static void front() throws IOException, InterruptedException {
      Runtime.getRuntime().exec("\"D:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe\" D:\\Artemis\\dat\\Missions\\MISS_Fed_Federation\\videos\\8_minute_warp_front.avi");

      System.out.println("VLC started. Playing 8 minute front");

   }
}

 
    
