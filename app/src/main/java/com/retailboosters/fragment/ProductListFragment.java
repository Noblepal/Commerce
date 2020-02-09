package com.retailboosters.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.HomeActivity;
import com.retailboosters.R;
import com.retailboosters.SearchListner;
import com.retailboosters.adapter.CustomPagerAdapter;
import com.retailboosters.adapter.ProductListAdapter;
import com.retailboosters.response.GetProductByStoreResponse;
import com.retailboosters.response.GetStoreResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Utils;

import org.json.JSONObject;

import java.util.ArrayList;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

public class ProductListFragment extends Fragment implements OnApiResponse,SearchListner {
    FragmentManager fragmentManager;
    private GridViewWithHeaderAndFooter mProductListView;
    private ProductListAdapter mArrayAdapter;
    GetStoreResponse.Datum store;
    FloatingActionButton fab;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_product_list, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();
        mProductListView = (GridViewWithHeaderAndFooter )rootView.findViewById(R.id.gridview);

        setHasOptionsMenu(false);
        getActivity().setTitle("Products");
        ((HomeActivity)getActivity()).setSearchListner(this);

        if(getArguments() != null) {
            store = (GetStoreResponse.Datum) getArguments().getSerializable("store");
            getStore();
        }


        mProductListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onClickProduct(position);
            }
        });

        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(store != null && store.getId() != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("storeId", store.getId());
                    AddProductFragment fragment = new AddProductFragment();
                    fragment.setArguments(bundle);
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, fragment, "EmployeeFragment");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }else{

                    Toast.makeText(getActivity(),"Please select store",Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(store != null && store.getId() != null) {

        }else{
            fab.hide();
        }


        return rootView;
    }

    @Override
    public void onQuerySearch(String s) {

        searchProduct(s);

    }

    public void onClickProduct(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("product",mArrayAdapter.getItem(position));
        bundle.putSerializable("store",store);

        BuyOnCreditFragment fragment = new BuyOnCreditFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment,"EmployeeFragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
    private void searchProduct(String s) {
        try {
            String url = Utils.FIND_PRODUCT+s;
            Log.e("URL",""+url);
            if(s != null && s.length() > 0) {
                new Utils().callGetApi(getActivity(), url, ProductListFragment.this, false);
            }else{
                mProductListView.setAdapter(null);
            }

        }catch (Exception e){

        }

    }

    private void getStore() {
        try {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("storeId", store.getId());
            new Utils().callApis(getActivity(),Utils.GET_PRODUCT,jsonBody,ProductListFragment.this);


        }catch (Exception e){

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

        GetProductByStoreResponse getProductByStoreResponse = gson.fromJson(resString,
                GetProductByStoreResponse.class);

        if(getProductByStoreResponse.getStatus()){



            /*ArrayList<GetProductByStoreResponse.Datum> featureArrayList = new ArrayList<>();
            ArrayList<GetProductByStoreResponse.Datum> productArrayList = new ArrayList<>();

            for(int i=0;i<getProductByStoreResponse.getData().size();i++){
                if(getProductByStoreResponse.getData().get(i).isFeatured()) {
                    featureArrayList.add(getProductByStoreResponse.getData().get(i));
                    Log.e("Product",""+getProductByStoreResponse.getData().get(i).getProductName());
                }else{
                    productArrayList.add(getProductByStoreResponse.getData().get(i));
                }

            }


            View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.product_list_header,null,false);
            ViewPager viewPager = (ViewPager)headerView.findViewById(R.id.viewpager);
            viewPager.setAdapter(new CustomPagerAdapter(getActivity(),featureArrayList));
            mProductListView.addHeaderView(headerView);*/


            mArrayAdapter = new ProductListAdapter(getActivity(),getProductByStoreResponse.getData());
            mProductListView.setAdapter(mArrayAdapter);


        }else{
            new Utils().showErrorDialog(getActivity(),"Failed to load stores");
        }

    }

}
