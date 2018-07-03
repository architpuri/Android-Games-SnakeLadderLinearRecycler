package extras.com.snakeladder.gameScreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import extras.com.snakeladder.R;

public class GameActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button startbtn;
    private Button rollbtn;
    private Button endbtn;
    private TextView rolltext;
    private TextView resulttext;
    int present=0;
    int a[][]= new int[25][2];
    int i=1;
    boolean isPlaying=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        for(int i=0;i<25;i++){a[i][0]=i+1; a[i][1]=0;}
        rolltext=findViewById(R.id.text_roll);
        resulttext=findViewById(R.id.text_result);
        startbtn=findViewById(R.id.btn_start);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPlaying)
                startGame();
                else
                {
                    Toast.makeText(GameActivity.this,"Finish Previous Game",Toast.LENGTH_SHORT).show();
                }
            }
        });
        rollbtn=findViewById(R.id.btn_roll_die);
        rollbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying)
                {
                    Random random=new Random();
                    int g=random.nextInt(5)+1;//generate random no.
                    rolltext.setText(""+g);
                    player(g);
                }

            }
        });
        endbtn=findViewById(R.id.btn_end);
        endbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GameActivity.this,"Game Ends",Toast.LENGTH_SHORT).show();
                isPlaying=false;
                a[present-1][1]=0;
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        recyclerView=findViewById(R.id.recycler);
        GameActivityAdapter adapter= new GameActivityAdapter(GameActivity.this,a,getDrawable(R.drawable.ic_home));
        recyclerView.setAdapter(adapter);
    }
    private void startGame(){
    isPlaying=true;
    present=1;
    resulttext.setText("Playing");
    changeFocus(present);
    }
    private void player(int dieAdd){
        if((present+dieAdd)<=25){
            //To keep the present yellow
            a[present-1][1]=0;
            recyclerView.getAdapter().notifyDataSetChanged();
            present=present+dieAdd;
            switch(present) {
                case 15:
                    Toast.makeText(GameActivity.this,""+present+"+4",Toast.LENGTH_SHORT).show();
                    present=present+4;
                    break;
                case 17:
                    Toast.makeText(GameActivity.this,""+present+"-3",Toast.LENGTH_SHORT).show();
                    present=present-3;
                    break;
                case 22:
                    Toast.makeText(GameActivity.this,""+present+"+1",Toast.LENGTH_SHORT).show();
                    present=present+1;
                    break;
                case 24:
                    Toast.makeText(GameActivity.this,""+present+"-18",Toast.LENGTH_SHORT).show();
                    present=present-18;
                    break;
                case 25:
                    gameWon();
            }
            changeFocus(present);
        }
    }
private void gameWon(){
        a[present-1][1]=0;
        recyclerView.getAdapter().notifyDataSetChanged();
        isPlaying=false;
        resulttext.setText("You Won");
        Toast.makeText(GameActivity.this,"Press Start To Play Again",Toast.LENGTH_SHORT).show();
}
private void changeFocus(int position){
        a[position-1][1]=1;
        recyclerView.getAdapter().notifyDataSetChanged();
}
}
