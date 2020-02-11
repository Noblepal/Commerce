package com.retailboosters.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.R;
import com.retailboosters.adapter.ProductListRecyclerViewAdapter;
import com.retailboosters.adapter.StoreListAdapter;
import com.retailboosters.adapter.StoreListRecyclerViewAdapter;
import com.retailboosters.response.GetProductByStoreResponse;
import com.retailboosters.response.GetStoreResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Utils;

public class StoreListFragment extends Fragment implements OnApiResponse {
    FragmentManager fragmentManager;
    //private ListView mStoreListView;
    private StoreListAdapter mArrayAdapter;
    RecyclerView productsRecyclerView, storesRecyclerView;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.product_list_header, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();

        productsRecyclerView = rootView.findViewById(R.id.recyclerViewProducts);
        storesRecyclerView = rootView.findViewById(R.id.recyclerViewStores);
        LinearLayoutManager pManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager sManager = new GridLayoutManager(getActivity(), 2);

        productsRecyclerView.setLayoutManager(pManager);
        storesRecyclerView.setLayoutManager(sManager);

        getActivity().setTitle("Stores");

        getStore();

        getFeatureProduct();

        return rootView;
    }


    public void onListClick(GetStoreResponse.Datum store) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("store", store);
        ProductListFragment fragment = new ProductListFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment, "EmployeeFragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    private void getStore() {
        String URL = Utils.GET_STORE;

        new Utils().callGetApi(getActivity(), URL, StoreListFragment.this, true);


    }

    private void getFeatureProduct() {
        String URL = Utils.GET_FEATURE_PRODUCT;

        new Utils().callGetApi(getActivity(), URL, StoreListFragment.this, true);

    }

    @Override
    public void onSuccess(String url, String response) {
        if (getActivity() != null) {
            if (url.equalsIgnoreCase(Utils.GET_FEATURE_PRODUCT)) {

                GsonBuilder gsonb = new GsonBuilder();
                Gson gson = gsonb.create();

                GetProductByStoreResponse getProductByStoreResponse = gson.fromJson(response,
                        GetProductByStoreResponse.class);

                if (getProductByStoreResponse.getData().size() > 0) {
                    parseProductsData(response);
                    //View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.product_list_header, null, false);
                    //viewPager = (ViewPager) headerView.findViewById(R.id.viewpager);
                    //viewPager.setAdapter(new CustomPagerAdapter(getActivity(), getProductByStoreResponse.getData(), StoreListFragment.this));
                    //mStoreListView.addHeaderView(headerView);


                    //updateTimer();
                }

            } else {
                parseStoresData(response);
            }
        }
    }

    public void onClickProduct(GetProductByStoreResponse.Datum product) {
        Bundle bundle = new Bundle();

        /*for (int i = 0; i < mArrayAdapter.getCount(); i++) {
            if (mArrayAdapter.getItem(i).getId().equals(id)) {
                bundle.putSerializable("store", mArrayAdapter.getItem(i));
                return;

            }
        }*/
        bundle.putSerializable("product", product);

        BuyOnCreditFragment fragment = new BuyOnCreditFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment, "EmployeeFragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    Runnable runnable;
    Handler handler = new Handler();

    private void updateTimer() {
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        runnable = new Runnable() {
            @Override
            public void run() {

                if (viewPager != null && viewPager.getCurrentItem() < viewPager.getAdapter().getCount() - 1) {
                    int index = viewPager.getCurrentItem();
                    viewPager.setCurrentItem(index + 1);
                } else {
                    viewPager.setCurrentItem(0);
                }
                updateTimer();
            }
        };
        handler.postDelayed(runnable, 3000);
    }

    @Override
    public void onError(String response) {

    }

    private void parseStoresData(String resString) {

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        GetStoreResponse getStoreResponse = gson.fromJson(resString,
                GetStoreResponse.class);


        if (getStoreResponse.getStatus() && getActivity() != null) {

            storesRecyclerView.setAdapter(new StoreListRecyclerViewAdapter(getActivity(),
                    getStoreResponse.getData(), StoreListFragment.this));
            //mArrayAdapter = new StoreListAdapter(getActivity(), getStoreResponse.getData(), StoreListFragment.this);
            //mStoreListView.setAdapter(mArrayAdapter);

        } else {
            if (getActivity() != null) {
                new Utils().showErrorDialog(getActivity(), "Failed to load stores");
            }
        }

    }

    private void parseProductsData(String resString) {

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        GetProductByStoreResponse getStoreResponse = gson.fromJson(resString,
                GetProductByStoreResponse.class);


        if (getStoreResponse.getStatus() && getActivity() != null) {

            productsRecyclerView.setAdapter(new ProductListRecyclerViewAdapter(getActivity(),
                    getStoreResponse.getData(), StoreListFragment.this));
            //mArrayAdapter = new StoreListAdapter(getActivity(), getStoreResponse.getData(), StoreListFragment.this);
            //mStoreListView.setAdapter(mArrayAdapter);

        } else {
            if (getActivity() != null) {
                new Utils().showErrorDialog(getActivity(), "Failed to load products");
            }
        }

    }

}
