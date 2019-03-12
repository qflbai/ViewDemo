package com.qflbai.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.line_layout, "line_layout"));
        pageModels.add(new PageModel(R.layout.filpboard_layout, "filpboard_layout"));
        pageModels.add(new PageModel(R.layout.like_layout, "like_layout"));
        pageModels.add(new PageModel(R.layout.ruler_layout, "ruler_layout"));
        pageModels.add(new PageModel(R.layout.move_layout, "move_layout"));
        pageModels.add(new PageModel(R.layout.waveview_layout, "waveview_layout"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.productLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return pageModels.get(position).titleRes;
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private class PageModel {
        @LayoutRes
        int productLayoutRes;
        String titleRes;

        PageModel(@LayoutRes int sampleLayoutRes, String titleRes) {
            this.productLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
        }
    }
}
