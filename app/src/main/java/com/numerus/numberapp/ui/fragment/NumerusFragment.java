package com.numerus.numberapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.numerus.numberapp.R;
import com.numerus.numberapp.di.components.NumerusActivityComponent;
import com.numerus.numberapp.mvp.presenter.NumerusPresenter;
import com.numerus.numberapp.mvp.view.NumerusView;
import com.numerus.numberapp.ui.fragment.base.BaseFragment;
import com.numerus.numberapp.util.Constant;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.Unbinder;

import static android.R.attr.country;

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
        initViews();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getComponent(NumerusActivityComponent.class).inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rb1.setChecked(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        if(presenter!=null){
            presenter.init(this);
        }
    }

    private void initViews(){
        ArrayAdapter aa = new ArrayAdapter(getActivity(),
                android.R.layout.simple_spinner_item, Constant.CATEGORY);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
    }

    @OnCheckedChanged({R.id.rb1, R.id.rb2})
    public void onFactsSelected(CompoundButton button, boolean checked){
        if(checked){
            Log.d(TAG,"Radio Selected:"+button.getId());
            switch (button.getId()){
                case R.id.rb1:
                    isBasic = true;
                    numberPickerView.setVisibility(View.GONE);
                    datePickerView.setVisibility(View.GONE);
                    invalidateSearch(true);
                    break;
                case R.id.rb2:
                    isBasic = false;
                    invalidatePicker(false);
                    invalidateSearch(false);
                    break;
            }
        }
    }

    @OnItemSelected(R.id.spn)
    void onCategorySelected(Spinner spinner, int position){
        Log.d(TAG,"Spinner Seleced:"+position);
        if(isBasic){
            //do nothing
            return;
        }
        switch (Constant.CATEGORY[position].toLowerCase()){
            case "trivia":
            case "math":
            case "year":
                invalidatePicker(false);
                break;
            case "date":
                invalidatePicker(true);
                break;
        }
    }

    @OnClick(R.id.btn)
    void onSearchClicked(View view){
        Log.d(TAG,"Selcted Searc:"+spinner.getSelectedItem().toString());
        presenter.getFacts(spinner.getSelectedItem().toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void invalidateSearch(boolean flag){
        button.setEnabled(flag);
    }

    private void invalidatePicker(boolean dateFlag){
        numberPickerView.setVisibility(dateFlag ? View.GONE : View.VISIBLE );
        datePickerView.setVisibility(dateFlag ? View.VISIBLE : View.GONE);
    }

    @Override
    public void render(String facts) {
        if(!TextUtils.isEmpty(facts)){
            txtFacts.setText(facts);
        }
    }

    @BindView(R.id.rg)
    RadioGroup radioGroup;

    @BindView(R.id.rb1)
    RadioButton rb1;

    @BindView(R.id.rb2)
    RadioButton rb2;

    @BindView(R.id.ll_num_picker)
    LinearLayout numberPickerView;

    @BindView(R.id.ll_date_picker)
    LinearLayout datePickerView;

    @BindView(R.id.spn)
    Spinner spinner;

    @BindView(R.id.btn)
    Button button;

    @BindView(R.id.txt_result)
    TextView txtFacts;

    @Inject
    NumerusPresenter presenter;

    private boolean isBasic;
    private Unbinder unbinder;
    private static final String TAG = NumerusFragment.class.getSimpleName();
}
