package giovany;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;

/**
 *
 * @author henri
 */
public class WindowManager {
    static long window;
    static int width = 800;
    static int height = 600;
    
    static String window_title = "Java game";
    
    static boolean Vsync = false;
    
    static boolean window_should_close() {
        return glfwWindowShouldClose(window);
    }
    
    static void Init() {
        glfwInit();
        
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
    }
    
    static void CreateWindow() {
        window = glfwCreateWindow(width, height, window_title, 0, 0);
        
        glfwMakeContextCurrent(window);
        
        if (Vsync) glfwSwapInterval(1);
        else glfwSwapInterval(0);
    }
    
    static void UpdateWindow() {
        glfwSwapBuffers(window); // swap the color buffers
        glfwPollEvents();
    }
    
    public static void DestroyDisplay(){
        // Terminate GLFW and free the error callback
        CleanUp();
        glfwTerminate();
    }

    private static void CleanUp() {
        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
    }
}
