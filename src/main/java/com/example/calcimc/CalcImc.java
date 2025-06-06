package com.example.calcimc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalcImc extends Application {

     public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            // Título da janela
            primaryStage.setTitle("Calculadora de IMC");

            // Componentes da interface
            Label pesoLabel = new Label("Peso (kg):");
            TextField pesoField = new TextField();

            Label alturaLabel = new Label("Altura (m):");
            TextField alturaField = new TextField();

            Button calcularButton = new Button("Calcular IMC");
            Label resultadoLabel = new Label();

            // Ação do botão
            calcularButton.setOnAction(e -> {
                try {
                    double peso = Double.parseDouble(pesoField.getText());
                    double altura = Double.parseDouble(alturaField.getText());

                    double imc = peso / (altura * altura);
                    String classificacao;

                    // Definindo classificação
                    if (imc < 18.5) {
                        classificacao = "Abaixo do peso";
                    } else if (imc < 24.9) {
                        classificacao = "Peso normal";
                    } else if (imc < 29.9) {
                        classificacao = "Sobrepeso";
                    } else if (imc < 34.9) {
                        classificacao = "Obesidade Grau 1";
                    } else if (imc < 39.9) {
                        classificacao = "Obesidade Grau 2";
                    } else {
                        classificacao = "Obesidade Grau 3 (mórbida)";
                    }

                    // Exibir resultado
                    resultadoLabel.setText(String.format("Seu IMC é: %.2f (%s)", imc, classificacao));

                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("Por favor, insira valores válidos.");
                }
            });

            // Layout vertical
            VBox layout = new VBox(10);
            layout.getChildren().addAll(pesoLabel, pesoField, alturaLabel, alturaField, calcularButton, resultadoLabel);

            // Cena e exibição
            Scene scene = new Scene(layout, 300, 250);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
}



