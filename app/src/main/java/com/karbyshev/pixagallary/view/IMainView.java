package com.karbyshev.pixagallary.view;

import com.karbyshev.pixagallary.model.Hit;

import java.util.ArrayList;

/**
 * Created by vilen on 26.03.2018.
 */

public interface IMainView {

    void OnItemClick (int position, ArrayList<Hit> list);
}
