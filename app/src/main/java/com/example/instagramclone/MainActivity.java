package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

import static com.example.instagramclone.Post.KEY_USER;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private EditText etDescription;
    private Button btnCapture;
    private Button btnPost;
    private ImageView ivPostImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDescription = findViewById(R.id.etDescription);
        btnCapture = findViewById(R.id.btnCapture);
        btnPost = findViewById(R.id.btnPost);
        ivPostImage = findViewById(R.id.ivPostImage);

        queryPosts();
    }

    private void queryPosts(){
        ParseQuery <Post> query = ParseQuery.getQuery(Post.class);
        query.include(KEY_USER);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if(e != null){
                    Log.e(TAG, "Issue with getting the posts");
                    return;
                }
                for(Post post: posts){
                    Log.i(TAG, "Post: " +post.getDescription() + " username: " + post.getUser().getUsername());
                }
            }
        });
    }
}