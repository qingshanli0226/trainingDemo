package com.example.player.a1610aplayerdemo.presenter;

import android.content.Context;
import com.example.player.a1610aplayerdemo.Server.AllServer;
import com.example.player.a1610aplayerdemo.common.HomeBean;
import com.example.player.a1610aplayerdemo.util.RetrofitHelper;
import com.example.player.a1610aplayerdemo.view.CourseView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CoursePresenter implements ICoursepresenter{
private  CourseView mCourseView ;

    public CoursePresenter(CourseView mCourseView) {
        this.mCourseView = mCourseView;
    }

    @Override
    public void getHomeData(String token, Context mContext) {
        RetrofitHelper helper = RetrofitHelper.getInstance(mContext);
        AllServer service = helper.getService();
        Observable<HomeBean> homeInfo = service.getHomeInfo("BE46DFAA67FE0C41D3A03D5B1E087706");
        homeInfo.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<HomeBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HomeBean homeBean) {
                mCourseView.SuccessCourse(homeBean);

            }

            @Override
            public void onError(Throwable e) {
                mCourseView.FailureCourse(e.toString());
            }

            @Override
            public void onComplete() {

            }
        });

    }
}
