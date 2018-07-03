package extras.com.snakeladder.gameScreen;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import extras.com.snakeladder.R;

public class GameActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context contextActivity;
    int array[][];
    Drawable drawable;
    public GameActivityAdapter(Context c,int a[][],Drawable d) {
    contextActivity=c;
    array=a;
    drawable=d;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public Button leftButton,leftmidButton,midButton,rightmidButton,rightButton;
        public ViewHolder(View itemView) {
            super(itemView);
            leftButton=itemView.findViewById(R.id.btn_left);
            leftmidButton=itemView.findViewById(R.id.btn_mid_left);
            midButton=itemView.findViewById(R.id.btn_mid);
            rightmidButton=itemView.findViewById(R.id.btn_mid_right);
            rightButton=itemView.findViewById(R.id.btn_right);
        }

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.activity_game_row,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
            int numToDisplay=5*position+1;
            if(array[numToDisplay-1][1]==1){
                viewHolder.leftButton.setBackgroundColor(Color.GREEN);
            }
            else
            {
                viewHolder.leftButton.setBackgroundColor(Color.YELLOW);
            }
        viewHolder.leftButton.setText(""+numToDisplay);
        numToDisplay++;
        if(array[numToDisplay-1][1]==1){
            viewHolder.leftmidButton.setBackgroundColor(Color.GREEN);
        }
        else
        {
            viewHolder.leftmidButton.setBackgroundColor(Color.YELLOW);
        }
        if(array[numToDisplay-1][0]==17){
            viewHolder.leftmidButton.setTextSize(20);
            viewHolder.leftmidButton.setText(""+17+"(-3)");
        }
        else if(array[numToDisplay-1][0]==22){
            viewHolder.leftmidButton.setTextSize(20);
            viewHolder.leftmidButton.setText(""+22+"(+1)");
        }
        else
        viewHolder.leftmidButton.setText(""+numToDisplay);
        numToDisplay++;
        if(array[numToDisplay-1][1]==1){
            viewHolder.midButton.setBackgroundColor(Color.GREEN);
        }
        else
        {
            viewHolder.midButton.setBackgroundColor(Color.YELLOW);
        }
        viewHolder.midButton.setText(""+numToDisplay);
        numToDisplay++;
        if(array[numToDisplay-1][1]==1){
            viewHolder.rightmidButton.setBackgroundColor(Color.GREEN);
        }
        else
        {
            viewHolder.rightmidButton.setBackgroundColor(Color.YELLOW);
        }
        if(array[numToDisplay-1][0]==24){
            viewHolder.rightmidButton.setTextSize(20);
            viewHolder.rightmidButton.setText(""+24+"(-18)");
        }
        else viewHolder.rightmidButton.setText(""+numToDisplay);
        numToDisplay++;
        if(array[numToDisplay-1][1]==1){
            viewHolder.rightButton.setBackgroundColor(Color.GREEN);
        }
        else
        {
            viewHolder.rightButton.setBackgroundColor(Color.YELLOW);
        }
        if(array[numToDisplay-1][0]==25){
            viewHolder.rightButton.setTextSize(20);
            viewHolder.rightButton.setText(""+25);
            viewHolder.rightButton.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, drawable);
        }
        else if(array[numToDisplay-1][0]==15){
            viewHolder.rightButton.setTextSize(20);
            viewHolder.rightButton.setText(""+15+"(+4)");
        }
        else
            viewHolder.rightButton.setText(""+numToDisplay);
    }
    @Override
    public int getItemCount() {
        return 5;
    }
}
