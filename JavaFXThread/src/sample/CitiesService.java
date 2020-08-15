package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class CitiesService extends Service<ObservableList<String>> {

    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] names={"Delhi",
                        "Mumbai",
                        "Jaipur",
                        "Pune",
                        "Hyderabad",
                        "Chandigarh",
                        "Goa",
                        "Shimla"};
                ObservableList<String> cities= FXCollections.observableArrayList();
                for (int i=0;i<names.length;i++){
                    cities.add(names[i]);
                    updateMessage("Added " + names[i] + " to the list");
                    updateProgress(i+1,names.length);
                    Thread.sleep(200);
                }

                return cities;
            }
        };
    }
}
