package com.mycompany.bulletbound;

import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL33C.*;

public class BulletBound {
    public static void main(String[] args) {
        WindowManager.Init();
        WindowManager.CreateWindow();
        
        GL.createCapabilities();
        
        while (!WindowManager.window_should_close()) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
            WindowManager.UpdateWindow();
        }
        
        WindowManager.DestroyDisplay();
    }
}