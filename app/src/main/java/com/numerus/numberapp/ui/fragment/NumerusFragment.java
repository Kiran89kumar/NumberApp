package com.numerus.numberapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.numerus.numberapp.R;
import com.numerus.numberapp.di.components.NumerusActivityComponent;
import com.numerus.numberapp.mvp.presenter.NumerusPresenter;
import com.numerus.numberapp.mvp.view.NumerusView;
import com.numerus.numberapp.ui.fragment.base.BaseFragment;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by kiran.kumar on 10/12/17.
 */

public class NumerusFragment extends BaseFragment implements NumerusView{
    public NumerusFragment() {
        // Required empty public constructor
    }

    public static NumerusFragment newInstance() {
        NumerusFragment fragment = new NumerusFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numerus, container, false);
        unbinder = ButterKnife.bind(this,view);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rb1.setChecked(true);
        rbCategory1.setChecked(true);
        category = getString(R.string.trivia).toLowerCase();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getComponent(NumerusActivityComponent.class).inject(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.numerus, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onStart() {
        super.onStart();
        if(presenter!=null){
            presenter.init(this);
        }
    }

    @OnCheckedChanged({R.id.rb1, R.id.rb2})
    public void onFactsSelected(CompoundButton button, boolean checked){
        if(checked){
            Log.d(TAG,"Radio Selected:"+button.getId());
            switch (button.getId()){
                case R.id.rb1:
                    isBasic = true;
                    toggleBasicOrAdvaceView(isBasic);
                    break;
                case R.id.rb2:
                    isBasic = false;
                    toggleBasicOrAdvaceView(isBasic);
                    break;
            }
        }
    }

    @OnCheckedChanged({R.id.rb_cat1, R.id.rb_cat2, R.id.rb_cat3, R.id.rb_cat4})
    public void onCategorySelected(CompoundButton button, boolean checked){
        Log.d(TAG,"Categiry Seleced:");
        String textValue = "";
        boolean isDigit = false;
        if(checked){
            switch (button.getId()){
                case R.id.rb_cat1:
                    category = getString(R.string.trivia).toLowerCase();
                    isDigit = true;
                    textValue = "Enter Number:";
                    break;
                case R.id.rb_cat2:
                    category = getString(R.string.math).toLowerCase();
                    isDigit = true;
                    textValue = "Enter Number:";
                    break;
                case R.id.rb_cat3:
                    category = getString(R.string.date).toLowerCase();
                    isDigit = false;
                    textValue = "Enter Date(dd/mm):";
                    break;
                case R.id.rb_cat4:
                    category = getString(R.string.year).toLowerCase();
                    isDigit = true;
                    textValue = "Enter Year:";
                    break;
            }

            if(!isBasic){
                toggleDigitOrDatePicker(isDigit);
                setTextValue(txtEnterNum, textValue);
            }
        }
    }

    @OnClick(R.id.btn)
    void onSearchClicked(View view){
        if(isBasic){
            presenter.getFacts("random",category);
        } else {
            presenter.getFacts("random",category);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void render(String facts) {
        if(!TextUtils.isEmpty(facts)){
            txtFacts.setText(facts);
        }
    }

    private void setTextValue(TextView textView, String value){
        textView.setText(value);
    }

    @Override
    public void showLoading() {
        rlProgress.setVisibility(View.VISIBLE);
        clearFacts();
    }

    @Override
    public void hideLoading() {
        rlProgress.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void toggleBasicOrAdvaceView(boolean isBasic) {
        if(isBasic){
            numberPickerView.setVisibility(View.GONE);
            datePickerView.setVisibility(View.GONE);
        }else {
            toggleDigitOrDatePicker(true);
        }
    }

    @Override
    public void toggleDigitOrDatePicker(boolean isDigit) {
        numberPickerView.setVisibility(isDigit ? View.VISIBLE: View.GONE);
        datePickerView.setVisibility(!isDigit ? View.VISIBLE : View.GONE);
    }

    @Override
    public void clearFacts() {
        txtFacts.setText("");
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.destroy();
    }

    @BindView(R.id.rb1)
    RadioButton rb1;

    @BindView(R.id.rb_cat1)
    RadioButton rbCategory1;

    @BindView(R.id.ll_num_picker)
    LinearLayout numberPickerView;

    @BindView(R.id.ll_date_picker)
    LinearLayout datePickerView;

    @BindView(R.id.btn)
    Button button;

    @BindView(R.id.txt_result)
    TextView txtFacts;

    @BindView(R.id.txt_enter_num)
    TextView txtEnterNum;

    @Inject
    NumerusPresenter presenter;

    @BindView(R.id.rl_progress)
    RelativeLayout rlProgress;

    private String category;
    private boolean isBasic;
    private Unbinder unbinder;
    private static final String TAG = NumerusFragment.class.getSimpleName();
}
