package trinhhoangduyanh.example.countdownapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class EventAdapter extends BaseAdapter {
    FloatingActionButton floatingActionButton;
    ImageView deleteImageView;
    private MainActivity mContext;
    private  int layout;
    private List<Event> eventList;

    public EventAdapter(MainActivity mContext, int layout, List<Event> events) {
        this.mContext = mContext;
        this.layout = layout;
        this.eventList = events;
    }
    private class ViewHolder{
        TextView title, description, date;

    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolderl;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate( layout,null );

            //Ánh xạ dữ liệu
            viewHolderl = new ViewHolder();
            viewHolderl.title =(TextView) convertView.findViewById( R.id.event_title );
            viewHolderl.description =(TextView) convertView.findViewById( R.id.event_des );
            viewHolderl.date =(TextView) convertView.findViewById( R.id.event_date );
            deleteImageView = (ImageView) convertView.findViewById( R.id.delete_icon );

            convertView.setTag( viewHolderl );
        }
        else{
            viewHolderl = (ViewHolder) convertView.getTag();
        }
        //tao su kien
        Event event  = eventList.get(position );
        viewHolderl.title.setText( event.getTitle() );
        viewHolderl.description.setText( event.getDescription() );
        viewHolderl.date.setText( event.getDate(  ) );

        //Xoa event
        deleteImageView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( mContext, "Bạn đá xóa một sự kiện", Toast.LENGTH_SHORT ).show();
                mContext.Xoa(position);
            }
        } );

        return convertView ;
    }
}
