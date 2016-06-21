package com.example.y.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.y.mvp.R;

import java.util.LinkedList;
import java.util.List;

/**
 * by 12406 on 2016/6/21.
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int IS_ITEM = -1;
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOT = 2;
    private static final int RESOURCE_ERROR = 0x0;

    protected Context context;
    protected LayoutInflater layoutInflater;
    private OnItemClickListener<T> mOnItemClickListener;
    private OnItemLongClickListener<T> mOnLongClickListener;
    private List<T> mDatas = new LinkedList<>();
    private boolean isHead = false;
    private boolean isFoot = false;
    private int headLayout;
    private int footLayout;



    public BaseRecyclerViewAdapter(List<T> mDatas) {
        if (!mDatas.isEmpty()) {
            this.mDatas = mDatas;
        }
    }


    public interface OnItemClickListener<T> {
        void onItemClick(View view, int position, T info);
    }

    public interface OnItemLongClickListener<T> {
        void onLongClick(View view, int position, T info);
    }

    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        this.mOnItemClickListener = listener;
    }

    public void setOnLongClickListener(OnItemLongClickListener<T> listener) {
        this.mOnLongClickListener = listener;
    }

    public int getFootLayout() {
        return footLayout;
    }

    public void setFootLayout(int footLayout) {
        this.footLayout = footLayout;
    }

    public int getHeadLayout() {
        return headLayout;
    }

    public void setHeadLayout(int headLayout) {
        this.headLayout = headLayout;
    }

    public boolean isFoot() {
        return isFoot;
    }

    public void setFoot(boolean foot) {
        this.isFoot = foot;
        notifyDataSetChanged();
    }

    public boolean isHead() {
        return isHead;
    }

    public void setHead(boolean head) {
        this.isHead = head;
        notifyDataSetChanged();
    }

    public void addAll(List<T> datas) {
        mDatas.addAll(datas);
    }

    public void addItemTop(List<T> datas) {
        mDatas = datas;
    }

    public void remove(int position) {
        mDatas.remove(position);
        this.notifyDataSetChanged();
    }

    public void removeAll() {
        if (mDatas.size() != 0) {
            mDatas.clear();
        }
        this.notifyDataSetChanged();
    }


    public List<T> getDatas() {
        return mDatas;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHead && position == 0) {
            return TYPE_HEAD;
        } else if (isFoot && position + 1 == getItemCount()) {
            return TYPE_FOOT;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        int type;
        if (isHead && isFoot) {
            type = 2;
        } else if (isHead || isFoot) {
            if (isHead) {
                IS_ITEM = TYPE_HEAD;
            } else {
                IS_ITEM = TYPE_FOOT;
            }
            type = 1;
        } else {
            IS_ITEM = TYPE_ITEM;
            type = 0;
        }
        return mDatas.size() + type;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        this.context = parent.getContext();
        layoutInflater = LayoutInflater.from(context);

        switch (viewType) {

            case TYPE_HEAD:

                View headView;
                if (headLayout == RESOURCE_ERROR) {
                    headView = layoutInflater.inflate(R.layout.head_error, parent, false);
                } else {
                    headView = layoutInflater.inflate(headLayout, parent, false);
                    getHeadLayoutId(headView);
                }
                return new BaseViewHolder(headView);

            case TYPE_ITEM:
                return new BaseViewHolder(layoutInflater.inflate(getItemLayoutId(), parent, false));
            case TYPE_FOOT:

                View footView;
                if (footLayout == RESOURCE_ERROR) {
                    footView = layoutInflater.inflate(R.layout.foot_error, parent, false);
                } else {
                    footView = layoutInflater.inflate(footLayout, parent, false);
                    getFootLayoutId(footView);
                }
                return new BaseViewHolder(footView);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEAD || getItemViewType(position) == TYPE_FOOT) {
            return;
        }
        final int pos = getItemPosition(holder);
        final T data = mDatas.get(pos);
        if (data == null) {
            return;
        }
        BaseViewHolder baseViewHolder = (BaseViewHolder) holder;
        onBind(baseViewHolder.getViewHolder(),position, data);
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v, pos, data);
                }
            });
        }
        if (mOnLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnLongClickListener.onLongClick(v, pos, data);
                    return true;
                }
            });
        }
    }

    public <T extends View> T getView(View view,int id) {
        return (T) view.findViewById(id);
    }

    protected  void getHeadLayoutId(View headView){
    }

    protected abstract int getItemLayoutId();

    protected  void getFootLayoutId(View footView){
    }

    protected abstract void onBind(ViewHolder holder, int position, T data);

    private int getItemPosition(RecyclerView.ViewHolder holder) {
        int pos = holder.getLayoutPosition();
        if ((isFoot && IS_ITEM == TYPE_FOOT) || ( !isFoot && !isHead && IS_ITEM == TYPE_ITEM)) {
            return pos;
        } else {
            return pos - 1;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (getItemViewType(position) == TYPE_HEAD || getItemViewType(position) == TYPE_FOOT) {
                        return gridManager.getSpanCount();
                    } else {
                        return 1;
                    }
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams stagger = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            if ((isHead && holder.getLayoutPosition() == 0) || (isFoot && holder.getLayoutPosition() + 1 == getItemCount())) {
                stagger.setFullSpan(true);
            } else {
                stagger.setFullSpan(false);
            }
        }
    }


    public class BaseViewHolder extends RecyclerView.ViewHolder {

        private ViewHolder viewHolder;

        public BaseViewHolder(View itemView) {
            super(itemView);
            viewHolder = ViewHolder.getViewHolder(itemView);
        }

        public ViewHolder getViewHolder() {
            return viewHolder;
        }

        public <T extends View> T getView(int id) {
            return (T) itemView.findViewById(id);
        }

        public TextView getTextView(int id) {

            return getView(id);
        }

        public ImageView getImageView(int id) {
            return getView(id);
        }

        public void setTextView(int id, CharSequence charSequence) {
            getTextView(id).setText(charSequence);
        }

    }

    public static class ViewHolder {
        private SparseArray<View> viewHolder;
        private View view;

        private ViewHolder(View view) {
            this.view = view;
            viewHolder = new SparseArray<>();
            view.setTag(viewHolder);
        }

        public <T extends View> T get(int id) {
            View childView = viewHolder.get(id);
            if (childView == null) {
                childView = view.findViewById(id);
                viewHolder.put(id, childView);
            }
            return (T) childView;
        }

        public static ViewHolder getViewHolder(View view) {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            if (viewHolder == null) {
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            }
            return viewHolder;
        }
        public View getConvertView() {
            return view;
        }

        public TextView getTextView(int id) {
            return get(id);
        }

        public ImageView getImageView(int id) {
            return get(id);
        }
        public void setTextView(int id, CharSequence charSequence) {
            getTextView(id).setText(charSequence);
        }
    }
}
