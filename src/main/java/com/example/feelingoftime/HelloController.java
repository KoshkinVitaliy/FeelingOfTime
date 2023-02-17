package com.example.feelingoftime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button startBtn;

    @FXML
    private Button stopBtn;

    private Timer timer = new Timer();

    private int secondsCheck = 0;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Нажмите стоп, когда вам покажется, что прошла минута.");
        startBtn.setVisible(false);
        startBtn.setDisable(true);

        stopBtn.setVisible(true);
        stopBtn.setDisable(false);

        startTimer();
    }

    private void startTimer() {
        timer.schedule(new TimerTask() {
            int secondsCounter = 0;

            @Override
            public void run() {
                secondsCounter++;

                secondsCheck = secondsCounter;
            }
        }, 0, 1000);

    }
    @FXML
    protected void onStopButtonClick() {
        if (secondsCheck < 60) {
            welcomeText.setText("Слишком рано, попробуйте ещё раз!");

            reRunApplication();
        } else if (secondsCheck == 60) {
            welcomeText.setText("У вас прекрасное чувство времени!");

            reRunApplication();
        } else if (secondsCheck > 60) {
            welcomeText.setText("Слишком поздно! Попробуйте ещё раз!");

            reRunApplication();
        }
    }

    private void reRunApplication() {
        startBtn.setVisible(true);
        startBtn.setDisable(false);

        stopBtn.setVisible(false);
        stopBtn.setDisable(true);

        timer.purge();
        secondsCheck = 0;
    }
}