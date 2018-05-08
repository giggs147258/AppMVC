package com.example.kornchrismas.mvc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class MyAlertDialog {

        private AlertDialog.Builder objAlert;

        public void NoChooseEveryThing(Context context) {
            objAlert = new AlertDialog.Builder(context);
            objAlert.setIcon(R.drawable.danger);
            objAlert.setTitle("Please Choose Answer?");
            objAlert.setMessage("Please Choose Answer on Radiobutton");
            objAlert.setCancelable(false);
            objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                }
            });

            objAlert.show();
        }

}
