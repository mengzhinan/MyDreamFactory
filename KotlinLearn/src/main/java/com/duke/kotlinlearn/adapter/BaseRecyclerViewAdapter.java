package com.duke.kotlinlearn.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-10-31 18:05
 * description:
 */
public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder> {

    private final ArrayMap<Integer, ViewType> mViewTypeArrayMap = new ArrayMap<>();
    private final List<RecyclerItem> mItems = new ArrayList<>();
    private AdapterListener mAdapterListener;
    private OnRecyclerItemClickListener mItemOnClickListener;
    private OnRecyclerItemLongClickListener mItemLongClickListener;

    public BaseRecyclerViewAdapter() {
        super();
        final List<ViewType> viewTypes = this.onCreateViewTypes();
        for (final ViewType viewType : viewTypes) {
            this.mViewTypeArrayMap.put(viewType.getTypeId(), viewType);
        }
    }

    public void setItemOnClickListener(OnRecyclerItemClickListener itemOnClickListener) {
        mItemOnClickListener = itemOnClickListener;
    }

    public void setItemLongClickListener(OnRecyclerItemLongClickListener itemLongClickListener) {
        mItemLongClickListener = itemLongClickListener;
    }

    public int getPositionByData(Object data) {
        for (RecyclerItem item : mItems) {
            if (item.getData() == data) {
                return mItems.indexOf(item);
            }
        }
        return -1;
    }

    public void setRecyclerItem(final int position, final RecyclerItem recyclerItem) {
        this.mItems.set(position, recyclerItem);
        this.notifyItemChanged(position);
    }

    public void addRecyclerItem(final int position, final RecyclerItem recyclerItems) {
        this.mItems.add(position, recyclerItems);
        this.notifyItemInserted(position);
    }

    public void addRecyclerItem(final RecyclerItem... recyclerItems) {
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

    public RecyclerItem getRecyclerItem(final int position) {
        if (position < 0 || position >= mItems.size()) {
            return null;
        }
        return this.mItems.get(position);
    }

    public List<RecyclerItem> getRecyclerItems() {
        return this.mItems;
    }

    public void changeRecyclerItem(final RecyclerItem recyclerItem, final int position) {
        this.mItems.set(position, recyclerItem);
        this.notifyItemChanged(position);
    }

    public void removeData(Object data) {
        for (RecyclerItem item : mItems) {
            if (item.getData() == data) {
                removeRecyclerItem(item);
                break;
            }
        }
    }

    public void removeRecyclerItem(final int position) {
        this.mItems.remove(position);
        this.notifyItemRemoved(position);
    }

    public void removeRecyclerItem(final RecyclerItem recyclerItem) {
        final int index = this.mItems.indexOf(recyclerItem);
        this.removeRecyclerItem(index);
    }

    public void removeRecyclerItem(final int position, final int count) {
        this.mItems.subList(position, position + count).clear();
        this.notifyItemRangeRemoved(position, count);
    }

    // 这个方法只供 BaseAdvancePagingFragment 及其子类在数据第一次刷新的时候用，当页面有头部的时候，
    // 如果用 RecyclerView.Adapter#notifyItemRangeRemoved() 更新数据会导致闪屏；
    // (fromIndex < 0 || toIndex > size) -> IndexOutOfBoundsException
    // (fromIndex > toIndex) -> IllegalArgumentException
    // https://developer.android.com/reference/java/util/AbstractList.html#subList(int, int)
    public void removeListItemsFrom(final int position) {
        if (position > getItemCount()) {
            return;
        }
        this.mItems.subList(position, getItemCount()).clear();
        this.notifyDataSetChanged();
    }

    public void clearAllRecyclerItem() {
        this.mItems.clear();
        this.notifyDataSetChanged();
    }

    // 判断是否包含指定的 ViewType
    public boolean containViewType(final int typeId) {
        return mViewTypeArrayMap != null && mViewTypeArrayMap.containsKey(typeId);
    }

    protected abstract List<ViewType> onCreateViewTypes();

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parentView, final int type) {
        final ViewType viewType = this.mViewTypeArrayMap.get(type);
        if (viewType != null) {
            final Class<? extends ViewHolder> viewHolderClass = viewType.getViewHolderClass();
            final View view = LayoutInflater.from(parentView.getContext()).inflate(viewType.getLayoutResourceId(),
                    parentView, false);
            try {
                final ViewHolder viewHolder = viewHolderClass.getDeclaredConstructor(View.class).newInstance(view);
                if (this.mAdapterListener != null) {
                    this.mAdapterListener.onCreate(viewHolder);
                }
                if (mItemOnClickListener != null) {
                    viewHolder.setOnClickListener(this.mItemOnClickListener);
                }
                if (mItemLongClickListener != null) {
                    viewHolder.setOnLongClickListener(this.mItemLongClickListener);
                }
                viewHolder.setAdapter(this);
                return viewHolder;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator<Map.Entry<Integer, ViewType>> iterator = mViewTypeArrayMap.entrySet().iterator();
            while (iterator.hasNext()) {
                stringBuilder.append(iterator.next().getValue().getViewHolderClass().getSimpleName()).append(" ");
            }
            throw new IllegalStateException(getClass().getName() +
                    " missed some ViewHolder, owned ViewHolders: " + stringBuilder.toString());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onPreBind(holder, position);
        }
        holder.onBindData(this.mItems.get(position).getData()); // set videourl
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onBind(holder, position); //add to list may play
        }
    }

    // TODO 因为 Holder 里 onBindData 的修饰符为 protected，导致子类无法直接访问
    protected void internalBindDataToHolder(final ViewHolder holder, RecyclerItem item) {
        holder.onBindData(item.getData());
    }

    @Override
    public void onViewRecycled(final ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        viewHolder.onUnbind(); //release
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onUnbind(viewHolder); //remove from list
        }
    }

    @Override
    public int getItemViewType(final int position) {
        return this.mItems.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }

    @Override
    public void onViewAttachedToWindow(final ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        viewHolder.onAttachedToWindow();
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onAttachedToWindow(viewHolder);
        }
    }

    @Override
    public void onViewDetachedFromWindow(final ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        viewHolder.onDetachedFromWindow();
        if (this.mAdapterListener != null) {
            this.mAdapterListener.onDetachedFromWindow(viewHolder);
        }
    }

    public void setAdapterListener(final AdapterListener adapterListener) {
        this.mAdapterListener = adapterListener;
    }

    public static class ViewType {

        private final int mTypeId;
        private final int mLayoutResourceId;
        private final Class<? extends ViewHolder> mViewHolderClass;

        public ViewType(final int typeId,
                        @LayoutRes final int layoutResourceId,
                        final Class<? extends ViewHolder>
                                viewHolderClass) {
            this.mTypeId = typeId;
            this.mLayoutResourceId = layoutResourceId;
            this.mViewHolderClass = viewHolderClass;
        }

        public int getTypeId() {
            return this.mTypeId;
        }

        public int getLayoutResourceId() {
            return this.mLayoutResourceId;
        }

        public Class<? extends ViewHolder> getViewHolderClass() {
            return this.mViewHolderClass;
        }
    }

    public static class RecyclerItem<T> {

        private final int mViewType;
        private T mData;

        public RecyclerItem(final int viewType, final T data) {
            this.mViewType = viewType;
            this.mData = data;
        }

        public int getViewType() {
            return this.mViewType;
        }

        public T getData() {
            return this.mData;
        }

        public void setData(final T data) {
            this.mData = data;
        }
    }

    public static class ViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected BaseRecyclerViewAdapter mAdapter;
        protected OnRecyclerItemClickListener<T> mOnRecyclerItemClickListener;
        protected OnRecyclerItemLongClickListener<T> mOnRecyclerItemLongClickListener;
        protected T data;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
        }

        protected void setAdapter(final BaseRecyclerViewAdapter adapter) {
            this.mAdapter = adapter;
        }

        protected void onBindData(final T data) {
            this.data = data;
        }

        protected void onUnbind() {
            this.data = null;
        }

        public void setOnClickListener(OnRecyclerItemClickListener<T> onClickListener) {
            this.mOnRecyclerItemClickListener = onClickListener;
        }

        public void setOnLongClickListener(OnRecyclerItemLongClickListener<T> onLongClickListener) {
            this.mOnRecyclerItemLongClickListener = onLongClickListener;
        }

        public void onAttachedToWindow() {
        }

        public void onDetachedFromWindow() {
        }

        protected Resources getResources() {
            return this.itemView.getResources();
        }

        @Override
        public void onClick(final View view) {
            if (mOnRecyclerItemClickListener != null) {
                mOnRecyclerItemClickListener.onClick(view, this);
            }
        }

        public T getData() {
            return this.data;
        }

        public Context getContext() {
            return itemView.getContext();
        }
    }

    public interface OnRecyclerItemClickListener<T> {
        void onClick(View view, ViewHolder<T> viewHolder);
    }

    public interface OnRecyclerItemLongClickListener<T> {
        void onLongClick(View view, ViewHolder<T> viewHolder);
    }

    @SuppressWarnings("UnusedParameters")
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