package com.example.enric.menu.activities.stock;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.enric.menu.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LectorBarCameraFragment extends Fragment implements ZXingScannerView.ResultHandler{

    //private ZXingScannerView escanerView;
    public LectorBarCameraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*escanerView = new ZXingScannerView(this.getContext());
        FrameLayout rl = rl.findViewById(R.id.idCamaraLectorBar);
        rl.addView(escanerView);*/
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stock_lector_bar_camera, container, false);
    }

    @Override
    public void handleResult(Result result) {

    }
}
