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
import com.retailboosters.adapter.RepaymentListAdapter;
import com.retailboosters.adapter.TransactionHistoryAdapter;
import com.retailboosters.response.GetOrderHistoryResponse;
import com.retailboosters.response.GetUserOrdersResponse;
import com.retailboosters.utils.OnApiResponse;
import com.retailboosters.utils.Utils;

import java.util.List;

/**
 * Created by anupamchugh on 10/12/15.
 */
public class LoanStatusListFragment extends Fragment implements OnApiResponse {

    private ListView mListView;
    LoanStatusListAdapter listAdapter;
    FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_loan_status_list, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();

        mListView = (ListView) rootView.findViewById(R.id.listview);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                loadFragment(listAdapter.getItem(position).getOrderId());
            }
        });

        callApi();

        return rootView;
    }

    private void loadFragment(String id) {

        LoanStatusFragment loanStatusFragment = new LoanStatusFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        loanStatusFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, loanStatusFragment, "EmployeeFragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void callApi() {

//        String URL = Utils.GET_ALL_USERS;
        String URL = Utils.GET_ORDER_HISTORY;

        new Utils().callGetApiWithHeader(getActivity(), URL, LoanStatusListFragment.this, true);


    }

    @Override
    public void onSuccess(String method, String response) {

        if (getActivity() != null) {
            GsonBuilder gsonb = new GsonBuilder();
            Gson gson = gsonb.create();

           /* GetUserOrdersResponse getUserOrdersResponse = gson.fromJson(response,
                    GetUserOrdersResponse.class);

            if (getUserOrdersResponse.getStatus()) {


                listAdapter = new LoanStatusListAdapter(getActivity(), getUserOrdersResponse.getData());
                mListView.setAdapter(listAdapter);

            }*/

            GetOrderHistoryResponse getUserOrdersResponse = gson.fromJson(response,
                    GetOrderHistoryResponse.class);

            if (getUserOrdersResponse.getStatus()) {

                listAdapter = new LoanStatusListAdapter(getActivity(), getUserOrdersResponse.getData());
                mListView.setAdapter(listAdapter);


            }
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
