package com.example.e_bridgeuser.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.e_bridgeuser.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class HomeFragment extends Fragment {

    SliderLayout slider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        slider = view.findViewById(R.id.slider);
        slider.setIndicatorAnimation(IndicatorAnimations.COLOR);
        slider.setSliderTransformAnimation(SliderAnimations.CUBEINDEPTHTRANSFORMATION);
        slider.setScrollTimeInSec(2);


        setSliderImages();


        return view;
    }

    private void setSliderImages() {
        //using for loops for multiple images
        for (int i = 0; i < 5; i++) {
            DefaultSliderView defaultSliderView = new DefaultSliderView(getContext());
            switch (i) {
                case 0:
                    //using URL to so that our application is of small size
                    defaultSliderView.setImageUrl("https://www.admissionfever.com/Media/clgimg/gallery/343_img7278888380707487.png");
                    break;

                case 1:
                    defaultSliderView.setImageUrl("https://www.gla.ac.in/images/about-us.jpg");
                    break;

                case 2:
                    defaultSliderView.setImageUrl("https://akm-img-a-in.tosshub.com/sites/indiacontent/0/images/product/public/27112019/00/01/57/48/54/66/39/13/1574854663913/659-gla-university-iin-image-GLA_University__Mathura__16_.jpg");
                    break;

                case 3:
                    defaultSliderView.setImageUrl("https://getmyuni.azureedge.net/college-image/big/gla-university-mathura.jpg");
                    break;

                case 4:
                    defaultSliderView.setImageUrl("https://www.indcareer.com/files/imagecache/900x/files/54561/img3281a.jpg");
                    break;


            }
            //settingimage scale

        }


    }
}