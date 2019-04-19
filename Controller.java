package sample;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import java.util.ArrayDeque;
import java.util.Queue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.io.*;

public class Controller extends Karakterler {

    int[][] Map = new int[][]{
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0},
            {1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1},
            {0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane pane1;


    @FXML
    private ImageView Player;

    @FXML
    private ImageView WinPic;

    @FXML
    private ImageView LukeCharacter;

    @FXML
    private ImageView YodaCharacter;

    @FXML
    private ImageView Force;

    @FXML
    Karakterler jedi;


    @FXML
    Karakterler[] sith=new Karakterler[5];

    @FXML
    private ImageView sith1;

    @FXML
    private ImageView sith2;

    @FXML
    private ImageView sith3;

    @FXML
    private ImageView sith4;

    @FXML
    private ImageView sith5;


    @FXML
    private ImageView dvader;

    @FXML
    private ImageView kyloren;

    @FXML
    private ImageView stormtrooper;


    @FXML
    void ForceOut(MouseEvent event) {
        pane1.getChildren().remove(Force);
    }

    @FXML
    void SetCharacterLuke(MouseEvent event) {
        Image luke = new Image("file:C:\\Users\\user\\IdeaProjects\\deneme\\src\\sample\\Images\\lukechoose.jpeg");
        jedi=new LukeSkywalker();
        Player.setImage(luke);
        pane1.getChildren().remove(YodaCharacter);
        pane1.getChildren().remove(LukeCharacter);
    }

    @FXML
    void SetCharacterYoda(MouseEvent event) {
        Image yoda = new Image("file:C:\\Users\\user\\IdeaProjects\\deneme\\src\\sample\\Images\\yodachoose.jpeg");
        jedi=new MasterYoda();
        Player.setImage(yoda);
        pane1.getChildren().remove(YodaCharacter);
        pane1.getChildren().remove(LukeCharacter);
    }

    @FXML
    void setSiths() {
        File fl = new File("harita.txt");
        ArrayList <String> list=new ArrayList<String>();
        ArrayList <String> bilgi=new ArrayList<String>();
        int i;
        int kotuKarakterSayisi;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fl));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (i = 0; i < list.size() - 11; i++) {
            bilgi.add(list.get(i));

        }
        kotuKarakterSayisi = bilgi.size();
        String[] kapilar = new String[kotuKarakterSayisi];
        String[] robotlar = new String[kotuKarakterSayisi];
        for (i = 0; i < bilgi.size(); i++) {
            System.out.println(bilgi.get(i));

        }
        for (i = 0; i < bilgi.size(); i++) {

            String[] parts = bilgi.get(i).split(":");
            kapilar[i] = parts[2];
            for (j = 0; j < 3; j++) {
                String[] parts2 = parts[1].split(",");
                robotlar[i] = parts2[0];
            }
        }
    }
    @FXML
    void SetSithDarthVader(MouseEvent event) {
        Image DVader = new Image("file:C:\\Users\\user\\IdeaProjects\\deneme\\src\\sample\\Images\\darthvader.jpeg");
        sith1.setImage(DVader);
        sith[0]=new DarthVader();
    }

    @FXML
    void SetSithKyloRen(MouseEvent event) {
        Image kylo = new Image("file:C:\\Users\\user\\IdeaProjects\\deneme\\src\\sample\\Images\\kyloren.jpeg");
        sith2.setImage(kylo);
        sith4.setImage(kylo);
        sith[1]=new KyloRen();
        sith[3]=new KyloRen();
    }

    @FXML
    void SetSithStormtrooper(MouseEvent event) {
        Image storm = new Image("file:C:\\Users\\user\\IdeaProjects\\deneme\\src\\sample\\Images\\stormtrooper.jpeg");
        sith3.setImage(storm);
        sith5.setImage(storm);
        sith[2]=new Stormtrooper();
        sith[4]=new Stormtrooper();
    }


    /*@FXML
    void darthVader(MouseEvent event) {
        Image darthVader = new Image("file:C:\\Users\\asus1\\IdeaProjects\\deneme\\src\\sample\\Images\\darthvader.jpeg");

    }*/

    @FXML
    void PressRight(KeyEvent event) {
        switch (event.getCode()){
            case RIGHT:  if(Map[GridPane.getRowIndex(Player)][GridPane.getColumnIndex(Player)+1] == 1)
                GridPane.setColumnIndex(Player,GridPane.getColumnIndex(Player)+1);
                for (  int i=0;i<sith.length;i++){
                    if(GridPane.getColumnIndex(Player) == sith[i].j && GridPane.getRowIndex(Player) == sith[i].i){
                        jedi.can--;
                        if(jedi.can==0){
                            System.out.println("Kaybettiniz!");
                        }
                    }
                }
                if(GridPane.getColumnIndex(Player) == 13 && GridPane.getRowIndex(Player) == 9){
                    System.out.println("Kazandınız");
                    System.out.println(jedi.can);
                }
                break;
            default: break;
        }
    }

    @FXML
    void PressUp(KeyEvent event) {
        switch (event.getCode()){
            case UP: if(Map[GridPane.getRowIndex(Player)-1][GridPane.getColumnIndex(Player)] == 1)
                GridPane.setRowIndex(Player,GridPane.getRowIndex(Player)-1);
                for (  int i=0;i<sith.length;i++){
                    if(GridPane.getColumnIndex(Player) == sith[i].j && GridPane.getRowIndex(Player) == sith[i].i){
                        jedi.can--;
                        if(jedi.can==0){
                            System.out.println("Kaybettiniz!");
                        }
                    }
                }
                break;
            default: break;
        }
    }

    @FXML
    void PressDown(KeyEvent event) {
        switch (event.getCode()){
            case DOWN: if(Map[GridPane.getRowIndex(Player)+1][GridPane.getColumnIndex(Player)]== 1)
                GridPane.setRowIndex(Player,GridPane.getRowIndex(Player)+1);
                for (  int i=0;i<sith.length;i++){
                    if(GridPane.getColumnIndex(Player) == sith[i].j && GridPane.getRowIndex(Player) == sith[i].i){
                        jedi.can--;
                        if(jedi.can==0){
                            System.out.println("Kaybettiniz!");
                        }
                    }
                }
                break;
            default: break;
        }
    }

    @FXML
    void PressLeft(KeyEvent event) {
        switch (event.getCode()){
            case LEFT: if(Map[GridPane.getRowIndex(Player)][GridPane.getColumnIndex(Player)-1] == 1)
                GridPane.setColumnIndex(Player,GridPane.getColumnIndex(Player)-1);
                for (  int i=0;i<sith.length;i++){
                    if(GridPane.getColumnIndex(Player) == sith[i].j && GridPane.getRowIndex(Player) == sith[i].i){
                        jedi.can--;
                        if(jedi.can==0){
                            System.out.println("Kaybettiniz!");
                        }
                    }
                }
                break;
            default: break;
        }
    }

    @FXML
    void PlayerDown(MouseEvent event) {
        if(Map[GridPane.getRowIndex(Player)+1][GridPane.getColumnIndex(Player)]== 1)
            GridPane.setRowIndex(Player,GridPane.getRowIndex(Player)+1);
        for (  int i=0;i<sith.length;i++){
            if(GridPane.getColumnIndex(Player) == sith[i].j && GridPane.getRowIndex(Player) == sith[i].i){
                jedi.can--;
                if(jedi.can==0){
                    System.out.println("Kaybettiniz!");
                }
            }
        }
    }

    @FXML
    void PlayerLeft(MouseEvent event) {
        if(Map[GridPane.getRowIndex(Player)][GridPane.getColumnIndex(Player)-1] == 1)
            GridPane.setColumnIndex(Player,GridPane.getColumnIndex(Player)-1);
        for (  int i=0;i<sith.length;i++){
            if(GridPane.getColumnIndex(Player) == sith[i].j && GridPane.getRowIndex(Player) == sith[i].i){
                jedi.can--;
                if(jedi.can==0){
                    System.out.println("Kaybettiniz!");
                }
            }
        }
    }

    @FXML
    void PlayerRight(MouseEvent event) {
        if(Map[GridPane.getRowIndex(Player)][GridPane.getColumnIndex(Player)+1] == 1)
            GridPane.setColumnIndex(Player,GridPane.getColumnIndex(Player)+1);
        for (  int i=0;i<sith.length;i++){
            if(GridPane.getColumnIndex(Player) == sith[i].j && GridPane.getRowIndex(Player) == sith[i].i){
                jedi.can--;
                if(jedi.can==0){
                    System.out.println("Kaybettiniz!");
                }
            }
        }
        if(GridPane.getColumnIndex(Player) == 13 && GridPane.getRowIndex(Player) == 9){
            System.out.println("Kazandınız");
        }
    }

    @FXML
    void PlayerUp(MouseEvent event) {
        if(Map[GridPane.getRowIndex(Player)-1][GridPane.getColumnIndex(Player)] == 1)
            GridPane.setRowIndex(Player,GridPane.getRowIndex(Player)-1);
        for (  int i=0;i<sith.length;i++){
            if(GridPane.getColumnIndex(Player) == sith[i].j && GridPane.getRowIndex(Player) == sith[i].i){
                jedi.can--;
                if(jedi.can==0){
                    System.out.println("Kaybettiniz!");
                }
            }
        }
    }


    @FXML
    boolean GameOver(){
       /* for(int i=0;i<Sith.length;i++){
            if(GridPane.getRowIndex(Player) == GridPane.getRowIndex(Sith[i]) && GridPane.getColumnIndex(Player) == GridPane.getColumnIndex(Sith[i])){
                jedi.can--;
                if(jedi.can==0){
                    System.out.println("Kaybettiniz");
                    return true;
                }
                return false;
            }
            else if(GridPane.getColumnIndex(Player) == 13 && GridPane.getRowIndex(Player) == 9){
                return true;
            }
        }*/
        return false;
    }

    @FXML
    void initialize() {
        assert pane1 != null : "fx:id=\"pane1\" was not injected: check your FXML file 'sample.fxml'.";
        assert Player != null : "fx:id=\"Player\" was not injected: check your FXML file 'sample.fxml'.";
        assert dvader !=null : "fx:id=\"DarthVader\" was not injected: check your FXML file 'sample.fxml'.";
        assert kyloren !=null : "fx:id=\"KyloRen\" was not injected: check your FXML file 'sample.fxml'.";
        assert stormtrooper !=null : "fx:id=\"Stormtrooper\" was not injected: check your FXML file 'sample.fxml'.";
    }
    class Util {
        private static final int M = 10;
        private static final int N = 10;

        private final int row[] = {-1, 0, 0, 1};
        private final int col[] = {0, -1, 1, 0};
        class Node
        {
            // (x, y) represents matrix cell coordinates
            // dist represent its minimum distance from the source
            int x, y, dist;

            Node(int x, int y, int dist) {
                this.x = x;
                this.y = y;
                this.dist = dist;
            }
        };


        private boolean isValid(int mat[][], boolean visited[][],
                                int row, int col) {
            return (row >= 0) && (row < M) && (col >= 0) && (col < N)
                    && mat[row][col] == 1 && !visited[row][col];
        }


        private void BFS(int mat[][], int i, int j, int x, int y) {
            // construct a matrix to keep track of visited cells
            boolean[][] visited = new boolean[M][N];

            // create an empty queue
            Queue<Node> q = new ArrayDeque<>();

            // mark source cell as visited and enqueue the source node
            visited[i][j] = true;
            q.add(new Node(i, j, 0));

            // stores length of longest path from source to destination
            int min_dist = Integer.MAX_VALUE;

            // run till queue is not empty
            while (!q.isEmpty()) {
                // pop front node from queue and process it
                Node node = q.poll();

                // (i, j) represents current cell and dist stores its
                // minimum distance from the source
                i = node.x;
                j = node.y;
                int dist = node.dist;

                // if destination is found, update min_dist and stop
                if (i == x && j == y) {
                    min_dist = dist;
                    break;
                }

                // check for all 4 possible movements from current cell
                // and enqueue each valid movement
                for (int k = 0; k < 4; k++) {
                    // check if it is possible to go to position
                    // (i + row[k], j + col[k]) from current position
                    if (isValid(mat, visited, i + row[k], j + col[k])) {
                        // mark next cell as visited and enqueue it
                        visited[i + row[k]][j + col[k]] = true;
                        q.add(new Node(i + row[k], j + col[k], dist + 1));
                    }
                }
            }

            if (min_dist != Integer.MAX_VALUE) {
                System.out.print("The shortest path from source to destination "
                        + "has length " + min_dist);
            } else {
                System.out.print("Destination can't be reached from source");
            }
        }
    }
}