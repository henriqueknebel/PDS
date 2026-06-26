import java.awt.EventQueue;
import controller.CursoController;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CursoController controller = new CursoController();
                controller.abrirTelaCadastro();
            }
        });
    }
}
