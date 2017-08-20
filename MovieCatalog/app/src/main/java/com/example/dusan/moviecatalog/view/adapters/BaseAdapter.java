package com.example.dusan.moviecatalog.view.adapters;

import android.support.v7.widget.RecyclerView;
import java.util.List;

/**
 * Created by Dusan on 20.Aug.17.
 */

public abstract class BaseAdapter<Type extends RecyclerView.ViewHolder, Data> extends RecyclerView.Adapter<Type>{

  public abstract void setData(List<Data> data);
}
