package giovany;

import java.nio.FloatBuffer;
import org.lwjgl.system.MemoryUtil;
import static org.lwjgl.opengl.GL33C.*;

/**
 *
 * @author henri
 */
public class Mesh {
    private final int VBO;
    private final int VAO;
    
    private final int vertexCount;
    private ShaderCompile shaderProgram = new ShaderCompile();
    
    public Mesh(float[] positions) {
        FloatBuffer verticesBuffer = null;
        
        try {
            verticesBuffer = MemoryUtil.memAllocFloat(positions.length);
            vertexCount = positions.length / 3;
            verticesBuffer.put(positions).flip();
            
            VAO = glGenVertexArrays();
            glBindVertexArray(VAO);
            
            VBO = glGenBuffers();
            glBindBuffer(GL_ARRAY_BUFFER, VBO);
            glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);            
            glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
            glBindBuffer(GL_ARRAY_BUFFER, 0);
            
            glBindVertexArray(0);
        } finally {
            if (verticesBuffer  != null) {
                MemoryUtil.memFree(verticesBuffer);
            }
        }
    }
    
    public int getVAO() {
        return VAO;
    }
    
    public int getVertexCount() {
        return vertexCount;
    }
    
    public ShaderCompile getShaderProgram() {
        return shaderProgram;
    }
    
    public void cleanUp() {
        glDisableVertexAttribArray(0);

        // Delete the VBO
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glDeleteBuffers(VBO);

        // Delete the VAO
        glBindVertexArray(0);
        glDeleteVertexArrays(VAO);
    }
}
