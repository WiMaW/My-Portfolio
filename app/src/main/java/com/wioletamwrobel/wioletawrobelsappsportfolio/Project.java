package com.wioletamwrobel.wioletawrobelsappsportfolio;

public class Project {
    int name;
    int tools;
    int description;
    int image;
    int goToGithub;
    String link;

    public Project(int name, int tools, int description, int image, int goToGitHub, String link) {
        this.name = name;
        this.tools = tools;
        this.description = description;
        this.image = image;
        this.goToGithub = goToGitHub;
        this.link = link;
    }
}
