package com.example.collegematch;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.collegematch.databinding.ActivityMainBinding;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Firebase {
    private Map<String, Map<String, Object>> collegeDocuments = new HashMap<>();

    public Firebase() {
        readFirestoreDocuments();
    }

    private void readFirestore(String key) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("College").document(key);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("College Match", "DocumentSnapshot data: " + key +  ": " + document.getData());
                        // Add documents to the collegeDocuments HashMap
                        collegeDocuments.put(key, document.getData());
                    } else {
                        Log.d("College Match", "No such document");
                    }
                } else {
                    Log.d("College Match", "get failed with ", task.getException());
                }
            }
        });
    }
    private void readFirestoreDocuments() {
        FirebaseFirestore.getInstance()
            .collection("College")
            .get()
            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        List<DocumentSnapshot> myListOfDocuments = task.getResult().getDocuments();
                        for(DocumentSnapshot document: myListOfDocuments) {

                            readFirestore(document.getId());
                        }
                    }
                }
            });
    }

    public ArrayList<College> getCollegeDocuments() {
        ArrayList<College> colleges = new ArrayList<>();
        College nextCollege;
        for (String key : collegeDocuments.keySet()) {
            String name = key;
            float GPA = (float) collegeDocuments.get(key).get("GPA");
            int ACT = (int) collegeDocuments.get(key).get("ACT");
            int SAT = (int) collegeDocuments.get(key).get("SAT");
            ArrayList<String> majors = (ArrayList<String>) collegeDocuments.get(key).get("Majors");
            double PPS = (double) collegeDocuments.get(key).get("PPS"); // price per semester
            String location = (String) collegeDocuments.get(key).get("Location");
            nextCollege = new College(name, GPA, ACT, SAT, majors, PPS, location);
            colleges.add(nextCollege);
        }
        return colleges;
    }
}
