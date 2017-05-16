package com.example.marcellofolco.customlistviewlayoutclass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcellofolco.customlistviewlayoutclass1.model.Car;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listViewCars;
    ImageView imageViewCar;
    ArrayList<Car> listOfCars;
    ArrayAdapter<Car> carAdapter;
    int carPictures[] = {R.drawable.car0, R.drawable.car1,R.drawable.car2,R.drawable.car3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        listViewCars = (ListView) findViewById(R.id.listViewCars);
        imageViewCar = (ImageView) findViewById(R.id.imageViewCar);
        listViewCars.setOnItemClickListener(this);
        listOfCars = new ArrayList<Car>();
        Car car0 = new Car(carPictures[0],"Toyota","Corolla",12000),
            car1 = new Car(carPictures[1],"Honda","Civic",14000),
            car2 = new Car(carPictures[2],"Toyota","Camery",19000),
            car3 = new Car(carPictures[3],"Toyota","Yaris",11000);
        listOfCars.add(car0);listOfCars.add(car1);listOfCars.add(car2);listOfCars.add(car3);

        carAdapter = new ArrayAdapter<Car>(this,android.R.layout.simple_list_item_1, listOfCars);
        listViewCars.setAdapter(carAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        imageViewCar.setImageResource(listOfCars.get(position).getPicture());

//        TextView selectedText = (TextView)view;
//        Toast.makeText(this,selectedText.getText().toString(),
//                       Toast.LENGTH_LONG).show();

        int i = adapterView.getId();
        if (i == R.id.listViewCars)
            Toast.makeText(this,"List view selected", Toast.LENGTH_LONG).show();

    }
}
