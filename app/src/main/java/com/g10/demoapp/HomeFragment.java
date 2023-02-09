package com.g10.demoapp;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.g10.demoapp.Adapter.PoppularAdapter;
import com.g10.demoapp.Adapter.ProductAdapter;
import com.g10.demoapp.Pogo.PopularPogo;
import com.g10.demoapp.Pogo.Productpogo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private ImageSlider image_slider1;
    private RecyclerView recNewAddition,recPoppular;
    private ProductAdapter productAdapter;
    private PoppularAdapter poppularAdapter;
    private List<Productpogo> productpogoList;
    private List<PopularPogo> popularPogoList;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        image_slider1 = view.findViewById(R.id.image_slider1);
        // businessRecyclerview =view.findViewById(R.id.businessRecyclerview);
        recNewAddition = view.findViewById(R.id.recNewAddition);
        recPoppular = view.findViewById(R.id.recPoppular);


        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.bg_image, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.bg_image, ScaleTypes.FIT));

        image_slider1.setImageList(slideModels);

        recNewAddition.setHasFixedSize(true);
        productpogoList = new ArrayList<>();
        productpogoList.clear();


        recPoppular.setHasFixedSize(true);
        popularPogoList = new ArrayList<>();
        popularPogoList.clear();

        getNewAdditionData();

        getpopularBooks();


        return  view;
    }



    private void getNewAdditionData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.getCache().clear();
        JSONObject jObj = new JSONObject();
        try {
            jObj.put("get_book","true");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String URL="https://intellect-mitul.000webhostapp.com/prod_web.php";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                URL,
                jObj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e( "onResponse: ",response.toString() );
                        try {
                            JSONArray array = response.getJSONArray("book");
                            for (int j=0;j<array.length();j++){
                                JSONObject object = array.getJSONObject(j);
                                Productpogo pogo = new Productpogo();
                                pogo.setBookname(object.getString("bookname"));
                                pogo.setBookauthor(object.getString("bookauthor"));
                                pogo.setBookprice(object.getString("bookprice"));
                                pogo.setRating(Float.valueOf(object.getString("rating")));
                                pogo.setTotalrating(object.getString("totalrating"));
                                pogo.setImage(object.getString("image"));

                                productpogoList.add(pogo);

                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                                recNewAddition.setLayoutManager(linearLayoutManager);
                                productAdapter = new ProductAdapter(productpogoList, getContext());
                                recNewAddition.setAdapter(productAdapter);


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        productAdapter.notifyDataSetChanged();
//                        prb.setVisibility(View.GONE);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Something Went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        request.setRetryPolicy(new DefaultRetryPolicy(200*30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(getContext()).add(request);
    }

    private void getpopularBooks() {

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.getCache().clear();
        JSONObject jObj = new JSONObject();
        try {
            jObj.put("get_popularbook","true");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String URL="https://intellect-mitul.000webhostapp.com/popularbooks.php";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                URL,
                jObj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e( "onResponse: ",response.toString() );
                        try {
                            JSONArray array = response.getJSONArray("popularbook");
                            for (int j=0;j<array.length();j++){
                                JSONObject object = array.getJSONObject(j);
                                PopularPogo pogo = new PopularPogo();
                                pogo.setPname(object.getString("pname"));
                                pogo.setPauthor(object.getString("pauthor"));
                                pogo.setPdescription(object.getString("pdescription"));
                                pogo.setPimage(object.getString("pimage"));


                                popularPogoList.add(pogo);

                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                                recPoppular.setLayoutManager(linearLayoutManager);
                                poppularAdapter = new PoppularAdapter(popularPogoList, getContext());
                                recPoppular.setAdapter(poppularAdapter);


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        poppularAdapter.notifyDataSetChanged();
//                        prb.setVisibility(View.GONE);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Something Went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        request.setRetryPolicy(new DefaultRetryPolicy(200*30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(getContext()).add(request);
    }
}