package com.example.randvalteam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Stack;

public class HelloApplication extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Font f1 = new Font("Ariel" ,23);
        Font f2 = new Font("Times New Roman", 50);
        Font f3 = new Font("Langdon", 30);
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, Color.LIGHTBLUE);
        DropShadow shadow = new DropShadow();
        Stack<Integer> stack =  new Stack<>();
        int num1, num2, num3, num4, num5;


        for(int i = 0; i != 5; i++) {
            int randomNumber = (int)genRandom();
            if(stack.isEmpty()) {
                stack.push(randomNumber);
            }
            else if(!stack.contains(randomNumber)) {
                stack.push(randomNumber);
            }
            else {
                i--;
            }
        }
        num1 = stack.pop();
        num2 = stack.pop();
        num3 = stack.pop();
        num4 = stack.pop();
        num5 = stack.pop();

        // Text box for title of GUI
        Text prompt1 = new Text();
        prompt1.setText("Ultimate Bravery");
        prompt1.setLayoutX(130);
        prompt1.setLayoutY(200);
        prompt1.setFont(f2);


        //Prompts user to push the button
        Text prompt2 = new Text();
        prompt2.setText("Click below to Generate \n\tRandom Agents");
        prompt2.setLayoutX(180);
        prompt2.setLayoutY(350);
        prompt2.setFont(f1);

        //Image displayed underneath the Initial text box
        Image gameImage = new Image("file:////Users/javandurand/Downloads/images/game_banner.jpeg");
        ImageView imageView = new ImageView(gameImage);
        imageView.setX(119);
        imageView.setY(210);
        imageView.setFitHeight(110.0);
        imageView.setFitWidth(375.0);

        //Button to initially generate random team
        Button button1 = new Button("Generate");
        button1.setLayoutX(265);
        button1.setLayoutY(500);


        // Casts shadow over the button when it is hovered by the Mouse
        button1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button1.setEffect(shadow);
            }
        });


        //Removes shadow when the cursor is off
        button1.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button1.setEffect(null);
            }
        });


        //Once button is pressed begins the process of displaying random champs
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                stage.close();

                Stage stage1 = new Stage();
                Group root1 = new Group();
                Scene scene1 = new Scene(root1, 600, 600, Color.LIGHTBLUE);


                //Add text above the images
                Text player1 =  new Text();
                player1.setText("Agent 1");
                player1.setLayoutX(60);
                player1.setLayoutY(40);
                player1.setFont(f3);

                Text player2 =  new Text();
                player2.setText("Agent 2");
                player2.setLayoutX(240);
                player2.setLayoutY(40);
                player2.setFont(f3);

                Text player3 =  new Text();
                player3.setText("Agent 3");
                player3.setLayoutX(450);
                player3.setLayoutY(40);
                player3.setFont(f3);

                Text player4 =  new Text();
                player4.setText("Agent 4");
                player4.setLayoutX(140);
                player4.setLayoutY(270);
                player4.setFont(f3);

                Text player5 =  new Text();
                player5.setText("Agent 5");
                player5.setLayoutX(345);
                player5.setLayoutY(270);
                player5.setFont(f3);


                //The 5 corresponding images for the chosen random agents
                ImageView agent1 = new ImageView(agentDecider(num1));
                agent1.setX(30);
                agent1.setY(60);
                agent1.setFitHeight(170);
                agent1.setFitWidth(150);


                ImageView agent2 = new ImageView(agentDecider(num2));
                agent2.setX(220);
                agent2.setY(60);
                agent2.setFitHeight(170);
                agent2.setFitWidth(150);




                ImageView agent3 = new ImageView(agentDecider(num3));
                agent3.setX(420);
                agent3.setY(60);
                agent3.setFitHeight(170);
                agent3.setFitWidth(150);




                ImageView agent4 = new ImageView(agentDecider(num4));
                agent4.setX(115);
                agent4.setY(290);
                agent4.setFitHeight(170);
                agent4.setFitWidth(150);





                ImageView agent5 = new ImageView(agentDecider(num5));
                agent5.setX(330);
                agent5.setY(290);
                agent5.setFitHeight(170);
                agent5.setFitWidth(150);




                //root nodes for agent number above the images
                root1.getChildren().add(player1);
                root1.getChildren().add(player2);
                root1.getChildren().add(player3);
                root1.getChildren().add(player4);
                root1.getChildren().add(player5);

                // root nodes for the images
                root1.getChildren().add(agent1);
                root1.getChildren().add(agent2);
                root1.getChildren().add(agent3);
                root1.getChildren().add(agent4);
                root1.getChildren().add(agent5);

                stage1.setScene(scene1);
                stage1.show();
            }
        });


        //root nodes
        root.getChildren().add(prompt2);
        root.getChildren().add(prompt1);
        root.getChildren().add(imageView);
        root.getChildren().add(button1);



        stage.setScene(scene);
        stage.show();



    }// end main method

    //generate random number to associate with the corresponding agent
    public static double genRandom() {
        double random = 0;

        while (random == 0) {
            random = Math.random() * 23;
        }
        return random;
    }

    //Method for choosing and displaying agent
    public static Image agentDecider(int number) {

        Image agent = null;

            switch(number) {
                case 0 -> agent = new Image("File:////Users/javandurand/Downloads/images/brimstone1.jpeg");
                case 1 -> agent = new Image("File:////Users/javandurand/Downloads/images/phoenix_2.jpeg");
                case 2 -> agent = new Image("File:////Users/javandurand/Downloads/images/sage_3.jpeg");
                case 3-> agent = new Image("File:////Users/javandurand/Downloads/images/sova_4.jpeg");
                case 4 -> agent = new Image("File:////Users/javandurand/Downloads/images/viper_5.jpeg");
                case 5 -> agent = new Image("File:////Users/javandurand/Downloads/images/cypher_6.jpeg");
                case 6 -> agent = new Image("File:////Users/javandurand/Downloads/images/reyna_7.jpeg");
                case 7 -> agent = new Image("File:////Users/javandurand/Downloads/images/killjoy_8.jpeg");
                case 8 -> agent = new Image("File:////Users/javandurand/Downloads/images/breach_9.jpeg");
                case 9 -> agent = new Image("File:////Users/javandurand/Downloads/images/omen_10.jpeg");
                case 10 -> agent = new Image("File:////Users/javandurand/Downloads/images/jett_11.jpeg");
                case 11 -> agent = new Image("File:////Users/javandurand/Downloads/images/raze_12.jpeg");
                case 12 -> agent = new Image("File:////Users/javandurand/Downloads/images/skye_13.jpeg");
                case 13 -> agent = new Image("File:////Users/javandurand/Downloads/images/yoru_14.jpeg");
                case 14 -> agent = new Image("File:////Users/javandurand/Downloads/images/astra_15.jpeg");
                case 15 -> agent = new Image("File:////Users/javandurand/Downloads/images/kayo_16.jpeg");
                case 16 -> agent = new Image("File:////Users/javandurand/Downloads/images/chamber_17.jpeg");
                case 17 -> agent = new Image("File:////Users/javandurand/Downloads/images/neon_18.jpeg");
                case 18 -> agent = new Image("File:////Users/javandurand/Downloads/images/fade_19.jpeg");
                case 19 -> agent = new Image("File:////Users/javandurand/Downloads/images/harbor_20.jpeg");
                case 20 -> agent = new Image("File:////Users/javandurand/Downloads/images/gekko_21.jpeg");
                case 21 -> agent = new Image("File:////Users/javandurand/Downloads/images/deadlock_22.jpeg");
                case 22 -> agent = new Image("File:////Users/javandurand/Downloads/images/iso_23.jpeg");

            }// end switch

        return agent;
    }


} // end main class