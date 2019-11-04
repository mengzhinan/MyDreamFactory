package com.duke.kotlinlearn.recyclerView.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import java8.util.Optional;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-10-31 18:05
 * description:
 */
public abstract class BaseNewAdapter extends RecyclerView.Adapter<BaseNewAdapter.ViewHolder> {

    private final ArrayMap<Integer, ViewType> mViewTypeArrayMap;
    private final List<RecyclerItem> mItems = new ArrayList<>();
    private AdapterListener mAdapterListener;

    public BaseNewAdapter() {
        this.mViewTypeArrayMap = Optional.ofNullable(this.onCreateViewTypes()).orElseGet(ArrayMap::new);
    }

    public void setAdapterListener(final AdapterListener adapterListener) {
        this.mAdapterListener = adapterListener;
    }

    public List<RecyclerItem> getRecyclerItems() {
        return this.mItems;
    }

    public int getPositionByData(final Object data) {
        for (RecyclerItem item : mItems) {
            if (item.getData() == data) {
                return mItems.indexOf(item);
            }
        }
        return -1;
    }

    public RecyclerItem getRecyclerItem(final int position) {
        if (position < 0 || position >= mItems.size()) {
            return null;
        }
        return this.mItems.get(position);
    }

    public void setRecyclerItem(final int position, final RecyclerItem recyclerItem) {
        this.mItems.set(position, recyclerItem);
        this.notifyItemChanged(position);
    }

    public void addRecyclerItem(final int position, final RecyclerItem recyclerItem) {
        this.mItems.add(position, recyclerItem);
        this.notifyItemInserted(position);
    }

    public void addRecyclerItems(final RecyclerItem... recyclerItems) {
        final int oldItemCount = this.getItemCount();
        Collections.addAll(this.mItems, recyclerItems);
        this.notifyItemRangeInserted(oldItemCount, recyclerItems.length);
    }

    public void addRecyclerItemList(final List<RecyclerItem> recyclerItemList) {
        final int oldItemCount = this.getItemCount();
        this.mItems.addAll(recyclerItemList);
        this.notifyItemRangeInserted(oldItemCount, recyclerItemList.size());
    }

    public void addRecyclerItemList(final int position, final List<RecyclerItem> recyclerItemList) {
        this.mItems.addAll(position, recyclerItemList);
        this.notifyItemRangeInserted(position, recyclerItemList.size());
    }

    public void removeRecyclerItem(final int position) {
        this.mItems.remove(position);
        this.notifyItemRemoved(position);
    }

    public void removeRecyclerItem(final RecyclerItem recyclerItem) {
        final int index = this.mItems.indexOf(recyclerItem);
        this.removeRecyclerItem(index);
    }

    public void removeData(final Object data) {
        int position = this.getPositionByData(data);
        if (position <= -1) {
            return;
        }
        this.removeRecyclerItem(position);
    }

    public void removeRecyclerItems(final int position, final int count) {
        this.mItems.subList(position, position + count).clear();
        this.notifyItemRangeRemoved(position, count);
    }

    public void removeListItemsFrom(final int position) {
        this.removeRecyclerItems(position, getItemCount());
    }

    public void clearAllRecyclerItems() {
        this.mItems.clear();
        this.notifyDataSetChanged();
    }

    protected abstract ArrayMap<Integer, ViewType> onCreateViewTypes();

    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parentView, final int viewTypeInt) {
        final ViewType viewTypeObject = this.mViewTypeArrayMap.get(viewTypeInt);
        if (viewTypeObject != null) {
            final Class<? extends ViewHolder> viewHolderClass = viewTypeObject.getViewHolderClass();
            final View view = LayoutInflater.from(parentView.getContext()).inflate(
                    viewTypeObject.getLayoutResourceId(),
                    parentView,
                    false);
            try {
                final ViewHolder viewHolder = viewHolderClass.getDeclaredConstructor(View.class).newInstance(view);
                if (this.mAdapterListener != null) {
                    this.mAdapterListener.onCreate(viewHolder);
                }
                return viewHolder;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } else {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                for (Map.Entry<Integer, ViewType> integerViewTypeEntry : mViewTypeArrayMap.entrySet()) {
                    stringBuilder.append(integerViewTypeEntry.getValue().getViewHolderClass().getSimpleName()).append(" ");
                }
                throw new IllegalStateException(getClass().getName() +
                        " missed some ViewHolder, owned ViewHolders: " + stringBuilder.toString());
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @Override
    public void onBindViewHolder(@NotNull final ViewHolder holder, final int position) {
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onPreBind(holder, position);
        }

        holder.onBindData(Optional.ofNullable(this.mItems)
                .map(list -> list.get(position))
                .map(RecyclerItem::getData)
                .orElseGet(null));

        if (this.mAdapterListener != null) {
            this.mAdapterListener.onBind(holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return this.mItems.get(position).getViewTypeInt();
    }

    @Override
    public void onViewRecycled(@NotNull final ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        viewHolder.onUnbind();
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onUnbind(viewHolder);
        }
    }

    @Override
    public void onViewAttachedToWindow(@NotNull final ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        viewHolder.onAttachedToWindow();
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onAttachedToWindow(viewHolder);
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NotNull final ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        viewHolder.onDetachedFromWindow();
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onDetachedFromWindow(viewHolder);
        }
    }

    //================================
    //================================
    //================================

    public static class ViewType {
        private final int mLayoutResourceId;
        private final Class<? extends ViewHolder> mViewHolderClass;

        public ViewType(@LayoutRes final int layoutResourceId,
                        final Class<? extends ViewHolder> viewHolderClass) {
            this.mLayoutResourceId = layoutResourceId;
            this.mViewHolderClass = viewHolderClass;
        }

        public int getLayoutResourceId() {
            return this.mLayoutResourceId;
        }

        public Class<? extends ViewHolder> getViewHolderClass() {
            return this.mViewHolderClass;
        }
    }

    public static class RecyclerItem<T> {
        private final int mViewTypeInt;
        private T mData;

        public RecyclerItem(final int viewTypeInt, final T data) {
            this.mViewTypeInt = viewTypeInt;
            this.mData = data;
        }

        public int getViewTypeInt() {
            return this.mViewTypeInt;
        }

        public T getData() {
            return this.mData;
        }

        public void setData(final T data) {
            this.mData = data;
        }
    }

    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
        protected T data;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
        }

        public abstract void onBindData(final T data);

        public void onUnbind() {
            this.data = null;
        }

        public void onAttachedToWindow() {
        }

        public void onDetachedFromWindow() {
        }

        public T getData() {
            return this.data;
        }

        public Resources getResources() {
            return itemView.getResources();
        }

        public Context getContext() {
            return itemView.getContext();
        }
    }

    public static class AdapterListener {
        public void onCreate(final ViewHolder viewHolder) {
        }

        public void onPreBind(final ViewHolder viewHolder, int position) {
        }

        public void onBind(final ViewHolder viewHolder, int position) {
        }

        public void onUnbind(final ViewHolder viewHolder) {
        }

        public void onAttachedToWindow(final ViewHolder viewHolder) {
        }

        public void onDetachedFromWindow(final ViewHolder viewHolder) {
        }
    }
}