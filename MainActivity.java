package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0-donut
    //1- knife
    boolean gameat=true;
    String Winnerstr;
    int activeplayer=0;
    int[] gamestate={2, 2, 2, 2, 2, 2, 2, 2, 2};
    // 0-donut
    // 1-knife
    // 2- NULL
    int[][] winp = {{0,1,2},{3,4,5},{6,7,8},
                    {0,3,6},{1,4,7},{2,5,8},
                         {0,4,8},{2,4,6}};
public void playerTap(View view){
      ImageView img= (ImageView)view;
      int TappedImage = Integer.parseInt(img.getTag().toString());
      if(!gameat){
          reset(view);

      }
      if(gamestate[TappedImage]==2) {
          gamestate[TappedImage] = activeplayer;
          img.setTranslationY(-1000f);
          if (activeplayer == 0) {
              img.setImageResource(R.drawable.dd);
              activeplayer = 1;
              TextView Status = findViewById(R.id.status);
              Status.setText("Fork's Turn");
          } else {
              img.setImageResource(R.drawable.cc);
              activeplayer = 0;
              TextView Status = findViewById(R.id.status);
              Status.setText("Donut's Turn");
          }

          img.animate().translationYBy(1000f).setDuration(200);
      }

      for(int[]  win: winp){
          if(gamestate[win[0]] == gamestate[win[1]] && gamestate[win[1]] == gamestate[win[2]] && gamestate[win[0]]!=2){

              gameat=false;

              if(gamestate[win[0]]==0){

                  Winnerstr= "Donut Has Won!";
              }else {
                  Winnerstr= "Fork Has Won!";
              }

              TextView Status = findViewById(R.id.status);
              Status.setText(Winnerstr);
          }
      }
}

public void res(View view){
    reset(view);
}
    public void reset(View view){
    gameat=true;
    activeplayer=0;
    for(int i=0 ; i<gamestate.length;i++){
        gamestate[i]=2;
    }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView03)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}