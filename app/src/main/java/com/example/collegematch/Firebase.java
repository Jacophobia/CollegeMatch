package com.example.collegematch;

import android.util.Log;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Firebase {
    private Map<String, Map<String, Object>> collegeDocuments = new HashMap<>();
    private ArrayList<College> colleges = new ArrayList<>();

    public Firebase() {
        System.out.println("Beginning Firebase Query");
        readFirestoreDocuments();
        System.out.println("Firebase Query Complete");
    }

    private void readFirestoreDocuments() {
        FirebaseFirestore.getInstance()
            .collection("College")
            .get()
            .addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    List<DocumentSnapshot> myListOfDocuments = task.getResult().getDocuments();
                    for (DocumentSnapshot document : myListOfDocuments) {

                        readFirestore(document.getId());
                    }
                }
            });
    }

    private void readFirestore(String key) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("College").document(key);
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                assert document != null : "Unable to locate specified document";
                if (document.exists()) {
//                        Log.d("College Match", "DocumentSnapshot data: " + key +  ": " + document.getData());
                    // Add documents to the collegeDocuments HashMap
                    collegeDocuments.put(key, document.getData());

                    String name = key;
                    float GPA = Float.parseFloat("" + collegeDocuments.get(key).get("GPA"));
                    long ACT = (long) collegeDocuments.get(key).get("ACT");
                    long SAT = (long) collegeDocuments.get(key).get("SAT");
                    ArrayList<String> majors = (ArrayList<String>) collegeDocuments.get(key).get("Majors");
                    double PPS = Double.parseDouble("" + collegeDocuments.get(key).get("PPS")); // price per semester
                    String location = (String) collegeDocuments.get(key).get("Location");

                    colleges.add(new College(name, GPA, ACT, SAT, majors, PPS, location));
                } else {
                    Log.d("College Match", "No such document");
                }
            } else {
                Log.d("College Match", "get failed with ", task.getException());
            }
        });
    }

    public ArrayList<College> getCollegeList() {
        return colleges;
    }
}
