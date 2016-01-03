/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artemis_warp_monitor;

import java.io.IOException;

/**
 *
 * @author Andy
 */
public class KillVLC {
    
    public static void kill() throws IOException, InterruptedException {
    Runtime.getRuntime().exec("taskkill /F /IM vlc.exe");  
    System.out.println("VLC closed");
}
    
}
