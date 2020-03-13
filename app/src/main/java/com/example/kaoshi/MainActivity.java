package com.example.kaoshi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.example.kaoshi.adapter.MainFragmentAdapter;
import com.example.kaoshi.fragment.CatalogFragment;
import com.example.kaoshi.fragment.HomeFragment;
import com.example.kaoshi.fragment.OwnFragment;
import com.example.kaoshi.fragment.ShoppFragment;
import com.example.kaoshi.fragment.SubjectFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout main_tab;
    private HomeFragment homeFragment;
    private SubjectFragment subjectFragment;
    private CatalogFragment catalogFragment;
    private ShoppFragment shoppFragment;
    private OwnFragment ownFragment;
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> list;
    private ViewPager main_viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVie();
    }

    private void initVie() {
        main_tab = findViewById(R.id.main_tab);
        main_viewpager = findViewById(R.id.main_viewpager);
        homeFragment = new HomeFragment();
        subjectFragment = new SubjectFragment();
        catalogFragment = new CatalogFragment();
        shoppFragment = new ShoppFragment();
        ownFragment = new OwnFragment();
        fragmentManager = getSupportFragmentManager();
        list = new ArrayList<>();
        list.add(homeFragment);
        list.add(subjectFragment);
        list.add(catalogFragment);
        list.add(shoppFragment);
        list.add(ownFragment);
        MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(), list);
        main_viewpager.setAdapter(mainFragmentAdapter);
        main_tab.setupWithViewPager(main_viewpager);
        main_tab.getTabAt(0).setText("首页").setIcon(R.drawable.shouye);
        main_tab.getTabAt(1).setText("专题").setIcon(R.drawable.zhuanti);
        main_tab.getTabAt(2).setText("分类").setIcon(R.drawable.fenlei);
        main_tab.getTabAt(3).setText("购物车").setIcon(R.drawable.gouwuche);
        main_tab.getTabAt(4).setText("我的").setIcon(R.drawable.wode);
        initFragment();
    }

    private void initFragment() {

    }
}
