package com.flycar.asmagannouni.compfeflycar.Fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.flycar.asmagannouni.compfeflycar.Activities.CarInformationActivity;
import com.flycar.asmagannouni.compfeflycar.Activities.MainActivity;
import com.flycar.asmagannouni.compfeflycar.Activities.SignInActivity;
import com.flycar.asmagannouni.compfeflycar.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Salim FG on 4/11/2018.
 */

public class LoginFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.button_sign_in)
    Button button_sign_in;

//    @BindView(R.id.button_parents_click_here)
//    Button button_parents_click_here;

    @BindView(R.id.text_input_username)
    TextInputLayout text_input_username;

    @BindView(R.id.text_input_password)
    TextInputLayout text_input_password;

    @BindView(R.id.edit_text_username)
    TextInputEditText edit_text_username;

    @BindView(R.id.edit_text_password)
    TextInputEditText edit_text_password;
    /*
  * Empty public constructor
  * */

    private String tempAccessToken = "";

    public LoginFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);


        // Set listeners to views
        button_sign_in.setOnClickListener(this);
        //button_parents_click_here.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_sign_in:

                startActivity(new Intent(getActivity(),MainActivity.class));

                //logic sign in
                //verifyDetailsAndCallLoginAPI();
                break;

//            case R.id.button_parents_click_here:
//                //showParentsDialog();
//                //logic sign in
//                break;

        }

    }

    /*
* Check email id and password before proceed to login
* */
//    private void verifyDetailsAndCallLoginAPI() {
//        text_input_username.setError("");
//        text_input_password.setError("");
//        if (!isValidEmailAddress(edit_text_username.getText().toString())) {
//            text_input_username.setError(getString(R.string.invalid_email));
//            edit_text_username.requestFocus();
//        } else if (TextUtils.isEmpty(edit_text_password.getText())) {
//            text_input_password.setError(getString(R.string.empty_field));
//            edit_text_password.requestFocus();
//        } else {
//            hideKeyboard(getActivity());
//            if (isInternetConnected(getContext())) {
//                assert getActivity() != null;
//                ((SignInActivity) getActivity()).showLoading(getString(R.string.please_wait_text));
//                requestLoginAPI(edit_text_password.getText().toString(), edit_text_username.getText().toString(), loginCallBack);
//            } else
//                showErrorSnackBar(getView(), getContext(), getResources().getString(R.string.no_internet_connection));
//        }
//    }

    /*
* Call back for login
* */
//    private GsonResponseCallBack<PostLoginAuthentication> loginCallBack = new GsonResponseCallBack<PostLoginAuthentication>() {
//        @Override
//        public void onSuccess(PostLoginAuthentication response) {
//            LogUtils.i("**** success" + PostLoginAuthentication.class.getSimpleName(), response.getAccess_token());
//            tempAccessToken = response.getAccess_token();
//
//            ((SignInActivity) getActivity()).hideLoading();
//
//            Intent i = new Intent(getActivity(), MainActivity.class);
//            i.putExtra("token",tempAccessToken);
//            startActivity(i);
//
//        }
//
//        @Override
//        public void onError(int errorCode, String errorMessage) {
//            assert getActivity() != null;
//            ((SignInActivity) getActivity()).hideLoading();
//            showErrorSnackBar(getView(), getContext(), getString(R.string.str_invalid_username_password));
//            LogUtils.e("**** Failure" + PostLoginAuthentication.class.getSimpleName(), errorCode + " : " + errorMessage);
//        }
//    };
//
//    public void showParentsDialog(){
//                 AlertDialog.Builder builderInner = new AlertDialog.Builder(getActivity());
//                builderInner.setMessage(getActivity().getResources().getString(R.string.str_parents_popup_message));
//                builderInner.setTitle(getActivity().getResources().getString(R.string.str_parents_popup_title));
//                builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//        AlertDialog alertDialog = builderInner.create();
//        alertDialog.getWindow().setLayout(600, 400); //Controlling width and height.
//        alertDialog.show();
//    }
}
