package com.maximumintelligence.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.maximumintelligence.githubclient.R;
import com.maximumintelligence.skeleton.UserSkeleton;

import java.util.List;



public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder>  {

    private List<UserSkeleton> commonInfo;
    private int rowLayout;
    private Context context;

    public Adapter(List<UserSkeleton> commonInfo, int rowLayout, Context context) {
        this.setCommonInfo(commonInfo);
        this.setRowLayout(rowLayout);
        this.setContext(context);
    }

    public List<UserSkeleton> getCommonInfo() {return commonInfo;}

    public void setCommonInfo(List<UserSkeleton> commonInfo) {this.commonInfo = commonInfo;}

    public int getRowLayout() {return rowLayout;}

    public void setRowLayout(int rowLayout) {this.rowLayout = rowLayout;}

    public Context getContext() {return context;}

    public void setContext(Context context) {this.context = context;}

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {
        LinearLayout userInfoLayout;
        TextView userLogin;
        TextView userCompany;
        TextView userLocation;
        TextView userWebsite;
        TextView userTwitter;


        public AdapterViewHolder(View view) {
            super(view);
            userInfoLayout = (LinearLayout) view.findViewById(R.id.list_layout);
            userLogin = (TextView) view.findViewById(R.id.loginTV);
            userCompany = (TextView) view.findViewById(R.id.companyTV);
            userLocation = (TextView) view.findViewById(R.id.locationTV);
            userWebsite = (TextView) view.findViewById(R.id.websiteTV);
            userTwitter = (TextView) view.findViewById(R.id.twitterTV);
        }
    }

    @Override
    public Adapter.AdapterViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new AdapterViewHolder(view);
    }


    @Override
    public void onBindViewHolder(AdapterViewHolder holder, final int position) {
        holder.userLogin.setText("Login: " + commonInfo.get(position).getLogin());
        holder.userCompany.setText("Company: " + commonInfo.get(position).getCompany());
        holder.userLocation.setText("Location: " + commonInfo.get(position).getLocation());
        holder.userWebsite.setText("Website: " + commonInfo.get(position).getWebsite());
        holder.userTwitter.setText("Twitter: " + commonInfo.get(position).getTwitter());
    }

    @Override
    public int getItemCount() { return commonInfo.size();}
}

