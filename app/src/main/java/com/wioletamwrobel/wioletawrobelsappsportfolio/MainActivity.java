package com.wioletamwrobel.wioletawrobelsappsportfolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private ProjectsAdapter.RecyclerViewInterface listener;

    Project[] projects = {
            new Project(R.string.wielun_city_app_name, R.string.wielun_city_app_tools, R.string.wielun_city_app_description, R.drawable.wielun_city_app, R.string.wielun_city_app_link, "https://www.github.com/WiMaW/Wielun-City-App"),
            new Project(R.string.my_art_space_app_name, R.string.my_art_space_app_tools, R.string.my_art_space_app_description, R.drawable.my_art_space, R.string.my_art_space_app_link, "https://www.github.com/WiMaW/My-Art-Space"),
            new Project(R.string.daily_inspiration_name, R.string.daily_inspiration_tools, R.string.daily_inspiration_description, R.drawable.daily_inspiration, R.string.daily_inspiration_link, "https://www.github.com/WiMaW/DailyInspiration"),
            new Project(R.string.memories_app_name, R.string.memories_app_tools, R.string.memories_app_description, R.drawable.memories_app, R.string.memories_app_link, "https://www.github.com/WiMaW/Memories-App"),
            new Project(R.string.done_or_not_done_name, R.string.done_or_not_done_tools, R.string.done_or_not_done_description, R.drawable.done_or_notdone, R.string.done_or_not_done_link, "https://www.github.com/WiMaW/Done-or-NotDone"),
            new Project(R.string.meet_me_app_name, R.string.meet_me_tools, R.string.meet_me_description, R.drawable.meet_me_app, R.string.meet_me_link, "https://www.github.com/WiMaW/Meet-Me"),
            new Project(R.string.remind_me_name, R.string.remind_me_tools, R.string.remind_me_description, R.drawable.remind_me, R.string.remind_me_link, "https://www.github.com/WiMaW/Remind-Me"),
            new Project(R.string.the_bucket_list_app_name, R.string.the_bucket_list_app_tools, R.string.the_bucket_list_app_description, R.drawable.the_bucket_list_app, R.string.the_bucket_list_app_link, "https://www.github.com/WiMaW/The-Bucket-List"),
            new Project(R.string.apps_portfolio_name, R.string.apps_portfolio_tools, R.string.apps_portfolio_description, R.drawable.portfolio_app, R.string.the_bucket_list_app_link, "https://www.github.com/WiMaW?tab=repositories"),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.recycler_view_projects);

        setOnClickListener();
        ProjectsAdapter adapter = new ProjectsAdapter(this, projects, listener);

        list.setAdapter(adapter);

    }

    private void setOnClickListener() {
        listener = (v, position) -> {
            Toast.makeText(MainActivity.this, R.string.toast_message, Toast.LENGTH_SHORT).show();
            Uri webpage = Uri.parse(projects[position].link);
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        };
    }
}