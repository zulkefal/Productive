package com.example.productive;

public class model_tasks {
    String task,desc,time;
    int dic;

    public model_tasks()
    {

    }

    public int getDic() {
        return dic;
    }

    public void setDic(int dic) {
        this.dic = dic;
    }


    public model_tasks(String task, String desc, String time,int dic) {

        this.task = task;
        this.desc = desc;
        this.time=time;
        this.dic=dic;


    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
