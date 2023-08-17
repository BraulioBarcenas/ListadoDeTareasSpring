package com.example.ListadoDeTareas.models;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class TaskResponse {
    
    @Getter @Setter
    private long TaskId;
    @Getter @Setter
    private String status;
    @Getter @Setter
    private String message;
    // public TaskResponse(long taskId, String status, String response) {
    //     TaskId = taskId;
    //     this.status = status;
    //     this.response = response;
    // }

    
}
