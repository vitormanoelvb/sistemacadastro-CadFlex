package com.mycompany.sistema;

/**
 *
 * @author Vitor
 */

import javax.swing.*;
import java.awt.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class SplashScreen extends JFrame {

    private Runnable onFinish;
    private MediaPlayer mediaPlayer;

    public SplashScreen(Runnable onFinish) {
        this.onFinish = onFinish;

        setUndecorated(true);
        setSize(800, 500); // Tamanho fixo
        setLocationRelativeTo(null);
        setLayout(null);

        // Painel JavaFX para o vídeo
        JFXPanel jfxPanel = new JFXPanel();
        jfxPanel.setBounds(0, 0, 800, 500);
        add(jfxPanel);

        setOpacity(0f); 

        // Executa vídeo na thread JavaFX
        Platform.runLater(() -> {
            try {
                Media media = new Media(getClass().getResource("/com/mycompany/sistema/videos/intro.mp4").toExternalForm());
                mediaPlayer = new MediaPlayer(media);
                MediaView mediaView = new MediaView(mediaPlayer);

                mediaView.setFitWidth(800);
                mediaView.setFitHeight(500);
                mediaView.setPreserveRatio(false);

                StackPane root = new StackPane(mediaView);
                Scene scene = new Scene(root, 800, 500);
                jfxPanel.setScene(scene);

                mediaPlayer.setOnEndOfMedia(() -> {
                    SwingUtilities.invokeLater(() -> {
                        dispose();
                        if (onFinish != null) onFinish.run();
                    });
                });

                new Thread(() -> {
                    for (float f = 0f; f <= 1f; f += 0.05f) {
                        final float opacity = f;
                        SwingUtilities.invokeLater(() -> setOpacity(opacity));
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                mediaPlayer.play();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void mostrarSplash() {
        setVisible(true);
    }
}
