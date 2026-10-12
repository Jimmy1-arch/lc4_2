// -------------------activity_main.xml-------------------

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Select a Course"
        android:textSize="20sp"
        android:textStyle="bold" />

    <Spinner
        android:id="@+id/spinnerCourse"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="10dp" />

    <TextView
        android:id="@+id/txtResult"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Selected Course: None"
        android:textSize="18sp"
        android:layout_marginTop="30dp" />

</LinearLayout>
```
// -------------------MainActivity.java-------------------

```java
package com.example.spinnereventhandling;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerCourse;
    TextView txtResult;

    String[] courses = {
        "Select Course",
        "MCA",
        "BCA",
        "BSc Computer Science",
        "MSc Computer Science"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCourse = findViewById(R.id.spinnerCourse);
        txtResult = findViewById(R.id.txtResult);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_spinner_item,
            courses
        );

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        );

        spinnerCourse.setAdapter(adapter);

        spinnerCourse.setOnItemSelectedListener(
            new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(
                        AdapterView<?> parent,
                        View view,
                        int position,
                        long id) {

                    String selectedCourse = courses[position];

                    if (position != 0) {
                        txtResult.setText(
                            "Selected Course: " + selectedCourse
                        );

                        Toast.makeText(
                            MainActivity.this,
                            "You selected " + selectedCourse,
                            Toast.LENGTH_SHORT
                        ).show();
                    } else {
                        txtResult.setText("Selected Course: None");
                    }
                }

                @Override
                public void onNothingSelected(
                        AdapterView<?> parent) {

                    txtResult.setText("Selected Course: None");
                }
            }
        );
    }
}
```
