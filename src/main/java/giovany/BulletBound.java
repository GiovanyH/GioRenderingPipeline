package giovany;

import static giovany.FileLoader.FileLoader;
import java.io.IOException;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL33C.*;

public class BulletBound {
    public static void main(String[] args) throws IOException {
        WindowManager.Init();
        WindowManager.CreateWindow();
        
        GL.createCapabilities();
        
        FileLoader("src\\main\\java\\giovany\\test.txt");
        
        float vertices[] = {
            -0.5f, -0.5f, 0.0f,
             0.5f, -0.5f, 0.0f,
             0.0f,  0.5f, 0.0f
        }; 
        
        int VAO = TriangleDemo.generateVAO();
        int VBO = TriangleDemo.generateVBO(vertices);
        glBindVertexArray(0);
        
        while (!WindowManager.window_should_close()) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
            
            glBindVertexArray(VAO);
            glEnableVertexAttribArray(0);
            glDrawArrays(GL_TRIANGLES, 0, 3);
            glDisableVertexAttribArray(0);
            glBindVertexArray(0);
            
            WindowManager.UpdateWindow();
        }
        
        WindowManager.DestroyDisplay();
        WindowManager.CleanUp();
    }
}