
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nate Cox
 */
class SearchController {
    @FXML Stage stage;
    private static SearchController searchController;
    
    private SearchController(Stage theStage){
        stage = theStage;
        this.setUpSearchScene();
        stage.show();
    }
    
    public static SearchController getSearchController(Stage theStage){
        if(searchController != null){
            return searchController;
        } else{
            searchController = new SearchController(theStage);
        }
        return searchController;
    }

    private void setUpSearchScene() {
       Parent root;
       Scene scene;
       
       try{
           root = FXMLLoader.load(getClass().getResource("SearchView.fxml"));
            scene = new Scene(root);
            stage.setTitle("Search");
            stage.setScene(scene);
            stage.show();
       } catch(Exception e){
           e.printStackTrace();
       }
    }
}
