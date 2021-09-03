package com.resturant.orderSystem.services.token;

import com.resturant.orderSystem.models.Users;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import java.time.LocalDateTime;
@NoArgsConstructor
public class ConfirmationToken {

    @Id
    private String id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createTime;
    @Column(nullable = false)
    private LocalDateTime expirationTime;

    private LocalDateTime confirmationTime;
    @Column(nullable = false)
    private Users user;




    public ConfirmationToken(String token, LocalDateTime createTime, LocalDateTime expirationTime, Users users) {
        this.token = token;
        this.createTime = createTime;
        this.expirationTime = expirationTime;
        this.user = users;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    public void setConfirmationTime(LocalDateTime confirmationTime) {
        this.confirmationTime = confirmationTime;
    }

    public String getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public LocalDateTime getConfirmationTime() {
        return confirmationTime;
    }
}
