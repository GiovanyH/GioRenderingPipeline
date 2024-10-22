package giovany;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL33C.*;

/**
 *
 * @author henri
 */
public class ShaderCompile {
    private int programId;
    private int vertexShaderId;
    private int fragmentShaderId;
    
    public void ShaderProgram() throws Exception {
        programId = glCreateProgram();
        if (programId == 0) {
            throw new Exception("Could not create Shader");
        }
    }

    public int createVertexShader(String shaderCode) throws Exception {
        vertexShaderId = createShader(shaderCode, GL_VERTEX_SHADER);
        return vertexShaderId;
    }

    public int createFragmentShader(String shaderCode) throws Exception {
        fragmentShaderId = createShader(shaderCode, GL_FRAGMENT_SHADER);
        return fragmentShaderId;
    }
    
    protected int createShader(String shaderCode, int shaderType) throws Exception {
        int shaderId = glCreateShader(shaderType);
        if (shaderId == 0) {
            throw new Exception("Error creating shader. Type: " + shaderType);
        }

        glShaderSource(shaderId, shaderCode);
        glCompileShader(shaderId);

        if (glGetShaderi(shaderId, GL_COMPILE_STATUS) == 0) {
            throw new Exception("Error compiling Shader code: " + glGetShaderInfoLog(shaderId, 1024));
        }

        glAttachShader(programId, shaderId);

        return shaderId;
    }
    
    public void link() throws Exception {
        glLinkProgram(programId);
        if (glGetProgrami(programId, GL_LINK_STATUS) == 0) {
            throw new Exception("Error linking Shader code: " + glGetProgramInfoLog(programId, 1024));
        }

        if (vertexShaderId != 0) {
            glDetachShader(programId, vertexShaderId);
        }
        if (fragmentShaderId != 0) {
            glDetachShader(programId, fragmentShaderId);
        }

        glValidateProgram(programId);
        if (glGetProgrami(programId, GL_VALIDATE_STATUS) == 0) {
            System.err.println("Warning validating Shader code: " + glGetProgramInfoLog(programId, 1024));
        }
    }
    
    public void bind() {
        glUseProgram(programId);
    }
    
    public void unbind() {
        glUseProgram(0);
    }
    
    public void cleanup() {
        unbind();
        if (programId != 0) {
            glDeleteProgram(programId);
        }
    }
    
    public void CreateShader(String vertexShader, String fragmentShader) {
        try {
            ShaderProgram();
        } catch (Exception ex) {
            Logger.getLogger(ShaderCompile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int v_shader = createVertexShader(vertexShader);
        } catch (Exception ex) {
            Logger.getLogger(ShaderCompile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int f_shader = createFragmentShader(fragmentShader);
        } catch (Exception ex) {
            Logger.getLogger(ShaderCompile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            link();
        } catch (Exception ex) {
            Logger.getLogger(ShaderCompile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
