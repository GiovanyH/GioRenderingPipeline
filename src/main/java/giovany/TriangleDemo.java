package giovany;

import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;

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
        this.VBO = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, this.VBO);
        
        FloatBuffer buffer = OpenGLBuffers.createFloatBuffer(vertices);
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
    }
    
    public void generateVAO() {
        this.VAO = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(this.VAO);
    }
    
    public void compileShaders() {
    }
}
