package giovany;

import static org.lwjgl.opengl.GL33C.*;

/**
 *
 * @author henri
 */
public class Renderer {
    float vertices[] = {
        -0.5f, -0.5f, 0.0f,
         0.5f, -0.5f, 0.0f,
         0.0f,  0.5f, 0.0f,
    };

    int indices[] = {
        0, 1, 3,
        1, 2, 3
    };
    
    private WindowManager window = new WindowManager();
    private Mesh myMesh = new Mesh(vertices);
    
    public void Render(Mesh mesh) {
        clear();

        if ( window.isResized() ) {
            glViewport(0, 0, window.getWidth(), window.getHeight());
        }

        mesh.getShaderProgram().bind();

        // Draw the mesh
        glBindVertexArray(mesh.getVAO());
        glEnableVertexAttribArray(0);
        glDrawArrays(GL_TRIANGLES, 0, mesh.getVertexCount());

        // Restore state
        glDisableVertexAttribArray(0);
        glBindVertexArray(0);

        mesh.getShaderProgram().unbind();
    }
    
    public void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
        glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
    }

    public void cleanup() {
    }
}
