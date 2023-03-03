package com.winjit.qtmtest.module;

                import autoitx4java.AutoItX;
                import com.jacob.com.LibraryLoader;
                import java.io.*;


public class loginLogout extends base {


    //First Accept the pop up then login
    public void loginAndAcceptPopUp() throws InterruptedException, IOException {
        //SET JACOB DLL
        File file = new File("lib", "jacob-1.14.3-x64.dll"); //path to the jacob dll
        System.out.println(file.getAbsolutePath());
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

        //set auto it
        AutoItX AI = new AutoItX();
        String Dir_path = "C:\\Program Files (x86)\\SA-Taxi (QuanTaMax)\\QuanTaMax.exe";
        AI.run(Dir_path);

        // open in connect pop up choose no
        AI.winWaitActive("QuanTaMax");
        AI.ControlSetText("QuanTaMax","No","","");
     // AI.controlClick("QuanTaMax","&No","","&No");
        AI.send("{!N}"); // select No


        AI.sleep(20000);

        //Server is not operational pop up
        AI.winClose("");
       // AI.controlClick("","&OK","[CLASS:WindowsForms10.Window.b.app.0.2004eee; INSTANCE:1]");



        AI.winWaitActive("Login to QuanTaMax", "");
        AI.controlCommandEditPaste("Login to QuanTaMax","","[NAME:txtUserName]","kdixit");
        AI.ControlSetText("Login to QuanTaMax","","[NAME:txtPassword]","April@2023");
        AI.controlClick("Login to QuanTaMax","","[NAME:btnLogin]");


        AI.sleep(40000);



       //need to find a solution to get correct database here, we are assuming ther is only one database
        //QTM_VM



/*        AI.winWaitActive("QuanTaMax","");
        AI.send("{ALT}+RE");
        AI.sleep(3000);
        AI.winWaitActive("QuanTaMax","");
        AI.send("{^}+IM");
        AI.autoItSetOption("MouseCoordMode", "0");
        AI.winWait("Import Vehicles From Acquire System");

        AI.winActive("Import Vehicles From Acquire System");
        AI.mouseClick("primary", 47, 98, 1, 0);

        AI.sleep(6000);

        AI.mouseClick("primary", 18, 433, 1, 0);

        AI.sleep(8000);

        AI.mouseClick("primary", 911, 428, 1, 0);
*/

    }


}