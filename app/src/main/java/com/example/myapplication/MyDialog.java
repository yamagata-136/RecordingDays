package com.example.myapplication;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment{

    public interface NoticeDialogListener {
        public void onDialogClick(DialogFragment dialog);
    }
    NoticeDialogListener listener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener = (NoticeDialogListener) context;

    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        DialogClickListener listener = new DialogClickListener();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("リセット")
                .setMessage("本当にリセットしますか？")
                .setNegativeButton("いいえ", listener)
                .setPositiveButton("はい", listener);


        return builder.create();
    }

    private class DialogClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog,int buttonId){
            //System.out.println("オンクリック");
            switch(buttonId) {
                case DialogInterface.BUTTON_POSITIVE:
                    MainActivity.DAY_CNT = 0;
                    listener.onDialogClick(MyDialog.this);
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
            }
        }



    }
}
