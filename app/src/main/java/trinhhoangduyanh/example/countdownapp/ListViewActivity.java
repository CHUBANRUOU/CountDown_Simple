package trinhhoangduyanh.example.countdownapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ListViewActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button btnsetDate, btnAdd;
    TextView textDate;
    EditText editTitle, editDes;
    ArrayList<Event> list  = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.add );
        Anhxa();

        //set date cho event
        btnsetDate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFrag();
                datePicker.show( getSupportFragmentManager(),"date picker" );
            }
        } );
        //event change page
        btnAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListViewActivity.this, MainActivity.class);
                Bundle bundle  = new Bundle();Event event = new Event( String.valueOf( editTitle.getText() ),String.valueOf( editDes.getText() ), String.valueOf( textDate.getText() ) );
                bundle.putSerializable("objectEvent",event);
                intent.putExtra( "data",bundle );
                startActivity( intent );
            }
        } );

    }

    private void Anhxa() {
        btnsetDate =(Button) findViewById( R.id.btnSetDate );
        textDate = (TextView) findViewById( R.id.date );
        btnAdd = (Button) findViewById( R.id.btnAdd );
        editTitle = (EditText) findViewById( R.id.edtTitle );
        editDes =(EditText) findViewById( R.id.edtDes );
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c   = Calendar.getInstance();
        Calendar calendar =Calendar.getInstance();
        calendar.set( Calendar.YEAR, year );
        calendar.set( Calendar.MONTH, month );
        calendar.set( Calendar.DAY_OF_MONTH ,dayOfMonth );

        try {
            Date now = new Date();
            long current = now.getTime();
            long picked = calendar.getTimeInMillis();
            long resultDate = (picked - current)/(24*60*60*1000);
            textDate.setText( String.valueOf( resultDate )+ "Days Remainting" );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
