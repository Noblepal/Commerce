package com.retailboosters;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.angads25.filepicker.controller.DialogSelectionListener;
import com.github.angads25.filepicker.model.DialogConfigs;
import com.github.angads25.filepicker.model.DialogProperties;
import com.github.angads25.filepicker.view.FilePickerDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.fragment.BuyEmployeeInfoFragment;
import com.retailboosters.response.EditDocResponse;
import com.retailboosters.response.FileUploadResponse;
import com.retailboosters.response.GetUserDocResponse;
import com.retailboosters.response.LoginResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Pref;
import com.retailboosters.utils.Utils;

import java.io.File;
import java.util.HashMap;

public class DocumentActivity extends Activity implements OnApiResponse {

    private TextView mIdEditTextView,mLicenseTextView,mBillTextView,mBankTextView;

    private FilePickerDialog mIDPickerDialog,mLicencePickerDialog,mBillPickerDialog,mBankPickerDialog;
    private String mIdPathString,mLicensePath,mBillPath,mBankPath;
    DialogProperties proffProperties = new DialogProperties();
    GetUserDocResponse docResponse;
    private RelativeLayout mIdLayout,mLicenceLayout,mBillLayout,mBankLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);

        mIdEditTextView = (TextView)findViewById(R.id.editIdTextView);
        mLicenseTextView = (TextView)findViewById(R.id.editLicenseTextView);
        mBillTextView = (TextView)findViewById(R.id.editbillTextView);
        mBankTextView = (TextView)findViewById(R.id.editBankTextView);

        mIdLayout = (RelativeLayout)findViewById(R.id.idLayout);
        mLicenceLayout = (RelativeLayout)findViewById(R.id.licenceLayout);
        mBillLayout = (RelativeLayout)findViewById(R.id.billLayout);
        mBankLayout= (RelativeLayout)findViewById(R.id.bankLayout);


        proffProperties.selection_mode = DialogConfigs.SINGLE_MODE;
        proffProperties.selection_type = DialogConfigs.FILE_SELECT;
        proffProperties.root = new File(DialogConfigs.DEFAULT_DIR);
        proffProperties.error_dir = new File(DialogConfigs.DEFAULT_DIR);
        proffProperties.offset = new File(DialogConfigs.DEFAULT_DIR);
        proffProperties.extensions =null;

        new Utils().callGetApiWithHeader(DocumentActivity.this,Utils.GET_USER_DOCS,this,true);


        mIdEditTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIDPickerDialog = new FilePickerDialog(DocumentActivity.this,proffProperties);
                mIDPickerDialog.setTitle("Select a File");
                mIDPickerDialog.setDialogSelectionListener(new DialogSelectionListener() {
                    @Override
                    public void onSelectedFilePaths(String[] files) {
                        //files is the array of the paths of files selected by the Application User.
                        mIdPathString = files[0];

                        String URL = Utils.UPLOAD_DOC ;
                        HashMap<String,String> hashMap = new HashMap<>();
                        HashMap<String,String> imagesHashMap = new HashMap<>();
                        if(mIdPathString!=null){
                            imagesHashMap.put("govermentId", mIdPathString);

                        }
                        new Utils().uploadFile(DocumentActivity.this,URL,hashMap,imagesHashMap,DocumentActivity.this);

                    }
                });
                mIDPickerDialog.show();
            }
        });

        mLicenseTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLicencePickerDialog = new FilePickerDialog(DocumentActivity.this,proffProperties);
                mLicencePickerDialog.setTitle("Select a File");
                mLicencePickerDialog.setDialogSelectionListener(new DialogSelectionListener() {
                    @Override
                    public void onSelectedFilePaths(String[] files) {
                        //files is the array of the paths of files selected by the Application User.
                        mLicensePath = files[0];
                        String URL = Utils.UPLOAD_DOC ;
                        HashMap<String,String> hashMap = new HashMap<>();
                        HashMap<String,String> imagesHashMap = new HashMap<>();
                        if(mLicensePath!=null){
                            imagesHashMap.put("passportOrDrivingLicense", mLicensePath);

                        }
                        new Utils().uploadFile(DocumentActivity.this,URL,hashMap,imagesHashMap,DocumentActivity.this);

                    }
                });
                mLicencePickerDialog.show();
            }
        });

        mBillTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBillPickerDialog = new FilePickerDialog(DocumentActivity.this,proffProperties);
                mBillPickerDialog.setTitle("Select a File");
                mBillPickerDialog.setDialogSelectionListener(new DialogSelectionListener() {
                    @Override
                    public void onSelectedFilePaths(String[] files) {
                        //files is the array of the paths of files selected by the Application User.
                        mBillPath = files[0];
                        String URL = Utils.UPLOAD_DOC ;
                        HashMap<String,String> hashMap = new HashMap<>();
                        HashMap<String,String> imagesHashMap = new HashMap<>();
                        if(mBillPath!=null){
                            imagesHashMap.put("utilityBill", mBillPath);

                        }
                        new Utils().uploadFile(DocumentActivity.this,URL,hashMap,imagesHashMap,DocumentActivity.this);

                    }
                });
                mBillPickerDialog.show();
            }
        });

        String[] ext = new String[]{".pdf"};
        final DialogProperties properties = new DialogProperties();
        properties.selection_mode = DialogConfigs.SINGLE_MODE;
        properties.selection_type = DialogConfigs.FILE_SELECT;
        properties.root = new File(DialogConfigs.DEFAULT_DIR);
        properties.error_dir = new File(DialogConfigs.DEFAULT_DIR);
        properties.offset = new File(DialogConfigs.DEFAULT_DIR);
        properties.extensions =ext;

        mBankTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBankPickerDialog = new FilePickerDialog(DocumentActivity.this,properties);
                mBankPickerDialog.setTitle("Select a File");
                mBankPickerDialog.setDialogSelectionListener(new DialogSelectionListener() {
                    @Override
                    public void onSelectedFilePaths(String[] files) {
                        //files is the array of the paths of files selected by the Application User.
                        mBankPath = files[0];
                        String URL = Utils.UPLOAD_DOC ;
                        HashMap<String,String> hashMap = new HashMap<>();
                        HashMap<String,String> imagesHashMap = new HashMap<>();
                        if(mBankPath!=null){
                            imagesHashMap.put("bankStatement", mBankPath);

                        }
                        new Utils().uploadFile(DocumentActivity.this,URL,hashMap,imagesHashMap,DocumentActivity.this);

                    }
                });
                mBankPickerDialog.show();
            }
        });

        mBankLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(docResponse.getStatus() && mBankLayout.getTag() != null){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mBankLayout.getTag().toString()));
                    startActivity(browserIntent);
                }
            }
        });
        mIdLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(docResponse.getStatus() && mIdLayout.getTag() != null){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mIdLayout.getTag().toString()));
                    startActivity(browserIntent);
                }
            }
        });

        mLicenceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(docResponse.getStatus() && mLicenceLayout.getTag() != null){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mLicenceLayout.getTag().toString()));
                    startActivity(browserIntent);
                }
            }
        });
        mBillLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(docResponse.getStatus() && mBillLayout.getTag() != null){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mBillLayout.getTag().toString()));
                    startActivity(browserIntent);
                }
            }
        });
    }

    @Override
    public void onSuccess(String method, String response) {

        if(method.equalsIgnoreCase(Utils.GET_USER_DOCS)){
            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();

            docResponse = gson.fromJson(response,
                    GetUserDocResponse.class);

            if(docResponse.getStatus() && docResponse.getData().size() > 0){

                for(int i=0;i<docResponse.getData().size();i++){

                    if(docResponse.getData().get(i).getName().equalsIgnoreCase("Goverment Id")){
                        mIdLayout.setTag(docResponse.getData().get(i).getDocument());
                        if(!docResponse.getData().get(i).getIsEditable()){
                            mIdEditTextView.setEnabled(false);
                            mIdEditTextView.setAlpha(0.5f);
                        }

                    }else if(docResponse.getData().get(i).getName().equalsIgnoreCase("Internatinal Passport Or Driving License")){
                        mLicenceLayout.setTag(docResponse.getData().get(i).getDocument());
                        if(!docResponse.getData().get(i).getIsEditable()){
                            mLicenseTextView.setEnabled(false);
                            mLicenseTextView.setAlpha(0.5f);

                        }
                    }else if(docResponse.getData().get(i).getName().equalsIgnoreCase("Utility Bill")){
                        mBillLayout.setTag(docResponse.getData().get(i).getDocument());
                        if(!docResponse.getData().get(i).getIsEditable()){
                            mBillTextView.setEnabled(false);
                            mBillTextView.setAlpha(0.5f);

                        }
                    }else if(docResponse.getData().get(i).getName().equalsIgnoreCase("Bank Statement")){
                        mBankLayout.setTag(docResponse.getData().get(i).getDocument());
                        if(!docResponse.getData().get(i).getIsEditable()){
                            mBankTextView.setEnabled(false);
                            mBankTextView.setAlpha(0.5f);

                        }
                    }

                }
            }
        }else {
            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();

            EditDocResponse docResponse = gson.fromJson(response,
                    EditDocResponse.class);

            if(docResponse.getStatus()){
                new Utils().showErrorDialog(DocumentActivity.this,"File Uploaded Sucessfully");
                new Utils().callGetApiWithHeader(DocumentActivity.this,Utils.GET_USER_DOCS,this,true);

            }

        }


    }

    @Override
    public void onError(String response) {

    }
}
