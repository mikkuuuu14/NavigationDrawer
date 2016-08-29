package com.javahelps.navigationdrawer.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Angelhia on 29/8/2016.
 */
public class Helper {

    public static void showErrorDialog(Context context, String message, String buttonTitle) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(buttonTitle, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
