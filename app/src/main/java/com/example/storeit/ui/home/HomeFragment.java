package com.example.storeit.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.storeit.R;
import com.example.storeit.adapters.HomeHorAdapter;
import com.example.storeit.adapters.HomeVerAdapter;
import com.example.storeit.adapters.UpdateVerticalRec;
import com.example.storeit.models.HomeHorModel;
import com.example.storeit.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;


    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container,false);
        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        ////////////////////////////////Horizontal//////////////////////////
        homeHorModelList = new ArrayList<>();
        homeHorModelList.add(new HomeHorModel(R.drawable.mouse_ico,"Mouses"));
        homeHorModelList.add(new HomeHorModel(R.drawable.keyboard_ico,"Keyboards"));
        homeHorModelList.add(new HomeHorModel(R.drawable.headset_ico,"Headsets"));
        homeHorModelList.add(new HomeHorModel(R.drawable.graphics_ico,"Graphics"));
        homeHorModelList.add(new HomeHorModel(R.drawable.ram_ico,"RAM"));
        homeHorModelList.add(new HomeHorModel(R.drawable.storage_ico,"Storage"));
        homeHorModelList.add(new HomeHorModel(R.drawable.phone_ico,"Phones"));
        homeHorModelList.add(new HomeHorModel(R.drawable.monitor_ico,"Monitors"));

        homeHorAdapter = new HomeHorAdapter(this,getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        ////////////////////////////////Vertical//////////////////////////
        homeVerModelList = new ArrayList<>();

        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));


        return root;
    };

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);
    }
}

