package com.retailboosters;


import com.retailboosters.fragment.AccountFragment;
import com.retailboosters.fragment.BuyOnCreditFragment;
import com.retailboosters.fragment.BuyProductPaymentFragment;
import com.retailboosters.fragment.ConnectFragment;
import com.retailboosters.fragment.DataModel;
import com.retailboosters.fragment.DrawerItemCustomAdapter;
import com.retailboosters.fragment.LoanStatusFragment;
import com.retailboosters.fragment.LoanStatusListFragment;
import com.retailboosters.fragment.PaymentFragment;
import com.retailboosters.fragment.ProductListFragment;
import com.retailboosters.fragment.RepaymentFragment;
import com.retailboosters.fragment.StoreListFragment;
import com.retailboosters.fragment.TrasactionHistoryFragment;
import com.retailboosters.utils.Pref;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity {

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private RelativeLayout listLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    FragmentManager fragmentManager;
    SearchListner searchListner;
    MenuItem myActionMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        listLayout = (RelativeLayout) findViewById(R.id.listLayout);

        setupToolbar();


        DataModel[] drawerItem = new DataModel[4];

        drawerItem[0] = new DataModel(R.drawable.ic_launcher, "Buy On Credit");
        drawerItem[1] = new DataModel(R.drawable.ic_launcher, "Loan History");
        drawerItem[2] = new DataModel(R.drawable.ic_launcher, "Repayment Schedule");
        drawerItem[3] = new DataModel(R.drawable.ic_launcher, "Transaction History");
//        drawerItem[4] = new DataModel(R.drawable.ic_launcher, "Payment");
//        drawerItem[4] = new DataModel(R.drawable.ic_launcher, "Logout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);


        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        TextView accountTextView = (TextView) findViewById(R.id.textViewName);
        accountTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                AccountFragment fragment = new AccountFragment();
                fragmentManager = getSupportFragmentManager();

                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

//            mDrawerList.setItemChecked(position, true);
//            mDrawerList.setSelection(position);
                setTitle("Account");

                mDrawerLayout.closeDrawer(listLayout);
            }
        });
        setupDrawerToggle();

        mDrawerToggle.setToolbarNavigationClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        if (getIntent() != null) {
            int id = getIntent().getIntExtra("id", 0);
            if (id != 4) {
                selectItem(id);
            } else {
                accountTextView.performClick();
            }
        } else {
            selectItem(0);
        }

    }

    public void setSearchListner(SearchListner listner) {
        searchListner = listner;
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new StoreListFragment();
//                fragment = new BuyProductPaymentFragment();
                break;
            case 1:
                fragment = new LoanStatusListFragment();
                break;
            case 2:
                fragment = new RepaymentFragment();
                break;
            case 3:
                fragment = new TrasactionHistoryFragment();
                break;
            case 4:
                Pref.saveIntPref(HomeActivity.this, Pref.REGISTRATION_STEP, -1);
                Pref.saveStringPref(HomeActivity.this, Pref.STEP_1_RESPONSE, null);
                Pref.saveStringPref(HomeActivity.this, Pref.STEP_2_RESPONSE, null);
                Pref.saveStringPref(HomeActivity.this, Pref.STEP_3_RESPONSE, null);
                Pref.saveStringPref(HomeActivity.this, Pref.STEP_4_RESPONSE, null);


                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }

        if (fragment != null) {
            fragmentManager = getSupportFragmentManager();

            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

//            mDrawerList.setItemChecked(position, true);
//            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);

            mDrawerLayout.closeDrawer(listLayout);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.content_frame);
        fragment.onActivityResult(requestCode, resultCode, data);
    }

    public void onSearchClick() {

        ProductListFragment fragment = new ProductListFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment, "EmployeeFragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnSearchClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Search", "click");
                onSearchClick();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Toast like print
                myActionMenuItem.collapseActionView();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // UserFeedback.show( "SearchOnQueryTextChanged: " + s);
                if (searchListner != null) {
                    searchListner.onQuerySearch(s);
                }
//                Log.e("Search",""+s);

                return false;
            }
        });


        return true;
    }

    public void closeSearch() {
        myActionMenuItem.collapseActionView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;

        getSupportActionBar().setTitle(mTitle);

//       

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        toolbar.setNavigationIcon(R.drawable.option_icon);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle() {
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
//        mDrawerToggle.setDrawerIndicatorEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.option_icon);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
        mDrawerToggle.syncState();
    }

}
