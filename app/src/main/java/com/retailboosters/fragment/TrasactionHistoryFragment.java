package com.retailboosters.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.retailboosters.R;
import com.retailboosters.adapter.LoanStatusListAdapter;
import com.retailboosters.adapter.TransactionHistoryAdapter;
import com.retailboosters.response.GetOrderHistoryResponse;
import com.retailboosters.response.GetRepaymentHistory;
import com.retailboosters.response.GetUserOrdersResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Utils;

/**
 * Created by anupamchugh on 10/12/15.
 */
public class TrasactionHistoryFragment extends Fragment implements OnApiResponse {

    private ListView mListView;
    TransactionHistoryAdapter listAdapter;
    FragmentManager fragmentManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_transaction_history, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();

        mListView = (ListView)rootView.findViewById(R.id.listview);



        callApi();

        return rootView;
    }
    private void loadFragment(String id) {

        LoanStatusFragment loanStatusFragment = new LoanStatusFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        loanStatusFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, loanStatusFragment,"EmployeeFragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void callApi() {

//        String URL = Utils.GET_ORDER_HISTORY;
        String URL = Utils.GET_REPAYMENT_HISTORY;

        new Utils().callGetApiWithHeader(getActivity(),URL,TrasactionHistoryFragment.this,true);


    }
    @Override
    public void onSuccess(String method,String response) {

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        GetRepaymentHistory repaymentHistory = gson.fromJson(response,
                GetRepaymentHistory.class);

//        GetOrderHistoryResponse getUserOrdersResponse = gson.fromJson(response,
//                GetOrderHistoryResponse.class);


        if(repaymentHistory.getStatus()){

            listAdapter = new TransactionHistoryAdapter(getActivity(), repaymentHistory.getData());
            mListView.setAdapter(listAdapter);

        }

    }

    @Override
    public void onError(String response) {

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
