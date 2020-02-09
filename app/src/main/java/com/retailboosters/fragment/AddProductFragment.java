package com.retailboosters.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.R;
import com.retailboosters.response.AddProductResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static android.app.Activity.RESULT_OK;
import static com.android.volley.VolleyLog.TAG;

public class AddProductFragment extends Fragment implements OnApiResponse {

    private ImageView mProductImageView;
    private EditText mNameEditText,mPriceEditText,mVatEditText,mDescEditText,mShippingFeeEditText;
    private Bitmap mProductBitmap;
    private String mStoreId;
    private Button mAddButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add_product, container, false);

        mStoreId = getArguments().getString("storeId");

        mProductImageView = (ImageView)rootView.findViewById(R.id.productImageView);

        mNameEditText = (EditText)rootView.findViewById(R.id.pNameEdittext);
        mPriceEditText = (EditText)rootView.findViewById(R.id.priceEdittext);
        mVatEditText = (EditText)rootView.findViewById(R.id.vatEdittext);
        mDescEditText = (EditText)rootView.findViewById(R.id.descEdittext);
        mShippingFeeEditText = (EditText)rootView.findViewById(R.id.shippingFeeEdittext);

        mAddButton= (Button) rootView.findViewById(R.id.addButton);

        mProductImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isReadStoragePermissionGranted();
            }
        });

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickConfirm(v);
            }
        });

        return rootView;

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

            //getting the image Uri
            Uri imageUri = data.getData();
            try {
                //getting bitmap object from uri
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);

                //displaying selected image to imageview
                mProductImageView.setImageBitmap(bitmap);

                //calling the method uploadBitmap to upload image
                mProductBitmap = bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onClickConfirm(View view){
        callApi();
    }

    private void callApi() {

            if(mNameEditText.getText().toString().trim().length() <= 0 || mPriceEditText.getText().toString().trim().length() <= 0
                    || mDescEditText.getText().toString().trim().length() <= 0
                   ){

                Toast.makeText(getActivity(),"Please instert value in all field",Toast.LENGTH_LONG).show();
            }else{
                String URL = Utils.ADD_PRODUCT;
                Map<String, String> params = new HashMap<>();
                params.put("store",mStoreId);
                params.put("productName",mNameEditText.getText().toString());
                params.put("unitprice",  mPriceEditText.getText().toString());
//                params.put("VAT", mVatEditText.getText().toString());
                params.put("description", mDescEditText.getText().toString());
//                params.put("shippingFee", mShippingFeeEditText.getText().toString());


                HashMap<String,Bitmap> imagesHashMap = new HashMap<>();
                if(mProductBitmap!=null){
                    imagesHashMap.put("productImage", mProductBitmap);

                }
                new Utils().uploadImage(getActivity(),URL,params,imagesHashMap,AddProductFragment.this);
            }


    }

    @Override
    public void onSuccess(String method,String response) {
        parseData(response);
    }

    @Override
    public void onError(String response) {

    }

    private void parseData(String resString) {

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        AddProductResponse addProductResponse = gson.fromJson(resString,
                AddProductResponse.class);

        if(addProductResponse.getStatus()){

            Toast.makeText(getActivity(),"Product added successfully",Toast.LENGTH_LONG).show();
            getActivity().onBackPressed();

        }else{
            new Utils().showErrorDialog(getActivity(),"Failed to add product");
        }

    }

    public  boolean isReadStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (getActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 100);
                return true;
            } else {

                Log.v(TAG,"Permission is revoked1");
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, 100);
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.v(TAG,"Permission: "+permissions[0]+ "was "+grantResults[0]);
            //resume tasks needing this permission
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, 100);
        }else{

        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.findItem(R.id.action_search);
        menuItem.setVisible(false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
}