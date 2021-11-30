package trinhhoangduyanh.example.countdownapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fbtnAdd;
    ListView lvEvent;
    ArrayList<Event> listEvent;
    EventAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        Anhxa();
        getBundle();

        adapter = new EventAdapter( this, R.layout.event_item, listEvent );
        lvEvent.setAdapter( adapter );
        fbtnAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity( intent );
            }
        } );
        
    }

    @SuppressLint("WrongViewCast")
    private void getBundle() {
        lvEvent =(ListView) findViewById( R.id.LvEvent );
        Intent intent =  getIntent();
        Bundle bundle = intent.getBundleExtra( "data" );
        listEvent = new ArrayList<>();
        //listEvent.add( new Event( "Happy new year", "Happy new year 2022", "31 days remaining" ) );
        Event ev= (Event)  bundle.getSerializable( "objectEvent" );

        listEvent.add( ev );
    }

    private void Anhxa() {
        fbtnAdd = (FloatingActionButton) findViewById( R.id.fbtnAdd );

    }

    public  void  Xoa(final  int position){
        listEvent.remove( position );
        adapter.notifyDataSetChanged();;
    }
}