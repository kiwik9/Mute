package dev.sis.mute;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Memoria2Activity extends AppCompatActivity {


    TextView tv_p1, tv_p2;
    ImageView iv11, iv12, iv13, iv14, iv21, iv22, iv23, iv24, iv31, iv32, iv33, iv34;

    //Array de imagenes
    Integer[]cardsArray = {101,102,103,104,105,106,201,202,203,204,205,206};


    int image101,image102,image103,image104,image105,image106,image201,image202,image203,image204,image205,image206;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber =1;
    int turn =1;
    int playerpoints= 0,cpupoints=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria2);

        tv_p1 = (TextView) findViewById(R.id.tv_p1);
        tv_p2 = (TextView) findViewById(R.id.tv_p2);


        iv11 = (ImageView) findViewById(R.id.iv11);
        iv12 = (ImageView) findViewById(R.id.iv12);
        iv13 = (ImageView) findViewById(R.id.iv13);
        iv14 = (ImageView) findViewById(R.id.iv14);
        iv21 = (ImageView) findViewById(R.id.iv21);
        iv22 = (ImageView) findViewById(R.id.iv22);
        iv23 = (ImageView) findViewById(R.id.iv23);
        iv24 = (ImageView) findViewById(R.id.iv24);
        iv31 = (ImageView) findViewById(R.id.iv31);
        iv32 = (ImageView) findViewById(R.id.iv32);
        iv33 = (ImageView) findViewById(R.id.iv33);
        iv34 = (ImageView) findViewById(R.id.iv34);

        iv11.setTag("0");
        iv12.setTag("1");
        iv13.setTag("2");
        iv14.setTag("3");
        iv21.setTag("4");
        iv22.setTag("5");
        iv23.setTag("6");
        iv24.setTag("7");
        iv31.setTag("8");
        iv32.setTag("9");
        iv33.setTag("10");
        iv34.setTag("11");

        frontOfCardResources();

        //shuffle
        Collections.shuffle((Arrays.asList(cardsArray)));

        //color of p2 inactive
        tv_p2.setTextColor(Color.GRAY);


        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard  = Integer.parseInt((String)view.getTag());
                doStuff(iv11,theCard);

            }
        });

        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard  = Integer.parseInt((String)view.getTag());
                doStuff(iv12,theCard);
            }
        });

        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard  = Integer.parseInt((String)view.getTag());
                doStuff(iv13,theCard);

            }
        });

        iv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard  = Integer.parseInt((String)view.getTag());
                doStuff(iv14,theCard);
            }
        });

        iv21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard  = Integer.parseInt((String)view.getTag());
                doStuff(iv21,theCard);

            }
        });

        iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard  = Integer.parseInt((String)view.getTag());
                doStuff(iv22,theCard);
            }
        });

        iv23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard  = Integer.parseInt((String)view.getTag());
                doStuff(iv23,theCard);
            }
        });

        iv24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard  = Integer.parseInt((String)view.getTag());
                doStuff(iv24,theCard);
            }
        });


        iv31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard  = Integer.parseInt((String)view.getTag());
                doStuff(iv31,theCard);
            }
        });


        iv32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard  = Integer.parseInt((String)view.getTag());
                doStuff(iv32,theCard);
            }
        });


        iv33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard  = Integer.parseInt((String)view.getTag());
                doStuff(iv33,theCard);
            }
        });


        iv34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard  = Integer.parseInt((String)view.getTag());
                doStuff(iv34,theCard);
            }
        });

    }

    //set the correct image to the imageview
    private void doStuff(ImageView iv, int card){
        if (cardsArray[card]==101){
            iv.setImageResource(image101);
        }
        else if (cardsArray[card]==102){
            iv.setImageResource(image102);
        }
        else if (cardsArray[card]==103){
            iv.setImageResource(image103);
        }
        else if (cardsArray[card]==104){
            iv.setImageResource(image104);
        }
        else if (cardsArray[card]==105){
            iv.setImageResource(image105);
        }
        else if (cardsArray[card]==106){
            iv.setImageResource(image106);
        }
        else if (cardsArray[card]==201){
            iv.setImageResource(image201);
        }
        else if (cardsArray[card]==202){
            iv.setImageResource(image202);
        }
        else if (cardsArray[card]==203){
            iv.setImageResource(image203);
        }
        else if (cardsArray[card]==204){
            iv.setImageResource(image204);
        }
        else if (cardsArray[card]==205){
            iv.setImageResource(image205);
        }
        else if (cardsArray[card]==206){
            iv.setImageResource(image206);
        }

        //check wich image is selected and sved to a temporary variable

        if(cardNumber ==1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if(cardNumber==2){
            secondCard =cardsArray[card];
            if(secondCard>200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv11.setEnabled(false);
            iv12.setEnabled(false);
            iv13.setEnabled(false);
            iv14.setEnabled(false);
            iv21.setEnabled(false);
            iv22.setEnabled(false);
            iv23.setEnabled(false);
            iv24.setEnabled(false);
            iv31.setEnabled(false);
            iv32.setEnabled(false);
            iv33.setEnabled(false);
            iv34.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if de selected images are equal
                    calculate();

                }
            } ,1000);

        }
    }

    //if images are equal remove them and add point
    private void calculate() {
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                iv11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv24.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                iv33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                iv34.setVisibility(View.INVISIBLE);
            }


            if (clickedSecond == 0) {
                iv11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv24.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                iv33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                iv34.setVisibility(View.INVISIBLE);
            }

            //add point to the correct player
            if (turn == 1) {
                playerpoints++;
                tv_p1.setText("P1:" + playerpoints);
            } else if (turn == 2) {
                cpupoints++;
                tv_p2.setText("P2:" + cpupoints);
            }

        } else {
            iv11.setImageResource(R.drawable.signo2);
            iv12.setImageResource(R.drawable.signo2);
            iv13.setImageResource(R.drawable.signo2);
            iv14.setImageResource(R.drawable.signo2);
            iv21.setImageResource(R.drawable.signo2);
            iv22.setImageResource(R.drawable.signo2);
            iv23.setImageResource(R.drawable.signo2);
            iv24.setImageResource(R.drawable.signo2);
            iv31.setImageResource(R.drawable.signo2);
            iv32.setImageResource(R.drawable.signo2);
            iv33.setImageResource(R.drawable.signo2);
            iv34.setImageResource(R.drawable.signo2);

            //change the player turn
            if( turn == 1){
                turn = 2;
                tv_p1.setTextColor(Color.GRAY);
                tv_p2.setTextColor(Color.BLACK);
            } else if( turn == 2){
                turn =1;
                tv_p2.setTextColor(Color.GRAY);
                tv_p1.setTextColor(Color.BLACK);
            }

        }

        iv11.setEnabled(true);
        iv12.setEnabled(true);
        iv13.setEnabled(true);
        iv14.setEnabled(true);
        iv21.setEnabled(true);
        iv22.setEnabled(true);
        iv23.setEnabled(true);
        iv24.setEnabled(true);
        iv31.setEnabled(true);
        iv32.setEnabled(true);
        iv33.setEnabled(true);
        iv34.setEnabled(true);


        //check if the game  is over
        checkEnd();

    }

    private void checkEnd() {
        if (iv11.getVisibility() == View.INVISIBLE &&
                iv12.getVisibility() == View.INVISIBLE &&
                iv13.getVisibility() == View.INVISIBLE &&
                iv14.getVisibility() == View.INVISIBLE &&
                iv21.getVisibility() == View.INVISIBLE &&
                iv22.getVisibility() == View.INVISIBLE &&
                iv23.getVisibility() == View.INVISIBLE &&
                iv24.getVisibility() == View.INVISIBLE &&
                iv31.getVisibility() == View.INVISIBLE &&
                iv32.getVisibility() == View.INVISIBLE &&
                iv33.getVisibility() == View.INVISIBLE &&
                iv34.getVisibility() == View.INVISIBLE ){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Memoria2Activity.this);
            alertDialogBuilder
                    .setMessage("Game Over!\nP1: " + playerpoints + "\nP2:" + cpupoints)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent (getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                            finish();
                        }})
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    private void frontOfCardResources() {
        image101 = R.drawable.letraa;
        image102 = R.drawable.letrab;
        image103 = R.drawable.letrac;
        image104 = R.drawable.letrad;
        image105 = R.drawable.letrae;
        image106 = R.drawable.letraf;
        image201 = R.drawable.letraaa;
        image202 = R.drawable.letraab;
        image203 = R.drawable.letraac;
        image204 = R.drawable.letraad;
        image205 = R.drawable.letraae;
        image206 = R.drawable.letraaf;
    }
}
