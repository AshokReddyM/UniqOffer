package com.marapps.uniqoffer.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.marapps.uniqoffer.R;
import com.marapps.uniqoffer.ui.base.BaseActivity;
import com.marapps.uniqoffer.ui.compare.CompareFragment;
import com.marapps.uniqoffer.ui.home.HomeFragment;
import com.marapps.uniqoffer.ui.offers.OffersFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    private static final String EXTRA_TRIGGER_SYNC_FLAG = "ui.main.MainActivity.EXTRA_TRIGGER_SYNC_FLAG";

    @BindView(R.id.drawer_layout)
    public DrawerLayout mDrawerLayout;

    @BindView(R.id.navigation)
    public NavigationView navigationView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.bottomBar)
    BottomBar bottomBar;

    @BindView(R.id.left_drawer)
    ListView mDrawerList;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    ActionBarDrawerToggle mDrawerToggle;


    private String[] mNavigationDrawerItemTitles;


    @Inject
    MainPresenter mMainPresenter;

    public static Intent getStartIntent(Context context, boolean triggerDataSyncOnCreate) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_TRIGGER_SYNC_FLAG, triggerDataSyncOnCreate);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);


        setupToolbar();

        DataModel[] drawerItem = new DataModel[9];

        drawerItem[0] = new DataModel(R.drawable.ic_chat_bubble, "Offer of the day");
        drawerItem[1] = new DataModel(R.drawable.ic_chat_bubble, "Categories");
        drawerItem[2] = new DataModel(R.drawable.ic_chat_bubble, "Saved");
        drawerItem[3] = new DataModel(R.drawable.ic_chat_bubble, "Notifications");
        drawerItem[4] = new DataModel(R.drawable.ic_chat_bubble, "Settings");
        drawerItem[5] = new DataModel(R.drawable.ic_chat_bubble, "Share the App");
        drawerItem[6] = new DataModel(R.drawable.ic_chat_bubble, "Rate the App");
        drawerItem[7] = new DataModel(R.drawable.ic_chat_bubble, "Feedback");
        drawerItem[8] = new DataModel(R.drawable.ic_chat_bubble, "Help & Support");

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();

        selectItem(0);

        bottomBar.selectTabAtPosition(0);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        updateFragment(new HomeFragment());
                        break;
                    case R.id.tab_offers:
                        updateFragment(new OffersFragment());
                        break;
                    case R.id.tab_compare:
                        updateFragment(new CompareFragment());
                        break;
                }
            }
        });
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
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;

            case 7:
                break;

            case 8:
                break;


            default:
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                break;
        }

    }


    public void updateFragment(Fragment fragment) {

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }

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
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
    }


}





