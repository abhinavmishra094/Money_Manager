package com.example.abhin.money_manager;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Suggest_Feature extends DialogFragment {

   Dialog dialog ;
    public Suggest_Feature() {

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        dialog = null;
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(getActivity());
        aBuilder.setTitle("Suggest Feature");
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_suggest__feature,null);



        aBuilder.setView(view);
        dialog = aBuilder.create();
        return dialog;
    }
}
