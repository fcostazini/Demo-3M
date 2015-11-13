package com.example.facundo.demo_3m;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class ImagenesMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes_menu);
        int[] imagenes;
        Button btnAberrometria = (Button)findViewById(R.id.btn_aberrometria);
        imagenes = new int[]{R.drawable.aberrometria_1};
        btnAberrometria.setOnClickListener(new ClickHandler(imagenes));

        Button btnBiomicroscopia = (Button)findViewById(R.id.btn_biomicroscopia);
        imagenes = new int[]{R.drawable.biomicroscopia1,
                R.drawable.biomicroscopia2,
                R.drawable.biomicroscopia3,
                R.drawable.biomicroscopia4,
                R.drawable.biomicroscopia5,
                R.drawable.biomicroscopia6,
                R.drawable.biomicroscopia7,
                R.drawable.biomicroscopia8,
                R.drawable.biomicroscopia9};
        btnBiomicroscopia.setOnClickListener(new ClickHandler(imagenes));

        Button btnCampoVisual = (Button)findViewById(R.id.btn_campovisual);
        imagenes = new int[]{R.drawable.campovisual1,
                R.drawable.campovisual2,
                R.drawable.campovisual3
               };
        btnCampoVisual.setOnClickListener(new ClickHandler(imagenes));

        Button btnEcografia = (Button)findViewById(R.id.btn_ecografia_b);
        imagenes = new int[]{R.drawable.ecografia_b_1,
                R.drawable.ecografia_b_2,
                R.drawable.ecografia_b_3,
                R.drawable.ecografia_b_4
        };
        btnEcografia.setOnClickListener(new ClickHandler(imagenes));

        Button btnMicroscopia = (Button)findViewById(R.id.btn_microscopia_endotelial);
        imagenes = new int[]{R.drawable.microscopia_1};
        btnMicroscopia.setOnClickListener(new ClickHandler(imagenes));

        Button btnOct = (Button)findViewById(R.id.btn_oct);
        imagenes = new int[]{R.drawable.oct_1,
                R.drawable.oct_2,
                R.drawable.oct_3,
                R.drawable.oct_4,
                R.drawable.oct_5,
                R.drawable.oct_6,
                R.drawable.oct_7,
                R.drawable.oct_8,
                R.drawable.oct_9,
                R.drawable.oct_10,
                R.drawable.oct_11,
                R.drawable.oct_12,
                R.drawable.oct_13};
        btnOct.setOnClickListener(new ClickHandler(imagenes));

        Button btnOctCamara = (Button)findViewById(R.id.btn_oct_camara_anterior);
        imagenes = new int[]{R.drawable.oct_camara_anterior_1,
                R.drawable.oct_camara_anterior_2,
                R.drawable.oct_camara_anterior_3
       };
        btnOctCamara.setOnClickListener(new ClickHandler(imagenes));

        Button btnRetinografias = (Button)findViewById(R.id.btn_retinografias);
        imagenes = new int[]{R.drawable.retinografia_1,
                R.drawable.retinografia_2,
                R.drawable.retinografia_3,
                R.drawable.retinografia_4,
                R.drawable.retinografia_5,
                R.drawable.retinografia_6
        };
        btnRetinografias.setOnClickListener(new ClickHandler(imagenes));

    }

    private class ClickHandler implements View.OnClickListener{

        private int[] imagenes;

        public ClickHandler(int[] imagenes) {
            this.imagenes = imagenes;
        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            Bundle b = new Bundle();
            b.putIntArray(ImageCarroucelActivity.TO_SHOW, imagenes);
            Intent i = new Intent(ImagenesMenu.this,ImageCarroucelActivity.class);
            i.putExtras(b);
            startActivity(i);

        }
    }

}