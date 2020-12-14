package com.progon.prowind.infrastructure.data.api.volley;

import android.content.Context;
import android.graphics.Bitmap;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import com.progon.prowind.infrastructure.data.api.IApiCallback;
import com.progon.prowind.infrastructure.data.api.IApiDataProvider;
import com.progon.prowind.infrastructure.log.ILogService;
import com.progon.prowind.infrastructure.log.Log;
import com.progon.prowind.infrastructure.log.LogType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class VolleyDataProvider implements IApiDataProvider {
    private Context context;
    private VolleyConfiguration configuration;
    private ILogService logService;

    public VolleyDataProvider(Context Context, VolleyConfiguration Configuration, ILogService LogService){
        this.context = Context;
        this.configuration = Configuration;
        logService = LogService;
    }

    @Override
    public String MakeGetRequest(String Route) {
        try {
            JsonObjectRequest jsonRequest = new JsonObjectRequest
                    (Request.Method.GET, configuration.ApiUrl + "/" + Route, null, null, null);
            return GetSyncObjectResponse(jsonRequest).toString();
        }
        catch (Exception E) {
            logService.WriteLog(new Log(LogType.Error, new Date(), "VolleyDataProvider.MakeGetRequest : " + E.getMessage()));
            return "";
        }
    }

    @Override
    public void MakeGetAllRequest(String Route, final IApiCallback Callback) {
        try {
            JsonArrayRequest jsonRequest = new JsonArrayRequest
                    (Request.Method.GET, configuration.ApiUrl + "/" + Route, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Callback.onSuccess(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            Callback.onError(volleyError + "");
                        }
                    });
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(jsonRequest);
        }
        catch (Exception E) {
            logService.WriteLog(new Log(LogType.Error, new Date(), "VolleyDataProvider.MakeGetAllRequest.Exception : " + E.getMessage()));
        }
    }

    @Override
    public String MakePostRequest(String Route, String Json) {
        try {
            JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.POST, configuration.ApiUrl + "/" + Route, new JSONObject(Json), null, null);
            return GetSyncObjectResponse(jsonRequest).toString();
        }
        catch (Exception E) {
            logService.WriteLog(new Log(LogType.Error, new Date(), "VolleyDataProvider.MakePostRequest.Exception : " + E.getMessage()));
            return "";
        }
    }

    @Override
    public String MakePutRequest(String Route, String Json) {
        return MakePostRequest(Route, Json);
    }

    @Override
    public String MakeDeleteRequest(String Route, String Json) {
        return MakePostRequest(Route, Json);
    }

    private JSONObject GetSyncObjectResponse(Request Request){
        RequestFuture<JSONObject> futureRequest = RequestFuture.newFuture();
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(Request);
        try {
            JSONObject response = futureRequest.get(configuration.ResponseTimeOut, TimeUnit.SECONDS);
            logService.WriteLog(new Log(LogType.Info, new Date(), "VolleyDataProvider.GetSyncObjectResponse : Response Successful"));
            return response;
        } catch (Exception E){
            logService.WriteLog(new Log(LogType.Error, new Date(), "VolleyDataProvider.MakePostRequest.Exception : " + E.getMessage()));
            return new JSONObject();
        }
    }

    private JSONArray GetSyncArrayResponse(Request Request){
        RequestFuture<JSONArray> futureRequest = RequestFuture.newFuture();
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(Request);
        try {
            JSONArray response = futureRequest.get(configuration.ResponseTimeOut, TimeUnit.SECONDS);
            return response;
        } catch (TimeoutException E) {
            return new JSONArray();
        } catch (InterruptedException E) {
            return new JSONArray();
        } catch (ExecutionException E) {
            return new JSONArray();
        } catch (Exception E){
            return new JSONArray();
        }
    }
}
