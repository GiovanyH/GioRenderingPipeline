package giovany;

import static org.lwjgl.opengl.GL33C.*;

import java.nio.FloatBuffer;

/**
 *
 * @author henri
 */
public class TriangleDemo {
    // Some code from learnopengl
    float vertices[] = {
        -0.5f, -0.5f, 0.0f,
         0.5f, -0.5f, 0.0f,
         0.0f,  0.5f, 0.0f
    };
    
    int VBO, VAO;
    
    int vertexShader, fragmentShader, shaderProgram;
    
    public void generateVBO() {
        this.VBO = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, this.VBO);
        
        FloatBuffer buffer = OpenGLBuffers.createFloatBuffer(vertices);
        glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
    }
    
    public void generateVAO() {
        this.VAO = glGenVertexArrays();
        glBindVertexArray(this.VAO);
    }
    
    public void compileShaders() {
    }
}
