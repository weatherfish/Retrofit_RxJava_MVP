package com.example.y.mvp.mvp.presenter;


import android.content.pm.PackageManager;
import android.widget.Toast;

import com.example.y.mvp.ImageDetailInfo;
import com.example.y.mvp.R;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.mvp.model.ImageDetailModelImpl;
import com.example.y.mvp.mvp.model.Model;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class ImageDetailPresenterImpl extends BasePresenterImpl<BaseView.ImageDetailView, ImageDetailInfo>
        implements Presenter.ImageDetailPresenter {

    private final Model.ImageDetailModel imageDetailModel;

    public ImageDetailPresenterImpl(BaseView.ImageDetailView view) {
        super(view);
        this.imageDetailModel = new ImageDetailModelImpl();
    }

    @Override
    public void requestNetWork(int id) {
        imageDetailModel.netWorkDetail(id);
    }

    @Override
    public void competence(int requestCode, int[] grantResults) {
        if (requestCode == Constant.WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            //noinspection StatementWithEmptyBody
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.competence_error), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public int getBundle() {
        return UIUtils.getActivity().getIntent().getExtras().getInt("id");
    }

    @Override
    protected void onNetWorkSuccess(List<ImageDetailInfo> data) {
        view.setData(data);
    }


    @Override
    protected void onNetWorkError() {
        view.netWorkError();
    }
}
