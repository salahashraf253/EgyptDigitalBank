package com.example.edb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

private final ArrayList <DataModel> dataSet;

public static class MyViewHolder extends RecyclerView.ViewHolder {

    TextView accountNumText;
    TextView currencyText;
    TextView balanceText;
    ImageView accountIcon;

    public MyViewHolder(View itemView) {
        super(itemView);
        this.accountNumText = itemView.findViewById(R.id.account_num_txt);
        this.currencyText = itemView.findViewById(R.id.currency_txt);
        this.balanceText = itemView.findViewById(R.id.balance_txt);
        this.accountIcon = itemView.findViewById(R.id.account_image);
    }
}

    public CardAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_card, parent, false);
        view.setOnClickListener(MainActivity.myOnClickListener);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView accountNumText = holder.accountNumText;
        TextView balanceText = holder.balanceText;
        ImageView accountIcon = holder.accountIcon;
        accountNumText.setText(dataSet.get(listPosition).getAccountNumber());
        balanceText.setText(String.valueOf(dataSet.get(listPosition).getBalance()));
        accountIcon.setImageResource(R.drawable.ic_mastercard_logo_192);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}