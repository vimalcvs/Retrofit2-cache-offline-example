package www.technovimal.com.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tos.retrofitokhttpcaching.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Url;
import www.technovimal.com.adapter.SecondAdapter;
import www.technovimal.com.webapi.APIService;
import www.technovimal.com.webapi.RootUrl;
import www.technovimal.com.webapi.api.SecondData;

/**
 * Created by vimalcvs on 10/01/2021.
 */
public class SecondActivity extends AppCompatActivity {

    ProgressBar progressBar;
    RecyclerView recyclerView;
    Context context;
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        context = this;

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);

        WebInterface webInterface = APIService.createService(WebInterface.class, RootUrl.BASE_URL);
        String image_url = getIntent().getExtras().getString("ApiId");
        webInterface.getPhotoData(image_url)
                .enqueue(new Callback<List<SecondData>>() {
                    @Override
                    public void onResponse(@NotNull Call<List<SecondData>> call, @NotNull Response<List<SecondData>> response) {
                        if (response.raw().networkResponse() != null) {
                            Log.d(TAG, "onResponse: response is from NETWORK...");
                        } else if (response.raw().cacheResponse() != null
                                && response.raw().networkResponse() == null) {
                            Log.d(TAG, "onResponse: response is from CACHE...");
                        }
                        if (response.code() == 200) {
                            progressBar.setVisibility(View.GONE);
                            List<SecondData> postData = response.body();
                            SecondAdapter adapter = new SecondAdapter(postData);
                            recyclerView.setLayoutManager(new LinearLayoutManager(context));
                            recyclerView.setAdapter(adapter);
                        } else {
                            Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(@NotNull Call<List<SecondData>> call, @NotNull Throwable t) {
                    }
                });
    }

    public interface WebInterface {
        @GET
        Call<List<SecondData>> getPhotoData(@Url String url);
    }
}
