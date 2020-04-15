package com.possible.onlinestore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    @NotBlank(message = "Product name cannot be blank")
    private String name;
    @NotBlank(message = "Product brand cannot be blank")
    private String brand;

/*    @NotBlank(message = "Tell us something about the product")*/
    @JsonIgnore
    private String description;

    @Min(value = 1)
    private double unitPrice;
    private int quantity;
    @JsonIgnore
    private boolean active;
    @JsonIgnore
    private int categoryId;
    @JsonIgnore
    private int supplierId;
    private int purchases;
    private int views;
    private CategoryEnum categoryEnum;
    private String imageUrl;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "product")
    private List<Category> categories;

    private Date created_At;
    private Date updated_At;

    @PrePersist void onCreate(){
        this.created_At = new Date();
    }

    @PreUpdate void onUpdate(){
        this.updated_At = new Date();
    }

    public Product() {
        this.code = "PRD-"+ UUID.randomUUID().toString().substring(26).toUpperCase();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }
}

