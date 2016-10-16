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
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Report_Bugs_Dialog extends DialogFragment {

    Dialog dialog;
    TextView reporbugs;
    Button submit,cancel;

    public Report_Bugs_Dialog() {
        // Required empty public constructor
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = null;

        AlertDialog.Builder aBuilder = new AlertDialog.Builder(getActivity());

        aBuilder.setTitle("Report Bugs");
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_report__bugs__dialog,null);


        reporbugs = (TextView) view.findViewById(R.id.reportbugs);
        submit = (Button) view.findViewById(R.id.submit);
        cancel = (Button) view.findViewById(R.id.ccancel);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
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
