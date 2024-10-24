package giovany;

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
    
    public static boolean isResized() {
        int[] currentWidth = new int[1];
        int[] currentHeight = new int[1];
        
        glfwGetWindowSize(window, currentWidth, currentHeight);
        
        if (currentWidth[0] != width || currentHeight[0] != height) {
            width = currentWidth[0];
            height = currentHeight[0];
            return true;
        }
        return false;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public static void DestroyDisplay(){
        // Terminate GLFW and free the error callback
        CleanUp();
        glfwTerminate();
    }

    public static void CleanUp() {
        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
    }
}
