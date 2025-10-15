package com.example.carphone;
import android.view.*; import android.widget.*; import androidx.annotation.*; import androidx.recyclerview.widget.RecyclerView; import java.util.*;
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.VH>{
    private final List<Car> data; public CarAdapter(List<Car> d){data=d;}
    @NonNull @Override public VH onCreateViewHolder(@NonNull ViewGroup p,int v){
        View view=LayoutInflater.from(p.getContext()).inflate(android.R.layout.simple_list_item_2,p,false); return new VH(view);
    }
    @Override public void onBindViewHolder(@NonNull VH h,int i){ Car x=data.get(i); h.text1.setText(x.brand); h.text2.setText(x.model); }
    @Override public int getItemCount(){ return data.size(); }
    static class VH extends RecyclerView.ViewHolder{ TextView text1,text2; VH(@NonNull View v){ super(v); text1=v.findViewById(android.R.id.text1); text2=v.findViewById(android.R.id.text2);}}
}
