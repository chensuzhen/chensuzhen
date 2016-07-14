package com.example.administrator.mylive;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/12.
 */
public class DrawerFragment extends Fragment{
    private ListView drawerlistview;
    private List<Drawerlist> list_menu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drawerlistview,container,false);
        initleftmenu(view);
        return view;
    }
    private void initleftmenu(View view) {
        drawerlistview = (ListView)view.findViewById(R.id.drawerlistview);
        list_menu = getMenuItem();
        drawerlistview.setAdapter(new DrawerlistAdapter(getActivity(),list_menu));
        drawerlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private List<Drawerlist> getMenuItem()
    {
        List<Drawerlist> list_menu = new ArrayList<Drawerlist>();

        String[] itemTitle = getResources().getStringArray(R.array.item_title);
        TypedArray itemIconRes = getResources().obtainTypedArray(R.array.item_icon_res);

        for(int i=0;i<itemTitle.length;i++)
        {

            Drawerlist dlist = new Drawerlist();
            dlist.setMainDrawer_icon(itemIconRes.getResourceId(i,0));
            dlist.setMainDrawer_menuName(itemTitle[i]);
            list_menu.add(dlist);
        }

        return list_menu;
    }

}
