package com.wioletamwrobel.wioletawrobelsappsportfolio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder> {

    private static RecyclerViewInterface listener;

    public ProjectsAdapter(Context context, Project[] projects, RecyclerViewInterface listener) {
        this.projects = projects;
        this.context = context;
        ProjectsAdapter.listener = listener;
    }

    private final Project[] projects;
    Context context;

    @Override
    public int getItemCount() {
        return projects.length;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(projects[position]);
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView projectImage;
        private final TextView projectName;
        private final TextView projectTools;
        private final TextView projectDescription;
        private final TextView projectLink;


        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            projectImage = itemView.findViewById(R.id.image_view_project_image);
            projectName = itemView.findViewById(R.id.text_view_project_name);
            projectTools = itemView.findViewById(R.id.text_view_project_tools);
            projectDescription = itemView.findViewById(R.id.text_view_project_description);
            projectLink = itemView.findViewById(R.id.text_view_project_link);

            projectLink.setOnClickListener(this);
        }

        public void bind(Project project) {
            projectName.setText(project.name);
            projectTools.setText(project.tools);
            projectDescription.setText(project.description);
            projectImage.setImageResource(project.image);
            projectLink.setText(project.goToGithub);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClicked(itemView, getAbsoluteAdapterPosition());
        }
    }

    public interface RecyclerViewInterface {
        void onItemClicked(View v, int position);
    }
}
