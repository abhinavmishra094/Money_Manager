package com.example.abhin.money_manager;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_Us extends DialogFragment {

    Dialog dialog;
    Button Ok;

    public About_Us() {
        // Required empty public constructor
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = null;

        final AlertDialog.Builder aBuilder = new AlertDialog.Builder(getActivity());

        aBuilder.setTitle("About Us");
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_about__us, null);
        Ok = (Button) view.findViewById(R.id.ok);

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        aBuilder.setView(view);
        dialog = aBuilder.create();
        return dialog;
    }
}
