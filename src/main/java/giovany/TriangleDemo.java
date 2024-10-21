package giovany;

import static org.lwjgl.opengl.GL33C.*;
import java.nio.FloatBuffer;

/**
 *
 * @author henri
 */
public class TriangleDemo {
    int vertexShader, fragmentShader, shaderProgram;
    
    public static int generateVBO(float[] vertices) {
        int VBO = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, VBO);
        
        FloatBuffer buffer = OpenGLBuffers.createFloatBuffer(vertices);
        glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        
        return VBO;
    }
    
    public static int generateVAO() {
        int VAO = glGenVertexArrays();
        glBindVertexArray(VAO);
        
        return VAO;
    }
    
    public void compileShaders() {
    }
}
